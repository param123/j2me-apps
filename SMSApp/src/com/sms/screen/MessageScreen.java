/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.interfaces.screen.IEnter;
import com.sms.screen.list.ListItem;
import com.sms.screen.list.SMSList;
import javax.microedition.lcdui.List;

/**
 *
 * @author PKumar
 */
public class MessageScreen extends AbstractScreen{

    private SMSList itemList = null;

    public MessageScreen(IEnter enter){
        super(enter);
    }

    public boolean show() {
        itemList = new SMSList("Messages", List.IMPLICIT);
        itemList.addItem(new ListItem("Inbox", this));
        itemList.addItem(new ListItem("Compose", this));
        itemList.addItem(new ListItem("Sent", this));
        addCommonCommand(itemList);
        enter.getDisplay().setCurrent(itemList);
        return true;
    }

    public boolean action() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }



}
