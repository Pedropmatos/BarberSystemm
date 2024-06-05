package Model.DAO;

import Model.Cliente;

import java.util.ArrayList;
import java.util.List;


public class ClienteDAOImpl implements GenericDAO<Cliente> {
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
