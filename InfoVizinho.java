public class InfoVizinho {
	int lViz, cViz;
	Carta vizinha;
	int meuValor;
	int valorOpostoVizinho;
	String direcao;

	public InfoVizinho(int lV, int cV, Carta v, int mV, int vOV, String dir) {
		this.lViz = lV;
		this.cViz = cV;
		this.vizinha = v;
		this.meuValor = mV;
		this.valorOpostoVizinho = vOV;
		this.direcao = dir;
	}
}
