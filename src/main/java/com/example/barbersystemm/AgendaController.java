package com.example.barbersystemm;

import Model.Classes.Agendamento;
import Model.DAO.AgendamentoDAOImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AgendaController {

    @FXML
    private TableColumn<Agendamento, String> ColunaData;

    @FXML
    private TableColumn<Agendamento, String> ColunaHora;

    @FXML
    private TableColumn<Agendamento, Integer> ColunaID;

    @FXML
    private TableColumn<Agendamento, String> ColunaNome;

    @FXML
    private TableColumn<Agendamento, String> ColunaPreco;

    @FXML
    private TableColumn<Agendamento, String> ColunaServico;

    @FXML
    private TableView<Agendamento> Tabela;

    AgendamentoDAOImpl agenda = AgendamentoDAOImpl.getInstance();

    @FXML
    private Button btVoltar5;

    @FXML
    private void onbtVoltar5Action(ActionEvent event) throws IOException {
        Parent scene1Parent = FXMLLoader.load(getClass().getResource("menuBarbeiro.fxml"));
        Scene scene1 = new Scene(scene1Parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(scene1);
        window.show();
    }

    @FXML
    private void initialize() {
        ColunaID.setCellValueFactory(new PropertyValueFactory<>("id"));
        ColunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        ColunaHora.setCellValueFactory(new PropertyValueFactory<>("hora"));
        ColunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ColunaPreco.setCellValueFactory(new PropertyValueFactory<>("preco"));
        ColunaServico.setCellValueFactory(new PropertyValueFactory<>("servico"));

        ObservableList<Agendamento> agendamentos = FXCollections.observableArrayList(agenda.getAllAgendamentos());
        Tabela.setItems(agendamentos);
    }
}
