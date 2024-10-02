
package enums;


public enum Reserva {
    O("OCUPADO"),
    L("LIVRE");
    
    private String descricao;

    private Reserva(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return this.descricao;
    } 
    
}
