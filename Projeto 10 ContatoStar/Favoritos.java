import java.util.ArrayList;
import java.util.Arrays;

public class Favoritos{
    public static void main(String[] args) {
        AgendaPlus agenda = new AgendaPlus();
        agenda.addContato("eva", new ArrayList<Fone>(Arrays.asList(new Fone("oi", "8585"), new Fone("cla", "9999"))));
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "3434"))));
        agenda.addContato("bia", new ArrayList<Fone>(Arrays.asList(new Fone("viv", "5454"))));
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("cas", "4567"), new Fone("oi", "8754"))));
        agenda.addContato("zac", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "5453"))));
        agenda.addContato("slayer", new ArrayList<Fone>(Arrays.asList(new Fone("Tim", "5488"))));
        System.out.println(agenda);

        agenda.bookmark("eva");
        agenda.bookmark("ana");
        agenda.bookmark("zac");
        agenda.bookmark("ana");
        agenda.bookmark("rex");
        agenda.getBookmarks();

    }
}