package dados;
import java.util.Date;

public class Agendamento {
    private Date data;
    private String horario;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private boolean realizado;

    public Agendamento(Date data, String horario, Cliente cliente, Funcionario funcionario, Servico servico) {
        this.data = data;
        this.horario = horario;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.realizado = false;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public boolean isRealizado() {
        return realizado;
    }

    public void setRealizado(boolean realizado) {
        this.realizado = realizado;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Agendamento)) {
            return false;
        }
        Agendamento outro = (Agendamento) obj;
        return this.data.equals(outro.data) && this.horario.equals(outro.horario)
                && this.cliente.equals(outro.cliente) && this.funcionario.equals(outro.funcionario)
                && this.servico.equals(outro.servico);
    }
}