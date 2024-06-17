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
import java.util.List;


public class AgendaController {

    @FXML
    private TableView<Agendamento> Tabela;

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
        ColunaID.setCellValueFactory(new PropertyValueFactory<Agendamento, Integer>("id"));
        ColunaData.setCellValueFactory(new PropertyValueFactory<Agendamento, String>("data"));
        ColunaHora.setCellValueFactory(new PropertyValueFactory<Agendamento, String>("hora"));
        ColunaNome.setCellValueFactory(new PropertyValueFactory<Agendamento, String>("nome"));
        ColunaPreco.setCellValueFactory(new PropertyValueFactory<Agendamento, String>("preco"));
        ColunaServico.setCellValueFactory(new PropertyValueFactory<Agendamento, String>("servico"));

        List<Agendamento> agendamentosList = agenda.getAllAgendamentos();

        System.out.println("Número de agendamentos carregados: " + agendamentosList.size());

        for (Agendamento agendamento : agendamentosList) {
            System.out.println(agendamento.getId() + ", " + agendamento.getNome());
        }

        ObservableList<Agendamento> agendamentos = FXCollections.observableArrayList(agenda.getAllAgendamentos());
        Tabela.setItems(agenda.getAllAgendamentos());
    }
}
