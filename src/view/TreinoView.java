package view;

import java.util.List;
import model.Treino;

public class TreinoView {
    public void exibirTreinos(List<Treino> treinos) {
        if (treinos.isEmpty()) {
            System.out.println("Nenhum treino registrado.");
            return;
        }
        for (Treino t : treinos) {
            System.out.println("----------------------------");
            System.out.println(t.getDetalhes());
        }
    }
    
    public void exibirTreino(Treino treino) {
        if (treino == null) {
            System.out.println("Treino não encontrado.");
            return;
        }
        System.out.println("----------------------------");
        System.out.println(treino.getDetalhes());
    }
}
