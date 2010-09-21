package com.sms.controller;
import java.util.Hashtable;

import com.sms.interfaces.screen.IParent;
import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.events.ActionEvent;


public class AppController {
	
	    private Hashtable screenNameValue = null;
	    private IScreen[] displayOrder = new IScreen[10];
	    private int stackSize = 0;
	    private IParent parent = null;
	    
	    public AppController(IParent parent){
	    	this.parent = parent;
	    	screenNameValue = new Hashtable();
	    }
	    
	    public Object getScreen(Object key){
	    	return screenNameValue.get(key);
	    }
	    
	    public void registerScreen(IScreen screen){
	    	screenNameValue.put(screen.getName(), screen);
	    }
	    
	    public void unregisterScreen(Object key){
	    	screenNameValue.remove(key);
	    }
	    
	    public void addCommonCommand(Form form){
	    	form.addCommand(back);
	    	form.addCommand(getParent().getCommand());
	    }
	    

	    public Command back = new Command("Back", 1) {
	        public void actionPerformed(ActionEvent evt){
	        	IScreen current = displayOrder[--stackSize];
	            displayOrder[stackSize] = null;
	            current.destroy();
	            IScreen previous = displayOrder[--stackSize];
	            displayOrder[stackSize] = null;
	            previous.launchUI(true);
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
	    
	    public IParent getParent(){
	    	return parent;
	    }

}
