package dados;

public class Servico {
    private String nome;
    private double preco;
    private int duracao;

    //int duracao
    public Servico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        //this.duracao = duracao;
    }
    
    public int getDuracao() {
		return duracao;
	}

	public void setDuracao(int duracao) {
		this.duracao = duracao;
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

    public String buscarServico(String nome) {
        return nome;
    }

    public String getBuscarServico(String nome) {
        return nome;
    }
}
