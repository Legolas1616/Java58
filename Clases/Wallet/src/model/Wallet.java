package model;
public class Wallet {
    public static final int CAPACIDAD_MAXIMA = 1000000;//su valor no cambia y tiene valor inicial
    private int saldo;
    private boolean tieneLimite;
    private int meta;
    public Wallet() {
        super();
        saldo = 0;
        tieneLimite = true;
        meta = 0;
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
        return "Transacción exitosa, nuevo saldo "+ saldo;
    }

    public String breakLimt(){
        if(!tieneLimite){
            return "Tu cuenta no tiene limite";
        }
        if(saldo >= 10000){
            saldo-=10000;
            setTieneLimite(false);
            return "Has roto los limites";
        }
        return "No tienes saldo suficiente ";
    }
}
