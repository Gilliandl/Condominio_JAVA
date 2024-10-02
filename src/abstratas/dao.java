
package abstratas;

import java.sql.*;

abstract public class dao {
    
    public PreparedStatement getStatement(String SQL) throws SQLException{
        return Dados.getConnection().prepareStatement(SQL);
    }
    
    public int executeUpdate(String SQL, Object... parametro) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < parametro.length; i++) {
            pst.setObject((i+1), parametro[i]);
        }
        return pst.executeUpdate();
    }
    
    public ResultSet executeQuery(String SQL, Object... parametro) throws SQLException{
        PreparedStatement pst = getStatement(SQL);
        for (int i = 0; i < parametro.length; i++) {
            pst.setObject((i+1), parametro[i]);
        }
        return pst.executeQuery();
    }
}
