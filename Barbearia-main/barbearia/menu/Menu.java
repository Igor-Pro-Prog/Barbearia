package menu;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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
        System.out.println("Agendamento de serviço");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        // verifica se existe um cliente com o nome informado no repositório
        Cliente cliente = clienteRepositorio.buscarClientePorNome(nomeCliente);
    
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
    
        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();
        Funcionario funcionario = funcionarioRepositorio.buscarFuncionarioPorNome(nomeFuncionario);
    
        if (funcionario == null) {
            System.out.println("Funcionário não encontrado!");
            return;
        }
    
        System.out.print("Nome do serviço: ");
        String nomeServico = scanner.nextLine();
        Servico servico = servicoRepositorio.buscarServicoPorNome(nomeServico);
    
        if (servico == null) {
            System.out.println("Serviço não encontrado!");
            return;
        }
    
        System.out.print("Data do agendamento (dd/mm/aaaa): ");
        String data = scanner.nextLine();
        System.out.print("Horário do agendamento (hh:mm): ");
        String horario = scanner.nextLine();
    
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(data + " " + horario, formatter);
            Agendamento agendamento = new Agendamento(cliente, funcionario, servico, dataHora);
            agendamentoRepositorio.adicionarAgendamento(agendamento);
            System.out.println("Agendamento cadastrado com sucesso!");
        } catch (DateTimeParseException e) {
            System.out.println("Data ou horário inválidos!");
        }
    }
    
    
    private static Cliente getNomeCliente(String nomeCliente) {
        return null;
    }


    private static Servico getServico(String nomeServico) {
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
        System.out.println();
        
    }
    
    public static void listarFuncionarios() {
        // verifica se há funcionários cadastrados se não houver exibe uma mensagem se houver exibe a lista de funcionários
        if (funcionarioRepositorio.buscarTodos().isEmpty()) {
            System.out.println("Não há funcionários cadastrados!");
        } else {
            for (Funcionario funcionario : funcionarioRepositorio.buscarTodos()) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println();
            }
        }
    }
}