import java.util.TreeSet;

public class Tweet {
    private int idTw;
    private String username;
    private String msg;
    private TreeSet<String> likes;

    public Tweet(int idTw, String username, String msg){
        this.idTw = idTw;
        this.username = username;
        this.msg = msg;
        this.likes = new TreeSet<>();
    }

    public int getIdTw() {
        return idTw;
    }

    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }

    void like(String username){
        if(this.likes.contains(username)){
            throw new DuplicatedKeyException(username + " já curtiu essa publicação");
        }
        this.likes.add(username);
    }

    public String toString(){
        int i = 0;
        StringBuilder saida = new StringBuilder();
        saida.append(this.idTw + ": " + this.username + "( " + this.msg + ")");
        if(this.likes.size() == 0){
            return saida.toString();
        }
        saida.append("[ ");
        for(String like : this.likes){
            if(i == (this.likes.size() - 1)){
                saida.append(like + " ");
            }else{
                saida.append(like + ", ");
            }
            i++;
        }
        saida.append("]");
        return saida.toString();
    }
}
