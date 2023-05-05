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

    public List<Funcionario> listarFuncionarios() {
        return funcionarios;
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
