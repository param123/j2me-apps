/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;




import java.util.Hashtable;

import javax.microedition.midlet.MIDlet;

import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet {

    
   // private Display display = null;
   private IScreen[] displayOrder = new IScreen[10];
   private int stackSize = 0;
   private Hashtable screenNameValue = null;
    
    public void startApp() {
        try{
        Display.init(this);
        Resources theme = Resources.open("/LWUITtheme.res");
            UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
            //open the resources file that contains all the icons
         //final Resources res = Resources.open("/resources.res");
         Display.getInstance().callSerially(new Runnable() {
                public void run() {
                    //UIManager.getInstance().setResourceBundle(res.getL10N("localize", "en"));
                	screenNameValue = new Hashtable();
                	new InboxScreen(getInstance());
                	new ComposeScreen(getInstance());
                	new SentScreen(getInstance());
                	
                    new MainScreen(getInstance()).launchUI();
                }
            });
      // display = Display.getDisplay(this);
       
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

   
//    public Display getDisplay() {
//      // return display;
//    }

//    private  Command select = new SMSCommand("Select", Command.ITEM, 1) {
//        public void execute(IScreen screen) {
//            System.out.println(" screen ");
//           screen.action();
//        }
//    };
    
   public Command exit = new Command("Exit", 1) {
      public void actionPerformed(ActionEvent evt){
          System.out.println("Exit");
          notifyDestroyed();
       }
    };
    
    
    public Command back = new Command("Back", 1) {
        public void actionPerformed(ActionEvent evt){
        	IScreen current = displayOrder[--stackSize];
            displayOrder[stackSize] = null;
            current.destroy();
            IScreen previous = displayOrder[--stackSize];
            displayOrder[stackSize] = null;
            previous.launchUI();
         }
      };

    
    public void updateDisplayOrder(IScreen screen){
    	if(stackSize<displayOrder.length){
    		displayOrder[stackSize++]=screen;
    	}else{
    	IScreen[] temp = new IScreen[displayOrder.length+5];
    	System.arraycopy(displayOrder, 0, temp, 0, displayOrder.length-1);
    	temp[stackSize++]=screen;
    	displayOrder = temp;
    	}
    }
    
    public Object getScreen(Object key){
    	return screenNameValue.get(key);
    }
    
    public void addCommonCommand(Form form){
    	form.addCommand(exit);
    	form.addCommand(back);
    }
    
    public void registerScreen(IScreen screen){
    	screenNameValue.put(screen.getName(), screen);
    }
    
    public void unregisterScreen(Object key){
    	screenNameValue.remove(key);
    }

//    public Command[] commonCommand(){
//         return new Command[]{select,exit};
//    }
}
