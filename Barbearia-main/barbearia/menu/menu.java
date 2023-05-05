package menu;

import java.util.List;
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
        System.out.println("Você é um cliente (1) ou um funcionário (2)?");
        int tipoUsuario = scanner.nextInt();
        
        if (tipoUsuario == 1) {
            System.out.println("Para agendar um serviço, é necessário estar cadastrado como cliente.");
            System.out.println("Você é um cliente cadastrado? (1 - sim / qualquer outro número - não)");
            int cadastrarCliente = scanner.nextInt();
            
            if (cadastrarCliente == 1) {
                // cria um menu de cliente cadastrado,onde cliente pode agendar serviço ou ver a lista de serviços 
                do {
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Agendar serviço");
                    System.out.println("2 - Listar serviços");
                    System.out.println("3 - Sair");
                    
                    opcao = scanner.nextInt();
                    
                    switch (opcao) {
                        case 1:
                            agendarServico();
                            break;
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
            } else {
                // se escolher não, entra em cadastramento de cliente para se cadastrar
                cadastrarCliente();
                // mostra as opções disponiveis para o cliente
                do {
                    System.out.println("Selecione uma opção:");
                    System.out.println("1 - Agendar serviço");
                    System.out.println("2 - Listar serviços");
                    System.out.println("3 - Sair");
                    
                    opcao = scanner.nextInt();
                    
                    switch (opcao) {
                        case 1:
                            agendarServico();
                            break;
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
                
                opcao = scanner.nextInt();
                
                switch (opcao) {
                    case 0:
                    	do {
                            System.out.println("Selecione uma opção:");
                            System.out.println("1 - Agendar serviço");
                            System.out.println("2 - Listar serviços");
                            System.out.println("3 - Sair");
                            
                            opcao = scanner.nextInt();
                            
                            switch (opcao) {
                                case 1:
                                    agendarServico();
                                    break;
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
        double preco = scanner.nextDouble();
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
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        // guarda os dados do cliente em um objeto da classe Cliente
        Cliente cliente = new Cliente(nome, email, telefone);
        // adiciona o cliente ao repositório
        clienteRepositorio.adicionarCliente(cliente);
        // coloca na cor verde
        System.out.println("\033[0;32mCliente cadastrado com sucesso!\033[0m");

    }
    
    public static void listarClientes() {
        System.out.println("--- Lista de Clientes ---");
        // verifica se há clientes cadastrados
        if (clienteRepositorio.buscarTodos().length == 0) {
            // coloca na cor amarela
            System.out.println("\033[0;33mNão há clientes cadastrados!\033[0m");
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
        System.out.print("Horário do agendamento (hh:mm): ");
        String horario = scanner.nextLine();
    
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            LocalDateTime dataHora = LocalDateTime.parse(data + " " + horario, formatter);
            Agendamento agendamento = new Agendamento(cliente, funcionario, servico, dataHora);
            agendamentoRepositorio.adicionarAgendamento(agendamento);
            // coloca na cor verde
            System.out.println("\033[0;32mAgendamento cadastrado com sucesso!\033[0m");
        } catch (DateTimeParseException e) {
            // coloca na cor vermelha
            System.out.println("\033[0;31mData ou horário inválidos!\033[0m");
        }
    }
    
    public static void listarAgendamentos() {
        System.out.println("Lista de agendamentos");
        List<Agendamento> agendamentos = agendamentoRepositorio.buscarTodos();
        if (agendamentos.isEmpty()) {
            System.out.println("Não há agendamentos cadastrados.");
        } else {
            List<Agendamento> agendamentosNaData = buscarAgendamentosPorData();
            if (agendamentosNaData.isEmpty()) {
                System.out.println("Não há agendamentos agendados para hoje.");
            } else {
                for (Agendamento agendamento : agendamentosNaData) {
                    System.out.println("Cliente: " + agendamento.getCliente().getNome());
                    System.out.println("Funcionário: " + agendamento.getFuncionario().getNome());
                    System.out.println("Serviço: " + agendamento.getServico().getNome());
                    System.out.println("Data e hora: " + agendamento.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
                    System.out.println();
                }
            }
        }
    }
    
    private static List<Agendamento> buscarAgendamentosPorData() {
        return null;
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
}
