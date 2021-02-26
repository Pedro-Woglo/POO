import java.util.TreeMap;

class Evento{
    private String nome;
    private TreeMap<String, Setor> repSetores;

    public Evento(String nome){
        this.nome = nome;
        repSetores = new TreeMap<>();
    }

    public String getNome(){
        return this.nome;
    }

    public Setor getSetor(String idSetor) {
		Setor setor = repSetores.get(idSetor);
        if(setor != null)
            return setor;
        throw new MissingKeyException("Setor", idSetor);
	}

    void addSetor(Setor setor){
        if(this.repSetores.containsKey(setor.getNome()))
            throw new DuplicatedKeyException("fail: setor " + setor.getNome() + " ja existente");
        this.repSetores.put(setor.getNome(), new Setor(setor.getNome(), setor.getPreco(), setor.getCapacidade()));
    }

    public String toString() {
        return "[" + nome + "]\n";
    }
}