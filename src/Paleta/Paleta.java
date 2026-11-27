package Paleta;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.io.IOException;

public class Paleta {
    private final List<Color> paleta;
    private int tamanho;

    public Paleta(Path arquivo) throws IOException {
        this.paleta = new ArrayList<>();
        List<String> linhas = Files.readAllLines(arquivo);
        for (String linha : linhas) {
            if (linha.length() != 7 || !linha.startsWith("#") || linha.isEmpty()) {
                continue;
            }
            paleta.add(Color.decode(linha));
            tamanho++;
        }
    }

    public int obterTamanho() {
        return tamanho;
    }

    public Color obterCor(int indice) {
        if (indice < 0 || indice >= tamanho) {
            return Color.BLACK;
        }
        return paleta.get(indice);
    }

    public void listarCores() {
        int n = 0;
        for (Color cor : paleta) {
            System.out.println("Índice " + Integer.toString(n) + ": " + cor + "\n");
            n++;
        }
    }

    public static void main(String[] args) throws IOException {
        Path arquivo = Path.of("cores.hex");
        Paleta paleta = new Paleta(arquivo);

        System.out.println(paleta.obterTamanho());
        System.out.println(paleta.obterCor(9));
        paleta.listarCores();
    }
}