/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;





import com.sms.screen.list.ListItem;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;
import com.sun.lwuit.list.DefaultListModel;





/**
 *
 * @author PKumar
 */
public class MainScreen extends AbstractScreen  {

    private List itemList = null;
    private Form mainForm = null;
    public MainScreen(EntryScreen enter){
        super(enter);
    }

    

    public boolean show() {
        mainForm = new Form("Messages");
        mainForm.setLayout(new BorderLayout());
        
        itemList = new List();
        itemList.setFocus(true);
        //itemList.setBorderPainted(true);
        //itemList.setModel(new DefaultListModel());
        itemList.addItem(new ListItem("Inbox", this));
        itemList.addItem(new ListItem("Compose", this));
        itemList.addItem(new ListItem("Sent", this));
        itemList.addItem(new ListItem("Setting", this));
//      itemList.adsetCommandListener(this);
//      enter.getDisplay().setCurrent(itemList);
        mainForm.addComponent(BorderLayout.CENTER,itemList);
        mainForm.addCommand(enter.exit);
        mainForm.addCommand(new Command("Select", 1){
            public void actionPerformed(ActionEvent evt){
               ListItem item = (ListItem)itemList.getSelectedItem();
               destroy();
               item.getIScreen().show();
            }
        });

        mainForm.show();
        return true;
    }

//    public Object[] getFormItem(){
//        return new ListItem[]{new ListItem("Inbox", this),
//                              new ListItem("Compose", this),
//                              new ListItem("Sent", this),
//                              new ListItem("Setting", this)};
//    }

//    public boolean action() {
//        ListItem item = itemList.getListItem(itemList.getSelectedIndex());
//        if(item.getIScreen().show()){
//            destroy();
//        }
//        return true;
//    }

    public boolean destroy() {
        itemList = null;
        mainForm = null;
        return true;
    }

   

//    public void actionPerformed(ActionEvent event) {
//        Command c = event.getCommand();
//
//    }

    
}
