package Model.DAO;

import Model.Classes.Barbeiro;

import java.util.ArrayList;
import java.util.List;


public class BarbeiroDAOImpl implements GenericDAO<Barbeiro> {

    private static BarbeiroDAOImpl instance;

    Barbeiro barbeiro1 = new Barbeiro(1, "barbeiro1","senha");
    Barbeiro barbeiro2 = new Barbeiro(2, "barbeiro2", "senha");


    public List<Barbeiro> barbeiros;

    public BarbeiroDAOImpl() {
        barbeiros = new ArrayList<>();
        barbeiros.add(barbeiro1);
        barbeiros.add(barbeiro2);

    }
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
    public void update(Barbeiro barbeiro) {
        Barbeiro existingUser = findById(barbeiro.getId());
        if (existingUser != null) {
            existingUser.setNome(barbeiro.getNome());
        }
    }

    @Override
    public void delete(Barbeiro barbeiro) {
        barbeiros.removeIf(u -> u.getId() == barbeiro.getId());
    }

    public static synchronized BarbeiroDAOImpl getInstance(){
        if (instance == null){
            instance = new BarbeiroDAOImpl();
        }
        return instance;
    }
}

