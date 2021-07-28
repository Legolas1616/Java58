package views;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class Panel extends JPanel implements ActionListener {

    public final static String BTN_SALDO = "Saldo";
    public final static String BTN_CARGAR = "Cargar";
    //crear relaciones o atributos
    private JButton btnSaldo;
    private JButton btnCargar;
    private JLabel Label1;
    private Interfaz interfaz1;
   

    public Panel(Interfaz i){
        
        super();
        setLayout( new GridLayout(1,1));
        setBorder(new TitledBorder("Opciones"));
        interfaz1 = i;
        //inicialiaza los atributos
        btnSaldo = new JButton(BTN_SALDO);
        btnCargar = new JButton(BTN_CARGAR);
        Label1 = new JLabel("Seleccione una opción");
        //modificar las propiedades
        btnSaldo.setActionCommand(BTN_SALDO);
        btnSaldo.addActionListener(this);
        btnCargar.setActionCommand(BTN_CARGAR);
        btnCargar.addActionListener(this);
        //Agregar las relaciones o atributos
        add(Label1);
        add(btnSaldo);
        add(btnCargar);   
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getActionCommand().equals(BTN_SALDO)){
            Label1.setText("Oprime boton saldo");
            JOptionPane.showMessageDialog(interfaz1, "El saldo es:","Saldo Wallet",JOptionPane.WARNING_MESSAGE);
            //System.out.println("Oprimio Saldo");
        }
        if(e.getActionCommand().equals(BTN_CARGAR)){
            Label1.setText("Oprime boton cargar");
            JOptionPane.showMessageDialog(interfaz1, "Cargar wallet con:","Cargar Wallet",JOptionPane.WARNING_MESSAGE);
            //System.out.println("Oprimio Cargar");
        }
    }
}