import java.util.*;

public class Evento {
    private String descricao;
    private int id_evento;
    private ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
    private int ocorrencia;
    public Evento(String descricao, int id_evento, ArrayList<Pessoa> pessoas){
        this.descricao = descricao;
        this.id_evento = id_evento;
        this.pessoas = pessoas;
    }

    public ArrayList<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public int getId_evento() {
        return id_evento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setOcorrencia() {
        this.ocorrencia +=1;
    }

    public int getOcorrencia(){
        return ocorrencia;
    }
}