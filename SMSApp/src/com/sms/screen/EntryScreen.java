/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.interfaces.screen.IEnter;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet implements IEnter{

    
    private Display display = null;
    
    public void startApp() {
        display = Display.getDisplay(this);
        new MessageScreen(this).show();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

   
    public Display getDisplay() {
       return display;
    }
}
