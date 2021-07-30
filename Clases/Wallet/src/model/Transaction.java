package model;

public class Transaction {
    private int amount;
    private String fecha;
    private int type;
    private String descripcion;
    /**
     * Tipo de transaccion
     * 1 ingreso de dinero
     * 2 retiro de dinero
     */
   
    /**
     * 
     * @param amount
     * @param fecha
     * @param type
     */
    public Transaction(int amount,String fecha, int type, String descripcion) {
        super();
        this.amount = amount;
        this.fecha = fecha;
        this.type = type;
        this.descripcion = descripcion;
    }
    public int getAmount() {
        return amount;
    }
    public String getFecha() {
        return fecha;
    }
    public int getType() {
        return type;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public String toString(){
        return "Monto: $ "+ amount + " fecha: "+fecha+" Tipo: "+type+" Descripcion: "+descripcion;
    }
}
