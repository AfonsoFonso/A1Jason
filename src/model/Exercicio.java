package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Exercicio {
    protected String nome;
    protected List<Serie> series;

    public Exercicio(String nome) {
        this.nome = nome;
        this.series = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Serie> getSeries() {
        return series;
    }

    public void addSerie(Serie serie) {
        this.series.add(serie);
    }
    
    public abstract String getDetalhes();
}
