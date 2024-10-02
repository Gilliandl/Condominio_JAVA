
package model;

import java.time.LocalDate;


public class Conta implements java.io.Serializable {
    private int id;
    private LocalDate datapagamento;
    private double vlagua;
    private double vlenergia;
    private double vlgas;
    private double valor;
    
    public Conta() {
        this.setId(0);
        this.setDatapagamento(LocalDate.now());
        this.setVlagua(0);
        this.setVlenergia(0);
        this.setVlgas(0);
        this.setValor(0);
    }

    public Conta(int id, LocalDate datapagamento, double vlagua, double vlenergia, double vlgas, double valor) {
        this.setId(id);
        this.setDatapagamento(datapagamento);
        this.setVlagua(vlagua);
        this.setVlenergia(vlenergia);
        this.setVlgas(vlgas);
        this.setValor(valor);
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setDatapagamento(LocalDate datapagamento) {
        this.datapagamento = datapagamento == null ? LocalDate.now() : datapagamento;
    }

    public void setVlagua(double vlagua) {
        this.vlagua = vlagua < 0 ? 0 : vlagua;
    }

    public void setVlenergia(double vlenergia) {
        this.vlenergia = vlenergia < 0 ? 0 : vlenergia;
    }

    public void setVlgas(double vlgas) {
        this.vlgas = vlgas < 0 ? 0 : vlgas;
    }

    public void setValor(double valor) {
        this.valor = valor < 0 ? 0 : valor;
    }

    public int getId() {
        return this.id;
    }
    
    public LocalDate getDatapagamento() {
        return this.datapagamento;
    }
    
    public double getVlagua() {
        return this.vlagua;
    }
    
    public double getVlenergia() {
        return this.vlenergia;
    }
    
    public double getVlgas() {
        return this.vlgas;
    }
    
    public double getValor() {
        return this.valor;
    }

    @Override
    public String toString() {
        return this.valor+"";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Conta other = (Conta) obj;
        return this.id == other.id;
    }
    
    
        
}
