package com.xuesi.engine.model;

public class ScoreResult {
    private String indicatorName;
    private double value;
    private int score;

    public ScoreResult(String indicatorName, double value, int score) {
        this.indicatorName = indicatorName;
        this.value = value;
        this.score = score;
    }
    public String getIndicatorName() {
        return indicatorName;
    }
    public double getValue() {
        return value;
    }
    public int getScore() {
        return score;
    }
}
