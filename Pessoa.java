public class Pessoa {
    private int id;
    private String nome;

    public Pessoa(int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public int getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public void print(){
        System.out.println(this.nome);
        System.out.println(this.id);
    }
}