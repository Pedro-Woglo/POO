
class Setor{
    private String nome;
    private double preco;
    private int qtd;
    private int capacidade;

    public Setor(String nome, double preco, int capacidade){
        this.nome = nome;
        this.preco = preco;
        this.capacidade = capacidade;
        this.qtd = 0;
    }

    public String getNome(){
        return this.nome;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getQtd(){
        return this.qtd;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    public void setQtd(int x){
        if(x <= this.getCapacidade()){
            this.qtd = x;
        }else{
            System.out.println("fail: Quantidade invalida");
        }
    }

    void vender(){
        this.qtd++;
    }
}