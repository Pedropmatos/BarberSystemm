package Model;

public class Servico {
    private int id;
    private String service;
    private double preco;

    public Servico(int id, String service, double preco) {
        this.id = id;
        this.service = service;
        this.preco = preco;
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
}
