package main.java.controller;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.model.dao.Requerimiento_1Dao;
import main.java.model.dao.Requerimiento_2Dao;
import main.java.model.dao.Requerimiento_3Dao;
import main.java.model.vo.Requerimiento1;
import main.java.model.vo.Requerimiento2;
import main.java.model.vo.Requerimiento3;

public class ControladorRequerimientosReto4{       
    private Requerimiento_1Dao requerimiento_1Dao;
    private Requerimiento_2Dao requerimiento_2Dao;
    private Requerimiento_3Dao requerimiento_3Dao;
    
    public ControladorRequerimientosReto4(){
       this.requerimiento_1Dao = new Requerimiento_1Dao();
       this.requerimiento_2Dao = new Requerimiento_2Dao();
       this.requerimiento_3Dao = new Requerimiento_3Dao();
    }

    public ArrayList<Requerimiento1> consultarRequerimiento_1() throws SQLException {
       return requerimiento_1Dao.requerimiento1();
    }
    
    public ArrayList<Requerimiento2> consultarRequerimiento_2() throws SQLException {
        return requerimiento_2Dao.requerimiento2();
    }

    public ArrayList<Requerimiento3> consultarRequerimiento_3() throws SQLException {
        return requerimiento_3Dao.requerimiento3();
    }

}
