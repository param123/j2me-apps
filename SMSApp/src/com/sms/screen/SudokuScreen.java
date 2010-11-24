/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;


import com.sms.screen.algo.SudokuAlgo;

import com.sms.screen.textfield.SudokuTextField;
import com.sun.lwuit.Command;
import com.sun.lwuit.Component;
import com.sun.lwuit.Font;
import com.sun.lwuit.Form;
import com.sun.lwuit.TextField;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.GridLayout;



/**
 *
 * @author PKumar
 */
public class SudokuScreen extends AbstractScreen implements FocusListener {

    private Form sudokuForm = null;
    private SudokuAlgo sa = null;
    private TextField selectedField = null;

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
            }
        }
   
        sudokuForm.addCommand(new Command("clear"){
            public void actionPerformed(ActionEvent evt){
                System.out.println(evt.getKeyEvent());
                selectedField.clear();
            }
        });
        MainScreen.setTransition(sudokuForm);
        appController.addCommonCommand(sudokuForm);
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
          ((TextField)arg0).setFocusable(false);

    }

}
