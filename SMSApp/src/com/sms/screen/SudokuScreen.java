/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;
import com.sun.lwuit.Form;

/**
 *
 * @author prabhat
 */
public class SudokuScreen extends AbstractScreen{

    private Form sudoku = null;
    

    public SudokuScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
        sudoku.show();
        return true;
    }

    protected void init() {
        sudoku = new Form("Sudoku");
    }

    public boolean destroy() {
        sudoku = null;
        return true;
    }

    public String getName() {
        return "Sudoku";
    }

}
