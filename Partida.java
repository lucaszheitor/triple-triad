   import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Partida {

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("=================================================");
        System.out.println("            BEM-VINDO AO TRIPLE TRIAD            ");
        System.out.println("=================================================");
        System.out.println(" Prepare as suas cartas, estude as regras e vença!");
        System.out.println("-------------------------------------------------\n");

        System.out.print("Digite o nome do Jogador 1: ");
        String nomeP1 = scanner.nextLine();
        
        System.out.print("Digite o nome do Jogador 2: ");
        String nomeP2 = scanner.nextLine();
        System.out.println("-------------------------------------------------\n");

        boolean jogoAtivo = true;
        int ronda = 1;

        while (jogoAtivo) {
            Tabuleiro tabuleiro = new Tabuleiro();

            Jogador p1 = new Jogador(nomeP1);
            Jogador p2 = new Jogador(nomeP2);

            List<Carta> baralho = criarBaralhoCompleto();
            Collections.shuffle(baralho);

            for (int i = 0; i < 5; i++) {
                p1.adicionarCartaMao(baralho.remove(0));
            }
            for (int i = 0; i < 5; i++) {
                p2.adicionarCartaMao(baralho.remove(0));
            }

            System.out.println("=================================================");
            System.out.println("            TRIPLE TRIAD - RONDA " + ronda);
            System.out.println("=================================================");

            int idxP1 = rand.nextInt(p1.mao.size());
            int idxP2 = rand.nextInt(p2.mao.size());
            Carta cartaTemp = p1.mao.get(idxP1);
            p1.mao.set(idxP1, p2.mao.get(idxP2));
            p2.mao.set(idxP2, cartaTemp);
            System.out.println("-> [SWAP] Uma carta foi trocada aleatoriamente entre as mãos!\n");

            int turno = rand.nextInt(2);
            Jogador jogadorSorteado = (turno == 0) ? p1 : p2;
            System.out.println("-> [MOEDA] " + jogadorSorteado.nome + " foi sorteado(a) para começar a jogar!\n");

            int jogadasTotais = 0;

            while (jogadasTotais < 9) {
                tabuleiro.desenhar();

                Jogador jogadorAtual = (turno == 0) ? p1 : p2;
                Jogador jogadorOponente = (turno == 0) ? p2 : p1;
                
                String tagDono = jogadorAtual.nome;
                String tagOponente = jogadorOponente.nome;

                System.out.println("Vez de: " + jogadorAtual.nome);
                jogadorAtual.mostrarMao();

                if (jogadorAtual.mao.isEmpty()) {
                    break;
                }

                System.out.println("\n-> [ORDER] Jogando automaticamente a primeira carta da mão...");
                Carta cartaJogada = jogadorAtual.mao.remove(0);

                System.out.print("Escolha a posição no tabuleiro (1 a 9): ");
                int pos = scanner.nextInt();

                if (!tabuleiro.posicaoDisponivelPorNumero(pos)) {
                    System.out.println("Posição inválida ou já ocupada! Perdeu a jogada.");
                    jogadorAtual.mao.add(0, cartaJogada);
                    continue;
                }

                int linha = tabuleiro.getLinha(pos);
                int coluna = tabuleiro.getColuna(pos);

                cartaJogada.dono = tagDono;
                tabuleiro.grelha[linha][coluna] = cartaJogada;
                jogadasTotais++;

                RegrasJogo.executarCapturas(tabuleiro, linha, coluna, tagDono, tagOponente, jogadorAtual, jogadorOponente);

                turno = 1 - turno;
            }

            tabuleiro.desenhar();
            System.out.println("=================================================");
            System.out.println("                 FIM DA RONDA " + ronda);
            System.out.println("=================================================");
            System.out.println("Pontuação final - " + p1.nome + ": " + p1.pontos);
            System.out.println("Pontuação final - " + p2.nome + ": " + p2.pontos);

            if (p1.pontos > p2.pontos) {
                System.out.println("\nVencedor: " + p1.nome + "!");
                jogoAtivo = false;
            } else if (p2.pontos > p1.pontos) {
                System.out.println("\nVencedor: " + p2.nome + "!");
                jogoAtivo = false;
            } else {
                System.out.println("\n-> [SUDDEN DEATH] Empate detectado! Morte súbita ativada: nova ronda...\n");
                ronda++;
            }
        }

        scanner.close();
    }

    private List<Carta> criarBaralhoCompleto() {
        List<Carta> baralho = new ArrayList<>();
        baralho.add(new Carta("Geezard", 1, 1, 5, 4, "NEUTRAL"));
        baralho.add(new Carta("Funguar", 5, 1, 3, 1, "NEUTRAL"));
        baralho.add(new Carta("Bite Bug", 1, 3, 5, 3, "NEUTRAL"));
        baralho.add(new Carta("Red Bat", 6, 1, 2, 1, "NEUTRAL"));
        baralho.add(new Carta("Blobra", 2, 1, 5, 3, "NEUTRAL"));
        baralho.add(new Carta("Gayla", 2, 4, 4, 1, "THUNDER"));
        baralho.add(new Carta("Gesper", 1, 4, 1, 5, "NEUTRAL"));
        baralho.add(new Carta("Fastitocalon-F", 3, 2, 1, 5, "EARTH"));
        baralho.add(new Carta("Blood Soul", 2, 6, 1, 1, "NEUTRAL"));
        baralho.add(new Carta("Caterchipillar", 4, 4, 3, 2, "NEUTRAL"));
        baralho.add(new Carta("Cockatrice", 2, 6, 1, 2, "THUNDER"));
        baralho.add(new Carta("Grat", 7, 1, 1, 3, "NEUTRAL"));
        baralho.add(new Carta("Buel", 6, 3, 2, 2, "NEUTRAL"));
        baralho.add(new Carta("Mesmerize", 5, 4, 3, 3, "NEUTRAL"));
        baralho.add(new Carta("Glacial Eye", 6, 3, 1, 4, "ICE"));
        baralho.add(new Carta("Granaldo", 7, 2, 5, 3, "NEUTRAL"));
        baralho.add(new Carta("Tri-Face", 3, 5, 3, 5, "NEUTRAL"));
        baralho.add(new Carta("Snow Lion", 7, 3, 1, 5, "ICE"));
        baralho.add(new Carta("Iron Giant", 6, 6, 5, 4, "NEUTRAL"));
        baralho.add(new Carta("Behemoth", 3, 6, 4, 7, "NEUTRAL"));
        return baralho;
    }
}