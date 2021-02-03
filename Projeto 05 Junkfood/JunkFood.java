import java.util.ArrayList;

class Espiral{

    String nome;
    int qtd;
    float preco;

    public Espiral(String nome, int qtd, float preco){
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String toString(){
        return "[" + nome + " : " + qtd + " U : " + preco + " RS]";
    }
}

class Maquina{

    ArrayList<Espiral> espirais;
    String conteudo = "";
    float saldoCliente;
    float lucro;
    int maxProdutos;
    int qtdEspirais;

    public Maquina(int qtdEspirais,int maxProdutos){
        this.maxProdutos = maxProdutos;
        this.qtdEspirais = qtdEspirais;
        this.espirais = new ArrayList<>();
        for(int i = 0; i < qtdEspirais; i++){
            espirais.add(new Espiral("empty", 0, 0));
        }
    }

    boolean inserirDinheiro(float valor){
        this.saldoCliente += valor;
        return true;
    }
    float pedirTroco(){
        float aux = this.saldoCliente;
        this.saldoCliente = 0;
        System.out.println("Voce recebeu " + aux + " RS de troco.");
        return aux;
    }
    boolean vender(int indice){
        if(this.saldoCliente < this.espirais.get(indice).preco){
            System.out.println("Saldo insuficiente!");
            return false;
        }
        if(this.espirais.get(indice).qtd == 0){
            System.out.println("Produto esgotado!");
            return false;
        }
        this.saldoCliente -= this.espirais.get(indice).preco;
        this.espirais.get(indice).qtd --;
        return true;
    }
    boolean alterarEspiral(int indice, String nome, int qtd, float preco){
        if(indice >= this.qtdEspirais || indice < 0){
            System.out.println("Indice invalido!");
            return false;
        }
        if(qtd > this.maxProdutos){
            System.out.println("A espiral nao suporta essa quantidade de produtos!");
            return false;
        }
        this.espirais.get(indice).qtd = qtd;
        this.espirais.get(indice).nome = nome;
        this.espirais.get(indice).preco = preco;
        return true;
    }
    void limparEspiral(int indice){
        this.espirais.get(indice).nome = "empty";
        this.espirais.get(indice).qtd = 0;
        this.espirais.get(indice).preco = 0;
    }
    float getSaldo(){
        System.out.println("Voce possui " + this.saldoCliente + " RS de credito");
        return this.saldoCliente;
    }

    public String toString(){
        String saida = "";
        for(int i = 0; i < qtdEspirais; i++){
            saida += i + " " + this.espirais.get(i) + "\n";
        }
        return saida;
    }
}

public class JunkFood{

    public static void main(String[] args) {

        Maquina maquina = new Maquina(3, 5);
        System.out.println(maquina);
        maquina.alterarEspiral(2, "todinho", 3, 2.50f);
        System.out.println(maquina);
        maquina.inserirDinheiro(10);
        maquina.vender(2);
        maquina.vender(2);
        maquina.pedirTroco();
        System.out.println(maquina);
    }

}
