package repositorio;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dados.Agendamento;
import dados.Cliente;
import dados.Funcionario;

public class AgendamentoRepositorio {
    private List<Agendamento> agendamentos = new ArrayList<>();

    public void adicionar(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public List<Agendamento> buscarPorData(Date data) {
        List<Agendamento> agendamentosEncontrados = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getData().equals(data)) {
                agendamentosEncontrados.add(agendamento);
            }
        }
        return agendamentosEncontrados;
    }

    public List<Agendamento> buscarPorFuncionario(Funcionario funcionario) {
        List<Agendamento> agendamentosEncontrados = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getFuncionario().equals(funcionario)) {
                agendamentosEncontrados.add(agendamento);
            }
        }
        return agendamentosEncontrados;
    }

    public List<Agendamento> buscarPorCliente(Cliente cliente) {
        List<Agendamento> agendamentosEncontrados = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getCliente().equals(cliente)) {
                agendamentosEncontrados.add(agendamento);
            }
        }
        return agendamentosEncontrados;
    }

    public List<Agendamento> buscarTodos() {
        return agendamentos;
    }

    // outros métodos de busca

    public void atualizar(Agendamento agendamento) {
        for (int i = 0; i < agendamentos.size(); i++) {
            if (agendamentos.get(i).equals(agendamento)) {
                agendamentos.set(i, agendamento);
                return;
            }
        }
    }

    public void remover(Agendamento agendamento) {
        agendamentos.remove(agendamento);
    }

    public void adicionarAgendamento(Agendamento agendamento) {
    }

    public List<Agendamento> buscarAgendamentosPorData(List<Agendamento> agendamentos, LocalDate data) {
        List<Agendamento> agendamentosNaData = new ArrayList<>();
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getData().equals(data)) {
                agendamentosNaData.add(agendamento);
            }
        }
        return agendamentosNaData;
    }
    
    
}