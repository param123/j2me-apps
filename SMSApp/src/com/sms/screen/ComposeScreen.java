package com.sms.screen;

import com.sms.controller.AppController;
import com.sun.lwuit.Form;

public class ComposeScreen extends AbstractScreen {

	private Form compose = null;
	
	public ComposeScreen(AppController appController) {
		super(appController);
	}

	public boolean show() {
		compose.show();
		return true;
	}

	public boolean destroy() {
		return false;
	}

	public String getName() {
		return "Compose";
	}

	protected void init() {
		compose = new Form(getName());
		appController.addCommonCommand(compose);		
	}

}
