# Sistema Básico de Caixa Eletrônico em Java

Este projeto é uma implementação de um sistema bancário básico em Java, desenvolvido como parte do desafio do curso "Java: criando a sua primeira aplicação" da Alura. Ele foi construído com o objetivo de aplicar conceitos fundamentais da linguagem Java, como variáveis, condicionais, loops e leitura de dados, além de explorar conceitos mais avançados, como classes, objetos e padrões de projeto (strategy e factory method).

## Funcionalidades

- **Cadastro de Cliente:** Permite que o cliente cadastre um usuário e senha, escolhendo o tipo de conta (poupança ou corrente).
- **Login:** Permite que o cliente faça login em sua conta.
- **Menu de Conta:** Após o login, o cliente pode criar uma nova conta, consultar saldo, receber valor e transferir valor entre contas.

## Estrutura do Projeto

O projeto consiste em diferentes classes e interfaces para gerenciar o banco de dados, os clientes e suas contas, incluindo a lógica para realizar transações bancárias. Abaixo está uma breve descrição das principais classes:

- **BancoDeDados:** Implementa a interface `Database` e gerencia o armazenamento dos clientes e suas contas, incluindo métodos para cadastrar clientes, fazer login, consultar saldo, transferir valor, entre outros.
- **Cliente:** Representa um cliente do banco, contendo informações como nome de usuário, senha e lista de contas associadas.
- **Conta:** Representa uma conta bancária, com funcionalidades para depositar, sacar, transferir valor, etc.
- **ContaFactory:** Implementa o padrão Factory Method para criar diferentes tipos de conta (poupança ou corrente) de acordo com a escolha do cliente.

## Uso

Para utilizar o sistema, basta clonar este repositório e executar o código em sua IDE Java preferida. Certifique-se de ter o JDK instalado em sua máquina.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues relatando problemas encontrados ou sugerindo novas funcionalidades. Se deseja contribuir diretamente, siga os passos abaixo:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-feature`)
3. Faça commit das suas mudanças (`git commit -am 'Adiciona nova feature'`)
4. Faça push para a branch (`git push origin feature/nova-feature`)
5. Crie um novo Pull Request

## Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

