package main.java.view;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import main.java.controller.ControladorRequerimientosReto4;
import main.java.model.vo.Requerimiento1;
import main.java.model.vo.Requerimiento2;
import main.java.model.vo.Requerimiento3;

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
        tbd.addTab("Consulta requerimientos reto 5",panel);
        var panelEntrada = new JPanel();
        var btnConsulta1 = new JButton("Consulta requerimiento 1");
        var btnConsulta2 = new JButton("Consulta requerimiento 2");
        var btnConsulta3 = new JButton("Consulta requerimiento 3");
        btnConsulta1.addActionListener(e ->cargarTablaConsulta1());
        panelEntrada.add(btnConsulta1);
        btnConsulta2.addActionListener(e ->cargarTablaConsulta2());
        panelEntrada.add(btnConsulta2);
        btnConsulta3.addActionListener(e ->cargarTablaConsulta3());
        panelEntrada.add(btnConsulta3);
        panel.add(panelEntrada, BorderLayout.PAGE_START);
        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }
   
    private void cargarTablaConsulta1() {
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
    private void cargarTablaConsulta2() {
        try {
            var lista2 = controlador.consultarRequerimiento_2();
            var tableModel2 = new Requerimiento2Tablemodel();
            tableModel2.setData(lista2);
            tabla.setModel(tableModel2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private class Requerimiento2Tablemodel extends AbstractTableModel{
        private ArrayList<Requerimiento2> data2;

        public void setData(ArrayList<Requerimiento2>data2){
            this.data2 = data2;
        }

        @Override
        public String getColumnName(int column){
            switch(column){
                case 0:
                    return "CIUDAD";
                case 1:
                    return "CONSTRUCTORA";
                case 2:
                    return "ID_PROYECTO";
                case 3:
                    return "ESTRATO";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data2.size();
        }
        @Override
        public int getColumnCount() {
            return 4;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro2 = data2.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return registro2.getCiudad();
                case 1:
                    return registro2.getConstructora();
                case 2:
                    return registro2.getId_proyecto();
                case 3:
                    return registro2.getEstrato();
            }
            return null;
        }

    }

    private void cargarTablaConsulta3() {
        try {
            var lista3 = controlador.consultarRequerimiento_3();
            var tableModel3 = new Requerimiento3Tablemodel();
            tableModel3.setData(lista3);
            tabla.setModel(tableModel3);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class Requerimiento3Tablemodel extends AbstractTableModel{
        private ArrayList<Requerimiento3> data3;

        public void setData(ArrayList<Requerimiento3>data3){
            this.data3 = data3;
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
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data3.size();
        }
        @Override
        public int getColumnCount() {
            return 3;
        }
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var registro3 = data3.get(rowIndex);
            switch(columnIndex){
                case 0:
                    return registro3.getNombre();
                case 1:
                    return registro3.getApellido();
                case 2:
                    return registro3.getId_lider();
            }
            return null;
        }

    }
}
