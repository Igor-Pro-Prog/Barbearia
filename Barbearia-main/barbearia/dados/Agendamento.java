package dados;
import java.time.LocalDateTime;
import java.util.Date;

public class Agendamento {
    private Date data;
    private String horario;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private boolean realizado;

    public Agendamento(Date i, String cliente2, Cliente funcionario2, Funcionario servico2, Servico dateTime) {
        this.data = i;
        this.horario = cliente2;
        this.cliente = funcionario2;
        this.funcionario = servico2;
        this.servico = dateTime;
        this.realizado = false;
    }

    public Agendamento(Servico servico2, Cliente cliente2, Funcionario funcionario2, LocalDateTime dataHora) {
    }

    public Agendamento(int nextInt, Cliente cliente2, Funcionario funcionario2, Servico servico2,
            LocalDateTime dateTime) {
    }

    public Agendamento(Cliente cliente2, Funcionario funcionario2, Servico servico2, LocalDateTime dataHora) {
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

    public LocalDateTime getDataHora() {
        return null;
    }
}