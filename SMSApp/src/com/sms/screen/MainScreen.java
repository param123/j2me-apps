/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;



import com.sms.commands.SMSCommand;
import com.sms.screen.list.ListItem;
import com.sms.screen.list.SMSList;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.List;

/**
 *
 * @author PKumar
 */
public class MainScreen extends AbstractScreen implements CommandListener {

    private SMSList itemList = null;

    public MainScreen(EntryScreen enter){
        super(enter);
    }

    

    public boolean show() {
        itemList = new SMSList("Messages", List.IMPLICIT);
        itemList.addItem(new ListItem("Inbox", this));
        itemList.addItem(new ListItem("Compose", this));
        itemList.addItem(new ListItem("Sent", this));
        addCommonCommand(itemList);
        itemList.setCommandListener(this);
        enter.getDisplay().setCurrent(itemList);

        return true;
    }

    public boolean action() {
        ListItem item = itemList.getListItem(itemList.getSelectedIndex());
        if(item.getIScreen().show()){
            destroy();
        }
        return true;
    }

    public boolean destroy() {
        itemList = null;
        return true;
    }

    public void commandAction(Command c, Displayable d) {
         System.out.println(c+" label : "+c.getLabel()+" commandType : "+c.getCommandType()+"  priority : "+c.getPriority());
        if(c instanceof SMSCommand){
          ((SMSCommand)c).execute(this);
        }else{
           
        }

    }
}
