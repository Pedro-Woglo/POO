
class Pessoa{
    private String nome;
    private boolean meia;

    public Pessoa(String nome, boolean pagaMeia){
        this.nome = nome;
        this.meia = pagaMeia;
    }

    public String getNome(){
        return this.nome;
    }

    public boolean getMeia(){
        return this.meia;
    }

    public String toString() {
        StringBuilder saida = new StringBuilder();
        saida.append("[" + nome + ", ");
        saida.append((meia ? "meia" : "inteira") + "]");
        return saida.toString();
    }
}