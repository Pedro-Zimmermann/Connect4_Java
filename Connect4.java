package TrabalhoFinal;

import java.util.Scanner;

public class Connect4 {

    private char tabuleiro[][] = new char[6][7];
    private Scanner sc = new Scanner(System.in);
    private String cor;
    private String corComputador;
    private String jogadorVencedor;

    // Constructor
    public Connect4() {
        System.out.println("Olá! Vamos inciar o jogo. Selecione uma cor: \n");
        this.cor = corJogo(); //atributo da classe, método para selecionar a cor do jogador (Azul ou Vermelho)
        inciarJogo(); // inicializar a matriz do tabuleiro com a letra "B" (representando um espaço vazio)

        do {
            tabuleiroJogo(); //tabuleiro inicial 
            
            posicaoJogo(); //solicitar a posição que quer jogar (coluna) e tem que ficar na linha disponível (a peça vai cair para a linha mais baixa disponível na coluna escolhida)
            if (validarVitoria() || empateJogo()) { 
                break; //se tiver vitória ou empate, o jogo acaba e mostra a mensagem de vitória ou empate.
            }
            computadorJogada(); //computador joga utilizando o Math.Random para escolher uma coluna aleatória
            if(validarVitoria() || empateJogo()) { 
                break; //se tiver vitória ou empate, o jogo acaba e mostra a mensagem de vitória ou empate.
            }
        } while (!(validarVitoria() == true) && !(empateJogo() == true)); //enquanto o método validarVitoria for false, o jogo continua. Se for true, o jogo acaba e mostra a mensagem de vitória.

        if (empateJogo() == true) {
            tabuleiroJogo(); //mostra o tabuleiro final
            System.out.println("EMPATE! O tabuleiro está cheio e não há vencedor.");
            reiniciarJogo();
        }

        if(validarVitoria() == true) {
            tabuleiroJogo(); //mostra o tabuleiro final
            System.out.println("Fim de jogo! O jogador " + jogadorVencedor + " venceu!");
            reiniciarJogo();

        }
    }

    public String corJogo() {
        System.out.print("Azul (A) ou Vermelho (V): ");
        String opcao = sc.next();

        switch (opcao.toUpperCase()) {
            case "A":
            case "AZUL":
                System.out.println("Você selecionou a cor Azul. Que iniciem os jogos! \n");
                return "A";
            case "V":
            case "VERMELHO":
                System.out.println("Você selecionou a cor Vermelha. Que iniciem os jogos! \n");
                return "V";
            default:
                System.out.println("Opção inválida. Por favor, selecione uma cor válida.");
                return corJogo(); // Chama o método novamente para solicitar a cor correta
        }
    }

