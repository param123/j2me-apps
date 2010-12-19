/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.interfaces.screen;



/**
 *
 * @author PKumar
 */
public interface IScreen {

   public boolean launchUI(boolean reload);
	
    public boolean destroy();
    
    public String getName();

    public boolean callBack();
    
}
