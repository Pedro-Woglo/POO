import java.util.ArrayList;

class Pessoa implements Comparable<Pessoa>{
    String id;
    String fone;
    public Pessoa(String id, String fone){
        this.id = id;
        this.fone = fone;
    }
    public String toString(){
        return id + ":" + fone;
    }

    public int compareTo(Pessoa other){
        return id.compareTo(other.id);
    }
}

class Sala{
    ArrayList<Pessoa> cadeiras;
    public Sala(int tamanho){
        cadeiras = new ArrayList<>();
        Pessoa pessoa = null;
        for(int i = 0; i < tamanho; i++){
            cadeiras.add(pessoa);
        }
    }

    public void reservar(String id, String fone, int index){
        if(index < 0 || index >= cadeiras.size()){ 
            System.out.println("Indice inválido");
            return;
        }
        if(cadeiras.get(index) != null){
            System.out.println("Cadeira ocupada");
            return;
        }

        for(Pessoa cadeira : cadeiras){
            if(cadeira != null && cadeira.id.equals(id)){ //null point exception !!!!!!!!!!!!!!
                System.out.println("Já existe esta pessoa na sala de cinema!");
                return;
            }
        }
        cadeiras.set(index, new Pessoa(id, fone));
    }

    public void cancelar(String id){
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i) != null && cadeiras.get(i).id.equals(id)){
                cadeiras.set(i, null);
                System.out.println("Reserva cancelada.");
                return;
            }
        }
        System.out.println("Pessoa nao reservada na sala de cinema!");
     }

    public String toString(){
        String saida = "[ ";
        for(Pessoa pessoa : cadeiras){
            if(pessoa == null)
                saida += "- ";
            else
                saida += pessoa + " ";
        }
        return saida + "]";
    }
}

public class Cinema{
    public static void main(String[] args) {
        Sala sala = new Sala(6);
        System.out.println(sala);
        sala.reservar("David", "85", -1);
        sala.reservar("David", "85", 6);
        sala.reservar("David", "85", 5);
        sala.reservar("Lavor", "69", 4);
        sala.cancelar("David");
        System.out.println(sala);
    }
}


