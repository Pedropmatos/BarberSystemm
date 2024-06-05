package Model.DAO;

import Model.Servico;

import java.util.ArrayList;
import java.util.List;


public class ServicoDAOImpl implements GenericDAO<Servico> {
    private List<Servico> servicos = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void save(Servico user) {
        user.setId(currentId++);
        servicos.add(user);
    }

    @Override
    public Servico findById(int id) {
        return servicos.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Servico> findAll() {
        return new ArrayList<>(servicos);
    }

    @Override
    public void update(Servico entity) {

    }

    @Override
    public void delete(Servico entity) {

    }

}
