package Model.DAO;

import Model.Classes.Agendamento;

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

    public List<Agendamento> getAllAgendamentos() {
        return new ArrayList<>();
    }

    Agendamento agendamento1 = new Agendamento(1, "Pedro Paulo", "Corte", 20, "01/07/2024", "11:00");
    Agendamento agendamento2 = new Agendamento(1, "Filipe Silva", "Barba", 10, "02/07/2024","12:00");
    public List<Agendamento> agendamentos;

    public AgendamentoDAOImpl() {
        agendamentos = new ArrayList<>();
        agendamentos.add(agendamento1);
        agendamentos.add(agendamento2);
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
    public List<Agendamento> findAll() {
        return new ArrayList<>(agendamentos);
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