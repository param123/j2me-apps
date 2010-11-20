/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;
import com.sms.interfaces.screen.IScreen;
import com.sun.lwuit.Command;
import com.sun.lwuit.Form;
import com.sun.lwuit.List;
import com.sun.lwuit.events.ActionEvent;
import com.sun.lwuit.layouts.BorderLayout;

/**
 *
 * @author PKumar
 */
public class GameScreen extends AbstractScreen{

    private List gameList = null;
    private Form gameForm = null;
    private int lastListItemSelected = 0;
    
    public GameScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
        gameForm.show();
        return true;
    }

    protected void init() {
        gameForm = new Form(getName());
        gameForm.setLayout(new BorderLayout());

        gameList = new List();
        gameList.addItem("Sudoku");
        gameForm.addComponent(BorderLayout.CENTER,gameList);
        gameForm.addCommand(new Command("Select"){
            public void actionPerformed(ActionEvent evt){
            	lastListItemSelected = gameList.getSelectedIndex();
                Object itemName = gameList.getSelectedItem();
                getChildScreen(itemName.toString()).launchUI(false);
            }
        });
        MainScreen.setTransition(gameForm);
        appController.addCommonCommand(gameForm);

    }

    public boolean destroy() {
        gameForm = null;
        gameList = null;

        return true;
    }

    public String getName() {
        return "Games";
    }

    private IScreen getChildScreen(String screenName){
		IScreen screen = new SudokuScreen(appController);
		return screen;
	}

}
