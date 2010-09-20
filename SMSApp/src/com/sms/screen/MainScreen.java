package com.sms.screen;

import com.sun.lwuit.Command;

import com.sms.controller.AppController;
import com.sms.interfaces.screen.IParent;
import com.sms.interfaces.screen.IScreen;
import com.sms.util.Util;
import com.sun.lwuit.Button;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.ActionListener;
import com.sun.lwuit.layouts.GridLayout;


public class MainScreen extends AbstractScreen implements ActionListener,IParent{

    private Form mainForm  = null;
    
    public MainScreen(AppController controller) {
                super(controller);
	}

	public void actionPerformed(ActionEvent event) {
		//Button src = (Button)event.getSource();
		int buttonOrder = mainForm.getComponentIndex( mainForm.getFocused());//src.getParent().getComponentIndex(src);
                launchChildScreen(buttonOrder);
	}

        public boolean show() {
                  mainForm.show();
                  return true;
        }

    protected void init() {
        mainForm = new Form(getName());
    	mainForm.setLayout(new GridLayout(5, 4));
        String screens[] = getChildScreensName();
    	for (int i = 0; i < screens.length; i++) {
		Button b = new Button(screens[i], Util.getInstance().getImage(screens[i]+"_un"));
		b.setUIID("J2MEID");
	        b.setRolloverIcon(Util.getInstance().getImage(screens[i]+"_sel"));
	        b.setAlignment(Label.CENTER);
	        b.setTextPosition(Label.BOTTOM);
	        mainForm.addComponent(b);
	        b.addActionListener(this);
	}
       
       mainForm.addCommand(new Command("Select"));
       appController.getParent().addCommand(mainForm);
//       mainForm.addCommand(getCommand());
//       addCommand(mainForm);
       mainForm.setCommandListener(this);
     }

    public boolean destroy() {
       mainForm = null;
       return true;
    }

    public String getName() {
        return "J2ME Apps";
    }

    public void addCommand(Form form) {
       //appController.getParent().addCommand(form);
    }

    private String[] getChildScreensName(){
       return new String[]{"SMS","Settings"};
    }

    private void launchChildScreen(int index){
        IScreen screen = null;
        switch(index){
            case 0:
                screen = new MessageScreen(appController);
                break;
            case 1:
                screen = new SettingScreen(appController);
                break;
        }
        screen.launchUI(false);
        destroy();
    }

}
