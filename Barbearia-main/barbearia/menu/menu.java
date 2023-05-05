package menu;

import java.util.List;
import java.util.Scanner;

import repositorio.AgendamentoRepositorio;
import repositorio.ClienteRepositorio;
import repositorio.FuncionarioRepositorio;
import repositorio.ServicoRepositorio;

import dados.Agendamento;
import dados.Cliente;
import dados.Funcionario;
import dados.Servico;

class menu {
    
    private static Scanner scanner = new Scanner(System.in);

    private static  ClienteRepositorio clienteRepositorio = new ClienteRepositorio();
    private static  FuncionarioRepositorio funcionarioRepositorio = new FuncionarioRepositorio();
    private static  ServicoRepositorio servicoRepositorio = new ServicoRepositorio();
    private static  AgendamentoRepositorio agendamentoRepositorio = new AgendamentoRepositorio();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        int opcao = 0;
        // coloca na cor vermelha
        System.out.println("\033[0;31mBem-vindo ao sistema de agendamento de serviços da Barbearia!\033[0m");
        System.out.println("Para o início do sistema por favor cadastre um funcionário:");
        cadastrarFuncionario();
        System.out.println("Agora cadastre os serviços disponíveis da barbearia");
        System.out.println("Número de serviços que deseja cadastrar:");
        int num = Integer.valueOf(scanner.nextLine());
        for(int i=0; i < num; i++) {
        	cadastrarServico();
        }
        System.out.println("Você é um cliente (1) ou um funcionário (2)?");
        int tipoUsuario = Integer.valueOf(scanner.nextLine());
        
        if (tipoUsuario == 1) {
            System.out.println("Para agendar um serviço, é necessário estar cadastrado como cliente.");
            System.out.println("Você é um cliente cadastrado? (1 - sim / qualquer outro número - não)");
            int cadastrarCliente = Integer.valueOf(scanner.nextLine());
            
            if (cadastrarCliente == 1) {
                // cria um menu de cliente cadastrado,onde cliente pode agendar serviço ou ver a lista de serviços 
                MenuCliente(opcao,sair);
            } else {
                // se escolher não, entra em cadastramento de cliente para se cadastrar
                cadastrarCliente();
                // mostra as opções disponiveis para o cliente
                MenuCliente(opcao,sair);
            }
            
        } else if (tipoUsuario == 2) {
            do {               
                System.out.println("Selecione uma opção:");
                System.out.println("0 - Entrar como cliente");
                System.out.println("1 - Cadastrar serviço");
                System.out.println("2 - Listar serviços");
                System.out.println("3 - Cadastrar cliente");
                System.out.println("4 - Listar clientes");
                System.out.println("5 - Agendar serviço");
                System.out.println("6 - Listar agendamentos");
                System.out.println("7 - Cadastrar funcionário");
                System.out.println("8 - Listar funcionários");
                System.out.println("9 - Sair");
                
                opcao = Integer.valueOf(scanner.nextLine());
                
                switch (opcao) {
                    case 0:
                    	MenuCliente(opcao,sair);
                        break;
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
                    // coloca na cor verde
                        System.out.println("\033[0;32mObrigado por utilizar nosso sistema de barbearia. Até mais!\033[0m");
                        sair = true;
                        break;
                    default:
                    // coloca na cor amarela
                        System.out.println("\033[0;33mOpção inválida. Tente novamente.\033[0m");
                        break;
                }
            } while (!sair);
        } else {
            // coloca na cor amarela
            System.out.println("\033[0;33mOpção inválida, encerrando programa...\033[0m");
        }
        
