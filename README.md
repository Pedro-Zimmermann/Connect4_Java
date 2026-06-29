# Connect Four (Lig4) em Java

> Trabalho acadêmico desenvolvido para a disciplina de **Programação Orientada a Objetos** — implementação do clássico jogo de tabuleiro Connect Four rodando inteiramente no terminal.
>
> ## Sobre o Projeto
>
> Este projeto foi desenvolvido como trabalho da faculdade com o objetivo de aplicar os conceitos de Programação Orientada a Objetos (POO) em Java, como encapsulamento, herança e organização em classes. A escolha do Connect Four permitiu explorar lógica de jogo, manipulação de matrizes e interação com o usuário via linha de comando.
>
> O Connect Four (conhecido no Brasil como **Lig4**) é um jogo de estratégia para dois jogadores. Cada jogador escolhe uma cor e, alternadamente, lança peças em uma grade de 7 colunas por 6 linhas. O objetivo é ser o primeiro a conectar quatro peças consecutivas na horizontal, vertical ou diagonal.
>
> ## Funcionalidades
>
> - Modo **Jogador vs Jogador** (dois jogadores no mesmo terminal)
> - - Tabuleiro renderizado no terminal com visualização clara das peças
>   - - Detecção automática de vitória (horizontal, vertical e diagonal)
>     - - Detecção de empate (tabuleiro cheio sem vencedor)
>       - - Validação de jogadas inválidas (coluna inexistente ou cheia)
>         - - Reinício de partida ao fim do jogo
>          
>           - ## Tecnologias
>          
>           - - **Java** (JDK 11+)
>             - - Execução via terminal / linha de comando
>               - - Sem dependências externas
>                
>                 - ## Como Executar
>                
>                 - ### Pré-requisitos
>                
>                 - - Java JDK 11 ou superior instalado
> - Terminal (CMD, PowerShell, Bash, etc.)
>
> - ### Passos
>
> - ```bash
>   # Clone o repositório
>   git clone https://github.com/Pedro-Zimmermann/Connect4_Java.git
>
>   # Entre na pasta do projeto
>   cd Connect4_Java
>
>   # Compile o projeto
>   javac src/*.java -d out/
>
>   # Execute o jogo
>   java -cp out/ Main
>   ```
>
> ## Como Jogar
>
> 1. Ao iniciar, o jogador **1 (X)** começa a partida.
> 2. 2. Cada turno exibe o tabuleiro atualizado e solicita que o jogador escolha uma **coluna** (de 1 a 7).
>    3. 3. A peça cai automaticamente para a posição mais baixa disponível na coluna escolhida.
>       4. 4. Vence quem conectar **4 peças seguidas** primeiro — na horizontal, vertical ou diagonal.
>          5. 5. Se o tabuleiro encher sem vencedor, o resultado é **empate**.
>            
>             6. ## Estrutura do Projeto
>            
>             7. ```
>                Connect4_Java/
>                ├── src/
>                │   ├── Main.java        # Ponto de entrada da aplicação
>                │   ├── Jogo.java        # Lógica principal do jogo
>                │   ├── Tabuleiro.java   # Representação e renderização do tabuleiro
>                │   └── Jogador.java     # Classe que representa cada jogador
>                └── README.md
>                ```
>
> ## Contexto Acadêmico
>
> Este projeto foi entregue como trabalho prático da disciplina de **Programação Orientada a Objetos** na graduação em Ciência da Computação / Engenharia de Software. O desenvolvimento individual permitiu consolidar os fundamentos de Java e boas práticas de organização de código.
>
> ## Autor
>
> Feito por **Pedro Zimmermann**.
> 
