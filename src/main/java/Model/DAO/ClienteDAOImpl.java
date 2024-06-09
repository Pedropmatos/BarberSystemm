package Model.DAO;

import Model.Classes.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteDAOImpl implements GenericDAO<Cliente> {


    Cliente cliente1 = new Cliente(1, "Pedro Paulo", "0428902456", "749992231242", 'M');
    Cliente cliente2 = new Cliente(2, "Filipe Silva", "0467842456", "749992231242", 'M');
    Cliente cliente3 = new Cliente(3, "Cauane Galdino", "042454456", "749994342", 'F');
    Cliente cliente4 = new Cliente(4, "Leo Santos", "042424233356", "749992231242", 'M');
    Cliente cliente5 = new Cliente(5, "Leomas", "04244542456", "749992341242", 'M');



    private final List<Cliente> clientes = new ArrayList<>();
    private int currentId = 1; // Para gerar IDs únicos

    @Override
    public void save(Cliente cliente) {
        cliente.setId(currentId++);
        clientes.add(cliente);
    }

    @Override
    public Cliente findById(int id) {
        return clientes.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cliente> findAll() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void update(Cliente cliente) {
        Cliente existingUser = findById(cliente.getId());
        if (existingUser != null) {
            existingUser.setNome(cliente.getNome());
            existingUser.setCpf(cliente.getCpf());
        }
    }

    @Override
    public void delete(Cliente cliente) {
        clientes.removeIf(u -> u.getId() == cliente.getId());
    }
}
