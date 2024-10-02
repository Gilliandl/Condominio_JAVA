
package controller;

import abstratas.dao;
import controller.daoApartamento;
import enums.Limpeza;
import enums.Reserva;
// import java.sql.ResultSet;
//import java.sql.SQLException;
import model.salaoFesta;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Apartamento;



public class daoSalaofesta extends dao{
    
        public int create(salaoFesta salaofesta) throws SQLException{
        String SQL = "Insert into salao_festa (data_reserva,reserva,limpeza,id_apartamento) values(?,?,?,?)";
        return super.executeUpdate(SQL, salaofesta.getDatareserva(),salaofesta.getReserva().name(),salaofesta.getLimpeza().name(),salaofesta.getApartamento().getId());
    }
    
    public int update(salaoFesta salaofesta) throws SQLException{
        String SQL = "update salao_festa set data_reserva = ?, reserva = ?, limpeza = ?, id_apartamento = ? where id = ? ";
        return super.executeUpdate(SQL, salaofesta.getDatareserva(),salaofesta.getReserva().name(),salaofesta.getLimpeza().name(),salaofesta.getApartamento().getId());
    }
    
    public int delete(salaoFesta salaofesta) throws SQLException{
        return super.executeUpdate("delete from salao_festa where id=" + salaofesta.getId());
    }
    
    public List<salaoFesta> read() throws SQLException{
        String SQL = "select * from salao_festa order by data_reserva";
        ResultSet rs = super.executeQuery(SQL);
        List<salaoFesta> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;  
    }
    public salaoFesta read(int id) throws SQLException{
        String SQL = "select * from salao_festa where id = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
        
    }
    
//método que faz o mapeamento de um registro relacional em objeto
    private salaoFesta montaObjeto(ResultSet rs) throws SQLException{
        salaoFesta s = new salaoFesta();
        s.setId(rs.getInt("id"));
        s.setDatareserva(rs.getDate("data_reserva").toLocalDate());
        
        Reserva rsva = Reserva.valueOf(rs.getString("reserva"));
        Limpeza lpz = Limpeza.valueOf(rs.getString("limpeza"));
        
        Apartamento a = new daoApartamento().read(rs.getInt("id_apartamento"));
        s.setApartamento(a);
      
        
        return s;
    }
    
}