    public void inciarJogo() {
        String letra = "B"; // "B" representa um espaço vazio no tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                tabuleiro[i][j] = letra.charAt(0); // "B" representa um espaço vazio no tabuleiro
            }
        }
    }

    public void tabuleiroJogo() {
        //Cabeçalho do tabuleiro
        System.out.print("| 1 | 2 | 3 | 4 | 5 | 6 | 7 | \n");
        System.out.println("-----------------------------");

        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print("| " + tabuleiro[i][j] + " ");
            }
            System.out.print("|\n");
            System.out.println("-----------------------------");
        }
    }

    private void linhaDisponível(String cor, int coluna) {
        //validar posição disponível
        for (int i = tabuleiro.length - 1; i >= 0; i--) {
            if (tabuleiro[i][coluna - 1] == 'B') { //verificar se a posição está disponível (se tiver "B", significa que está vazia). coluna-1 porque o usuário vai digitar a coluna de 1 a 7, mas o índice do array começa em 0
                tabuleiro[i][coluna - 1] = cor.charAt(0); //converte a cor selecionada para char e coloca na posição disponível.
                break;
            } else if (i == 0) { //se chegar na linha 0 e ainda tiver "B", significa que a coluna está cheia
                System.out.println("Coluna cheia, escolha outra coluna.");
                posicaoJogo(); //chama o método para solicitar a posição novamente
            }
        }
    }

    public void posicaoJogo() {

        System.out.println("Indique a coluna que você quer jogar.");
        int posicaoColuna = sc.nextInt();

        if (posicaoColuna < 1 || posicaoColuna > 7) {
            System.out.println("Coluna inválida, tente novamente");
            posicaoJogo();
        } else {
            System.out.println("Você jogou na coluna " + posicaoColuna + "\n");
            linhaDisponível(cor, posicaoColuna);
        }
        jogadorVencedor = cor; //atribuir a cor do jogador vencedor para mostrar na mensagem de vitória no final do jogo

    }

    private boolean validarVitoria() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro[i].length; j++) {
                if (j <= 3) { //Validar na horizontal (O array tem colunas de 0 a 6. Se você está em j=5 e tenta olhar j+3=8, essa posição não existe e o programa trava.)
                    if (tabuleiro[i][j] != 'B' && tabuleiro[i][j] == tabuleiro[i][j + 1] && tabuleiro[i][j + 2] == tabuleiro[i][j] && tabuleiro[i][j + 3] == tabuleiro[i][j]) {
                        return true;
                    }
                }
                if (i <= 2) { //valida na vertical (O array tem linhas de 0 a 5. Se você está em i=3 e tenta olhar i+3=6, não existe.)
                    if (tabuleiro[i][j] != 'B' && tabuleiro[i][j] == tabuleiro[i + 1][j] && tabuleiro[i][j] == tabuleiro[i + 2][j] && tabuleiro[i][j] == tabuleiro[i + 3][j]) {
                        return true;
                    }
                }
                if (i <= 2 && j <= 3) { //valida na diagonal (O array tem linhas de 0 a 5 e colunas de 0 a 6. Se você está em i=3 e tenta olhar i+3=6, não existe. Se você está em j=5 e tenta olhar j+3=8, não existe.)
                    if (tabuleiro[i][j] != 'B' && tabuleiro[i][j] == tabuleiro[i + 1][j + 1] && tabuleiro[i][j] == tabuleiro[i + 2][j + 2] && tabuleiro[i][j] == tabuleiro[i + 3][j + 3]) {
                        return true;
                    }
                }
                if (i <= 2 && j >= 3) { //valida na diagonal inversa (O array tem linhas de 0 a 5 e colunas de 0 a 6. Se você está em i=3 e tenta olhar i+3=6, não existe. Se você está em j=2 e tenta olhar j-3=-1, não existe.)
                    if (tabuleiro[i][j] != 'B' && tabuleiro[i][j] == tabuleiro[i + 1][j - 1] && tabuleiro[i][j] == tabuleiro[i + 2][j - 2] && tabuleiro[i][j] == tabuleiro[i + 3][j - 3]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private void computadorJogada() {
        if (cor.equals("A")) {
            corComputador = "V";
        } else {
            corComputador = "A";
        }
        int jogadaComputador = (int) (Math.random() * (7 - 1 + 1)) + 1; // Utilizar Math.random para escolher uma coluna aleatória
        linhaDisponível(corComputador, jogadaComputador);

        jogadorVencedor = corComputador; //atribuir a cor do computador vencedor para mostrar na mensagem de vitória no final do jogo

    }

    private boolean empateJogo() {
            for (int i = 0; i < tabuleiro.length; i++) {
                for (int j = 0; j < tabuleiro[i].length; j++) {
                    if (tabuleiro[i][j] == 'B') { //verificar se ainda tem espaço vazio no tabuleiro. Se tiver, o jogo continua. Se não tiver, é empate.
                        return false;
                    }
                }
            }
            return true;
    }

    private void reiniciarJogo() {
        System.out.println("Deseja jogar novamente? (S/N)");
        String opcao = sc.next();
        switch (opcao.toUpperCase()) {
            case "S":
                new Connect4(); // Reinicia o jogo
                break;
            case "N":
                System.out.println("Obrigado por jogar!");
                break;
            default:
                System.out.println("Opção inválida. Por favor, selecione S ou N.");
                reiniciarJogo(); // Chama o método novamente para solicitar a opção correta
        }
    }

    public static void main(String[] args) {
        new Connect4();
    }

}
