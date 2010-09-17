/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sun.lwuit.Form;



/**
 *
 * @author PKumar
 */
public class InboxScreen extends AbstractScreen{

	private Form inboxForm = null;


    public InboxScreen(EntryScreen entryScreen){
        super(entryScreen);
    }

    public boolean show() {
    	System.gc();
        inboxForm = new Form("inbox");
        enter.addCommonCommand(inboxForm);
        enter.updateDisplayOrder(this);
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

    

}
