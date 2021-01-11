import java.util.ArrayList;
import java.util.Collections;

class Cliente{
    String id;
    String fone;

    public Cliente(String id, String fone){
        this.id = id;
        this.fone = fone;
    }

    public String toString(){
        return id + ":" + fone;
    }
}

public class Cinema {

    ArrayList<Cliente> clientes;

    public Cinema(int size){
        this.clientes = new ArrayList<>(Collections.nCopies(size, null));
    }
    void reservar(String id, String fone, int indice){ 
        for(Cliente cliente : clientes) {
            if(cliente == null){
                cliente = new Cliente(id, fone);
                System.out.println("Cliente reservado!");
                break;
            }
            if(cliente.id.equals(id)){
                System.out.println("O cliente ja esta no cinema!");
                break;
            }
        }
        System.out.println("Cinema lotado!");
    }
    boolean cancelar(String id){
        for(Cliente cliente : clientes) {
            if(cliente.id.equals(id)){
                cliente = null;
                return true;
            }
        }
        return false;
    }
    public String toString(){
        return clientes;
    }
    public static void main(String[] args) {
        
    }
}
