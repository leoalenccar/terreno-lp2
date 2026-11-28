package saida;

import terreno.Terreno;

import java.awt.image.BufferedImage;

public class DadosSaida {
    private Terreno terreno;
    private BufferedImage imagem;

    DadosSaida (){
        this.terreno = null;
        this.imagem = null;
    }

    public Terreno getTerreno() {
        return terreno;
    }

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public BufferedImage getImagem() {
        return imagem;
    }

    public void setImagem(BufferedImage imagem) {
        this.imagem = imagem;
    }
}
