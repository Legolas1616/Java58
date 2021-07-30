package test;

import model.Client;

public class Test {
    
    public static void main(String[] args) {
        Test iniciarPruebas = new Test();
        iniciarPruebas.escenarioClient();
    }
    

    public void escenarioClient(){
        Client cliente1 = new Client("Esteban");
        boolean test1 = asserEquals("Esteban",cliente1.getNombre());
        boolean test2 = assertNotnull(cliente1.getWallet());
        System.out.println((test1)?"paso la prueba de nombre":"Error el nombre no es igual");
        System.out.println((test2)?"La wallet es valida":"Error no existe la wallet");
    }

    public boolean asserEquals(String expected, String received){
        if(expected.equalsIgnoreCase(received)){
            return true;
        }
        return false;
    }
    public boolean assertNotnull(Object objeto){
        if(objeto != null){
            return true;
        }
        return false;
    }
}
