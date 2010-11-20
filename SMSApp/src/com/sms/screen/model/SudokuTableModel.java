/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.screen.model;

import com.sms.screen.algo.SudokuAlgo.Region;
import com.sun.lwuit.events.DataChangedListener;
import com.sun.lwuit.table.TableModel;

/**
 *
 * @author PKumar
 */
public class SudokuTableModel implements TableModel{

    private Region region = null;

    public SudokuTableModel() {

    }

    public int getRowCount() {
        return 3;
    }

    public int getColumnCount() {
      return getRowCount();
    }

    public String getColumnName(int arg0) {
        return "";
    }

    public boolean isCellEditable(int arg0, int arg1) {
        return true;
    }

    public Object getValueAt(int arg0, int arg1) {
       return region.getCell(new int[]{arg0,arg1});
      }

    public void setValueAt(int arg0, int arg1, Object arg2) {
        region.setCell(new int[]{arg0,arg1}, Integer.parseInt(arg2.toString()));
    }

    public void addDataChangeListener(DataChangedListener arg0) {
       
    }

    public void removeDataChangeListener(DataChangedListener arg0) {
       
    }

    public void setRegion(Region region){
        this.region = region;
    }

}
