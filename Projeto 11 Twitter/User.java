import java.util.TreeMap;

public class User {
    private String username;
    private TreeMap<String, User> followers;
    private TreeMap<String, User> following;
    private TreeMap<Integer, Tweet> timeline;
    private int unreadCont;

    public User(String username){
        this.username = username;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timeline = new TreeMap<>();
        this.unreadCont = 0;
    }

    public String getUsername() {
        return username;
    }

    public TreeMap<String, User> getFollowers() {
        return followers;
    }
    
    public TreeMap<String, User> getFollowing() {
        return following;
    }

    public TreeMap<Integer, Tweet> getTimeline() {
        this.unreadCont = 0;
        return this.timeline;
    }

    public int getUnreadCont() {
        return this.unreadCont;
    }

    public String showTimeline(){
        this.unreadCont = 0;
        StringBuilder line = new StringBuilder();
        for(Tweet tweet : timeline.values()){
            line.append(tweet + "\n");
        }
        return line.toString();
    }

    Tweet getTweet(int idTw){
        if(!this.timeline.containsKey(idTw)){
            throw new MissingKeyException("Tweet não existente!");
        }
        Tweet tweet = this.timeline.get(idTw);
        return tweet;
    }

    public String getUnread(){ 
        StringBuilder unread = new StringBuilder();
        if(this.unreadCont == 0){
            unread.append("Sem novas mensagens...\n");
            return unread.toString();
        }
        for(int i = this.timeline.size() - this.unreadCont; i < this.timeline.size(); i++){
            if(this.timeline.get(i) != null && !this.timeline.get(i).getUsername().equals(this.getUsername())){
                unread.append(timeline.get(i) + "\n");
            }
        }
        this.unreadCont = 0;
        return unread.toString();
    }

    private void setUnreadCount(){
        this.unreadCont = this.unreadCont + 1;
    }

    void follow(User other){
        if(this.following.containsKey(other.getUsername())){
            throw new DuplicatedKeyException(this.getUsername() + " já segue este usuário.");
        }
        this.following.put(other.getUsername(), other);
        other.followers.put(this.getUsername(), this);
        /*for (Tweet tweet : other.getTimeline().values()){
            if(tweet != null && tweet.getUsername() == other.getUsername()){
                this.timeline.put(tweet.getIdTw(), tweet);
            }
        }*/
    }

    void unfollow(String username){
        if(!this.following.containsKey(username)){
            throw new DuplicatedKeyException(this.getUsername() + " não segue este usuário.");
        }
        User user = following.get(username);
        this.following.remove(username);
        user.followers.remove(this.getUsername());
    }
    
    void sendTweet(Tweet tweet){
        this.timeline.put(tweet.getIdTw(), tweet);
        this.setUnreadCount();
        for(User user : this.followers.values()) {
            user.getTimeline().put(tweet.getIdTw(), tweet);
            user.setUnreadCount();
        }
    }

    public String toString(){
        return username;
    }
}
