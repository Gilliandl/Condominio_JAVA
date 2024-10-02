
package model;


public class Morador implements java.io.Serializable{
    private int id;
    private String nome;
    private String cpf;
    
    public Morador(){
        this.setId(0);
        this.setNome("sem nome");
        this.setCpf("000.000.000-00");
    }
    
    public Morador(int id, String nome, String cpf) {
        this.setId(id);
        this.setNome(nome);
        this.setCpf(cpf);
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"VAZIO":nome.toUpperCase();
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf.trim().isEmpty()?"000.000.000-00":cpf;
    }
    
    public int getId() {
        return this.id;
    }
        
    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + this.id;
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
        final Morador other = (Morador) obj;
        return this.id == other.id;
    }
    
    
    
    
}



