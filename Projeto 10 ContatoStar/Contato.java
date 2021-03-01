import java.util.ArrayList;

public class Contato {
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
        for(Fone fone : this.fones){
            saida += " [" + i + ":" + fone + "]";
            i++;
        }
        return saida;
    }
}
