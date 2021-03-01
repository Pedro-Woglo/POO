import java.util.ArrayList;

public class Agenda {
    ArrayList<Contato> contatos;

    public Agenda(){
        this.contatos = new ArrayList<>();
    }

    public Contato getContatos(String name){
        for(Contato contato : contatos){
            if(contato != null && contato.nome.equals(name)){
                return contato;
            }
        }
        return null;
    }

    int findContato(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i) != null && contatos.get(i).nome.equals(name)){
                return i;
            }
        }
        return -1;
    }

    void addContato(String name, ArrayList<Fone> fones){
        if(this.findContato(name) != -1){
            System.out.println("Esse contato já está na agenda!");
            return;
        }
        Contato novoContato = new Contato(name);
        novoContato.fones = fones;
        contatos.add(novoContato);
    }

    boolean rmContato(String name){
        int pos = this.findContato(name);
        if(pos == -1){
            System.out.println("Esse contato não está na agenda!");
            return false;
        }else{
            contatos.remove(pos);
        }
        return true;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(int i = 0; i < contatos.size(); i++){
            saida.append("- " + contatos.get(i) + "\n");
        }
        return saida.toString();
    }
}
