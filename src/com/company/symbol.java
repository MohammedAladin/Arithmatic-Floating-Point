package com.company;
public class symbol {

    String letter;
    double probability;
    double highRange;
    double lowRange;


    public symbol(String letter,float probability, float highRange, float lowRange ){
        this.letter=letter;
        this.probability=probability;
        this.highRange=highRange;
        this.lowRange=lowRange;
    }
    public symbol(){}
    public void setLetter(String letter) {
        this.letter = letter;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setLow_range(double lowRange) {
        this.lowRange = lowRange;
    }

    public void setHigh_range(double highRange) {
        this.highRange = highRange;
    }

    public String getLetter() {
        return letter;
    }

    public double getProbability() {
        return probability;
    }

    public double getLow_range() {
        return lowRange;
    }

    public double getHigh_range() {
        return highRange;
    }
    @Override
    public String toString() {
        return "symbol{" +
                "letter='" + letter + '\'' +
                ", probability=" + probability +
                ", highRange=" + highRange +
                ", lowRange=" + lowRange +
                '}';
    }
}


