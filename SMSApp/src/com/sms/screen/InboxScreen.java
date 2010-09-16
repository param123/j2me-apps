/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author PKumar
 */
public class InboxScreen extends AbstractScreen implements CommandListener{



    public InboxScreen(EntryScreen entryScreen){
        super(entryScreen);
    }

    public boolean show() {

        return true;
    }

    public boolean action() {
        
        return true;
    }

    public boolean destroy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void commandAction(Command c, Displayable d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
