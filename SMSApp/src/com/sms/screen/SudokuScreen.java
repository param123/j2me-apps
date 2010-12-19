/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;


import com.sms.message.IMessage;
import com.sms.screen.algo.SudokuAlgo;

import com.sms.screen.textfield.SudokuTextField;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.GridLayout;
import java.io.IOException;
import javax.microedition.rms.RecordEnumeration;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;



/**
 *
 * @author PKumar
 */
public class SudokuScreen extends AbstractScreen implements FocusListener {

    private Form sudokuForm = null;
    private SudokuAlgo sa = null;
    private TextField selectedField = null;
    private boolean focusSet = false;
    public SudokuScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
        sudokuForm.show();
       return true;
    }

    protected void init() {
        sa = new SudokuAlgo();
        sudokuForm = new Form(getName());
        sudokuForm.setLayout(new GridLayout(9, 9));
        sudokuForm.setScrollable(false);
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                TextField tf = new SudokuTextField(1,sa.getRow(i).getCell(new int[]{j}));
                tf.getStyle().setMargin(0, 0, 0, 0);
                tf.getStyle().setPadding(2, 0, 3, 0);
                tf.getStyle().setFont(Font.createSystemFont(Font.FACE_MONOSPACE,Font.STYLE_PLAIN,Font.SIZE_MEDIUM));
                tf.setInputMode("123");
                tf.setReplaceMenu(true);
                tf.addFocusListener(this);
                sudokuForm.addComponent(tf);
                if(tf.isFocusable() && !focusSet){
                    selectedField = tf;
                    focusSet= true;
                }
            }
        }

         appController.addCommonCommand(sudokuForm);

        sudokuForm.addCommand(new Command("Check"){
            public void actionPerformed(ActionEvent evt){
              boolean flag = sa.check();
              String msg = flag?IMessage.SUDOKU_WIN:IMessage.SUDOKU_WRONG;
              Dialog.show(IMessage.TITLE_MSG, msg, Dialog.TYPE_INFO, null, "Ok", null);
            }
        });
        sudokuForm.addCommand(new Command("Clear"){
            public void actionPerformed(ActionEvent evt){
               selectedField.clear();
            }
        });

       sudokuForm.addCommand(new Command("Save"){
            public void actionPerformed(ActionEvent evt){
                try {
                    save();
                }catch(IOException io){
                    Dialog.show(IMessage.TITLE_ERROR, "Error while saving", Dialog.TYPE_ERROR, null, "Ok", null);
                }
                catch(RecordStoreException rse){
                     Dialog.show(IMessage.TITLE_ERROR, "Error while saving", Dialog.TYPE_ERROR, null, "Ok", null);
                }
            }
        });
        MainScreen.setTransition(sudokuForm);
       
    }

    public boolean destroy() {
       sudokuForm = null;
       sa = null;
       return true;

    }

    public String getName() {
        return "Sudoku";
    }

    
    public void focusGained(Component arg0) {
       this.selectedField = (TextField)arg0;
       selectedField.setFocus(true);
       
    }

    public void focusLost(Component arg0) {
       arg0.setFocus(false);
    }

    public boolean callBack(){
       
//        Dialog d = new Dialog(IMessage.TITLE_CONFIRM);
        Command yes = new Command("Yes");
        Command no = new Command("No");
        Command cancel = new Command("Cancel");
        Command cmds[] = new Command[]{yes,no,cancel};
        Label label = new Label(IMessage.DIALOG_SAVE);
        Command cmd = Dialog.show(IMessage.TITLE_CONFIRM, label,cmds, Dialog.TYPE_ERROR, null);

       
        try{
            if(cmd == cancel){
                return false;
            }else if(cmd == no){
                getFreshRecordStore();
                return true;
            }else{
                save();
                return true;
            }
        }catch(IOException io){
            Dialog.show(IMessage.TITLE_ERROR, "Error while saving", Dialog.TYPE_ERROR, null, "Ok", null);
        }
        catch(RecordStoreException rse){
             Dialog.show(IMessage.TITLE_ERROR, "Error while saving", Dialog.TYPE_ERROR, null, "Ok", null);
        }

        return true;
    }

    private RecordStore getFreshRecordStore() throws RecordStoreException{
         RecordStore rs = RecordStore.openRecordStore(IMessage.GAME_RECORD, true);
         RecordEnumeration re = rs.enumerateRecords(null, null, false);
                    while(re.hasNextElement()){
                        int recordId = re.nextRecordId();
                       rs.deleteRecord(recordId);
                    }
            return rs;
    }

    private void save() throws RecordStoreException, IOException{
           RecordStore rs = getFreshRecordStore();
           byte b[] = sa.save();
           rs.addRecord(b, 0, b.length);
           rs.closeRecordStore();
        
    }

}
