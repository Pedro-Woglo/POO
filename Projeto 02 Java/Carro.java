

public class Carro {

    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;

    Carro(){  

        this.gas = 0;
        this.gasMax = 100;
        this.pass = 0;
        this.passMax = 2;
        this.km = 0;
    }

    boolean in(){
        if(pass == passMax){
            System.out.println("O carro está lotado!");
            return false;
        }else{
            pass += 1;
        }
        return true;
    }

    boolean out(){
        if(pass == 0){
            System.out.println("O carro já está vazio!");
            return false;
        }else{
            pass -= 1;
        }
        return true;
    }

    void fuel(int value){  
        if((gas + value) > 100){
            gas = 100;
        }else{
            gas += value;
        }
    }

    boolean drive(int distance){
        if((pass > 0) && (gas > 0)){
            if(distance >= gas){
                km += gas;
                System.out.println("Tanque vazio após percorrer " + gas + " km");
                gas = 0;
            }else{
                km += distance;
                gas -= distance;
            }
        }else if (pass > 0 && gas == 0){ 
            System.out.println("Tanque vazio!");
            return false;
        }
        else if (gas > 0 && pass == 0){
            System.out.println("Não há ninguém no carro!");
            return false;
        }else{
            System.out.println("Não há ninguem no carro, e o mesmo está com o tanque vazio!");
        }
        return true;
    }

    public String toString() {
        return "Passageiros: " + pass + ", Combustível: " + gas + ", Km: " + km;
    }

    public static void main(String[] args) {
        
        Carro car = new Carro();
        System.out.println(car);
    }
}

