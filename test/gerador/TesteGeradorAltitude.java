package gerador;

import java.util.Random;

import gerador.GeradorAltitude;
import terreno.Terreno;

public class TesteGeradorAltitude {

    // cria um terreno de uma só altitude
    static class AltitudeIgual extends GeradorAltitude {
        private int valor;

        public AltitudeIgual(long seed, int min, int max, int valor) {
            super(seed, min, max);
            this.valor = valor;
        }

        @Override 
        protected void preencher(Terreno t, Random r) {
            for(int lin = 0; lin < t.getLinhas(); lin++) {
                for(int col = 0; col < t.getColunas(); col++) {
                    t.setAltitude(lin, col, valor);
                }
            }
        }
    }

    public static void main(String[] args) {
        // testa criar terreno com tamanho pedido
        Terreno t1 = new AltitudeIgual(11, 0, 10, 3).gerar(7, 3);
        assert t1.getLinhas() == 7 : "tamanho da linha deveria ser 7";
        assert t1.getColunas() == 3 : "tamanho da linha deveria ser 3";

        // testa se valor dentro do intervalo de altitude não é alterado
        Terreno t2 = new AltitudeIgual(17, 10, 20, 15).gerar(5, 5);
        assert t2.getAltitude(0, 0) == 15 : "valor não deveria mudar";

        // testa se valor abaixo do mínimo é corrigido
        Terreno t3 = new AltitudeIgual(8, 5, 10, 2).gerar(5, 5);
        assert t3.getAltitude(0, 0) == 5 : "valor abaixo do min deveria virar min";

        // testa se valor acima do máximo é corrigido
        Terreno t4 = new AltitudeIgual(8, 5, 10, 15).gerar(5, 5);
        assert t4.getAltitude(0, 0) == 10 : "valor acima do max deveria virar max";

        //testa min = max lança exceção
        boolean lancouIgual = false;
        try {
            new AltitudeIgual(13, 10, 10, 13);
        } catch(IllegalArgumentException e) {
            lancouIgual = true;
        }
        assert lancouIgual : "min = max deveria lançar exceção";

        // min maior que max lança exceção
        boolean lancouMaior = false;
        try {
            new AltitudeIgual(16, 10, 5, 1);
        } catch (IllegalArgumentException e) {
            lancouMaior = true;
        }
        assert lancouMaior : "min > max deveria lançar exceção";

    }
}