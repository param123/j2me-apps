/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;
import com.sms.screen.model.SudokuTableModel;
import com.sun.lwuit.Form;
import com.sun.lwuit.layouts.GridLayout;
import com.sun.lwuit.table.Table;

/**
 *
 * @author PKumar
 */
public class SudokuScreen extends AbstractScreen {

    private Form sudokuForm = null;
    

    public SudokuScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
       sudokuForm.show();
       return true;
    }

    protected void init() {
        sudokuForm = new Form(getName());
        //GridLayout layout = new GridLayout(3, 3);
        sudokuForm.setLayout(new GridLayout(3, 3));
        for(int i=0;i<9;i++){
            Table table = new Table(new SudokuTableModel());
            table.setLayout(new GridLayout(3, 3));
            table.setIncludeHeader(false);
            table.setScrollable(false);
            table.setVisible(true);
            sudokuForm.addComponent(i, table);
        }

    }

    public boolean destroy() {
       sudokuForm = null;
       return true;
    }

    public String getName() {
        return "Sudoku";
    }

}
