/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.list;

import javax.microedition.lcdui.List;

/**
 *
 * @author PKumar
 */
public class SMSList extends List{

    //We don't expect item count will go beyond 10.
    private ListItem[] itemList  = new ListItem[10];
    private int count=0;
    public SMSList(String title,int mode){
        super(title, mode);
    }

    public void addItem(ListItem item){
        append(item.getItemName() , item.getImage());
        itemList[count++]=item;
    }

    public ListItem getListItem(int index){
        return itemList[index];
    }
    
}
