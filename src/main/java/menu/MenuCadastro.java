package menu;
import dao.*;
import model.*;
import java.time.LocalDate;
import java.util.Scanner;

public class MenuCadastro {
    static Scanner scanner = new Scanner(System.in);
    private ConsumidorDAO consumidorDAO = new ConsumidorDAO();
    private VendedorDAO vendedorDAO = new VendedorDAO();
    private MenuLogin menuLogin;

    public void exibirMenuCadastro() {

        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Vendedor");
            System.out.println("2 - Cadastrar Consumidor");
            System.out.println("0 - Sair");

            try {
                int opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        cadastrarVendedor();
                        break;
                    case 2:
                        cadastrarConsumidor();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um número válido.");
            }
        }
    }

    private static void cadastrarVendedor() {

        // Obter o email
        String email = obterInputLoop("Qual é o seu email?");

        // Obter a senha
        String senha;
        do {
            System.out.println("Qual é a sua senha? (Deve ter 2 letras, 1 caractere especial e 6 dígitos numéricos)");
            senha = obterInputLoopComValidacaoSenha();
        } while (!validarSenha(senha));

        // Obter o nome
        String nome = obterInputLoop("Qual é o seu nome? (Pode conter letras e espaços, mas não espaços extras)");

        // Obter o CPF
        String cpf = obterInputLoop("Qual é o seu CPF? (Deve seguir a norma de CPF)");

        // Fechar o scanner para evitar vazamentos de recursos

        Vendedor novoVendedor = new Vendedor(email, senha, nome, cpf);

        // Criar um objeto VendedorDAO
        VendedorDAO vendedorDAO = new VendedorDAO();

        // Chamar o método cadastrarVendedor do VendedorDAO
        vendedorDAO.cadastrarVendedor(novoVendedor);



    }

    private static String obterInputLoopComValidacaoSenha() {
        String senha;
        do {
            senha = scanner.nextLine();
            if (!validarSenha(senha)) {
                System.out.println("Senha inválida. Tente novamente.");
            }
        } while (!validarSenha(senha));
        return senha;
    }

    private static boolean validarSenha(String senha) {
        // Adicione sua lógica de validação de senha aqui
        // Por exemplo, você pode usar expressões regulares ou outras verificações específicas
        return senha.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*(),.?\":{}|<>])(?=.*[0-9]).{8,}$");
    }

    private static String obterInputLoop(String mensagem) {
        String input;
        do {
            System.out.println(mensagem);
            input = scanner.nextLine();
        } while (input.trim().isEmpty()); // Loop até que o usuário forneça uma entrada não vazia

        return input;
    }

    private static void cadastrarConsumidor() {

        // Obter o email
        String email = obterInputLoop("Qual é o seu email?");

        // Obter a senha
        String senha;
        do {
            System.out.println("Qual é a sua senha? (Deve ter 2 letras, 1 caractere especial e 6 dígitos numéricos)");
            senha = scanner.nextLine();
        } while (!validarSenha(senha));

        // Obter o nome
        String nome = obterInputLoop("Qual é o seu nome? (Pode conter letras e espaços, mas não espaços extras)");

        // Obter o CPF
        String cpf = obterInputLoop("Qual é o seu CPF? (Deve seguir a norma de CPF)");

        // Fechar o scanner para evitar vazamentos de recursos

        // Criar um objeto VendedorDAO
        Consumidor novoConsumidor = new Consumidor(email, senha, nome, cpf);

        // Criar um objeto ConsumidorDAO
        ConsumidorDAO consumidorDAO = new ConsumidorDAO();

        // Chamar o método cadastrarConsumidor do ConsumidorDAO
        consumidorDAO.cadastrarConsumidor(novoConsumidor);

    }

    private void exibirOpcoesAposCadastro() {
        System.out.println("O que você deseja fazer agora?");
        System.out.println("1 - Entrar na conta");
        System.out.println("2 - Realizar outra ação");
        System.out.println("0 - Sair");

        try {
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1:
                    menuLogin.exibirMenuLogin(); // Chama a função exibirMenuLogin do MenuLogin
                    break;
                case 2:
                    // Realizar outra ação (pode chamar um método específico para isso)
                    break;
                case 0:
                    System.out.println("Saindo...");
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Saindo...");
                    System.exit(0);
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, insira um número válido. Saindo...");
            System.exit(0);
        }
    }

}








