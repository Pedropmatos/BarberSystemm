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

public class AgendamentoController {
    @FXML
    private Button btVoltar4;
    @FXML
    private void onbtVoltar4Action(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("menuCliente.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }
}
