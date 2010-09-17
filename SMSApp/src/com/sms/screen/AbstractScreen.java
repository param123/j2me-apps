/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;



import com.sms.interfaces.screen.IScreen;


/**
 *
 * @author PKumar
 */
public abstract class AbstractScreen implements IScreen {

    protected EntryScreen enter = null;
    public AbstractScreen(EntryScreen midlet){
        enter = midlet;
        enter.registerScreen(this);
    }
    
    public abstract boolean show();
    
    public final boolean launchUI(){
    	boolean flag = show();
    	if(flag){
    	  afterLauncUI();
    	}
    	return flag;
    }
    
    public void afterLauncUI(){
    	enter.updateDisplayOrder(this);
    }
    
//    public void addCommonCommand(Screen screen){
//         Command[] command = enter.commonCommand();
//        for (int i=0;i<command.length;i++) {
//          screen.addCommand(command[i]);
//        }
//    }

     
}
