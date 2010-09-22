/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;



import com.sms.controller.AppController;
import com.sms.interfaces.screen.IScreen;


/**
 *
 * @author PKumar
 */
public abstract class AbstractScreen implements IScreen {

    protected AppController appController = null;
    public AbstractScreen(AppController appController){
    	this.appController = appController;
//    	appController.registerScreen(this);
    }
    
    public abstract boolean show();
    
    protected abstract void init();
    
    public final boolean launchUI(boolean reload){
        System.gc();
    	init();
    	maintainPreviousState(reload);
    	boolean flag = show();
    	if(flag){
    	  afterLauncUI();
    	}
    	return flag;
    }
    
    protected void afterLauncUI(){
    	appController.updateDisplayOrder(this);
    }
      
    protected void maintainPreviousState(boolean maintain){}
    
    
//    public void addCommonCommand(Screen screen){
//         Command[] command = enter.commonCommand();
//        for (int i=0;i<command.length;i++) {
//          screen.addCommand(command[i]);
//        }
//    }

     
}
