package controller;

import java.util.ArrayList;
import java.util.List;
import model.ExercicioDeForca;
import model.Treino;

public class TreinoController {
    private List<Treino> treinos;
    private Persistencia persistencia;

    public TreinoController(Persistencia persistencia) {
        this.persistencia = persistencia;
        try {
            this.treinos = persistencia.carregar();
        } catch (Exception e) {
            System.out.println("Falha ao carregar os treinos: " + e.getMessage());
            this.treinos = new ArrayList<>();
        }
    }

    public void adicionarTreino(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            Treino treinoExistente = buscarTreinoPorId(id);
            if (treinoExistente == null) {
                Treino treino = new Treino(id);
                treinos.add(treino);
                System.out.println("Treino adicionado com sucesso com o id: " + id);
            } else {
                System.out.println("Já existe um treino registrado com esse id.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar treino: " + e.getMessage());
        }
    }

    public void adicionarExercicioAoTreino(String idStr, ExercicioDeForca exercicio) {
        try {
            int id = Integer.parseInt(idStr);
            Treino treino = buscarTreinoPorId(id);
            if (treino != null) {
                treino.addExercicio(exercicio);
                System.out.println("Exercício adicionado com sucesso ao treino com id " + id);
            } else {
                System.out.println("Treino não encontrado com o id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Erro ao adicionar exercício: " + e.getMessage());
        }
    }
    
    public Treino buscarTreinoPorId(int id) {
        for (Treino t : treinos) {
            if (t.getId() == id)
                return t;
        }
        return null;
    }

    public void excluirTreino(String idStr) {
        try {
            int id = Integer.parseInt(idStr);
            Treino treino = buscarTreinoPorId(id);
            if (treino != null) {
                treinos.remove(treino);
                System.out.println("Treino removido com sucesso para o id: " + id);
            } else {
                System.out.println("Treino não encontrado com o id: " + id);
            }
        } catch (Exception e) {
            System.out.println("Erro na exclusão do treino: " + e.getMessage());
        }
    }

    public List<Treino> listarTreinos() {
        return treinos;
    }

    public void salvarTreinos() {
        try {
            persistencia.salvar(treinos);
        } catch (Exception e) {
            System.out.println("Erro ao salvar treinos: " + e.getMessage());
        }
    }
}
