package main.java.model.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.model.vo.Requerimiento3;
import main.java.util.JDBCUtilities;

public class Requerimiento_3Dao {
    public ArrayList<Requerimiento3> requerimiento3() throws SQLException {
        var response = new ArrayList<Requerimiento3>();
        String consulta = "select  ID_Lider ,Nombre , Primer_Apellido from Lider where Primer_Apellido like '%z' order by Nombre ASC";
        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery();){
            while(rset.next()){
                var requerimiento3_VO = new Requerimiento3();
                requerimiento3_VO.setApellido(rset.getString("Primer_Apellido"));
                requerimiento3_VO.setId_lider(rset.getInt("ID_Lider"));
                requerimiento3_VO.setNombre(rset.getString("Nombre"));
                response.add(requerimiento3_VO);
            }
        }
        return response;
    }
}