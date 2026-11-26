public class Tabuleiro {
    Carta[][] grelha;

    public Tabuleiro() {
        grelha = new Carta[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grelha[i][j] = null;
            }
        }
    }

    public void desenhar() {
        for (int i = 0; i < 3; i++) {
            System.out.println("+---------------+---------------+---------------+");

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (grelha[i][j] == null) {
                    System.out.print(centralizar("", 15) + "|");
                } else {
                    System.out.print(centralizar(formatarValor(grelha[i][j].cima), 15) + "|");
                }
            }
            System.out.println();

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(centralizar("", 15) + "|");
            }
            System.out.println();

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (grelha[i][j] == null) {
                    int numPos = (i * 3) + j + 1;
                    System.out.print(centralizar(String.valueOf(numPos), 15) + "|");
                } else {
                    String esq = formatarValor(grelha[i][j].esquerda);
                    String dir = formatarValor(grelha[i][j].direita);
                    String nomeCentro = centralizar(grelha[i][j].nome, 13);
                    System.out.print(esq + nomeCentro + dir + "|");
                }
            }
            System.out.println();

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(centralizar("", 15) + "|");
            }
            System.out.println();

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (grelha[i][j] == null) {
                    System.out.print(centralizar("", 15) + "|");
                } else {
                    System.out.print(centralizar(formatarValor(grelha[i][j].baixo), 15) + "|");
                }
            }
            System.out.println();

            System.out.println("+---------------+---------------+---------------+");

            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                if (grelha[i][j] == null) {
                    System.out.print(centralizar("", 15) + "|");
                } else {
                    System.out.print(centralizar(grelha[i][j].dono, 15) + "|");
                }
            }
            System.out.println();
        }
        System.out.println("+---------------+---------------+---------------+");
    }

    public boolean posicaoDisponivelPorNumero(int numero) {
        if (numero < 1 || numero > 9) return false;
        int linha = (numero - 1) / 3;
        int coluna = (numero - 1) % 3;
        return grelha[linha][coluna] == null;
    }

    public int getLinha(int numero) {
        return (numero - 1) / 3;
    }

    public int getColuna(int numero) {
        return (numero - 1) % 3;
    }

    private String centralizar(String texto, int largura) {
        if (texto.length() >= largura) {
            return texto.substring(0, largura);
        }
        int espacosTotais = largura - texto.length();
        int espacosEsquerda = espacosTotais / 2;
        int espacosDireita = espacosTotais - espacosEsquerda;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espacosEsquerda; i++) sb.append(" ");
        sb.append(texto);
        for (int i = 0; i < espacosDireita; i++) sb.append(" ");
        return sb.toString();
    }

    private String formatarValor(int val) {
        return (val == 10) ? "A" : String.valueOf(val);
    }
}