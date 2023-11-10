package menu;
import dao.*;
import model.*;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuCadastro {
    private Scanner scanner;
    private ContaDAO contaDAO;
    private Conta conta; // Variável de instância para armazenar a conta



    public MenuCadastro(ContaDAO contaDAO) {
        this.contaDAO = contaDAO;
        this.conta = new Conta(); // Inicializa a conta
        this.scanner = new Scanner(System.in);
    }


    public void cadastrarConta() {
        System.out.println("=== Cadastro de Conta ===");

        // Captura do Nome
        String nome = "";
        while (true) {
            System.out.println("Qual é o seu nome?");
            nome = scanner.nextLine().trim();

            if (nome.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")) {
                break; // Nome válido, sai do loop
            } else {
                System.out.println("Nome inválido. Por favor, insira um nome válido.");
            }
        }

        // Captura do Email
        String email = "";
        while (true) {
            System.out.println("Qual é o seu email?");
            email = scanner.nextLine().trim();

            if (email.matches("^[\\w.-]+@[a-zA-Z]+\\.[a-zA-Z]{2,}$")) {
                break; // Email válido, sai do loop
            } else {
                System.out.println("Email inválido. Por favor, insira um email válido.");
            }
        }

        // Captura do CPF
        String cpf = "";
        while (true) {
            System.out.println("Qual é o seu CPF?");
            cpf = scanner.nextLine().trim();

            if (cpf.matches("^\\d{11}$")) {
                break; // CPF válido, sai do loop
            } else {
                System.out.println("CPF inválido. Por favor, insira um CPF válido.");
            }
        }

        // Captura da Senha
        String senha = "";
        while (true) {
            System.out.println("Qual é a sua senha?");
            senha = scanner.nextLine();

            if (senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d{6})(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>/?]).+$")) {
                break; // Senha válida, sai do loop
            } else {
                System.out.println("Senha inválida. Por favor, insira uma senha válida.");
            }
        }

        // Configura a conta com as informações fornecidas pelo usuário
        conta.setNome(nome);
        conta.setEmail(email);
        conta.setCpf(cpf);
        conta.setSenha(senha);

        // Escolhe o tipo de conta
        escolherTipoConta();

        // Chama o método correspondente no DAO
        contaDAO.cadastrarConta(conta, conta.getTipoConta());

        // Se a conta for de um vendedor, envie dados para a tabela vendedor
        if ("vendedor".equals(conta.getTipoConta())) {
            cadastrarVendedor();
        }
        // Se a conta for de um consumidor, envie dados para a tabela consumidor
        else if ("consumidor".equals(conta.getTipoConta())) {
            cadastrarConsumidor();
        }

        System.out.println("Conta cadastrada com sucesso!");
    }

    private void escolherTipoConta() {
        System.out.println("Escolha o tipo de conta:");
        System.out.println("1 - Consumidor");
        System.out.println("2 - Vendedor");

        int escolha = Integer.parseInt(scanner.nextLine());

        switch (escolha) {
            case 1:
                conta.setTipoConta("consumidor");
                break;
            case 2:
                conta.setTipoConta("vendedor");
                break;
            default:
                System.out.println("Opção inválida. A conta será cadastrada como Consumidor.");
                conta.setTipoConta("consumidor");
        }
    }

    private void cadastrarVendedor() {
        System.out.println("=== Cadastro de Vendedor ===");

        // Adicione a lógica para cadastrar dados específicos do vendedor
        // na tabela vendedor utilizando o ContaDAO
        // Exemplo:
        // String campoEspecificoVendedor = obterInput("Digite um campo específico do vendedor:");
        // contaDAO.cadastrarVendedor(conta.getIdConta(), campoEspecificoVendedor);
    }

    private void cadastrarConsumidor() {
        System.out.println("=== Cadastro de Consumidor ===");

        // Adicione a lógica para cadastrar dados específicos do consumidor
        // na tabela consumidor utilizando o ContaDAO
        // Exemplo:
        // String campoEspecificoConsumidor = obterInput("Digite um campo específico do consumidor:");
        // contaDAO.cadastrarConsumidor(conta.getIdConta(), campoEspecificoConsumidor);
    }

    private String obterInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    private String obterInput(String prompt, String regex) {
        String input;
        do {
            input = obterInput(prompt);
        } while (!input.matches(regex));
        return input;
    }

    public Conta getConta() {
        return conta;
    }
}