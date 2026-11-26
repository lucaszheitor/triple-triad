import java.util.ArrayList;

public class Jogador {
	String nome;
	ArrayList<Carta> mao;
	int pontos;

	public Jogador(String nome) {
		this.nome = nome;
		this.mao = new ArrayList<>();
		this.pontos = 5;
	}

	public void adicionarCartaMao(Carta carta) {
		mao.add(carta);
	}

	public void mostrarMao() {
		System.out.println("\n--- Mão de " + nome + " (Pontos Atuais: " + pontos + ") ---");
		for (int i = 0; i < mao.size(); i++) {
			System.out.print(i + " -> ");
			mao.get(i).exibirInfo();
		}
	}
}
