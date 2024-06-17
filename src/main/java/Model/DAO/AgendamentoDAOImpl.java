package Model.DAO;

import Model.Classes.Agendamento;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAOImpl implements GenericDAO<Agendamento>{

    private static AgendamentoDAOImpl instance;


    public static AgendamentoDAOImpl getInstance(){
        if (instance == null){
            instance = new AgendamentoDAOImpl();
        }
        return instance;
    }

    public ObservableList<Agendamento> getAllAgendamentos() {
        return FXCollections.observableArrayList(agendamentos);
    }

    Agendamento agendamento1 = new Agendamento(1, "Pedro Paulo", "Corte", 20, "01/07/2024", "11:00");
    Agendamento agendamento2 = new Agendamento(2, "Filipe Silva", "Barba", 10, "02/07/2024","12:00");
    Agendamento agendamento3 = new Agendamento(3, "Cauane Galdino", "Sobrancelha", 6, "20/06/2024", "08:00");
    Agendamento agendamento4 = new Agendamento(4, "Leo Santos", "Platinar", 30, "18/06/2024", "15:00");
    Agendamento agendamento5 = new Agendamento(5, "Leomas", "Pigmentação", 10, "25/06/2024", "18:00");
    public List<Agendamento> agendamentos;

    public AgendamentoDAOImpl() {
        agendamentos = new ArrayList<>();
        agendamentos.add(agendamento1);
        agendamentos.add(agendamento2);
        agendamentos.add(agendamento3);
        agendamentos.add(agendamento4);
        agendamentos.add(agendamento5);
    }
    private int currentId = 1;


    @Override
    public void save(Agendamento agendamento) {
        agendamento.setId(currentId++);
        agendamentos.add(agendamento);
    }

    @Override
    public Agendamento findById(int id) {
        return agendamentos.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Agendamento agendamento) {
        Agendamento existingUser = findById(agendamento.getId());
        if (existingUser != null) {
            existingUser.setNome(agendamento.getNome());
        }
    }

    @Override
    public void delete(Agendamento agendamento) {
        agendamentos.removeIf(u -> u.getId() == agendamento.getId());
    }


}