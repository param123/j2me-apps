package com.sms.screen;

import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Form;

public class ComposeScreen extends AbstractScreen implements IScreen {

	public ComposeScreen(EntryScreen midlet) {
		super(midlet);
	}

	public boolean show() {
		
		Form compose = new Form("Compose");
		enter.addCommonCommand(compose);
		compose.show();
		return true;
	}

	public boolean destroy() {
		return false;
	}

	public String getName() {
		return "Compose";
	}

}
