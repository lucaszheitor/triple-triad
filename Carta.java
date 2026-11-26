public class Carta {
	String nome;
	int cima;
	int baixo;
	int esquerda;
	int direita;
	String dono;
	String tipo;

	public Carta(String nome, int cima, int baixo, int esquerda, int direita, String tipo) {
		this.nome = nome;
		this.cima = cima;
		this.baixo = baixo;
		this.esquerda = esquerda;
		this.direita = direita;
		this.tipo = tipo;
		this.dono = null;
	}

	public void exibirInfo() {
		System.out.println("Carta: " + nome + " | Cima: " + cima + "  | Baixo: " + baixo + " | Esquerda: " + esquerda + " | Direita: " + direita
				+ " | Tipo: " + tipo);
	}
}
