/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;




import com.sun.lwuit.Command;
import com.sun.lwuit.Dialog;
import com.sun.lwuit.Display;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.plaf.UIManager;
import com.sun.lwuit.util.Resources;
import javax.microedition.midlet.*;

/**
 * @author PKumar
 */
public class EntryScreen extends MIDlet {

    
   // private Display display = null;
    
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
                    new MainScreen(getInstance()).show();
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

//    public Command[] commonCommand(){
//         return new Command[]{select,exit};
//    }
}
