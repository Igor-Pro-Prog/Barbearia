package dados;

import java.util.Random;

public class Cliente {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private int cpf;

    public Cliente(String nome, String telefone, String email) {
        this.id = (new Random()).nextInt();
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public Cliente(String nome2, String cpf2, String telefone2, String email2) {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public int getCpf() {
        return cpf;   
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cliente)) {
            return false;
        }
        Cliente outro = (Cliente) obj;
        return this.id == outro.id;
    }
    
    public String getTodos() {
        return null;
    }
}