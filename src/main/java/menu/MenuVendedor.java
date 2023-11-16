package menu;
import dao.*;
import model.*;
import java.util.InputMismatchException;
import java.util.Scanner;
public class MenuVendedor {


        //Instancia objetos
        private VendedorDAO vendedorDAO;
        private Vendedor vendedor;
        private Scanner scanner;

        public MenuVendedor() {
                vendedorDAO = new VendedorDAO();
                vendedor = new Vendedor();
                scanner = new Scanner(System.in);
        }

        public void menuPrincipalVendedor(Vendedor vendedor){

                int escolha = -1;  // Inicializa com um valor inválido para entrar no loop.

                do {
                        try {

                                System.out.println("1 - Perfil");
                                System.out.println("2 - Curso");
                                System.out.println("0 - Sair");


                                escolha = scanner.nextInt();

                                switch (escolha) {
                                        case 1:
                                                break;
                                        case 2:
                                                curso(vendedor);
                                                break;
                                        case 0:
                                                System.exit(0);
                                                break;
                                        default:
                                                System.out.println("Opção inválida. Tente novamente.");
                                                break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Porfavor digite um número valido");
                        }

                } while (escolha != 0);
        }

        public void perfil (){


        }

        public void curso(Vendedor vendedor) {

                int escolha = -1;  // Inicializa com um valor inválido para entrar no loop.

                do {
                        try {

                                System.out.println("1 - Adicionar curso");
                                System.out.println("2 - Atualizar curso");
                                System.out.println("0 - Voltar");

                                escolha = scanner.nextInt();

                                switch (escolha) {
                                        case 1:
                                                menuAdicionarCurso(vendedor);
                                                break;
                                        case 2:
                                                break;
                                        case 0:
                                                menuPrincipalVendedor(vendedor);
                                                break;
                                        default:
                                                System.out.println("Opção inválida. Tente novamente.");
                                                break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Porfavor digite um número valido");
                        }

                } while (escolha != 0);

        }

        public void menuAdicionarCurso(Vendedor vendedor) {

                String cpf = vendedor.getusuarioLogadoCPF();

                int idUsuarioLogado = vendedor.getUsuarioLogadoId();
                String nomeUsuarioLogado = vendedor.getUsuarioLogadoNome();

                // Nome do curso
                String nomeCurso;
                do {
                        System.out.print("Nome do curso: ");
                        nomeCurso = scanner.nextLine().trim();
                } while (!nomeCurso.matches("[a-zA-Z ]+"));

                // Resumo do curso
                String resumoCurso;
                do {
                        System.out.print("Resumo do curso: ");
                        resumoCurso = scanner.nextLine().trim();
                } while (!resumoCurso.matches("[a-zA-Z ]+"));

                // Conteúdo do curso
                String conteudoCurso;
                do {
                        System.out.print("Conteúdo do curso: ");
                        conteudoCurso = scanner.nextLine().trim();
                } while (!conteudoCurso.matches("[a-zA-Z ]+"));

                // Valor do curso
                double valorCurso = 0.0;
                boolean valorValido = false;
                do {
                        System.out.print("Valor do curso: ");
                        String inputValor = scanner.nextLine().trim();

                        try {
                                valorCurso = Double.parseDouble(inputValor);
                                valorValido = true;
                        } catch (NumberFormatException e) {
                                System.out.println("Por favor, insira um valor numérico válido.");
                        }
                } while (!valorValido);

                // Obter o id e o nome do usuário logado






                System.out.println(idUsuarioLogado);
                System.out.println(nomeUsuarioLogado);

                // Criar uma
                // de AdicionarCursoDAO
                AdicionarCursoDAO adicionarCursoDAO = new AdicionarCursoDAO();

                // Chamar a função para adicionar o curso ao banco de dados
                adicionarCursoDAO.adicionarCurso(nomeCurso, resumoCurso, conteudoCurso, valorCurso, idUsuarioLogado, nomeUsuarioLogado);

                menuPrincipalVendedor(vendedor);

        }

        public void menuAtualizarCurso() {

                int escolha = -1;  // Inicializa com um valor inválido para entrar no loop.

                do {
                        try {

                                System.out.println("1 - Ver cursos");
                                System.out.println("0 - Voltar");

                                escolha = scanner.nextInt();

                                switch (escolha) {
                                        case 1:
                                                break;
                                        case 0:
                                                System.exit(0);
                                                break;
                                        default:
                                                System.out.println("Opção inválida. Tente novamente.");
                                                break;
                                }
                        } catch (InputMismatchException e) {
                                System.out.println("Porfavor digite um número valido");
                        }

                } while (escolha != 0);

        }






}