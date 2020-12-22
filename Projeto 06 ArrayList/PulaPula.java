
import java.util.ArrayList;

class Crianca{
    String nome;
    int idade;
    public Crianca(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }
    public String toString(){
        return nome + ":" + idade;
    }
}

public class PulaPula{

    ArrayList<Crianca> esperando;
    ArrayList<Crianca> brincando;

    public PulaPula(){
        this.esperando = new ArrayList<>();
        this.brincando = new ArrayList<>();
    }

    public void chegar(Crianca crianca){
        esperando.add(0, crianca);
    }
    //tira da fila de espera e coloca na fila brincando
    public void entrar(){
        if(esperando.isEmpty())
            return;
        //obtive a crianca
        Crianca primeira = esperando.get(esperando.size() - 1);
        //retirei do vetor esperando
        esperando.remove(esperando.size() - 1);
        //adicionei na primeira posicao do vetor brincando
        brincando.add(0, primeira);
    }

    //tira da fila de brincando e coloca na fila de espera
    public void sair(){
        if(brincando.isEmpty())
            return;
        Crianca primeira = brincando.get(brincando.size() - 1);
        brincando.remove(brincando.size() - 1);
        esperando.add(0, primeira);
    }

    public Crianca remover(String nome){
        if(brincando.isEmpty())
            return null;
        for(Crianca crianca : brincando) {
            if(crianca.nome.equals(nome)){
                    int index = brincando.indexOf(crianca);
                    Crianca tchau = crianca;
                    brincando.remove(index);
                    return tchau;
            }
        }
        for(Crianca guri : esperando) {
            if(guri.nome.equals(nome)){
                    int index = esperando.indexOf(guri);
                    Crianca tchau = guri;
                    esperando.remove(index);
                    return tchau;
            }
        }

            System.out.println("Criança não encontrada!");
            return null;
    }
            

    public String toString(){
        return "=>" + esperando + " => " + brincando;
    }

    public static void main(String[] args) {
        PulaPula pp = new PulaPula();
        pp.chegar(new Crianca("Ana", 5));
        pp.chegar(new Crianca("Livia", 4));
        pp.chegar(new Crianca("Rubia", 3));
        System.out.println(pp);
        pp.entrar();
        pp.entrar();
        System.out.println(pp);
        pp.remover("Ana");
        System.out.println(pp);
        pp.chegar(new Crianca("Ana", 5));
        System.out.println(pp);
        pp.entrar();
        pp.entrar();
        System.out.println(pp);
        pp.sair();
        System.out.println(pp);
    }
}