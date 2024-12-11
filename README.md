# Monster Battle

## Visão Geral

Monster Battle é um jogo de combate por turnos que permite aos jogadores escolher diferentes tipos de monstros com atributos únicos, como ataque, defesa e habilidades especiais, para batalhar. O jogo pode ser jogado nos modos Jogador vs Jogador (PvP) ou Jogador vs Computador (PvE). Cada jogador realiza ações em turnos, como atacar, defender ou usar habilidades especiais, com o objetivo de derrotar o monstro do oponente.

## Como Executar o Projeto

### Pré-requisitos
- **Java Development Kit (JDK)**: Certifique-se de ter o JDK 17 (ou versão compatível) instalado.
- **IDE Java**: Utilize uma IDE como IntelliJ IDEA, Eclipse, ou NetBeans para abrir e executar o projeto.

### Passos para Executar
1. **Baixe ou Clone o Repositório**
   - Faça o download do repositório ou clone-o localmente:
     ```bash
     git clone https://github.com/camiyuka/monsters_battle_game.git
     ```

2. **Abra o Projeto na IDE**
   - Importe o projeto para sua IDE de preferência.
   - Certifique-se de configurar o SDK para a versão instalada do JDK.

3. **Compile e Execute**
   - Na sua IDE, localize a classe `Main` e execute-a.
   - Se preferir usar o terminal:
     ```bash
     javac MonsterBattleGame/src/main/java/br/squad3/Main.java
     ```

4. **Divirta-se**
   - Siga as instruções do jogo no console para escolher monstros e iniciar batalhas!

## Funcionalidades do Jogo

### 1. Criação de Monstros

- O jogador pode escolher entre diferentes tipos de monstros, como `Dragon`, `Robot` ou `Zombie`. Cada monstro possui atributos específicos de vida (`health`), ataque (`attackPower`), defesa (`defenseBoost`) e uma habilidade especial única.

### 2. Modos de Jogo

- **Jogador vs Jogador (PvP)**: Dois jogadores humanos competem entre si, cada um controlando um monstro.
- **Jogador vs Computador (PvE)**: Um jogador humano compete contra um oponente controlado pelo computador, que age de forma aleatória.

### 3. Sistema de Combate por Turnos

- O jogo é dividido em turnos. Em cada turno, o jogador pode escolher entre atacar, defender ou usar uma habilidade especial.
- **Ataque**: Causa dano ao oponente com base no atributo de ataque do monstro.
- **Defender**: Aumenta a defesa temporariamente, reduzindo o dano recebido no próximo ataque.
- **Habilidade Especial**: Cada monstro possui uma habilidade especial única, como regeneração de vida (`Zombie`) ou ataque de fogo (`Dragon`).

### 4. Sistema de Pontuação

- O `GameManager` rastreia a pontuação de cada jogador. Pontos são concedidos para ações específicas, como atacar ou usar uma habilidade especial.

### 5. Salvamento e Restauração do Progresso

- O jogo utiliza o padrão Memento para salvar o estado dos monstros e restaurar o progresso quando necessário. Isso permite ao jogador retomar o jogo de onde parou.
- O progresso é salvo após cada batalha, armazenando o estado atual dos monstros em um `GameMemento` gerenciado pelo `GameStateCaretaker`.

## Fluxo do Jogo

1. **Inicialização**: O jogador escolhe o modo de jogo (PvP ou PvE).
2. **Criação de Jogadores e Monstros**: Dois jogadores são criados, cada um com um monstro específico. O jogador escolhe o tipo de monstro ao ser criado.
3. **Combate por Turnos**: O combate se dá em turnos alternados, onde cada jogador pode atacar, defender ou usar uma habilidade especial. A vida do oponente é reduzida de acordo com o ataque realizado.
4. **Notificações**: Cada jogador é notificado das ações do oponente através do padrão Observer.
5. **Encerramento**: O jogo termina quando um dos monstros é derrotado. O vencedor é anunciado.
6. **Salvamento do Estado**: Após o fim da partida, o estado do jogo é salvo, permitindo ao jogador restaurar e continuar o jogo posteriormente.

