package Model.Classes;

public class Barbeiro extends Pessoa {

    protected String senha;

    public Barbeiro(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}


