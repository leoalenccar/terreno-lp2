package Renderizador;

import java.io.IOException;
import java.nio.file.Path;
import java.awt.image.BufferedImage;

import Paleta.Paleta;
import Terreno.FactoryTerreno;

public class Renderizador {
    private int altura;
    private int largura;
    private Paleta paleta;
    private Terreno terreno;

    public Renderizador(String tipo, int altura, int largura) {
        this.terreno = new FactoryTerreno(tipo, altura, largura);
        this.altura = altura;
        this.largura = largura;
    }

    public BufferedImage converterAltitudes(){

    }

    public BufferedImage gerarImagem(Paleta paleta) {

    }
}
