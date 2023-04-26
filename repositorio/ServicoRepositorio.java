package repositorio;
import java.util.ArrayList;
import java.util.List;
import dados.Servico;


public class ServicoRepositorio {
    private List<Servico> servicos;

    public ServicoRepositorio() {
        servicos = new ArrayList<>();
    }

    public List<Servico> buscarTodos() {
        return this.servicos;
    }

    public boolean existe(Servico servico) {
        return servicos.contains(servico);
    }

    public boolean existe(int id) {
        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean existeNome(String nomeServico) {
        for (Servico servico : servicos) {
            if (servico.getNome().equals(nomeServico)) {
                return true;
            }
        }
        return false;
    }

    public void adicionarServico(Servico servico) {
        servicos.add(servico);
    }

    public boolean removerServico(int id) {
        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                servicos.remove(servico);
                return true;
            }
        }
        return false;
    }

    public List<Servico> listarServicos() {
        return servicos;
    }

    public Servico buscarServico(int id) {
        for (Servico servico : servicos) {
            if (servico.getId() == id) {
                return servico;
            }
        }
        return null;
    }

    public static Servico buscarServico(String nomeServico) {
        return null;
    }

    public Servico buscarServicoPorNome(String nomeServico) {
        return servicos.stream().filter(servico -> servico.getNome().equals(nomeServico)).findFirst().orElse(null);
    }
}
