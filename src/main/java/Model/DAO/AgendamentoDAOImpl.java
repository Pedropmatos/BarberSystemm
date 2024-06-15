package Model.DAO;

import Model.Classes.Agendamento;
import Model.Classes.Barbeiro;

import java.util.ArrayList;
import java.util.List;

public class AgendamentoDAOImpl implements GenericDAO<Agendamento>{

    private static AgendamentoDAOImpl instance;

    private List<Agendamento> agendamentos = new ArrayList<>();
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
            existingUser.setCliente(agendamento.getCliente());
        }
    }

    @Override
    public void delete(Agendamento agendamento) {
        agendamentos.removeIf(u -> u.getId() == agendamento.getId());
    }
}

