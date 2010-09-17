package com.sms.screen;

import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Form;

public class SentScreen extends AbstractScreen implements IScreen {

	public SentScreen(EntryScreen midlet) {
		super(midlet);
		// TODO Auto-generated constructor stub
	}

	public boolean show() {
		Form sentScreen = new Form("Sent");
		enter.addCommonCommand(sentScreen);
		sentScreen.show();
		// TODO Auto-generated method stub
		return true;
	}

	public boolean destroy() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "Sent";
	}

}
