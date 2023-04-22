package dados;

import java.util.Random;

public class Servico {
    private int id;
    private String nome;
    private double preco;

    public Servico(String nome, double preco) {
        this.id = (new Random()).nextInt();
        this.nome = nome;
        this.preco = preco;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Servico)) {
            return false;
        }
        Servico outro = (Servico) obj;
        return this.id == outro.id;
    }
}
