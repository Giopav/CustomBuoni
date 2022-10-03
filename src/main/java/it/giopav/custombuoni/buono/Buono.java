package it.giopav.custombuoni.buono;

public class Buono {
    private Tipo tipo;

    public Buono(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}