import java.util.*;

public class Main {
    public static final int SAIR = 0;
    public static final int CADASTRAR_PESSOA = 1;
    public static final int CADASTRAR_EVENTO = 2;
    public static final int LISTAR_PESSOAS_EVENTOS = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> pessoas = new ArrayList<Pessoa>();
        ArrayList<Evento> eventos = new ArrayList<Evento>();

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            switch (escolha) {
                case SAIR:
                    continuar = false;
                    break;
                case CADASTRAR_PESSOA:
                    cadastrarPessoa(scanner, pessoas);
                    break;
                case CADASTRAR_EVENTO:
                    cadastrarEvento(scanner, pessoas, eventos);
                    break;
                case LISTAR_PESSOAS_EVENTOS:
                    listarPessoasEventos(pessoas, eventos);
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }

        // Fechar o scanner ao final do programa
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("Menu:");
        System.out.println("Opção " + SAIR + " - Sair");
        System.out.println("Opção " + CADASTRAR_PESSOA + " - Cadastrar Pessoa");
        System.out.println("Opção " + CADASTRAR_EVENTO + " - Cadastrar Evento");
        System.out.println("Opção " + LISTAR_PESSOAS_EVENTOS + " - Lista de Pessoas e Eventos");
        System.out.println("Para que o evento ocorra digite seu ID");
    }

    public static void cadastrarPessoa(Scanner scanner, ArrayList<Pessoa> pessoas) {
        System.out.println("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.println("Digite o ID: ");
        int identificador = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        while (identificador <= 0) {
            System.out.println("ID inválido! Digite novamente o ID");
            identificador = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada
        }

        Pessoa pessoa = new Pessoa(identificador, nome);
        pessoas.add(pessoa);
    }

    public static void cadastrarEvento(Scanner scanner, ArrayList<Pessoa> pessoas, ArrayList<Evento> eventos) {
        System.out.println("Descrição do Evento: ");
        String descricao = scanner.nextLine();
        System.out.println("Digite o ID do Evento: ");
        int identificador2 = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer de entrada

        ArrayList<Integer> listaDePessoasId = new ArrayList<Integer>();
        ArrayList<Pessoa> listaDePessoas = new ArrayList<Pessoa>();

        System.out.println("Digite o ID das pessoas que participaram do Evento (Digite 0 para encerrar): ");
        while (true) {
            int id = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer de entrada

            if (id == 0) {
                break;
            } else if (id < 0) {
                System.out.println("ID inválido!");
            } else if (listaDePessoasId.contains(id)) {
                System.out.println("Pessoa já registrada no Evento");
            } else {
                boolean encontrada = false;

                for (Pessoa participante : pessoas) {
                    if (participante.getId() == id) {
                        listaDePessoas.add(participante);
                        encontrada = true;
                        break;
                    }
                }

                if (!encontrada) {
                    System.out.println("Pessoa não cadastrada no sistema!");
                    continue;
                }

                listaDePessoasId.add(id);
            }
        }

        if (!listaDePessoasId.isEmpty()) {
            Evento evento = new Evento(descricao, identificador2, listaDePessoas);
            eventos.add(evento);
        }
    }

    public static void listarPessoasEventos(ArrayList<Pessoa> pessoas, ArrayList<Evento> eventos) {
        boolean encontrada;

        for (Pessoa participante : pessoas) {
            encontrada = false;
            System.out.println("A pessoa " + participante.getNome() + " participa dos eventos:");

            for (Evento evento : eventos) {
                ArrayList<Pessoa> pessoasEvento = evento.getPessoas();

                if (pessoasEvento.contains(participante)) {
                    System.out.println("de ID " + evento.getId_evento() + " e descrição " + evento.getDescricao());
                    System.out.println("");
                    encontrada = true;
                }
            }

            if (!encontrada) {
                System.out.println("Não participa de nenhum evento");
            }
        }
    }
}
