package com.dsyu.jacques;

public class Score extends Ace{

    private String playerScore = "0";

    private String cpuScore = "0";

    public String getPlayerScore() {
        return playerScore;
    }

    public String getCpuScore() {
        return cpuScore;
    }

    public String addPlayerScore(int num) {
        if (num > 10) {
            num = 10;
        }
        else if (num == 1) {
            num = 11;
        }
        playerScore = String.valueOf(Integer.parseInt(playerScore) + num);
        return playerScore;
    }

    public String addCpuScore(int num) {
        if (num > 10) {
            num = 10;
        }
        else if (num == 1) {
            num = 11;
        }
        cpuScore = String.valueOf(Integer.parseInt(cpuScore) + num);
        return cpuScore;
    }

    public int getPlayerScoreInt() {
        return Integer.parseInt(playerScore);
    }

    public int getCpuScoreInt() {
        return Integer.parseInt(cpuScore);
    }

    public boolean playerGameOver(boolean hasAce) {
        if (hasAce) {
            playerScore =  String.valueOf(Integer.parseInt(playerScore) - 10);
            return false;
        }
        else {
            return true;
        }
    }

    public boolean cpuGameOver(boolean hasAce) {
        if (hasAce) {
            cpuScore =  String.valueOf(Integer.parseInt(cpuScore) - 10);
            return false;
        }
        else {
            return true;
        }
    }
}

