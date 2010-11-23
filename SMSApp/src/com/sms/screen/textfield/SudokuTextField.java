/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.textfield;

import com.sms.screen.algo.SudokuAlgo.Cell;
import com.sun.lwuit.Graphics;
import com.sun.lwuit.TextField;


/**
 *
 * @author PKumar
 */
public class SudokuTextField extends TextField{

   
    private Cell cell = null;

//    final private int TOP_LEFT = 11;
//    final private int LEFT_BOTTOM = 12;
//    final private int BOTTOM_RIGHT = 13;
//    final private int RIGHT_TOP = 14;
   

    public SudokuTextField(int column, Cell cell){
        super(column);
        this.cell = cell;
        
       }

    protected void paintBorder(Graphics g) {
       
            int originalColor = g.getColor();
        int x = getX();
        int y = getY();
        int width = getWidth();
        int height = getHeight();
                width--;
                height--;
                for(int iter = 0 ; iter < 1 ; iter++) {
                    g.setColor(0x000000);
                    g.drawRect(x, y, width, height);
                    g.setColor( 0xFFFFFF);
                    if(checkForBottom()){
                        g.drawLine(x, y+height, x+width, y+height);
                    }

                    if(checkForRight()){
                         g.drawLine(x+width, y, x+width, y+height);
                    }
                    if(checkForLeft()){
                         g.drawLine(x, y, x, y+height);
                    }
                    if(checkForTop()){
                         g.drawLine(x, y, x+width, y);
                    }
//                    switch(paintWhiteBorder()){
////                        case TOP:
////                            g.drawLine(x, y, x+width, y);
////                            break;
////                        case LEFT:
////                             g.drawLine(x, y, x, y+height);
////                             break;
//                        case BOTTOM:
//
//                             break;
//                        case RIGHT:
//                            g.drawLine(x+width, y, x+width, y+height);
//                            break;
//                    }
//                    g.drawLine(x, y+height, x+width, y+height);
//                    g.setColor( 0xFFFFFF);
//                    g.drawLine(x, y, x, y+height);
//                    g.drawLine(x+width, y, x+width, y+height);
                    width -= 2; height -= 2;
                }

              g.setColor(originalColor);
    }

    private boolean checkForBottom(){

//        if(cell.rowNum == 0 && cell.colNum == 0){
//             return TOP_LEFT;
//        }else if(cell.rowNum == 0 && cell.colNum ==8){
//            return RIGHT_TOP;
//        }else if(cell.rowNum ==2 && cell.colNum == 0 || cell.rowNum == 5 && cell.colNum ==0 || cell.rowNum ==8 && cell.colNum == 0){
//            return LEFT_BOTTOM;
//        }else if(cell.ro){
//
//        }
//        else
        
        if(cell.rowNum == 2 || cell.rowNum == 5 || cell.rowNum == 8){
             return true;
        }
//        else if(cell.rowNum ==0 ){
//            return TOP;
//        }else if(cell.colNum == 0){
//            return LEFT;
//        }
        
      return false;
    }

    private boolean checkForRight(){
       if(cell.colNum ==2 || cell.colNum == 5 || cell.colNum == 8){
            return  true;
        }
       return false;
    }

    private boolean checkForLeft(){
        if(cell.colNum == 0){
            return true;
        }
        return false;
    }

    private boolean checkForTop(){
        if(cell.rowNum == 0){
            return true;
        }
        return false;
    }

}
