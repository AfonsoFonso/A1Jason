package model;

import java.util.ArrayList;
import java.util.List;

public class Treino {
    private int id;
    private List<Exercicio> exercicios;

    public Treino(int id) {
        this.id = id;
        this.exercicios = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Exercicio> getExercicios() {
        return exercicios;
    }

    public void addExercicio(Exercicio exercicio) {
        this.exercicios.add(exercicio);
    }

    public void removeExercicio(Exercicio exercicio) {
        this.exercicios.remove(exercicio);
    }

    public String getDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Treino ID: ").append(id).append("\n");
        for (Exercicio e : exercicios) {
            sb.append(e.getDetalhes()).append("\n");
        }
        return sb.toString();
    }
}
