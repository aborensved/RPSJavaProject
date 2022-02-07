package com.superdevs;

public class ActiveUserInTour {

    String nameId;
    int result;

    public ActiveUserInTour(String nameId, int result) {
        this.nameId = nameId;
        this.result = result;
    }

    public String getNameId() {
        return nameId;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ActiveUserInTour{" +
                "nameId='" + nameId + '\'' +
                ", result=" + result +
                '}';
    }

}
