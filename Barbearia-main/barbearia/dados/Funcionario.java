
package dados;

public class Funcionario {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private double salario;

    public Funcionario(int id, String nome, String cpf, String telefone, double salario) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Funcionario)) {
            return false;
        }
        Funcionario outro = (Funcionario) obj;
        return this.id == outro.id;
    }

    public String getEmail() {
        return null;
    }

    public String getEndereco() {
        return null;
    }

    public String getTodos() {
        return null;
    }
}