        scanner.close();
    }
    
    public static void cadastrarServico() {
        System.out.println("Cadastro de serviço");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Valor: ");
        double preco = Double.valueOf(scanner.nextLine());
        Servico servico = new Servico(nome, preco);
        servicoRepositorio.adicionarServico(servico);
        // coloca na cor verde
        System.out.println("\033[0;32mServiço cadastrado com sucesso!\033[0m");
    }
    
    public static void listarServicos() {
        System.out.println("Lista de serviços:");
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
        System.out.print("CPF: ");
        int cpf = Integer.valueOf(scanner.nextLine());
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        // guarda os dados do cliente em um objeto da classe Cliente
        Cliente cliente = new Cliente(nome, telefone, cpf);
        // adiciona o cliente ao repositório
        clienteRepositorio.adicionarCliente(cliente);
        // coloca na cor verde
        System.out.println("\033[0;32mCliente cadastrado com sucesso!\033[0m");
    }
    
    public static void listarClientes() {
        System.out.println("--- Lista de Clientes ---");
        // verifica se há clientes cadastrados
        if (clienteRepositorio.buscarTodos().isEmpty()) {
            // coloca na cor amarela
            System.out.println("\033[0;33mNão há clientes cadastrados!\033[0m");
        } else {
            for (Cliente cliente : clienteRepositorio.buscarTodos()) {
                System.out.println("Nome: " + cliente.getNome());
                System.out.println("Telefone: " + cliente.getTelefone());
                System.out.println("CPF: " + cliente.getCpf());
                ;
                System.out.println();
            }
        }
    }
    
    public static void agendarServico() {
    	listarServicos();
        System.out.println("Agendamento de serviço");
        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = clienteRepositorio.buscarClientePorNome(nomeCliente);

        if (cliente == null) {
            // coloca na cor vermelha
            System.out.println("\033[0;31mCliente não encontrado!\033[0m");
            return;
        }
    
        System.out.print("Nome do funcionário: ");
        String nomeFuncionario = scanner.nextLine();
        Funcionario funcionario = funcionarioRepositorio.buscarFuncionarioPorNome(nomeFuncionario);
    
        if (funcionario == null) {
            //coloca na cor vermelha
            System.out.println("\033[0;31mFuncionário não encontrado!\033[0m");
            return;
        }
    
        System.out.print("Nome do serviço: ");
        String nomeServico = scanner.nextLine();
        Servico servico = servicoRepositorio.buscarServicoPorNome(nomeServico);
    
        if (servico == null) {
            // coloca na cor vermelha
            System.out.println("\033[0;31mServiço não encontrado!\033[0m");
            return;
        }
    
        System.out.print("Data do agendamento (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        Agendamento agendamento = new Agendamento(cliente, funcionario, servico, data);
        agendamentoRepositorio.adicionarAgendamento(agendamento);
        // coloca na cor verde
        System.out.println("\033[0;32mAgendamento cadastrado com sucesso!\033[0m");      
    }
    
    public static void listarAgendamentos() {
        System.out.println("Lista de agendamentos");
        List<Agendamento> agendamentos = agendamentoRepositorio.buscarTodos();
        if (agendamentos.isEmpty()) {
            System.out.println("Não há agendamentos cadastrados.");
        } else {
                for (Agendamento agendamento : agendamentoRepositorio.buscarTodos()) {
                    System.out.println("Cliente: " + agendamento.getCliente().getNome());
                    System.out.println("Funcionário: " + agendamento.getFuncionario().getNome());
                    System.out.println("Serviço: " + agendamento.getServico().getNome());
                    System.out.println("Data: " + agendamento.getData());
                    System.out.println("");
                }
            }
        }

    public static void cadastrarFuncionario() {
        System.out.println("Cadastro de funcionário");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        int cpf = Integer.valueOf(scanner.nextLine());
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Funcionario funcionario = new Funcionario(nome,telefone,cpf);
        funcionarioRepositorio.adicionarFuncionario(funcionario);
        // coloca na cor verde
        System.out.println("\033[0;32mFuncionário cadastrado com sucesso!\033[0m");
        System.out.println();   
    }
    
    public static void listarFuncionarios() {
        // verifica se há funcionários cadastrados se não houver exibe uma mensagem se houver exibe a lista de funcionários
        if (funcionarioRepositorio.buscarTodos().isEmpty()) {
            // coloca na cor vermelha
            System.out.println("\033[0;31mNão há funcionários cadastrados!\033[0m");
        } else {
            for (Funcionario funcionario : funcionarioRepositorio.buscarTodos()) {
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println();
            }
        }
    }
    
    public static void MenuCliente(int opcao, boolean sair) {
    	do {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Agendar serviço");
            System.out.println("2 - Listar serviços");
            System.out.println("3 - Sair");
            
            opcao = Integer.valueOf(scanner.nextLine());
            
            switch (opcao) {
                case 1:
                	if(clienteRepositorio.buscarTodos().isEmpty()) {
                		System.out.println("Não há clientes cadastrados para poder agendar um serviço");
                		break;
                	}else {
                		agendarServico();
                		break;
                	}
                case 2:
                    listarServicos();
                    break;
                case 3:
                	// coloca na cor verde
                	System.out.println("\033[0;32mObrigado por utilizar nosso sistema de barbearia. Até mais!\033[0m");
                    sair = true;
                    break;
                default:
                    // coloca na cor amarela
                    System.out.println("\033[0;33mOpção inválida. Tente novamente.\033[0m");
                    break;
            }
        } while (!sair);     
    }
}
