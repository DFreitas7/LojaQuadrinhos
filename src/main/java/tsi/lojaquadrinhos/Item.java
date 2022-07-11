package tsi.lojaquadrinhos;

public abstract class Item {
    protected String nome;
    protected Float valor;

    public Item(String nome, Float valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    
    public Float getValor() {
        return valor;
    };

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
