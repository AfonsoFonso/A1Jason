package controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.ExercicioDeForca;
import model.Serie;
import model.Treino;

public class FilePersistence implements Persistencia {
    private String fileName;

    public FilePersistence(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void salvar(List<Treino> treinos) throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Treino treino : treinos) {
                bw.write("T|" + treino.getId());
                bw.newLine();
                for (var exercicio : treino.getExercicios()) {
                    bw.write("E|" + exercicio.getNome());
                    bw.newLine();
                    for (var serie : exercicio.getSeries()) {
                        bw.write("S|" + serie.getRepeticoes() + "|" + serie.getPeso());
                        bw.newLine();
                    }
                }
            }
        }
    }

    @Override
    public List<Treino> carregar() throws Exception {
        List<Treino> treinos = new ArrayList<>();
        File file = new File(fileName);
        if (!file.exists()) {
            return treinos;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            Treino treinoAtual = null;
            ExercicioDeForca exercicioAtual = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("T|")) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 2) {
                        int id = Integer.parseInt(parts[1]);
                        treinoAtual = new Treino(id);
                        treinos.add(treinoAtual);
                    }
                } else if (line.startsWith("E|") && treinoAtual != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 2) {
                        exercicioAtual = new ExercicioDeForca(parts[1]);
                        treinoAtual.addExercicio(exercicioAtual);
                    }
                } else if (line.startsWith("S|") && exercicioAtual != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length >= 3) {
                        int repeticoes = Integer.parseInt(parts[1]);
                        double peso = Double.parseDouble(parts[2]);
                        exercicioAtual.addSerie(new Serie(repeticoes, peso));
                    }
                }
            }
        }
        return treinos;
    }
}
