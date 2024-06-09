package Model.Classes;

public class Barbeiro extends Pessoa {

    protected String senha;
    protected String nivelAcesso;

    public Barbeiro(int id, String nome, String senha) {
        super(id, nome);
        this.senha = senha;
    }

    public Barbeiro(int id, String nome, String cpf, String telefone, String senha, String nivelAcesso) {
        super(id, nome, cpf, telefone);
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public String toString() {
        return "Barbeiro{" +
                "senha='" + senha + '\'' +
                ", nivelAcesso='" + nivelAcesso + '\'' +
                ", id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}


