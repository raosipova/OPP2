package ru.netology;

public class Radio {
    private int currentStation;
    private int currentVolume;
    private int stationLimit;

    public Radio() {
        this.stationLimit = 10;
    }

    public Radio(int stationLimit) {
        this.stationLimit = stationLimit;

    }

    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int newCurrentStation) {
        if (newCurrentStation < stationLimit) {
            if (newCurrentStation >= 0) {
                this.currentStation = newCurrentStation;
            }
        }
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 100) {
            return;
        }
        if (newCurrentVolume < 0) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void next() {
        if (currentStation == stationLimit - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationLimit - 1;
        } else {
            currentStation--;
        }
    }

    public void increaseVolume() {
        int target = currentVolume + 1;
        setCurrentVolume(target);
    }

    public void reduceVolume() {
        int target = currentVolume - 1;
        setCurrentVolume(target);
    }

}