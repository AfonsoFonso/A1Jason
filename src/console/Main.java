package console;

import controller.FilePersistence;
import controller.Persistencia;
import controller.TreinoController;
import java.util.Scanner;
import model.ExercicioDeForca;
import model.Serie;
import view.TreinoView;

public class Main {
    public static void main(String[] args) {
        Persistencia persistencia = new FilePersistence("treinos.txt");
        TreinoController controller = new TreinoController(persistencia);
        TreinoView view = new TreinoView();
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        
        do {
            System.out.println("==== Sistema de Registro de Treinos ====");
            System.out.println("1 - Adicionar Treino");
            System.out.println("2 - Adicionar Exercício a um Treino");
            System.out.println("3 - Exibir Treino Específico");
            System.out.println("4 - Listar Treinos");
            System.out.println("5 - Excluir Treino");
            System.out.println("6 - Sair e Salvar");
            System.out.print("Escolha uma opção: ");
            
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do treino (número natural): ");
                    String idTreino = scanner.nextLine();
                    controller.adicionarTreino(idTreino);
                    break;
                case 2:
                    System.out.print("Digite o ID do treino: ");
                    String id = scanner.nextLine();
                    System.out.print("Digite o nome do exercício: ");
                    String nomeExercicio = scanner.nextLine();
                    
                    ExercicioDeForca exercicio = new ExercicioDeForca(nomeExercicio);
                    
                    System.out.print("Digite a quantidade de séries para este exercício: ");
                    int quantidadeSeries = 0;
                    try {
                        quantidadeSeries = Integer.parseInt(scanner.nextLine());
                    } catch (Exception e) {
                        System.out.println("Número inválido para quantidade de séries!");
                        break;
                    }
                    
                    for (int i = 1; i <= quantidadeSeries; i++) {
                        System.out.print("Série " + i + " - Digite o número de repetições: ");
                        int repeticoes = 0;
                        try {
                            repeticoes = Integer.parseInt(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Número inválido para repetições!");
                            continue;
                        }
                        
                        System.out.print("Série " + i + " - Digite o peso utilizado: ");
                        double peso = 0.0;
                        try {
                            peso = Double.parseDouble(scanner.nextLine());
                        } catch (Exception e) {
                            System.out.println("Número inválido para peso!");
                            continue;
                        }
                        exercicio.addSerie(new Serie(repeticoes, peso));
                    }
                    controller.adicionarExercicioAoTreino(id, exercicio);
                    break;
                case 3:
                    System.out.print("Digite o ID do treino que deseja visualizar: ");
                    String idBusca = scanner.nextLine();
                    try {
                        int idNum = Integer.parseInt(idBusca);
                        view.exibirTreino(controller.buscarTreinoPorId(idNum));
                    } catch (NumberFormatException e) {
                        System.out.println("ID inválido!");
                    }
                    break;
                case 4:
                    view.exibirTreinos(controller.listarTreinos());
                    break;
                case 5:
                    System.out.print("Digite o ID do treino a ser excluído: ");
                    String idExclusao = scanner.nextLine();
                    controller.excluirTreino(idExclusao);
                    break;
                case 6:
                    controller.salvarTreinos();
                    System.out.println("Dados salvos. Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
        scanner.close();
    }
}
