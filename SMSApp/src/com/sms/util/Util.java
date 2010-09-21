package com.sms.util;

import java.io.IOException;

import com.sun.lwuit.Dialog;
import com.sun.lwuit.Image;
import com.sun.lwuit.util.Resources;

public class Util {
	
	private Resources imgres = null;
	private static Util instance = null;
	
	private Util(){
		try {
			imgres =  Resources.open("/imgs.res");
		} catch (IOException ex) {
			 ex.printStackTrace();
	         Dialog.show("Exception", ex.getMessage(), "OK", null);
		}
	}
	
	public static Util getInstance(){
		if(instance==null){
			instance = new Util();
		}
		return instance;
	}
	
	public Image getImage(String name){
    	return imgres.getImage(name);
    }
	
	

}
