package repositorio;
import java.util.ArrayList;
import java.util.List;
import dados.Cliente;


public class ClienteRepositorio {
    private List<Cliente> clientes;

    public ClienteRepositorio() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean removerCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return true;
            }
        }
        return false;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
