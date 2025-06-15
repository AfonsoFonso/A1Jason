package controller;

import java.util.List;
import model.Treino;

public interface Persistencia {
    void salvar(List<Treino> treinos) throws Exception;
    List<Treino> carregar() throws Exception;
}
