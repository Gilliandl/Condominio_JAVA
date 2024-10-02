
package controller;

import abstratas.dao;
import java.util.LinkedList;
import java.util.List;
import java.sql.*;
import model.Apartamento;
import model.Conta;
import model.Garagem;
import model.Morador;



public class daoApartamento extends dao{
    
    public int create(Apartamento apartamento) throws SQLException{
        String SQL = "Insert into apartamento (nome,andar,id_morador,id_garagem,id_conta) values(?,?,?,?,?)";
        return super.executeUpdate(SQL, apartamento.getNome(),apartamento.getAndar(),apartamento.getMorador().getId(),apartamento.getGaragem().getId(),apartamento.getConta().getId());
    }
    
    public int update(Apartamento apartamento) throws SQLException{
        String SQL = "update apartamento set nome = ?, andar = ?, id_morador,id_garagem = ?, id_conta = ? where id = ? ";
        return super.executeUpdate(SQL, apartamento.getNome(),apartamento.getAndar(),apartamento.getMorador().getId(),apartamento.getGaragem().getId(),apartamento.getConta().getId());
    }
    
    public int delete(Apartamento apartamento) throws SQLException{
        return super.executeUpdate("delete from apartamento where id=" + apartamento.getId());
    }
    
    public Apartamento read(int id) throws SQLException{
        String SQL = "select * from apartamento where id  = ?";
        ResultSet rs = super.executeQuery(SQL, id);
        return (!rs.next() ? null : montaObjeto(rs));
        
    }
    
    private Apartamento montaObjeto(ResultSet rs) throws SQLException{
        Apartamento apartamento = new Apartamento();
        apartamento.setId(rs.getInt("id"));
        apartamento.setNome(rs.getString("nome"));
        apartamento.setNome(rs.getString("andar"));
        
        /*-------------------------------------------------------------------*/
        Morador m = new daoMorador().read(rs.getInt("id_morador"));
        apartamento.setMorador(m);
        /*-------------------------------------------------------------------*/
        
        /*-------------------------------------------------------------------*/
        Garagem ga = new daoGaragem().read(rs.getInt("id_garagem"));
        apartamento.setGaragem(ga);
        /*-------------------------------------------------------------------*/
        
        /*-------------------------------------------------------------------*/
        Conta c = new daoConta().read(rs.getInt("id_conta"));
        apartamento.setConta(c);
        /*-------------------------------------------------------------------*/
               
        return apartamento;
    }
    
    public List<Apartamento> read() throws SQLException{
        String SQL = "select * from apartamento order by nome";
        ResultSet rs = super.executeQuery(SQL);
        List<Apartamento> retorno = new LinkedList<>();
        while(rs.next()){
            retorno.add(montaObjeto(rs));
        }
        return retorno;
    }
    
}
