/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;


import com.sms.commands.SMSCommand;
import com.sms.interfaces.screen.IScreen;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet {

    
    private Display display = null;
    
    public void startApp() {
        display = Display.getDisplay(this);
        new MainScreen(this).show();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

   
    public Display getDisplay() {
       return display;
    }

    private  Command select = new SMSCommand("Select", Command.ITEM, 1) {
        public void execute(IScreen screen) {
            System.out.println(" screen ");
           screen.action();
        }
    };
   private Command exit = new SMSCommand("Exit", Command.SCREEN, 1) {
        public void execute(IScreen screen) {
            System.out.println("Destroy");
          screen.destroy();
          notifyDestroyed();
        }
    };

    public Command[] commonCommand(){
         return new Command[]{select,exit};
    }
}
