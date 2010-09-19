package com.sms.screen;

import javax.microedition.midlet.MIDlet;

import com.sms.controller.AppController;
import com.sms.interfaces.screen.IParent;
import com.sms.interfaces.screen.IScreen;
import com.sms.util.Util;
import com.sun.lwuit.Button;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;


public class MainScreen implements ActionListener,IParent{
	
	
	private MIDlet midlet = null;
	private IScreen screens[] = null;
	private AppController controller = null;
		
    public MainScreen(MIDlet midlet) {
		this.midlet = midlet;
		controller = new AppController(this);
		screens = new IScreen[2];
		screens[0] = new MessageScreen(controller);
		screens[1] = new SettingScreen(controller);
	}
    
    
    public void displayUI(){
    	Form mainForm = new Form("J2ME Apps");
    	mainForm.setLayout(new GridLayout(3, 2));
    	for (int i = 0; i < screens.length; i++) {
			Button b = new Button(screens[i].getName(), Util.getInstance().getImage(screens[i].getName()+"_un"));
			b.setUIID("J2MEID");
	        b.setRolloverIcon(Util.getInstance().getImage(screens[i].getName()+"_sel"));
	        b.setAlignment(Label.CENTER);
	        b.setTextPosition(Label.BOTTOM);
	        mainForm.addComponent(b);
	        b.addActionListener(this);
		}
    	mainForm.show();
    }
    

	public void actionPerformed(ActionEvent event) {
		Button src = (Button)event.getSource();
		int buttonOrder = src.getParent().getComponentIndex(src);
		IScreen screen = screens[buttonOrder];
		screen.launchUI(false);	
	}


	public Command getCommand() {
		return exit;
	}

	 
	private Command exit = new Command("Exit", 1) {
	      public void actionPerformed(ActionEvent evt){
	          midlet.notifyDestroyed();
	       }
	};

}
