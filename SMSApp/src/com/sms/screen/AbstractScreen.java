/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.interfaces.screen.IEnter;
import com.sms.interfaces.screen.IScreen;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.Screen;

/**
 *
 * @author PKumar
 */
public abstract class AbstractScreen implements IScreen {

    protected IEnter enter = null;
    public AbstractScreen(IEnter midlet){
        enter = midlet;
    }

     public Command[] commonCommand(){
        Command select = new Command("Select", Command.ITEM, 1);
        Command exit = new Command("Exit", Command.SCREEN, 1);
        return new Command[]{select,exit};
    }

    public void addCommonCommand(Screen screen){
         Command[] command = commonCommand();
        for (int i=0;i<command.length;i++) {
          screen.addCommand(command[i]);
        }
    }

}
