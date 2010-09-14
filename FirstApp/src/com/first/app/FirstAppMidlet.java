/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.first.app;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.StringItem;
import javax.microedition.lcdui.TextBox;
import javax.microedition.midlet.*;

/**
 * @author PKumar
 */
public class FirstAppMidlet extends MIDlet {

    private ActionListener actionListener = new ActionListener();
    private Display display;
    private TextBox findArea ;

    private Form progressForm;
    private StringItem progressString;

    public FirstAppMidlet(){
        
        findArea = new TextBox("Search", "Write..", 32, 0);
        findArea.addCommand(new Command("Find",Command.OK  , 0));
        findArea.addCommand(new Command("Exit",Command.EXIT  , 0));
        findArea.addCommand(new Command("Exit",Command.CANCEL  , 0));
        findArea.setCommandListener(actionListener);

        progressForm = new Form("Lookup Form..");
        progressString = new StringItem(null, null);
        progressForm.append(progressString);
        
    }

    public void startApp() {
        display = Display.getDisplay(this);
        display.setCurrent(findArea);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }
}
