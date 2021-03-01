import java.util.TreeMap;

public class AgendaPlus extends Agenda{
    TreeMap<String, ContatoPlus> bookmarks;

    public AgendaPlus(){
        this.bookmarks = new TreeMap<>();
    }

    @Override
    boolean rmContato(String name) {
        ContatoPlus aux = this.bookmarks.remove(name);
        if(aux == null){
            System.out.println(name + "não está na lista de favoritos");
            return false;
        }else{
            return true;
        }
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
        this.bookmarks.put(id, new ContatoPlus(id, true));
        System.out.println("Contato favoritado!");
    }

    void unBookmark(String id){
        if(!this.bookmarks.containsKey(id)){
            System.out.println("Esse contato não está na lista de favoritos!");
            return;
        }
        this.bookmarks.remove(id);
        System.out.println("Contato desfavoritado");
    }

    public void getBookmarks(){
        StringBuilder saida = new StringBuilder();
        for(ContatoPlus contatoStar : this.bookmarks.values()){
            saida.append("@ " + contatoStar + "\n");
        }
        System.out.println(saida);
    }
}