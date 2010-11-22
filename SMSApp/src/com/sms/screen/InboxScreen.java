/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;


import com.sms.controller.AppController;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.events.SelectionListener;
import com.sun.lwuit.list.ListModel;



/**
 *
 * @author PKumar
 */
public class InboxScreen extends AbstractScreen implements ListModel{

    private Form inboxForm = null;
    private List messageList = null;

    public InboxScreen(AppController appController){
        super(appController);
        messageList = new List(this);
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

    public Object getItemAt(int arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
        
    }

    public int getSize() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getSelectedIndex() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setSelectedIndex(int arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addDataChangedListener(DataChangedListener arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeDataChangedListener(DataChangedListener arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addSelectionListener(SelectionListener arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeSelectionListener(SelectionListener arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void addItem(Object arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void removeItem(int arg0) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
