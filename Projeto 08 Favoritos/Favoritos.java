import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

class Fone{
    String label;
    String number;

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public static boolean validate(String number){
        String validos = "0123456789()-";
        for(int i = 0; i < number.length(); i++)
            if(validos.indexOf(number.charAt(i)) == -1)
                return false;
        return true;
    }
    public String toString(){
        return label + ":" + number;
    }
}

class Contato{
    String nome;
    ArrayList<Fone> fones;

    public Contato(String nome){
        this.nome = nome;
        this.fones = new ArrayList<>();
    }

    public int compareTo(Contato other){
        return nome.compareTo(other.nome);
    }

    public void addFone(String label, String number){//vai má!
        if(Fone.validate(number))
            fones.add(new Fone(label, number));
    }

    Fone getFone(int index){//bora
        if(index >= 0 && index < fones.size()) {
            return fones.get(index);
        }
        System.out.println("Indice invalido");
        return null;
    }
    
    Fone getFone(String label) { //se nao encontrar, retorna null
        for(Fone fone : fones)
            if(fone.label.equals(label))
                return fone;
        return null;
    }
    boolean rmFone(int index){
        if(index < 0 || index >= fones.size())
            return false;
        fones.remove(index);
        return true;
    }

    boolean rmFone(String number){
        for(Fone fone : fones)
            if(fone.number.equals(number)){
                fones.remove(fone);
            }
        return false;
    }

    public String toString(){
        String saida = this.nome;
        int i = 0;
        for(Fone fone : fones){
            saida += " [" + i + ":" + fone + "]";
            i++;
        }
        return saida;
    }

}

class Agenda{
    private ArrayList<Contato> contatos;
    private TreeMap<String, Contato> bookmarks;

    public Agenda(){
        this.contatos = new ArrayList<>();
        this.bookmarks = new TreeMap<>();
    }

    public Contato getContatos(String name){
        for(Contato contato : contatos){
            if(contato != null && contato.nome.equals(name)){
                return contato;
            }
        }
        return null;
    }

    private int findContato(String name){
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
            this.bookmarks.remove(name);
        }
        return true;
    }

    void bookmark(String id){
        if(findContato(id) == -1){
            System.out.println(id + " não existe na lista de contatos!");
            return;
        }
        if(this.bookmarks.containsKey(id)){
            System.out.println("Esse contato já existe na lista de favoritos!");
            return;
        }
        this.bookmarks.put(id, new Contato(id));
    }

    void unBookmark(String id){
        if(!this.bookmarks.containsKey(id)){
            System.out.println("Esse contato não faz parte da lista de favoritos!");
            return;
        }
        this.bookmarks.remove(id);
    }

    public void getBookmarks(){
        String saida = "";
        for(Contato contato : this.bookmarks.values()){
            saida += "@ " + contato + "\n";
        }
        System.out.println(saida);
    }

    public String toString(){
        String saida = "";
        for(int i = 0; i < contatos.size(); i++){
            if(this.bookmarks.containsKey(contatos.get(i).nome)){
                saida += "@ " + contatos.get(i) + "\n";
            }else{
                saida += "- " + contatos.get(i) + "\n";
            }
        }
        return saida;
    }
}

public class Favoritos{
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContato("eva", new ArrayList<Fone>(Arrays.asList(new Fone("oi", "8585"), new Fone("cla", "9999"))));
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "3434"))));
        agenda.addContato("bia", new ArrayList<Fone>(Arrays.asList(new Fone("viv", "5454"))));
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("cas", "4567"), new Fone("oi", "8754"))));
        agenda.addContato("zac", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "5453"))));
        agenda.addContato("slayer", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "5488"))));


        System.out.println(agenda);
        agenda.bookmark("eva");
        agenda.bookmark("ana");
        agenda.bookmark("ana");
        agenda.bookmark("zac");
        agenda.bookmark("rex");
        agenda.bookmark("slayer");
        System.out.println(agenda);

        agenda.rmContato("zac");
        System.out.println(agenda);

        agenda.unBookmark("eva");
        System.out.println(agenda);

        agenda.getBookmarks();

    }
}