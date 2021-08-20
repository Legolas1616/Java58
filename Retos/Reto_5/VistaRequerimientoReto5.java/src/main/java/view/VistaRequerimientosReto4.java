package main.java.view;
import main.java.controller.ControladorRequerimientosReto4;
import main.java.model.vo.Requerimiento1;
import main.java.model.vo.Requerimiento2;
import main.java.model.vo.Requerimiento3;

public class VistaRequerimientosReto4 {
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();
    public static void requerimiento1(){
        try{
            var requerimiento_1s = controlador.consultarRequerimiento_1();
            System.out.println("*** Lideres por Salario ***");
           for(Requerimiento1 requerimiento1 : requerimiento_1s){
                System.out.println("El Lider "+requerimiento1.getNombre()+" "+requerimiento1.getApellido()+" con Id "+requerimiento1.getId()+" Tiene un salario de "+requerimiento1.getSalario());
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void requerimiento2(){     
        try{
            var requerimiento_2s = controlador.consultarRequerimiento_2();
            System.out.println("*** Proyectos por Tipo ***");
            for(Requerimiento2 requerimiento2 : requerimiento_2s){
                System.out.println("El proyecto con ID "+requerimiento2.getId_proyecto()+" de la constructora: "+requerimiento2.getConstructora()+" de la ciudad "+requerimiento2.getCiudad()+", tiene un estrato asignado igual a "+requerimiento2.getEstrato());
            }
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void requerimiento3(){
        try{
            var requerimiento_3s = controlador.consultarRequerimiento_3();
            System.out.println("*** Lideres por Nombre ***");
            for(Requerimiento3 requerimiento3 : requerimiento_3s){
                System.out.println("El Lider con Id "+requerimiento3.getId_lider()+" se llama "+requerimiento3.getNombre()+" "+requerimiento3.getApellido());
            }  
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
