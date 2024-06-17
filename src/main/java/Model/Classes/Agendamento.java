package Model.Classes;

public class Agendamento {
    private int id;
    private String nome;
    private String servico;
    private float preco;
    private String data;

    private String hora;

    public Agendamento(int id, String nome, String servico, float preco, String data, String hora) {
        this.id = id;
        this.nome = nome;
        this.servico = servico;
        this.preco = preco;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
