package terreno;

public class Terreno {
    private int altitudes[][];
    private int tamanho;

    private void validar(int lin, int col) {
        if (lin < 0 || lin >= tamanho || col < 0 || col >= tamanho) {
            throw new PosicaoInvalidaException(lin, col);
        }
    }

    public Terreno(int tamanho) {
        if(tamanho <= 0) {
            throw new IllegalArgumentException("Tamanho deve ser maior que zero");
        }

        this.tamanho = tamanho;
        this.altitudes = new int[tamanho][tamanho];
    }
    
    public int getAltitude(int lin, int col) {
        validar(lin, col);
        return altitudes[lin][col];
    }

    public void setAltitude(int lin, int col, int alt) {
        validar(lin, col);
        altitudes[lin][col] = alt;
    }

    public int getTamanho() {
        return tamanho;
    }
}
