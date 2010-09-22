/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;
import com.sun.lwuit.Form;



/**
 *
 * @author PKumar
 */
public class InboxScreen extends AbstractScreen{

	private Form inboxForm = null;

    public InboxScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
    	inboxForm.show();
        return true;
    }

    public boolean destroy() {
        inboxForm = null;
    	return true;
    }

	public String getName() {
		return "Inbox";
	}

	protected void init() {
		inboxForm = new Form("inbox");
		appController.addCommonCommand(inboxForm);
                MainScreen.setTransition(inboxForm);
	}

    

}
