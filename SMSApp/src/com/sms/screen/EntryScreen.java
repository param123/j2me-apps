/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;




import com.sms.controller.AppController;
import com.sms.interfaces.screen.IParent;
import com.sun.lwuit.Command;
import javax.microedition.midlet.MIDlet;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet implements IParent {

        private AppController appController = null;

	public void startApp() {
        try{
        Display.init(this);
        Resources theme = Resources.open("/javaTheme.res");
        UIManager.getInstance().getLookAndFeel().setReverseSoftButtons(true); 
        UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
         Display.getInstance().callSerially(new Runnable() {
                public void run() {
                        appController = new AppController(getInstance());
                	new MainScreen(appController).launchUI(true);
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

       public void addCommand(Form form) {
		form.addCommand(exit);
	}


	private Command exit = new Command("Exit") {
	      public void actionPerformed(ActionEvent evt){
	          notifyDestroyed();
	       }
	};


}
