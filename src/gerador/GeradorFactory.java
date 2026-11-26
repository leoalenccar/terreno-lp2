package gerador;

import enums.AlgoritmoEnum;

public class GeradorFactory {
    public GeradorAltitude criar(AlgoritmoEnum algoritmo, long seed, int min, int max){
        return switch (algoritmo){
            case DIAMOND_SQUARE -> new DiamondSquare(seed, min, max);
            case VALUE_NOISE -> new ValueNoise(seed, min, max);
        };
    }
}
