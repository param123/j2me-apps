/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;





import com.sms.controller.AppController;
import com.sms.interfaces.screen.IParent;
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
public class MessageScreen extends AbstractScreen implements IParent  {

    private List itemList = null;
    private Form mainForm = null;
    
    //state related variables
    int lastListItemSelected = 0;
    private AppController childAppController = null;
    
    public MessageScreen(AppController appController){
        super(appController);
    }

    
    protected void init() {
    	childAppController = null;
    	childAppController = new AppController(this);
        childAppController.updateDisplayOrder(this);
//    	childAppController.registerScreen(this);
        mainForm = new Form(getName());
        mainForm.setLayout(new BorderLayout());
        
        itemList = new List();
        itemList.addItem("Inbox");
        itemList.addItem("Compose");
        itemList.addItem("Sent");

        mainForm.addComponent(BorderLayout.CENTER,itemList);
        mainForm.addCommand(new Command("Select"){
            public void actionPerformed(ActionEvent evt){
            	lastListItemSelected = itemList.getSelectedIndex();
                Object itemName = itemList.getSelectedItem();
                getChildScreen(itemName.toString()).launchUI(false);
            }
        });
        appController.addCommonCommand(mainForm);
    }

    public boolean destroy() {
        itemList = null;
        mainForm = null;
        return true;
    }

	public String getName() {
		return "SMS";
	}
	
	private IScreen getChildScreen(String screenName){
		IScreen screen =null;
		if(screenName.equals("Inbox")){
			screen = new InboxScreen(childAppController);
		}else if(screenName.equals("Compose")){
			screen = new ComposeScreen(childAppController);
		}else if(screenName.equals("Sent")){
			screen = new SentScreen(childAppController);
		}
		return screen;
	}
	
	protected void maintainPreviousState(boolean maintain){
		if(maintain){
		  itemList.setSelectedIndex(lastListItemSelected);
		}else{
		  lastListItemSelected = 0;
		}
	}

	public boolean show() {
		mainForm.show();
	        return true;
	}

	public void addCommand(Form form) {
		
	}
    
}
