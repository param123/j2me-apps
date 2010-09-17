/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;





import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;






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
        itemList.addItem("Inbox");
        itemList.addItem("Compose");
        itemList.addItem("Sent");
        itemList.addItem("Setting");
//      itemList.adsetCommandListener(this);
//      enter.getDisplay().setCurrent(itemList);
        mainForm.addComponent(BorderLayout.CENTER,itemList);
        mainForm.addCommand(enter.exit);
        mainForm.addCommand(new Command("Select", 1){
            public void actionPerformed(ActionEvent evt){
               Object itemName = itemList.getSelectedItem();
                destroy();
               ((IScreen)enter.getScreen(itemName)).launchUI();
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



	public String getName() {
		// TODO Auto-generated method stub
		return "Sms apps";
	}

   

//    public void actionPerformed(ActionEvent event) {
//        Command c = event.getCommand();
//
//    }

    
}
