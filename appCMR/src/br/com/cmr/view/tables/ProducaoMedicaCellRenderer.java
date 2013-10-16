/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.view.tables;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ritacosta
 */
public class ProducaoMedicaCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if(row % 2 == 0){
            setBackground(Color.YELLOW);
        }else{
            setBackground(null);
        }
        if(isSelected){
            setBackground(Color.GREEN);
        }
        int i = -1;
        table.getColumnModel().getColumn(++i).setMaxWidth(40);//0
        table.getColumnModel().getColumn(++i).setMaxWidth(60);//1
        table.getColumnModel().getColumn(++i).setMaxWidth(150);//2
        table.getColumnModel().getColumn(++i).setMaxWidth(120);//3
        table.getColumnModel().getColumn(++i).setMaxWidth(70);//4
        table.getColumnModel().getColumn(++i).setMaxWidth(60);//5
        table.getColumnModel().getColumn(++i).setMaxWidth(100);//6
        table.getColumnModel().getColumn(++i).setMaxWidth(70);//7
        table.getColumnModel().getColumn(++i).setMaxWidth(100);//8
        table.getColumnModel().getColumn(++i).setMaxWidth(70);//9
        table.getColumnModel().getColumn(++i).setMaxWidth(70);//10
        
        return this;
    }
}
