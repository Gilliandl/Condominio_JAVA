
package controller;

import abstratas.dao;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;
import model.Conta;

public class daoConta extends dao{
    
    public int create(Conta conta) throws SQLException{
         return super.executeUpdate("insert into conta (data_pagamento,vl_agua,vl_energia,vl_gas,valor) values (?,?,?,?,?)",conta.getDatapagamento(),conta.getVlagua(),conta.getVlenergia(),conta.getVlgas(),conta.getValor());
    }
    
    public int update(Conta conta) throws SQLException{
        String SQL = "update conta set data_pagamento = ?, vl_agua = ?, vl_energia = ?, vl_gas = ?, valor = ? where id = ? ";
        return super.executeUpdate(SQL,conta.getDatapagamento(),conta.getVlagua(),conta.getVlenergia(),conta.getVlgas(),conta.getValor(),conta.getId());
    }
    
    public int delete(Conta conta) throws SQLException{
        return super.executeUpdate("delete from conta where id =" + conta.getId());
    }
    
    public Conta read(int id) throws SQLException{
        String SQL="select * from conta where id=?";
        ResultSet rs = super.executeQuery(SQL, id);
        
        return(!rs.next() ? null : montaObjeto(rs));   
    }
    
    public List<Conta> read() throws SQLException{
        String SQL = "select * from conta order by data_pagamento";
        ResultSet rs = super.executeQuery(SQL);
        List<Conta> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;  
    }
    
    //método que faz o mapeamento de um registro relacional em objeto
    private Conta montaObjeto(ResultSet rs) throws SQLException{
        Conta conta = new Conta();
        conta.setId(rs.getInt("id"));
        conta.setDatapagamento(rs.getDate("data_pagamento").toLocalDate());
        conta.setVlagua(rs.getDouble("vl_agua"));
        conta.setVlenergia(rs.getDouble("vl_energia"));
        conta.setVlgas(rs.getDouble("vl_gas"));
        conta.setValor(rs.getDouble("valor"));
        
        return conta;
    }
    
}
