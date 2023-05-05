package dados;

public class Funcionario {
    private String nome;
    private String telefone;
    private int cpf;
    

    public Funcionario(String nome,String telefone,int cpf) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;   
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
}
