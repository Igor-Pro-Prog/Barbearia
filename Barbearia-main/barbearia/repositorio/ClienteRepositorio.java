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

    public Cliente[] buscarTodos() {
        return clientes.toArray(new Cliente[0]);
    }

    public boolean existe(Cliente cliente) {
        return clientes.contains(cliente);
    }

    public boolean existeNome(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public Cliente buscarClientePorNome(String nomeCliente) {
        return clientes.stream().filter(cliente -> cliente.getNome().equals(nomeCliente)).findFirst().orElse(null);
    }

    public Cliente existeNome(String nomeCliente) {
        return null;
    }
}
