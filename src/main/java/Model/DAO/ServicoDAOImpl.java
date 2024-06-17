package Model.DAO;

import Model.Classes.Servico;

import java.util.ArrayList;
import java.util.List;


public class ServicoDAOImpl implements GenericDAO<Servico> {

    private static ServicoDAOImpl instance;

    Servico servico1 = new Servico(1, "Cabelo", 20);
    Servico servico2 = new Servico(2, "Barba", 10);
    Servico servico3 = new Servico(3, "Sobrancelha", 6);
    Servico servico4 = new Servico(4, "Pigmentação", 10);
    Servico servico5 = new Servico(5, "Platinar", 30);

    public final List<Servico> servicos;

    public ServicoDAOImpl() {
        servicos = new ArrayList<>();
        servicos.add(servico1);
        servicos.add(servico2);
        servicos.add(servico3);
        servicos.add(servico4);
        servicos.add(servico5);
    }
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

    public static synchronized ServicoDAOImpl getInstance(){
        if (instance == null){
            instance = new ServicoDAOImpl();
        }
        return instance;
    }
}

