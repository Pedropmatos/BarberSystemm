package Model.Classes;

public class Cliente extends Pessoa {
    private char sexo;

    public Cliente(int id, String nome, String cpf, String telefone, char sexo) {
        super(id, nome, cpf, telefone);
        this.sexo = sexo;
    }

    public Cliente(){

    }

    public Cliente(int id, String nome, char sexo) {
        super(id, nome);
        this.sexo = sexo;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


}

