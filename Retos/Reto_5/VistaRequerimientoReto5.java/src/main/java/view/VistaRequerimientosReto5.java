package main.java.view;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;



import main.java.controller.ControladorRequerimientosReto4;
import main.java.model.vo.Requerimiento1;


public class VistaRequerimientosReto5 extends JFrame {
    
    private JTable tabla;
    private ControladorRequerimientosReto4 controlador;
    public VistaRequerimientosReto5(){
        controlador= new ControladorRequerimientosReto4();
        initUI();
        setLocationRelativeTo(null);
    }
    public void initUI(){
        setTitle("Reto final");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);
        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);
        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta requerimientos",panel);
        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimiento 1 "));
        var btnConsulta = new JButton("Consulta requerimiento 1");
        btnConsulta.addActionListener(e ->cargarTablaConsulta());
        panelEntrada.add(btnConsulta);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
    private void cargarTablaConsulta() {
        try {
            var lista = controlador.consultarRequerimiento_1();
            var tableModel = new Requerimiento1Tablemodel();
            tableModel.setData(lista);
            tabla.setModel(tableModel);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private class Requerimiento1Tablemodel extends AbstractTableModel{
        private ArrayList<Requerimiento1> data;

        public void setData(ArrayList<Requerimiento1>data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column){
            switch(column){
                case 0:
                    return "NOMBRE";
                case 1:
                    return "APELLIDO";
                case 2:
                    return "ID_LIDER";
                case 3:
                    return "SALARIO";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data.size();
        }
        @Override
        public int getColumnCount() {
            return 4;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro = data.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return registro.getNombre();
                case 1:
                    return registro.getApellido();
                case 2:
                    return registro.getId();
                case 3:
                    return registro.getSalario();
            }
            return null;
        }

    }
}
