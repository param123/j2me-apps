package com.sms.screen;

import com.sms.controller.AppController;
import com.sun.lwuit.Form;

public class SentScreen extends AbstractScreen  {

	Form sentScreen = null;
	
	public SentScreen(AppController appController) {
		super(appController);
	}

	public void init() {
		sentScreen = new Form(getName());
		appController.addCommonCommand(sentScreen);
	}

	public boolean destroy() {
		sentScreen = null;
		return true;
	}

	public String getName() {
		return "Sent";
	}


	public boolean show() {
		sentScreen.show();
		return true;		
	}

}
