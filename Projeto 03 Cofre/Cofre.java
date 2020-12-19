
enum Moeda {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    double valor;
    int volume;

    Moeda(double valor, int volume) {
        this.valor = valor;
        this.volume = volume;
    }

    public String toString() {
        return "Valor: " + valor + " Volume: " + volume;
    }
}

class Item{
    String descricao;
    int volume;

    Item(String descricao, int volume){
        this.descricao = descricao;
        this.volume = volume;
    }
}


class Porco{
    String itens;
    double valor;
    int volume;
    int volumeMax;
    boolean estaQuebrado;

    Porco(int v) {
        this.volumeMax = v;
        this.itens = "";
        this.volume = 0;
        this.valor = 0.0;
        this.estaQuebrado = false;
    }

    boolean addMoeda(Moeda moeda){
        if(estaQuebrado == true){
            System.out.println("O cofre está quebrado!");
            return false;
        }
        if((this.volume + moeda.volume) > this.volumeMax){
            System.out.println("O cofre está cheio!");
            return false;
        }
        this.volume += moeda.volume;
        this.valor += moeda.valor;
        return true;
    }
    boolean addItem(Item item){
        if(estaQuebrado == true){
            System.out.println("O cofre está quebrado!");
            return false;
        }
        if((item.volume + this.volume) > this.volumeMax){
            System.out.println("O cofre está cheio!");
            return false;
        }

        this.volume += item.volume;

        if(this.itens.equals("")){
            this.itens = item.descricao;
        }else{ 
            this.itens += (", " + item.descricao);      
        }
        return true;
    }
    boolean quebrar(){
        if(estaQuebrado == true){
            System.out.println("O cofre já está quebrado!");
            return false;
        }
        this.estaQuebrado = true;
        return true;
    }
    double pegarMoedas(){
        if(estaQuebrado == false){
            System.out.println("O cofre deve ser quebrado primeiro!");
            return 0.0;
        }

        this.volume = 0;

        double aux = this.valor;
        this.valor = 0.0;
        return aux;
    }
    String pegarItens(){
        if(estaQuebrado == false){
            System.out.println("O cofre deve ser quebrado primeiro!");
            return "";
        }

        this.volume = 0;

        String aux = this.itens;
        this.itens = "";
        return aux;
    }

    public String toString() {
        return  "I:("+ this.itens + ") " + "M:" + valor + " V:" + volume + "/" + volumeMax + " EQ:" + this.estaQuebrado;
    }

}

public class Cofre{
    public static void main(String[] args) {
        
        Porco porco = new Porco(20);
        System.out.println(porco); 
        porco.addMoeda(Moeda.M10);
        porco.addMoeda(Moeda.M50);
        System.out.println(porco);
        porco.addItem(new Item("ouro", 3));
        System.out.println(porco);
        porco.addItem(new Item("passaporte", 2));
        System.out.println(porco); 
        porco.addItem(new Item("PS5", 6));
        System.out.println(porco); 
        porco.pegarItens();
        porco.pegarMoedas();
        porco.quebrar();
        porco.quebrar();
        System.out.println(porco.pegarMoedas());
        System.out.println(porco.pegarItens());
        System.out.println(porco);
    }
}