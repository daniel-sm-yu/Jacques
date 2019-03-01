package com.dsyu.jacques;

import android.util.Log;
import android.widget.Toast;

import static com.dsyu.jacques.MainActivity.TAG;

public class Ace {

    private boolean playerHasAce;
    private boolean cpuHasAce;

    public void setPlayerAce(int num) {
        if (num == 1) {
            playerHasAce = true;
        }
    }

    public void setCpuAce(int num) {
        if (num == 1) {
            cpuHasAce = true;
        }
    }

    public boolean usePlayerAce() {
        if (playerHasAce) {
            playerHasAce = false;
            return true;
        }
        else {
            return false;
        }
    }

    public boolean useCpuAce() {
        if (cpuHasAce) {
            cpuHasAce = false;
            return true;
        }
        else {
            return false;
        }
    }


}