## Classes e Atributos

- **Main**: Responsável por inicializar o jogo, escolher o modo de jogo, gerenciar turnos e salvar o estado do jogo.
- **Player**: Contém informações sobre o jogador, incluindo o nome, o monstro que controla e a pontuação.
- **Monster** (Classe Abstrata): Define a estrutura básica dos monstros, incluindo atributos de vida, ataque, defesa e ações de combate. As subclasses são `Dragon`, `Robot` e `Zombie`, que implementam comportamentos específicos.
- **GameManager**: Singleton responsável por gerenciar o estado global, incluindo a pontuação total e o status do jogo.
- **GameStateCaretaker** e **GameMemento**: Implementam o salvamento e restauração do progresso do jogo, permitindo ao jogador voltar ao estado anterior.

## Arquitetura do Sistema

O sistema é baseado em vários padrões de projeto, incluindo Factory, Strategy, Observer, Memento e Singleton, para garantir uma arquitetura modular e flexível. Abaixo estão as principais classes e suas funcionalidades:

### 1. Classes Principais

- **Main**: Classe principal que inicializa o jogo, define o modo de jogo, cria jogadores, e gerencia o fluxo de combate por turnos.
- **Player**: Representa um jogador no jogo. Cada jogador possui um monstro que controla e um nome. A classe implementa a interface `GameObserver` para receber notificações sobre mudanças no estado do jogo.
- **Monster** (classe abstrata): Representa um monstro no jogo. Possui atributos como `health`, `attackPower`, `defenseBoost` e métodos abstratos que devem ser implementados pelas subclasses (`attack`, `defend`, `useSpecialAbility`). Implementa a interface `GameSubject` para gerenciar observadores.
- **Dragon**, **Robot**, **Zombie**: Subclasses da classe `Monster`, cada uma com suas próprias implementações dos métodos de ataque, defesa e habilidade especial.

### 2. Padrões de Projeto Utilizados
Para tornar o jogo modular, flexível e fácil de manter, foram utilizados os seguintes padrões de projeto:

#### 2.1. Factory

- **MonsterFactory**: Usado para criar instâncias de diferentes tipos de monstros com base no tipo especificado (`Dragon`, `Robot`, `Zombie`). Isso permite ao jogador escolher o monstro que deseja utilizar.

#### 2.2. Strategy

- Cada monstro tem ações de combate (`attack`, `defend`, `useSpecialAbility`) que são implementadas de maneira específica para cada tipo de monstro. O padrão Strategy permite definir ações de combate que variam conforme o monstro, dando flexibilidade às ações realizadas durante o jogo.

#### 2.3. Observer

- **GameObserver**: Interface que define o método `update(String message)`, que é implementado pela classe `Player` para receber notificações sobre mudanças no estado do jogo.
- **GameSubject**: Interface implementada por `Monster`, que permite adicionar, remover e notificar observadores. Cada jogador é um observador que recebe atualizações do estado do monstro controlado.

#### 2.4. Memento

- **MonsterMemento** e **GameMemento**: Implementação do padrão Memento para salvar e restaurar o estado do jogo. Cada monstro pode salvar seu estado atual em um `MonsterMemento`, e o estado do jogo completo pode ser salvo usando `GameMemento`.
- **GameStateCaretaker**: Classe que gerencia o histórico dos estados salvos do jogo, permitindo salvar e restaurar o progresso.

#### 2.5. Singleton

- **GameManager**: Classe Singleton que gerencia o estado global do jogo, como a pontuação e o status do jogo. Permite rastrear a pontuação dos jogadores e atualizar o status geral.

## Autores
- [Guilherme Martins Leal Fernandes](https://github.com/GuilhermeMLeal)
- [Camila Yukari Yatabe](https://github.com/camiyuka)
- [Ana Julia Moura Martins](https://github.com/AnaJuliaMM)
