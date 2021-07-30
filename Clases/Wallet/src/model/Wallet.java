package model;

import java.util.ArrayList;

public class Wallet {
    public static final int CAPACIDAD_MAXIMA = 1000000;//su valor no cambia y tiene valor inicial
    private int saldo;
    private boolean tieneLimite;
    private int meta;
    /**
     * Listas
     */
    private ArrayList <Transaction> transactions;

    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
        transactions = new ArrayList<>();
    }

    public float getSaldo(){
        return saldo;
    }

    public boolean getTieneLimite(){
        return tieneLimite;
    }

    public boolean establecerMeta(int value){
        if(value == 0){
            meta = value;
            return true;
        }
        if(value < 0 || value <= saldo || (value > CAPACIDAD_MAXIMA && tieneLimite)){
            return false;
        }
        meta = value;
        return true;  
    }

    public boolean verificarMeta(){
        if(meta == 0 || meta > saldo){
            return false;
        }
        return true;
    }

    public void setTieneLimite(boolean newtieneLimite){
        this.tieneLimite = newtieneLimite;
    }

    public String saveMoney(int value){
        if(saldo + value > CAPACIDAD_MAXIMA && tieneLimite){
            return "El saldo excede la capacidad maxima " + CAPACIDAD_MAXIMA;
        }
        saldo += value;
        Transaction transaction = new Transaction(value, "hoy", 1,"Ingreso dinero");
        transactions.add(transaction);
        if(verificarMeta()){
            System.out.println("haz cumplido la meta");
        }
        return "Transaccion exitosa, nuevo saldo " + saldo;
    }

    public String takeMoney(int value){
        if(saldo<value){
            return "SAldo insuficiente";
        }
        saldo-= value;
        Transaction transaction = new Transaction(value, "hoy", 2, "retiro de dinero");
        transactions.add(transaction);
        return "Transacción exitosa, nuevo saldo "+ saldo;
    }

    public String breakLimt(){
        if(!tieneLimite){
            return "Tu cuenta no tiene limite";
        }
        if(saldo >= 10000){
            saldo-=10000;
            setTieneLimite(false);
            Transaction transaction = new Transaction(saldo, "hoy", 3,"Rompe limite");
            transactions.add(transaction);
            return "Has roto los limites";
        }
        return "No tienes saldo suficiente ";
    }
     public String compararCuenta(Wallet otraWallet){
        if(saldo == otraWallet.getSaldo()){
            return "las cuentas son iguales";
        }if(saldo > otraWallet.getSaldo()){
            return "La primera cuenta es mayor";
        }
        return "La segunda cuenta es mayor";
     }
     public void displayMovimientos(){
         for(Transaction transaction : transactions){
             System.out.println(transaction);
         }
     }
}
