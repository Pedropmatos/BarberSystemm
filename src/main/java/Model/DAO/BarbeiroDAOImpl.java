package Model.DAO;

import Model.Barbeiro;

import java.util.ArrayList;
import java.util.List;


public class BarbeiroDAOImpl implements GenericDAO<Barbeiro> {


    Barbeiro barbeiro1 = new Barbeiro(1, "barbeiro1", "0323232433", "323246456", "senha", "todos");
    Barbeiro barbeiro2 = new Barbeiro(2, "barbeiro2", "012654373", "323763456", "senha", "todos");


    private List<Barbeiro> barbeiros = new ArrayList<>();
    private int currentId = 1;

    @Override
    public void save(Barbeiro barbeiro) {
        barbeiro.setId(currentId++);
        barbeiros.add(barbeiro);
    }

    @Override
    public Barbeiro findById(int id) {
        return barbeiros.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Barbeiro> findAll() {
        return new ArrayList<>(barbeiros);
    }

    @Override
    public void update(Barbeiro barbeiro) {
        Barbeiro existingUser = findById(barbeiro.getId());
        if (existingUser != null) {
            existingUser.setNome(barbeiro.getNome());
            existingUser.setCpf(barbeiro.getCpf());
        }
    }

    @Override
    public void delete(Barbeiro barbeiro) {
        barbeiros.removeIf(u -> u.getId() == barbeiro.getId());
    }
}

