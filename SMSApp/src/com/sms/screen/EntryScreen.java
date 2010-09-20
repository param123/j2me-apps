/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;




import javax.microedition.midlet.MIDlet;

import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet {


	public void startApp() {
        try{
        Display.init(this);
        Resources theme = Resources.open("/LWUITtheme.res");
        UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
         Display.getInstance().callSerially(new Runnable() {
                public void run() {
                	new MainScreen(getInstance()).displayUI();
                }
            });
       
        }catch(Exception ex){
            ex.printStackTrace();
            Dialog.show("Exception", ex.getMessage(), "OK", null);
        }
    }

    public final EntryScreen getInstance(){
        return this;
    }

    public void pauseApp() {
        
    }

    public void destroyApp(boolean unconditional) {
        
    }
    
}
