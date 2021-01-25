import java.util.ArrayList;

class Pass{
    String name;
    int idade;

    public Pass(String name, int idade){
        this.name = name;
        this.idade = idade;
    }

    public String toString(){
        return name + ":" + idade;
    }

    public boolean equals(Object pass){
        if(!(pass instanceof Pass))
            return false;
        Pass other = (Pass) pass;
        return this.name.equals(other.name);
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

    public boolean subir(Pass pass){
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i).equals(pass)){
                System.out.println("Passageiro já está na Topic!");
                return false;
            }
            if(){

            }
        }
        return true;
    }

    public Pass descer(String name){

    }

    public String toString(){
        String saida = "[ ";
        for(Pass pass : cadeiras){
            if(pass.idade >= 60)
                saida += "@" + pass;
            else
                saida += pessoa + " ";
        }
        return saida + "]";
    }
}


