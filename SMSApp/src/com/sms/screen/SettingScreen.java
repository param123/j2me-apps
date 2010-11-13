package com.sms.screen;


import com.sms.controller.AppController;
import com.sun.lwuit.ButtonGroup;
import com.sun.lwuit.Command;

import com.sun.lwuit.Component;
import com.sun.lwuit.Form;
import com.sun.lwuit.Label;
import com.sun.lwuit.M3G;
import com.sun.lwuit.RadioButton;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.events.FocusListener;
import com.sun.lwuit.layouts.BoxLayout;
import com.sun.lwuit.plaf.Style;


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

        private RadioButton createRB(String label, ButtonGroup g, Form f) {
            final RadioButton b = new RadioButton(label);
            b.addFocusListener(new FocusListener() {

            public void focusGained(Component arg0) {
               b.setSelected(true);
            }

            public void focusLost(Component arg0) {
              b.setSelected(false);
            }
        });
            Style s = b.getStyle();
            s.setMargin(0, 0, 0, 0);
            s.setBgTransparency(70);
            g.add(b);
            f.addComponent(b);
            return b;
      }

	protected void init() {
		settingForm = new Form(getName());
                settingForm.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
                Label title = new Label("Please select a transition type:");
                title.getStyle().setMargin(0, 0, 0, 0);
                title.getStyle().setBgTransparency(70);
                settingForm.addComponent(title);
                
                final ButtonGroup radioButtonGroup = new ButtonGroup();
                createRB("Default", radioButtonGroup, settingForm);
                if(M3G.isM3GSupported()){
                  createRB("Cube", radioButtonGroup, settingForm);
                }
                radioButtonGroup.setSelected(0);

                settingForm.addCommand(new Command("Select"){
                    public void actionPerformed(ActionEvent evt){
	             switch(radioButtonGroup.getSelectedIndex()){
                            case 0:
                                MainScreen.restorDefaultTransition();
                                break;
                            case 1:
                                MainScreen.setTransitionValue(com.sun.lwuit.animations.Transition3D.createCube(500, true),com.sun.lwuit.animations.Transition3D.createCube(500, false));
                                 ((com.sun.lwuit.animations.Transition3D)MainScreen.getOutTransition()).setHighQualityMode(true);
                                 ((com.sun.lwuit.animations.Transition3D)MainScreen.getInTransition()).setHighQualityMode(true);
                                break;
                        }
                        MainScreen.setTransition(settingForm);
                        appController.back.actionPerformed(null);
	          }
                });
                appController.addCommonCommand(settingForm);
                MainScreen.setTransition(settingForm);
            }

}
