package Paleta;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.awt.Color;
import java.io.IOException;

public class Paleta {
    private final List<Color> paleta = null;
    private int tamanho;

    public Paleta(Path arquivo) throws IOException {
        List<String> linhas = Files.readAllLines(arquivo);
        for (String linha : linhas) {
            if (linha.length() != 7 || linha.startsWith("#") == false || linha.isEmpty()) {
                continue;
            }
            paleta.add(Color.decode(linha));
            tamanho++;
        }
    }

    public int obterTamanho() {
        return tamanho;
    }
}