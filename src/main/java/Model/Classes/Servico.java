package Model.Classes;

public class Servico {
    private int id;
    private String service;
    private double preco;

    public Servico(int id, String service, double preco) {
        this.id = id;
        this.service = service;
        this.preco = preco;
    }

    public Servico() {
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", service='" + service + '\'' +
                ", preco=" + preco +
                '}';
    }
}
