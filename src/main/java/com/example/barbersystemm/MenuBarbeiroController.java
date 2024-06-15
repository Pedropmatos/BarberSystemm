package com.example.barbersystemm;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuBarbeiroController {
    @FXML
    private Button btVoltar;
    @FXML
    private void onbtVoltarAction(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    @FXML
    private Button btAgenda;
    @FXML
    private void onbtAgendaAction(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("agenda.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
    @FXML
    private Button btEstoque;
    @FXML
    private void onbtEstoqueAction(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("estoque.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
}
