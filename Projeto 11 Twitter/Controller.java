import java.util.TreeMap;

class DuplicatedKeyException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    DuplicatedKeyException(String message){
        super(message);
    }
}

class MissingKeyException extends RuntimeException{
 
    private static final long serialVersionUID = 1L;
    MissingKeyException(String message){
        super(message);
    }
}

public class Controller {
    private TreeMap<String, User> users;
    private TreeMap<Integer, Tweet> tweets;
    private int nextTwId;
    

    public Controller(){
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
        this.nextTwId = 0;
    }

    public TreeMap<String, User> getUsers() {
        return users;
    }

    void sendTweet(String username, String msg){
        if(msg == "" || msg == " "){
            throw new MissingKeyException("Mensagem sem conteúdo!");
        }
        Tweet tweet = new Tweet(nextTwId, username, msg);
        User user = getUser(username);
        tweets.put(nextTwId, tweet);
        user.sendTweet(tweet);
        nextTwId = nextTwId + 1;
    }

    void addUser(String username){
        if(users.containsKey(username)){
            throw new DuplicatedKeyException("Usuário já registrado!");
        }
        User user = new User(username);
        users.put(username, user);
    }

    User getUser(String username){
        if(!users.containsKey(username)){
            throw new MissingKeyException("Usuário " + username + " não registrado!");
        }
        User user = users.get(username);
        return user;
    }

    public String toString(){
        int i = 0, y = 0;
        StringBuilder saida = new StringBuilder();
        for(User user : this.users.values()){
            saida.append(user + "\n");
            saida.append("  seguidos: [ ");
            for(User following : user.getFollowing().values()){ //Lista de seguidos
                if(i == (user.getFollowing().size() - 1)){
                    saida.append(following + " ");
                }else{
                    saida.append(following + ", ");
                }
                i++;
            }
            saida.append("]\n");
            saida.append("  seguidores: [ ");
            for(User followers : user.getFollowers().values()){ //Lista de seguidores
                if(y == (user.getFollowers().size() - 1)){
                    saida.append(followers + " ");
                }else{
                    saida.append(followers + ", ");
                }
                y++;
            }
            saida.append("]\n");
        }
        return saida.toString();
    }

}
