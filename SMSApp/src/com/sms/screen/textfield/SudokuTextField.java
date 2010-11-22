/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.textfield;

import com.sun.lwuit.Graphics;
import com.sun.lwuit.TextField;
import com.sun.lwuit.plaf.Border;

/**
 *
 * @author PKumar
 */
public class SudokuTextField extends TextField{

    public SudokuTextField(int column){
        super(column);
    }

    protected void paintBorder(Graphics g) {
       
            int originalColor = g.getColor();
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();


//            case TYPE_LINE:
                width--;
                height--;
                for(int iter = 0 ; iter < 1 ; iter++) {
                    g.setColor(0x000000);
                    g.drawLine(x, y, x+width, y);
                    g.drawLine(x, y+height, x+width, y+height);
                    g.setColor( 0xFFFFFF);
                    g.drawLine(x, y, x, y+height);
                    g.drawLine(x+width, y, x+width, y+height);
//                    g.drawRect(x + iter, y + iter, width, height);
                    width -= 2; height -= 2;
                }

              g.setColor(originalColor);

        
    }

}
