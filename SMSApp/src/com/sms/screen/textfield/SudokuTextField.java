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
    

    public SudokuTextField( int column, Cell cell){
        super(column);
        this.cell = cell;
        setText(cell.toString());
        
        if(cell.toString().length()>0){
            setEditable(false);
            setFocusable(false);
            getStyle().setFgColor(0x3D8BFF);//, true);
          }
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
                    if(checkForBottom4Black()){
                         g.drawLine(x, y+height, x+width, y+height);
                    }

                    if(checkForRight4Black()){
                         g.drawLine(x+width, y, x+width, y+height);
                    }
                 
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

                    width -= 1; height -= 1;
                }

              g.setColor(originalColor);
    }

    private boolean checkForBottom4Black(){
        return cell.rowNum >=0 && cell.rowNum <=7;
    }

    private boolean checkForRight4Black(){
        return cell.colNum >=0 && cell.colNum <=7;
    }

    private boolean checkForBottom(){
        
        if(cell.rowNum == 2 || cell.rowNum == 5 || cell.rowNum == 8){
             return true;
        }
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


    public void keyPressed(int key){
       System.out.println("key=="+key);
        if(key>48 && key <58 && key == -9){
            clear();
         }
    }

    
    public void keyReleased(int key){
      
        if(key>48 && key <58){
            super.keyReleased(key);
         }
    }

}
