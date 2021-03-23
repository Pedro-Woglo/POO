import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller sistema = new Controller();
        
        while(true){
            System.out.print("Digite um comando: ");
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            try {
                if (ui[0].equalsIgnoreCase("end"))
                    break;
                else if (ui[0].equalsIgnoreCase("addUser")) {
                    sistema.addUser(ui[1]);
                } else if (ui[0].equalsIgnoreCase("show")) {
                    System.out.print(sistema);
                } else if (ui[0].equalsIgnoreCase("follow")) {
                    User one = sistema.getUser(ui[1]);
                    User two = sistema.getUser(ui[2]);
                    one.follow(two);
                }
                else if (ui[0].equalsIgnoreCase("twittar")) {
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    sistema.sendTweet(username, msg);
                }

                else if (ui[0].equalsIgnoreCase("showUnread")) {
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.getUnread());
                }

                else if (ui[0].equalsIgnoreCase("timeline")) {
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.showTimeline());
                }
                else if (ui[0].equalsIgnoreCase("like")) {
                    User user = sistema.getUser(ui[1]);
                    Tweet tw = user.getTweet(Integer.parseInt(ui[2]));
                    tw.like(ui[1]);
                }else if (ui[0].equalsIgnoreCase("unfollow")) {
                    User user = sistema.getUser(ui[1]);
                    user.unfollow(ui[2]);
                }else{
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException rt){
                System.out.println(rt.getMessage());
            }
        }
        scanner.close();
    }
}
