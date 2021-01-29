import java.util.ArrayList;

class Pass{
    String name;
    int idade;
    final int idadePref = 60;

    public Pass(String name, int idade){
        this.name = name;
        this.idade = idade;
    }

    public String toString(){
        return name + ":" + idade;
    }

    public boolean preferencial(){
        return this.idade >= this.idadePref;
    }
}

public class Topic {
    ArrayList<Pass> cadeiras;
    int qtdPref;

    public Topic(int lotacao, int qtdPref){
        this.qtdPref = qtdPref;
        cadeiras = new ArrayList<>();
        Pass pass = null;
        for(int i = 0; i < lotacao; i++){
            cadeiras.add(pass);
        }
    }

    private int encontrarPos(String name){
        for(int i = 0; i < this.cadeiras.size(); i++){
			if(cadeiras.get(i) != null && this.cadeiras.get(i).name.equals(name)){
                return i;
            }
        }
		return -1;
    }

    private int encontrarPosNull(int inicio, int fim){
        for(int i = inicio; i < fim; i++){
            if(cadeiras.get(i) == null){
                return i;
            }
        }
        return -1;
    }

    public boolean subir(Pass pass){
        if(this.encontrarPos(pass.name) > -1){
            System.out.println("O passageiro já se encontra na Topic!");
            return false;
        }
        int pos = -1;
		if(pass.preferencial()) {
            pos = encontrarPosNull(0, this.cadeiras.size());
		}else {
            pos = encontrarPosNull(this.qtdPref, this.cadeiras.size());
            if(pos == -1)
                pos = encontrarPosNull(0, this.qtdPref);	
		}
        if(pos == -1){ 
            System.out.println(pass.name + ", a Topic está lotada!");
            return false;
        }
        cadeiras.set(pos, pass);
        return true;
    }

    public void descer(String name){
        int pos = this.encontrarPos(name);
        if(pos > -1){
            System.out.println("Passageiro desembarcado!");
            this.cadeiras.set(pos, null);
        }else{
            System.out.println("Essa pessoa não está na Topic!");
        }
    }

    public String toString(){
        String passageiros = "";
        for (int i = 0; i < cadeiras.size(); i++){
            Pass pass = cadeiras.get(i);
            passageiros += (i < qtdPref) ? "@" : "=";
            passageiros += (pass == null) ? " " : pass + " ";
        }
        return "[ " + passageiros + "]";
    }

    public static void main(String[] args) {
        Topic topic = new Topic(5, 3);
        topic.subir(new Pass("Slayer", 35));
        topic.subir(new Pass("Johnny", 60));
        topic.subir(new Pass("Kastle", 24));
        topic.subir(new Pass("Kenny", 24));
        topic.subir(new Pass("Jenny", 24));
        topic.descer("Slayer");
        System.out.println(topic);
    }

}

