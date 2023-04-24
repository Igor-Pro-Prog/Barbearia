# Barbearia

Descrição do sistema:
A Barbearia é uma empresa que presta serviços de beleza, como cortes de cabelo, barba, bigode, entre outros. O sistema a ser desenvolvido tem como objetivo gerenciar os agendamentos dos clientes, controlar o histórico de atendimentos e pagamentos, além de realizar o cadastro de novos clientes, funcionários e serviços oferecidos pela barbearia. A equipe escolheu este tema porque percebeu uma demanda crescente por serviços de beleza e acredita que a automatização do processo de agendamento e gerenciamento pode contribuir para uma melhor experiência do cliente e aumento da eficiência da empresa. O sistema será utilizado pelos funcionários da barbearia, responsáveis pelo atendimento aos clientes e gerenciamento das informações.


## Backlog do projeto:

### Funcionalidade: ===================== Responsável:
#### Agendar horário ====================>   Maria      
#### Cancelar horário ===================>   João        
#### Verificar agenda ===================>	 Maria
#### Registrar pagamento ================>   Pedro
#### Cadastrar cliente	==================>  João 
#### Cadastrar funcionário ==============>	 Maria
#### Cadastrar serviço	==================>  Pedro
#### Verificar histórico de atendimento =>   João


# Arquitetura do sistema:

## Diagrama de casos de uso:

             +------------------------------------+
             |           Barbearia                |
             +------------------------------------+
             |                                    |
             |  +------------------------------+  |
             |  |   Gerenciamento de agendamento |  |
             |  +------------------------------+  |
             |         |            |            | |
             |         |            |            | |
             | +-----------------------+  +-------------------------+ |
             | |Agendar horário        |  |Cancelar horário         | |
             | +-----------------------+  +-------------------------+ |
             |         |            |            | |
             |         |            |            | |
             |  +------------------------------+  |
             |  |    Gerenciamento de cliente   |  |
             |  +------------------------------+  |
             |         |            |            | |
             |         |            |            | |
             | +-----------------------+  +-------------------------+ |
             | |Cadastrar cliente      |  |Verificar histórico      | |
             | +-----------------------+  +-------------------------+ |
             |         |            |            | |
             |         |            |            | |
             |  +------------------------------+  |
             |  |   Gerenciamento de funcionário|  |
             |  +------------------------------+  |
             |         |            |            | |
             |         |            |            | |
             | +-----------------------+  +-------------------------+ |
             | |Cadastrar funcionário  |  |Verificar agenda          | |
             | +-----------------------+  +-------------------------+ |
             |         |            |            | |
             |         |            |            | |
             |  +------------------------------+  |
             |  |   Gerenciamento de serviço   |  |
             |  +------------------------------+  |
             |         |            |            | |
             |         |            |            | |
             | +-----------------------+  +-------------------------+ |
             | |Cadastrar serviço      |  |Registrar pagamento       | |
             | +-----------------------+  +-------------------------+ |
             +------------------------------------+


## Diagrama de classes:

+------------------+            +-------------+       +---------+         +--------------+
|   Agendamento    |            |   Cliente   |       |  Servico  |      |   Funcionario   |
+------------------+            +-------------+       +---------+         +--------------+
| -data: String    |         | -nome: String     |  | -nome: String |   | -nome: String    |
| -hora: String    |         | -telefone: String |  | -preco: float |   | -telefone: String|
| -cliente: Cliente|         | -endereco: String |  | -duracao: int |   | -endereco: String|
| -funcionario: Funcionario| |                   |  |               |   |                  |
| -servico: Servico|          +-------------+          +---------+      |                  |
+------------------+                                                      +--------------+
