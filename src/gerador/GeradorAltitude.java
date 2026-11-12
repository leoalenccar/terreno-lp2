package gerador;

import java.util.Random;
import terreno.Terreno;

public abstract class GeradorAltitude {
    protected long seed;
    protected int min;
    protected int max;

    protected GeradorAltitude(long seed, int min, int max) {
        if(min >= max) {
            throw new IllegalArgumentException("min deve ser menor que max");
        }

        this.seed = seed;
        this.min = min;
        this.max = max;
    }

    public Terreno gerar(int tamanho) {
        Random random = new Random(seed);
        Terreno t = new Terreno(tamanho);
        preencher(t, random);
        limitar(t);

        return t;
    }

    protected abstract void preencher(Terreno t, Random random);

    // nao deixa altitude ser menor que o mínimo ou maior que o máximo
    private void limitar(Terreno t) {
        int n = t.getTamanho();

        for(int lin = 0; lin < n; lin++) {
            for(int col = 0; col < n; col++) {
                int alt = t.getAltitude(lin, col);
                if(alt < min) {
                    alt = min;
                } else if (alt > max) {
                    alt = max;
                }

                t.setAltitude(lin, col, alt);
            }
        }
    }
}