/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.list;

import com.sms.interfaces.screen.IScreen;
import javax.microedition.lcdui.Image;

/**
 *
 * @author PKumar
 */
public class ListItem {

    private String itemName = null;
    private IScreen screen = null;
    private Image image = null;

     public ListItem(String iname,IScreen iscreen) {
        this(iname, iscreen, null);
    }

    public ListItem(String iname,IScreen iscreen,Image image) {
        if(iname==null || iscreen ==null){
            throw new NullPointerException((iname==null?"List item name":"screen")+"can't be null.");
        }
         this.itemName = iname;
         this.screen = iscreen;
    }

    public String getItemName(){
           return itemName;
    }

    public IScreen getIScreen(){
         return screen;
    }

    public Image getImage(){
        return image;
    }

}
