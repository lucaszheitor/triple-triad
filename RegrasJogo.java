import java.util.ArrayList;

public class RegrasJogo {

	public static void executarCapturas(Tabuleiro tab, int l, int c, String meuDono, String donoOponente,
			Jogador jAtual, Jogador jOpo) {
		Carta cartaAtual = tab.grelha[l][c];
		ArrayList<InfoVizinho> vizinhosValidos = new ArrayList<>();

		if (l > 0 && tab.grelha[l - 1][c] != null)
			vizinhosValidos.add(new InfoVizinho(l - 1, c, tab.grelha[l - 1][c], cartaAtual.cima,
					tab.grelha[l - 1][c].baixo, "Cima"));
		if (l < 2 && tab.grelha[l + 1][c] != null)
			vizinhosValidos.add(new InfoVizinho(l + 1, c, tab.grelha[l + 1][c], cartaAtual.baixo,
					tab.grelha[l + 1][c].cima, "Baixo"));
		if (c > 0 && tab.grelha[l][c - 1] != null)
			vizinhosValidos.add(new InfoVizinho(l, c - 1, tab.grelha[l][c - 1], cartaAtual.esquerda,
					tab.grelha[l][c - 1].direita, "Esquerda"));
		if (c < 2 && tab.grelha[l][c + 1] != null)
			vizinhosValidos.add(new InfoVizinho(l, c + 1, tab.grelha[l][c + 1], cartaAtual.direita,
					tab.grelha[l][c + 1].esquerda, "Direita"));

		for (InfoVizinho iv : vizinhosValidos) {
			if (iv.vizinha.dono.equals(donoOponente) && iv.meuValor > iv.valorOpostoVizinho) {
				iv.vizinha.dono = meuDono;
				jAtual.pontos++;
				jOpo.pontos--;
				System.out.println("--> [Captura Básica] " + iv.vizinha.nome + " (" + iv.direcao + ")");
			}
		}
	}
}
