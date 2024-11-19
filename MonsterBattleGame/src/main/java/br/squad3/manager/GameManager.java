package br.squad3.manager;

public class GameManager {
    private static GameManager instance;
    private int score;
    private String gameStatus;

    private GameManager() {
        score = 0;
        gameStatus = "In Progress";
    }

    public static GameManager getInstance() {
        if (instance == null) {
            instance = new GameManager();
        }
        return instance;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int points) {
        score += points;
        System.out.println("Pontuação atual: " + score);
    }

    public String getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(String status) {
        gameStatus = status;
        System.out.println("Status do jogo: " + gameStatus);
    }
}
