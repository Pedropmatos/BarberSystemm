package com.example.barbersystemm;

import Model.Classes.Cliente;
import Model.DAO.ClienteDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginClienteController {

    @FXML
    private PasswordField EntradaCPF;

    @FXML
    private TextField EntradaNome;


    @FXML
    private Button btVoltar;

    ClienteDAOImpl loginCliente = ClienteDAOImpl.getInstance();
    @FXML
    private void onbtVoltarAction(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    @FXML
    private Button btCadastro;
    @FXML
    private void onbtCadastroAction(ActionEvent event) throws IOException {
        Parent scene3Parent = FXMLLoader.load(getClass().getResource("Cadastro.fxml"));
        Scene scene3 = new Scene(scene3Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene3);
        window.show();
    }

    @FXML
    private Button btLogin3;
    @FXML
    private void onbtLogin3Action(ActionEvent event) throws IOException {

        String nome = EntradaNome.getText();
        String cpf = EntradaCPF.getText();

        if (nome.isEmpty() || cpf.isEmpty()) {
            System.out.println("Nome ou CPF estão vazios");
            // Adicione um alerta para o usuário aqui
            return;
        }

        for (Cliente cliente : loginCliente.clientes) {
            if (nome.equals(cliente.getNome()) && cpf.equals(cliente.getCpf())) {

                Parent scene2Parent = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
                Scene scene2 = new Scene(scene2Parent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(scene2);
                window.show();
                return;
            }
        }

    }

}
