package Model.DAO;

import Model.Classes.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteDAOImpl implements GenericDAO<Cliente> {

    private static ClienteDAOImpl instance;

    Cliente cliente1 = new Cliente(1, "Pedro Paulo", "1", "749992231242", 'M');
    Cliente cliente2 = new Cliente(2, "Filipe Silva", "2", "749992231242", 'M');
    Cliente cliente3 = new Cliente(3, "Cauane Galdino", "3", "749994342", 'F');
    Cliente cliente4 = new Cliente(4, "Leo Santos", "4", "749992231242", 'M');
    Cliente cliente5 = new Cliente(5, "Leomas", "5", "749992341242", 'M');



    public final List<Cliente> clientes;


    public ClienteDAOImpl() {
        clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
    }

    private int currentId = 1;

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

    public static synchronized ClienteDAOImpl getInstance(){
        if (instance == null){
            instance = new ClienteDAOImpl();
        }
        return instance;
    }
}
