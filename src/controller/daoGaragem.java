
package controller;

import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Garagem;

public class daoGaragem extends dao{
    
    public int create(Garagem garagem) throws SQLException{
         return super.executeUpdate("insert into garagem (nome_box) values (?)",garagem.getNome_box());
    }
    
    public int update(Garagem garagem) throws SQLException{
        String SQL = "update garagem set nome_box = ? where id = ? ";
        return super.executeUpdate(SQL, garagem.getNome_box(),garagem.getId());
    }
    
    public int delete(Garagem garagem) throws SQLException{
        return super.executeUpdate("delete from garagem where id =" + garagem.getId());
    }
    
    public Garagem read(int id) throws SQLException{
        String SQL="select * from garagem where id=?";
        ResultSet rs = super.executeQuery(SQL, id);
        
        return(!rs.next() ? null : montaObjeto(rs));   
    }
    
    public List<Garagem> read() throws SQLException{
        String SQL = "select * from garagem order by nome_box";
        ResultSet rs = super.executeQuery(SQL);
        List<Garagem> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;  
    }
    
    //método que faz o mapeamento de um registro relacional em objeto
    private Garagem montaObjeto(ResultSet rs) throws SQLException{
        Garagem garagem = new Garagem();
        garagem.setId(rs.getInt("id"));
        garagem.setNome_box(rs.getString("nome_box"));
        return garagem;
    }
    
}
