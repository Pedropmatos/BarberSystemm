package com.example.barbersystemm;

import Model.Classes.Servico;
import Model.DAO.ServicoDAOImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AgendamentoController implements Initializable {

    ServicoDAOImpl servicosDAO = ServicoDAOImpl.getInstance();

    @FXML
    private TextField EscolherData;

    @FXML
    private TextField EscolherHora;

    @FXML
    private TextField EscolherId;

    @FXML
    private TextField EscolherNome;

    @FXML
    private ChoiceBox<String> EscolherServico;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Servico servicosArmazenar = new Servico();
        for (int i=0; i < servicosDAO.servicos.size(); i++){
            servicosArmazenar = servicosDAO.servicos.get(i);
            EscolherServico.getItems().add(servicosArmazenar.getService());
        }
    }
}
