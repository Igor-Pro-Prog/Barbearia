package dados;

public class Agendamento {
    private String data;
    private String hora;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;

    //String hora2
    public Agendamento(Cliente cliente2, Funcionario funcionario2, Servico servico2, String data2) {
    	this.cliente = cliente2;
    	this.funcionario = funcionario2;
    	this.servico = servico2;
    	this.data = data2;
    	//this.hora = hora2;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getHora() {
    	return hora;
    }
    
    public void setHora(String hora){
    	this.hora = hora;
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
}
