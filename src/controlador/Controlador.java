package controlador;

import enums.AlgoritmoEnum;
import enums.SaidaEnum;
import gerador.GeradorAltitude;
import gerador.GeradorFactory;
import saida.DadosSaida;
import saida.ISaida;
import saida.SaidaFactory;
import terreno.Terreno;

import java.awt.image.BufferedImage;

public class Controlador {



    Terreno terreno;
    DadosSaida dados;
    BufferedImage imagem;
    //Paleta paleta = new Paleta();
    //Renderizador renderizador = new Renderizador();

    public Controlador (){
        this.terreno = null;
        this.imagem = null;
    }

    private void atualizarDados(){
        dados.setImagem(this.imagem);
        dados.setTerreno(this.terreno);
    }

    public void alterarPaleta(){

    }

    public void gerarImagem(AlgoritmoEnum algoritmo, long seed, int min, int max, int tamanho){
        GeradorAltitude gerador = new GeradorFactory().criar(algoritmo, seed, min, max);
        this.terreno = gerador.gerar(tamanho);

        //Falta a classe Renderizador pra gerar a imagem
        atualizarDados();
    }

    public void exportarArquivo(SaidaEnum tipoSaida){
        ISaida saida = new SaidaFactory().criar(tipoSaida);
        saida.exportar(dados);
    }


}
