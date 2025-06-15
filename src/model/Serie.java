package model;

public class Serie {
    private int repeticoes;
    private double peso;

    public Serie(int repeticoes, double peso) {
        this.repeticoes = repeticoes;
        this.peso = peso;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public double getPeso() {
        return peso;
    }

    @Override
    public String toString() {
        return "Repetições: " + repeticoes + ", Peso: " + peso;
    }
}
