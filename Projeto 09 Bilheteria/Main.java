import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();
        while(true){
            System.out.print("Digite um comando: ");
            try{
                String line = scanner.nextLine();
                String[] ui = line.split(" ");
    
                if(ui[0].equalsIgnoreCase("end"))
                    break;

                else if(ui[0].equalsIgnoreCase("addPessoa")){
                    if(ui[2].equalsIgnoreCase("meia")){
                        bilheteria.addPessoa(ui[1], true);
                    }
                    if(ui[2].equalsIgnoreCase("inteira")){ 
                        bilheteria.addPessoa(ui[1], false);
                    }
                } 
                else if (ui[0].equalsIgnoreCase("addEvento")) {
                    bilheteria.addEvento(ui[1]);
                } 
                else if(ui[0].equalsIgnoreCase("addSetor")) {
                    bilheteria.addSetor(ui[1], ui[2], Double.parseDouble(ui[3]), Integer.parseInt(ui[4]));
                } 
                else if (ui[0].equalsIgnoreCase("vender")) {
                    bilheteria.vender(ui[1], ui[2], ui[3]);
                } 
                else if(ui[0].equalsIgnoreCase("ShowVendas")) {
                    bilheteria.showVendas();
                } 
                else if(ui[0].equalsIgnoreCase("ShowPessoas")) {
                    bilheteria.showPessoas();
                } 
                else if(ui[0].equalsIgnoreCase("ShowEventos")) {
                    bilheteria.showEventos();
                } 
                else{
                    System.out.println("fail: Comando invalido");
                }
            }
            catch(RuntimeException e){
                System.out.println(e);
            }
        }
        scanner.close();
    }
}
