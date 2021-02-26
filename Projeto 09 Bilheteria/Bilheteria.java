import java.util.*;

class DuplicatedKeyException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    DuplicatedKeyException(String message){
        super(message);
    }
}

class MissingKeyException extends RuntimeException{
 
    private static final long serialVersionUID = 1L;
    MissingKeyException(String tipo, String chave){
        super(tipo + " " + chave + " nao existe no repositorio");
    }
}

class SetorLotadoException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    SetorLotadoException(String message){
        super(message);
    }
}

public class Bilheteria{
    private ArrayList<Venda> repVendas;
    private TreeMap<String, Pessoa> repPessoas;
    private TreeMap<String, Evento> repEvento;
    private double caixa;

    public Bilheteria(){
        this.repPessoas = new TreeMap<>();
        this.repEvento = new TreeMap<>();
        this.repVendas = new ArrayList<>();
        this.caixa = 0f;
    }

    String getCaixa() {
        return "R$ " + this.caixa;
    }

    void showVendas(){
        for(Venda venda : repVendas){
            System.out.println(venda);
        }
        System.out.println("Caixa: " + this.getCaixa());
    }
    
    void showPessoas(){
        for(Pessoa pessoa : this.repPessoas.values()){
            System.out.println(pessoa);
        }
    }

    void showEventos(){
        for(Evento evento : this.repEvento.values()){
            System.out.println(evento);
        }
    }

    void vender(String cliente, String idEvento, String idSetor){
        Pessoa pessoa = getPessoa(cliente);
        Evento evento = getEvento(idEvento);
        Setor setor = evento.getSetor(idSetor);
        if(setor.getQtd() == setor.getCapacidade()){
            throw new SetorLotadoException("fail: Setor lotado");
        }
        setor.vender();
        repVendas.add(new Venda(pessoa, evento, setor, setor.getPreco()));
        this.caixa += setor.getPreco();

    }

    void addPessoa(String nome, boolean meia){
        
        if(this.repPessoas.containsKey(nome)){
            throw new DuplicatedKeyException("fail: " + nome + " ja esta no repositorio");
        }
        this.repPessoas.put(nome, new Pessoa(nome, meia));
    }

    void addEvento(String idEvento){
        if(this.repEvento.containsKey(idEvento)){
            throw new DuplicatedKeyException("fail: Evento " + idEvento + " ja esta no repositorio");
        }
        this.repEvento.put(idEvento, new Evento(idEvento));
    }

    void addSetor(String idEvento, String idSetor, double preco, int capacidade){
        Evento evento = getEvento(idEvento);
        evento.addSetor(new Setor(idSetor, preco, capacidade));
    }

    Pessoa getPessoa(String idPessoa){
        Pessoa pessoa = repPessoas.get(idPessoa);
        if(pessoa != null)
            return pessoa;
        throw new MissingKeyException("Pessoa", idPessoa);
    }

    Evento getEvento(String idEvento){
        Evento evento = repEvento.get(idEvento);
        if(evento != null)
            return evento;
        throw new MissingKeyException("Evento", idEvento);
    }
}