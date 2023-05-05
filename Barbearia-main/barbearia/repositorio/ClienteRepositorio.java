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

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Cliente> buscarTodos() {
        return clientes;
    }

    public boolean existe(Cliente cliente) {
        return clientes.contains(cliente);
    }

    public Cliente buscarClientePorNome(String nomeCliente) {
        return clientes.stream().filter(cliente -> cliente.getNome().equals(nomeCliente)).findFirst().orElse(null);
    }
}
