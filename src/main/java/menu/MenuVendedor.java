package menu;
import dao.*;
import java.util.Scanner;
public class MenuVendedor {
    private AdicionarCursoDAO adicionarCursoDAO;
    Scanner scanner = new Scanner(System.in);

    public MenuVendedor() {
        adicionarCursoDAO = new AdicionarCursoDAO();
    }



    public void adicionarCurso() {

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

        // Conteúdo do curso (pulamos)

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


        // Adiciona o curso ao banco de dados
        AdicionarCursoDAO.Curso novoCurso = new AdicionarCursoDAO.Curso(nomeCurso, resumoCurso, "", valorCurso);
        adicionarCursoDAO.adicionarCurso(novoCurso, "Patrick Gomes Siqueira");

        System.out.println("Curso adicionado com sucesso!");
    }


    public void atualizarCurso () {

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

        // Conteúdo do curso (pulamos)

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

        AdicionarCursoDAO.Curso cursoAtualizado = new AdicionarCursoDAO.Curso(nomeCurso, resumoCurso, "", valorCurso);
        adicionarCursoDAO.atualizarCurso(cursoAtualizado);


    }

    public void atualizarNomeCurso(int idDoCurso) {
        String novoNome;
        do {
            System.out.print("Novo nome do curso: ");
            novoNome = scanner.nextLine().trim();
        } while (!novoNome.matches("[a-zA-Z ]+"));

        // Chama o método de atualização na classe DAO
        adicionarCursoDAO.atualizarNomeCursoPorId(idDoCurso, novoNome);
        System.out.println("Nome do curso atualizado com sucesso!");

        voltarAtualizarMaisUmDado ();
    }

    // Função para atualizar o resumo do curso
    public void atualizarResumoCurso(int idDoCurso) {
        String novoResumo;
        do {
            System.out.print("Novo resumo do curso: ");
            novoResumo = scanner.nextLine().trim();
        } while (!novoResumo.matches("[a-zA-Z ]+"));

        // Chama o método de atualização na classe DAO
        adicionarCursoDAO.atualizarResumoCursoPorId(idDoCurso, novoResumo);
        System.out.println("Resumo do curso atualizado com sucesso!");

        voltarAtualizarMaisUmDado ();
    }

    // Função para atualizar o valor do curso
    public void atualizarValorCurso(int idDoCurso) {
        double novoValor = 0.0;
        boolean valorValido = false;
        do {
            System.out.print("Novo valor do curso: ");
            String inputValor = scanner.nextLine().trim();

            try {
                novoValor = Double.parseDouble(inputValor);
                valorValido = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, insira um valor numérico válido.");
            }
        } while (!valorValido);

        // Chama o método de atualização na classe DAO
        adicionarCursoDAO.atualizarValorCursoPorId(idDoCurso, novoValor);
        System.out.println("Valor do curso atualizado com sucesso!");

        voltarAtualizarMaisUmDado ();
    }




    public void voltarAtualizarMaisUmDado () {

        int opcaoVoltarAtualizarMaisUmDado = -1;

        while (opcaoVoltarAtualizarMaisUmDado != 0) {
            try{
                System.out.println("1 - Atualizar mais um dado");
                System.out.println("0 - Voltar");


                switch (opcaoVoltarAtualizarMaisUmDado){

                    case 1:
                        AtualizarDadoCurso();
                        break;
                    case 0:
                        escolherAtualizacao();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro");
            }
        }

    }



    public void AtualizarDadoCurso() {
        int opcaoAtualizarDado = -1;

        while (opcaoAtualizarDado != 0) {
            try {
                System.out.println("1 - Atualizar nome do curso");
                System.out.println("2 - Atualizar o resumo do curso");
                System.out.println("3 - Atualizar o valor do curso");
                System.out.println("0 - Voltar");

                opcaoAtualizarDado = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha após a leitura do número

                switch (opcaoAtualizarDado) {
                    case 1:


                        //atualizarNomeCurso();
                        break;
                    case 2:
                        //atualizarResumoCurso();
                        break;
                    case 3:
                        //atualizarValorCurso();
                        break;
                    case 0:
                        escolherAtualizacao();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Erro");
                scanner.nextLine();  // Limpar o buffer do scanner em caso de exceção
            }
        }
    }

    public void escolherAtualizacao () {

        int opcaoAtualizacaoEscolha = -1;

        while (opcaoAtualizacaoEscolha != 0) {
            try {
                System.out.println("1 - Atualizar tudo");
                System.out.println("2 - Atualizar apenas um dado");
                System.out.println("0 - Voltar");

                opcaoAtualizacaoEscolha = scanner.nextInt();

                switch (opcaoAtualizacaoEscolha) {

                    case 1:
                        atualizarCurso ();
                        break;
                    case 2:
                        AtualizarDadoCurso();
                        break;
                    case 0:
                        gerenciarCursos();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }

            } catch (Exception e) {
                System.out.println("Erro");
            }
        }
    }



    public void gerenciarCursos() {


        int opcaoGerenciar = -1;

        while (opcaoGerenciar != 0) {
            try {
                System.out.println("Atualizar curso");
                System.out.println("Remover curso");
                System.out.println("0 - Voltar");

                opcaoGerenciar = scanner.nextInt();

                switch (opcaoGerenciar) {

                    case 1:
                        escolherAtualizacao();
                        break;
                    case 2:
                        break;
                    case 0:
                        cursos();

                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Erro");
            }
        }


    }


    public void cursos() {
        int opcaoCursos = -1;

        while (opcaoCursos != 0) {
            try {
                System.out.println("1 - Adicionar curso");
                System.out.println("2 - Gerenciar cursos");
                System.out.println("0 - Voltar");

                opcaoCursos = scanner.nextInt();

                switch (opcaoCursos) {

                    case 1:
                        adicionarCurso();
                        break;
                    case 2:
                        gerenciarCursos();
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }


            } catch (Exception e) {
                System.out.println("Erro");
            }
        }


    }

    public void clientes() {

        int opcaoClientes = -1;

        while (opcaoClientes != 0) {

            try {
                System.out.println("1 - Ver meus clientes");
                System.out.println("0 - Voltar");


                opcaoClientes = scanner.nextInt();

                switch (opcaoClientes) {
                    case 1:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Erro");
            }
        }


    }

    public void perfil() {

        int opcaoPerfil = -1;

        while (opcaoPerfil != 0) {
            try {
                System.out.println("1 - Ver dados");
                System.out.println("2 - Conta");
                System.out.println("0 - Voltar");

                switch (opcaoPerfil) {

                    case 1:
                        break;
                    case 2:
                        break;
                    case 0:
                        menuPrincipal();
                        break;
                    default:
                        System.out.println("Opção inválida");
                        break;

                }

            } catch (Exception e) {
                System.out.println("Erro");
            }
        }

    }


    public void menuPrincipal() { // Menu Principal

        int opcao = -1;

        while (opcao != 0) {

            try {
                System.out.println("Escolha uma opção");
                System.out.println("1 - Perfil");
                System.out.println("2 - Cursos");
                System.out.println("3 - Clientes");
                System.out.println("0 - Sair");

                opcao = scanner.nextInt();

                switch (opcao) {

                    case 1:
                        perfil();
                        break;
                    case 2:
                        cursos();
                        break;
                    case 3:
                        clientes();
                        break;
                    case 0:

                        break;
                    default:
                        System.out.println("Opçção invalída");
                        break;


                }


            } catch (Exception e) {
                System.out.println("Erro");
                scanner.nextLine();
            }

        }
    }
}