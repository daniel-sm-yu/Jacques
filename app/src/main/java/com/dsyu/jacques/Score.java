package com.dsyu.jacques;

public class Score {

    private String playerScore = "0";
    private String cpuScore = "0";

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
}

