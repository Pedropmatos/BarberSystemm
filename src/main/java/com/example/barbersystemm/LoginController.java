package com.example.barbersystemm;

import Model.Classes.Barbeiro;
import Model.Classes.Cliente;
import Model.DAO.BarbeiroDAOImpl;
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

public class LoginController {


    @FXML
    private TextField EntradaBarb;

    @FXML
    private PasswordField EntradaSenha;

    BarbeiroDAOImpl loginBarbeiro = BarbeiroDAOImpl.getInstance();

    @FXML
    private Button btLogin;
    @FXML
    private void onbtLoginAction(ActionEvent event) throws IOException {

        String user = EntradaBarb.getText();
        String senha = EntradaSenha.getText();

        for (Barbeiro barbeiro : loginBarbeiro.barbeiros) {

            if (user.equals(barbeiro.getNome()) && senha.equals(barbeiro.getSenha())) {
                Parent scene2Parent = FXMLLoader.load(getClass().getResource("menuBarbeiro.fxml"));
                Scene scene2 = new Scene(scene2Parent);

                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

                window.setScene(scene2);
                window.show();
            }
        }
    }


    @FXML
    private Button btLogin2;
    @FXML
    private void onbtLogin2Action(ActionEvent event) throws IOException {
        Parent scene2Parent = FXMLLoader.load(getClass().getResource("loginCliente.fxml"));
        Scene scene2 = new Scene(scene2Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene2);
        window.show();
    }
}
