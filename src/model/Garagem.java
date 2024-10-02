
package model;


public class Garagem implements java.io.Serializable{
    private int id;
    private String nome_box;
    
    public Garagem() {
        this.setId(0);
        this.setNome_box("SEM IDENTIFICACAO");
    }

    public Garagem(int id, String nome_box) {
        this.setId(id);
        this.setNome_box(nome_box);
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNome_box(String nome_box) {
        this.nome_box = nome_box.trim().isEmpty()?"SEM ID_NOME":nome_box.toUpperCase();
    }
    
    public int getId() {
        return this.id;
    }
    public String getNome_box() {
        return this.nome_box; 
    }

    @Override
    public String toString() {
        return this.nome_box;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.id;
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
        final Garagem other = (Garagem) obj;
        return this.id == other.id;
    }
    
    

    
    
    
}
