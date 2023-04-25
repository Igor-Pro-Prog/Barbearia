package menu;

import java.util.Scanner;
import java.util.Date;
import java.util.Random;

import repositorio.AgendamentoRepositorio;
import repositorio.ClienteRepositorio;
import repositorio.FuncionarioRepositorio;
import repositorio.ServicoRepositorio;

import dados.Agendamento;
import dados.Cliente;
import dados.Funcionario;
import dados.Servico;

class Menu {
    

    private static Scanner scanner = new Scanner(System.in);

    private static  ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    private static  FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
    private static  ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
    private static  AgendamentoRepositorio agendamentoRepositorio = new AgendamentoRepositorio();

    private static  Cliente[] clientes;

    private static  Scanner input;

    private static Funcionario[] funcionarios;

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
			int opcao = 0;
            do {
                System.out.println("1 - Cadastrar serviço");
                System.out.println("2 - Listar serviços");
                System.out.println("3 - Cadastrar cliente");
                System.out.println("4 - Listar clientes");
                System.out.println("5 - Agendar serviço");
                System.out.println("6 - Listar agendamentos");
                System.out.println("7 - Cadastrar Funcionário");
                System.out.println("8 - Listar Funcionários");
                System.out.println("9 - Sair");
                System.out.print("Opção: ");
                opcao = entrada.nextInt();

                switch (opcao) {
                    case 1:
                        cadastrarServico();
                        break;
                    case 2:
                        listarServicos();
                        break;
                    case 3:
                        cadastrarCliente();
                        break;
                    case 4:
                        listarClientes();
                        break;
                    case 5:
                        agendarServico();
                        break;
                    case 6:
                        listarAgendamentos();
                        break;
                    case 7:
                        cadastrarFuncionario();
                        break;
                    case 8:
                        listarFuncionarios();
                        break;
                    case 9:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                    } 
                
                } while (opcao != 9);
    }}


    public static void cadastrarServico() {
        System.out.println("Cadastro de serviço");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: ");
        double preco = scanner.nextDouble();
        Servico servico = new Servico(nome, preco);
        servicoRepositorio.adicionarServico(servico);
        System.out.println("Serviço cadastrado com sucesso!");
    }

    public static void listarServicos() {
        System.out.println("Lista de serviços");
        for (Servico servico : servicoRepositorio.buscarTodos()) {
            System.out.println("Nome: " + servico.getNome());
            System.out.println("Valor: " + servico.getPreco());
            System.out.println();
        }
    }    

    public static void cadastrarCliente() {
        System.out.println("Cadastro de cliente");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        // guarda os dados do cliente em um objeto da classe Cliente
        Cliente cliente = new Cliente(nome, email, telefone);
        // adiciona o cliente ao repositório
        clienteRepositorio.adicionarCliente(cliente);
        System.out.println("Cliente cadastrado com sucesso!");

    }
     
    public static void listarClientes() {
        System.out.println("--- Lista de Clientes ---");
        // verifica se há clientes cadastrados
        if (clienteRepositorio.buscarTodos().length == 0) {
            System.out.println("Não há clientes cadastrados!");
        } else {
            for (Cliente cliente : clienteRepositorio.buscarTodos()) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("E-mail: " + cliente.getEmail());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println();
            }
        }
    }
     
    public static void agendarServico() {
        // solicita o nome do cliente e verifica se ele existe
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = input.next();
        Cliente cliente = buscarCliente(nomeCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        // solicita o nome do serviço e verifica se ele existe
        System.out.print("Digite o nome do serviço: ");
        String nomeServico = input.next();
        Servico servico = agendarServico(nomeServico);
        if (servico == null) {
            System.out.println("Serviço não encontrado!");
            return;
        }
        
        // solicita o nome do funcionário e verifica se ele existe
        System.out.print("Digite o nome do funcionário: ");
        String nomeFuncionario = input.next();
        Funcionario funcionario = buscarFuncionario(nomeFuncionario);
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }
        
        // solicita a data e hora do serviço
        System.out.print("Digite a data do serviço (dd/mm/aaaa): ");
        Date data = new Date(input.next());
        System.out.print("Digite a hora do serviço (hh:mm): ");
        String hora = input.next();

        Agendamento agendamento = new Agendamento(data, hora, cliente, funcionario, servico );
        agendamentoRepositorio.adicionar(agendamento);
        System.out.println("Agendamento realizado com sucesso!");
    }

    private static Servico agendarServico(String nomeServico) {
        return null;
    }

    private static Cliente buscarCliente(String nomeCliente) {
        return null;
    }

    private static Funcionario buscarFuncionario(String nomeFuncionario) {
        return null;
    }

    public static void listarAgendamentos() {
        System.out.println("Lista de agendamentos");
        for (Agendamento agendamento : agendamentoRepositorio.buscarTodos()) {
            System.out.println(agendamento);
        }
    }

    public static void cadastrarFuncionario() {
        System.out.println("Cadastro de funcionário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Funcionario funcionario = new Funcionario(0, nome, cpf, telefone, 0);
        funcionarioRepositorio.adicionarFuncionario(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }
    
    public static void listarFuncionarios() {
        System.out.println("--- Lista de Funcionários ---");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Telefone: " + funcionario.getTelefone());
            // System.out.println("Email: " + funcionario.getEmail());
            // System.out.println("Endereço: " + funcionario.getEndereco());
            System.out.println("------------------------");
        }
    }
}
