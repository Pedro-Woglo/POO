//Implementei uma lógica dentro do método "acidentar" de que quando o calango perde todas as suas patas, ele morre.
//Também implementei um método chamado "ressucitar" que verifica o atributo booleano "alive" para ressucitar o calango ou não.

public class Calango {
    int bucho; //atributos
    int maxBucho;
    int nPatas;
    boolean alive;

    //mesmo nome da classe = sombreamento de variavel
    Calango(int maxBucho){ //parametros
        this.bucho = maxBucho;
        this.maxBucho = maxBucho;
        this.nPatas = 4;
        this.alive = true;
    }

    void comer(int qtd){
        bucho += qtd;
        if(alive == false){
            System.out.println("Estou morto...");
        }else{
            if(bucho > maxBucho){
                bucho = maxBucho;
                System.out.println("Comi até ficar saciado");
            }else{
                System.out.println("Tô cheio");
            }
        }
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradavel");
            return;
        }
        System.out.println("Estou muito cansado");
        
    }

    void acidentar(){
        if(nPatas > 0){
            nPatas -= 1;
            if(nPatas == 0){
                alive = false;
                System.out.println("Morri...");
            }else{
                System.out.println("Ouch! Perdi uma pata");
            }
        }else{
            System.out.println("Já morri, cara!");
        }
    }

    void regenerar(){
        if(alive == false){
            System.out.println("Estou morto...");
        }else{
            if(nPatas == 4){
                System.out.println("Estou perfeito");
            }else if (bucho > 0){
                nPatas += 1;
                bucho -= 1;
                System.out.println("Opa! Recuperei uma pata!");
            }else{
                System.out.println("Nao tenho energia suficiente para me recuperar");
            }
        } 
    }

    void ressucitar(){
        if (alive == true){
            System.out.println("Já estou vivo...");
        }else{
            alive = true;
            System.out.println("Estou vivoooo!");
        }
    }

    public String toString() {
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas  + " Alive:" + alive;
    }

    public static void main(String[] args) {
        //referencia      = criando objeto
        Calango deadlango = new Calango(20);

        System.out.println(deadlango);

        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.acidentar();
        System.out.println(deadlango);
        deadlango.acidentar();
        deadlango.ressucitar();
        deadlango.ressucitar();

    }
}


        
