package registrodeasistenciav1;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Brayand
 */
public class resaltarfilastable extends DefaultTableCellRenderer{

    private Component componente;
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componente = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    if(table.getValueAt(row, 5).toString().equals("hora sin registrar")){
        setBackground(Color.red);
    }
    else
        setBackground(Color.getColor("204, 255, 255"));
    
    return componente;
    }
}
