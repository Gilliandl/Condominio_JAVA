
package model;


public class Apartamento implements java.io.Serializable{
    private int id;
    private String nome;
    private String andar;
    private Morador morador;
    private Garagem garagem;
    private Conta conta;
    
    public Apartamento() {
        this.setId(0);
        this.setNome("SEM Nº");
        this.setAndar("SEM ANDAR");
        this.setMorador(null);
        this.setGaragem(null);
        this.setConta(null);
    }

    public Apartamento(int id, String nome, String andar, Morador morador, Garagem garagem, Conta conta) {
        this.setId(id);
        this.setNome(nome);
        this.setAndar(andar);
        this.setMorador(morador);
        this.setGaragem(garagem);
        this.setConta(conta);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome.trim().isEmpty()?"SEM Nº":nome.toUpperCase();
    }

    public void setAndar(String andar) {
        this.andar = andar.trim().isEmpty()?"SEM ANDAR":andar.toUpperCase();
    }

    public void setMorador(Morador morador) {
        this.morador = morador == null ? new Morador(): morador;
    }

    public void setGaragem(Garagem garagem) {
        this.garagem = garagem == null ? new Garagem(): garagem;
    }

    public void setConta(Conta conta) {
        this.conta = conta == null ? new Conta(): conta;
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getAndar() {
        return this.andar;
    }

    public Morador getMorador() {
        return this.morador;
    }

    public Garagem getGaragem() {
        return this.garagem;
    }

    public Conta getConta() {
        return this.conta;
    }

    @Override
    public String toString() {
        return this.id+""; //"Apartamento{" + "id=" + id + ", nome=" + nome + ", andar=" + andar + ", morador=" + morador + ", garagem=" + garagem + ", conta=" + conta + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.id;
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
        final Apartamento other = (Apartamento) obj;
        return this.id == other.id;
    }
    
    
    
    
    
    
}
