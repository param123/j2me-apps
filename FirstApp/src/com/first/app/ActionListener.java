/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.first.app;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;

/**
 *
 * @author PKumar
 */
public class ActionListener implements CommandListener {

    public void commandAction(Command c, Displayable d) {

        int commandType = c.getCommandType();

        switch(commandType){
            case Command.OK:
                break;
            case Command.EXIT:
                break;
            case Command.CANCEL:
                break;
            default:
        }
    }

}
