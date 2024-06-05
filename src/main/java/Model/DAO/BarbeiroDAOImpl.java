package Model.DAO;

import Model.Barbeiro;

import java.util.ArrayList;
import java.util.List;


public class BarbeiroDAOImpl implements GenericDAO<Barbeiro> {
    private final List<Barbeiro> barbeiros = new ArrayList<>();
    private int currentId = 1; // Para gerar IDs únicos

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

