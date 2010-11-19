/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen;

import com.sms.controller.AppController;
import com.sms.screen.algo.SudokuAlgo;
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
    private SudokuAlgo sa = null;

    public SudokuScreen(AppController appController){
        super(appController);
    }

    public boolean show() {
        sudokuForm.show();
       return true;
    }

    protected void init() {
        sa = new SudokuAlgo();
        sa.reshuffel();
        sa.init();
        sudokuForm = new Form(getName());
        
        Table table = null;
        SudokuTableModel stm = null;
        sudokuForm.setLayout(new GridLayout(3, 3));
        for(int i=0;i<9;i++){
            stm = new SudokuTableModel();
            stm.setRegion(sa.getRegion(i));
            table = new Table(stm,false);
           // table.getStyle().setMargin(0, 0, 0, 0);
            table.getStyle().setPadding(0, 0, 0, 0);
            table.setScrollable(false);
            sudokuForm.addComponent(i, table);
        }

        MainScreen.setTransition(sudokuForm);
        appController.addCommonCommand(sudokuForm);
    }

    public boolean destroy() {
       sudokuForm = null;
       sa = null;
       return true;
    }

    public String getName() {
        return "Sudoku";
    }

}
