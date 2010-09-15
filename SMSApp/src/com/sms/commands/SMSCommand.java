/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.commands;


import com.sms.interfaces.screen.IScreen;
import javax.microedition.lcdui.Command;

/**
 *
 * @author PKumar
 */
public abstract class SMSCommand extends Command{

    public SMSCommand(String title,int type, int priority){
        super(title,type,priority);
    }
    
     public SMSCommand(String title,String longLabel,int type, int priority){
        super(title,longLabel,type,priority);
    }

    public abstract void execute(IScreen screen);

}
