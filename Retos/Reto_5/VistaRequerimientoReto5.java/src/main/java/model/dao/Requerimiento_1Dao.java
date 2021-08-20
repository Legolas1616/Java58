package main.java.model.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.model.vo.Requerimiento1;
import main.java.util.JDBCUtilities;

public class Requerimiento_1Dao {
    public ArrayList<Requerimiento1> requerimiento1() throws SQLException {
        var response = new ArrayList<Requerimiento1>();
        String consulta = "select ID_Lider,Nombre,Primer_Apellido,Salario from lider where Salario = 500000 or Salario < 500000 ORDER BY Salario";
        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery();){
            while(rset.next()){
                var requerimiento1_VO = new Requerimiento1();
                requerimiento1_VO.setNombre(rset.getString("Nombre"));
                requerimiento1_VO.setApellido(rset.getString("Primer_Apellido"));
                requerimiento1_VO.setId(rset.getInt("ID_Lider"));
                requerimiento1_VO.setSalario(rset.getInt("Salario"));
                response.add(requerimiento1_VO);
            }
        }
        return response;
    }
}
