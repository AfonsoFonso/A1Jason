package model;

public class ExercicioDeForca extends Exercicio {
    public ExercicioDeForca(String nome) {
        super(nome);
    }

    @Override
    public String getDetalhes() {
        StringBuilder sb = new StringBuilder();
        sb.append("Exercício: ").append(nome).append("\n");
        int count = 1;
        for (Serie s : series) {
            sb.append("  Série ").append(count++).append(": ").append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}
