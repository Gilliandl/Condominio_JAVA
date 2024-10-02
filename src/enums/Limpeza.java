package enums;


public enum Limpeza {
    M("MORADOR"),
    C("CONDOMINIO");
    
    private String descricao;

    private Limpeza(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    
    
    
    
}