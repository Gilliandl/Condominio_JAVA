
package model;

import enums.Limpeza;
import enums.Reserva;
import java.time.LocalDate;


public class salaoFesta implements java.io.Serializable{
    private int id;
    private LocalDate datareserva;
    private Reserva reserva;
    private Limpeza limpeza;
    private Apartamento apartamento;
    
    public salaoFesta() {
        this.setId(0);
        this.setDatareserva(LocalDate.now());
        this.setReserva(Reserva.O);
        this.setLimpeza(Limpeza.M);
        this.setApartamento(null);
    }

    public salaoFesta(int id, LocalDate datareserva,Reserva reserva,Limpeza limpeza, Apartamento apartamento) {
        this.setId(id);
        this.setDatareserva(datareserva);
        this.setReserva(reserva);
        this.setLimpeza(limpeza);
        this.setApartamento(apartamento);
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDatareserva(LocalDate datareserva) {
        this.datareserva = datareserva;
    }
    
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    public void setLimpeza(Limpeza limpeza) {
        this.limpeza = limpeza;
    }
        
    public void setApartamento(Apartamento apartamento) {
        this.apartamento = apartamento == null?new Apartamento():apartamento;
    }
    
    public int getId() {
        return this.id;
    }
        
    public LocalDate getDatareserva() {
        return this.datareserva;
    }
    
    public Reserva getReserva() {
        return this.reserva;
    }
    
    public Limpeza getLimpeza() {
        return this.limpeza;
    }
        
    public Apartamento getApartamento() {
        return this.apartamento;
 
    }

    @Override
    public String toString() {
        return this.id+"";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final salaoFesta other = (salaoFesta) obj;
        return this.id == other.id;
    }


    
    
    
    
    
    
}
