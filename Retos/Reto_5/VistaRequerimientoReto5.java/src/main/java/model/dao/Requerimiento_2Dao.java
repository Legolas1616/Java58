package main.java.model.dao;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.model.vo.Requerimiento2;
import main.java.util.JDBCUtilities;

public class Requerimiento_2Dao {
   
    public ArrayList<Requerimiento2> requerimiento2() throws SQLException {
        var response = new ArrayList<Requerimiento2>();
        String consulta = "select ID_Proyecto, Constructora, Ciudad, t.Estrato Estrato FROM Proyecto p inner join Tipo t on t.ID_Tipo  = p.ID_Tipo where p.Ciudad = 'Cartagena' order by t.Estrato ASC ";
        try(var connection = JDBCUtilities.getConnection();
            var statement = connection.prepareStatement(consulta);
            var rset = statement.executeQuery();){
            while(rset.next()){
                var requerimiento2_VO = new Requerimiento2();
                requerimiento2_VO.setCiudad(rset.getString("Ciudad"));
                requerimiento2_VO.setConstructora(rset.getString("Constructora"));
                requerimiento2_VO.setId_proyecto(rset.getInt("ID_Proyecto"));
                requerimiento2_VO.setEstrato(rset.getString("Estrato"));
                response.add(requerimiento2_VO);
            }
        }
        return response;
    }
        
}
