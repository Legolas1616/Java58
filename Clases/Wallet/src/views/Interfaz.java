package views;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Interfaz  extends JFrame{
    private Panel Panel1;
    public Interfaz(){
        super();
        setSize(600,450); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setTitle("Wallet");
        setLayout(new BorderLayout());
        Panel1 = new Panel(this);
        add(Panel1,BorderLayout.PAGE_START);
    }
    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }
}