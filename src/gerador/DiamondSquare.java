package gerador;

import java.util.Random;
import terreno.Terreno;

public class DiamondSquare extends GeradorAltitude {
    public DiamondSquare(long seed, int min, int max) {
        super(seed, min, max);
    }

    private boolean tamanhoValido(int n) {
        int m = n - 1;
        if(m < 2) return false;

        while(m % 2 == 0) {
            m = m/2;
        }

        return m == 1;
    }

    private int altitudeAleatoria(Random r) {
        return r.nextInt(max - min + 1);
    }

    private int deslocamento(Random r, int ruido) {
        return r.nextInt(2 * ruido + 1) - ruido;
    }

    private void square(Terreno t, Random r, int lin, int col, int alcance, int ruido) {
        int tam = t.getTamanho();
        int soma = 0;
        int cont = 0;

        // canto superior esquerdo do quadrado
        if(lin - alcance >= 0 && col - alcance >= 0) {
            soma += t.getAltitude(lin - alcance, col - alcance);
            cont++;
        }

        // canto superior direito do quadrado
        if(lin - alcance >= 0 && col + alcance < tam) {
            soma += t.getAltitude(lin - alcance, col + alcance);
            cont++;
        }

        // canto inferior esquerdo do quadrado
        if(lin + alcance < tam && col - alcance >= 0) {
            soma += t.getAltitude(lin + alcance, col - alcance);
            cont++;
        }

        // canto inferior direito do quadrado
        if(lin + alcance < tam && col + alcance < tam) {
            soma += t.getAltitude(lin + alcance, col + alcance);
            cont++;
        }

        int media = soma/cont;
        t.setAltitude(lin, col, media + deslocamento(r, ruido)); 
    }

    @Override
    protected void preencher(Terreno t, Random r) {
        int tam = t.getTamanho();
        if (!tamanhoValido(tam)) {
            throw new IllegalArgumentException("Tamanho deve ser 2^n + 1, digitado: " + tam);
        }

        int ultimoIndice = tam - 1;

        // canto superior esquerdo
        t.setAltitude(0, 0, altitudeAleatoria(r));
        // canto superior direito
        t.setAltitude(0, ultimoIndice, altitudeAleatoria(r));
        // canto inferior esquerdo
        t.setAltitude(ultimoIndice, 0, altitudeAleatoria(r));
        // canto inferior direito
        t.setAltitude(ultimoIndice, ultimoIndice, altitudeAleatoria(r));
        
        // tamanho do quadrado
        int passo = ultimoIndice;
        // para variação das altitudes
        int ruido = (max - min) / 2;

        while(passo > 1) {
            int alcance = passo/2;
            
            for(int lin = alcance; lin < tam; lin += passo) {
                for(int col = alcance; col < tam; col += passo) {
                    square(t, r, lin, col, alcance, ruido);
                }
            }

            passo = alcance;
            ruido = ruido/2;
        }
    }
}