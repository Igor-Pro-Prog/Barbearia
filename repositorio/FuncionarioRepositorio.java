package repositorio;
import java.util.ArrayList;
import java.util.List;
import dados.Funcionario;

public class FuncionarioRepositorio {
    private List<Funcionario> funcionarios;

    public FuncionarioRepositorio() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public boolean removerFuncionario(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                funcionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
    }

    public Funcionario buscarFuncionario(int id) {
        for (Funcionario funcionario : funcionarios) {
            if (funcionario.getId() == id) {
                return funcionario;
            }
        }
        return null;
    }

    public List<Funcionario> buscarTodos() {
        return funcionarios;
    }

    public boolean existe(Funcionario funcionario) {
        return funcionarios.contains(funcionario);
    }

    public Funcionario buscarFuncionarioPorNome(String nomeFuncionario) {
        return funcionarios.stream().filter(funcionario -> funcionario.getNome().equals(nomeFuncionario)).findFirst().orElse(null);
    }
}