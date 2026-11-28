package gerador;

import terreno.Terreno;

import java.util.Random;

public class ValueNoise extends GeradorAltitude {
    static final int DIVISOES = 32;

    public ValueNoise(long seed, int min, int max) {
        super(seed, min, max);
    }

    private static double interpolar(double a, double b , double t){
        return a + (b-a) * t;
    }


    @Override
    protected void preencher(Terreno terreno, Random random) {
        int tamanho = terreno.getTamanho();
        double escala = (double) tamanho/DIVISOES;
        int lado = DIVISOES+2;
        double[][]malha = new double[lado][lado];

        for (int ii = 0; ii < lado; ii++) {
            for (int jj = 0; jj < lado; jj++) {
                malha[ii][jj] = random.nextDouble();
            }
        }

        for (int linha = 0; linha < tamanho; linha++){
            for (int coluna = 0; coluna < tamanho; coluna++) {
                double y = linha / escala;
                double x = coluna/ escala;

                int y0 = (int) y;
                int x0 = (int) x;

                double fy = y - y0;
                double fx = x - x0;

                fy = Math.pow(fy,2) * (3-2*fy);
                fx = Math.pow(fx,2) * (3-2*fx);

                double topo = interpolar(malha[y0][x0], malha[y0][x0+1],fx);
                double base = interpolar(malha[y0 + 1][x0], malha[y0 + 1][x0 + 1], fx);
                double valor = interpolar(topo, base, fy);
                terreno.setAltitude(linha, coluna, (int) Math.round(min + valor * (max - min)));
            }
        }

    }
}
