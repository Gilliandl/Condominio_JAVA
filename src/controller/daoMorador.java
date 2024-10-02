
package controller;

import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Morador;

public class daoMorador extends dao{
    
    public int create(Morador morador) throws SQLException{
         return super.executeUpdate("insert into morador (nome,cpf) values (?,?)",morador.getNome(),morador.getCpf());
    }
    
    public int update(Morador morador) throws SQLException{
        String SQL = "update morador set nome = ?, cpf = ? where id = ? ";
        return super.executeUpdate(SQL, morador.getNome(),morador.getCpf(),morador.getId());
    }
    
    public int delete(Morador morador) throws SQLException{
        return super.executeUpdate("delete from morador where id =" + morador.getId());
    }
    
    public Morador read(int id) throws SQLException{
        String SQL="select * from morador where id=?";
        ResultSet rs = super.executeQuery(SQL, id);
        
        return(!rs.next() ? null : montaObjeto(rs));   
    }
    
    public List<Morador> read() throws SQLException{
        String SQL = "select * from morador order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Morador> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;  
    }
    
    //método que faz o mapeamento de um registro relacional em objeto
    private Morador montaObjeto(ResultSet rs) throws SQLException{
        Morador morador = new Morador();
        morador.setId(rs.getInt("id"));
        morador.setNome(rs.getString("nome"));
        morador.setCpf(rs.getString("cpf"));
        return morador;
    }
    
}
