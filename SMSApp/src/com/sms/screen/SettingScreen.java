package com.sms.screen;


import com.sms.controller.AppController;
import com.sun.lwuit.Form;

public class SettingScreen extends AbstractScreen {
	
	private Form settingForm = null;

	public SettingScreen(AppController appController) {
		super(appController);
	}

	public boolean destroy() {
        settingForm = null;
		return true;
	}

	public String getName() {
		return "Settings";
	}

	public boolean show() {
		settingForm.show();
		return true;
	}


	protected void init() {
		settingForm = new Form(getName());
		appController.addCommonCommand(settingForm);
	}

}
