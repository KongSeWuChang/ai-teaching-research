package com.xuesi.engine.model;

public class Indicator {
    private String name;
    private String fieldName;
    private double excellent;
    private double good;
    private double pass;
    private String level0Comment;
    private String level1Comment;
    private String level2Comment;
    private String level3Comment;
    private String level0Suggestion;
    private String level1Suggestion;
    private String level2Suggestion;
    private String level3Suggestion;
    public Indicator(String name, String fieldName, double excellent, double good, double pass,
                     String level0Comment, String level0Suggestion,
                     String level1Comment, String level1Suggestion,
                     String level2Comment, String level2Suggestion,
                     String level3Comment, String level3Suggestion)
    {
        this.name = name;
        this.fieldName = fieldName;
        this.excellent = excellent;
        this.good = good;
        this.pass = pass;
        this.level0Comment = level0Comment;
        this.level1Comment = level1Comment;
        this.level2Comment = level2Comment;
        this.level3Comment = level3Comment;
        this.level0Suggestion = level0Suggestion;
        this.level1Suggestion = level1Suggestion;
        this.level2Suggestion = level2Suggestion;
        this.level3Suggestion = level3Suggestion;
    }

    public String getName(){
        return this.name;
    }

    public String getFieldName(){
        return this.fieldName;
    }

    public double getExcellent(){
        return this.excellent;
    }

    public double getGood(){
        return this.good;
    }

    public double getPass(){
        return this.pass;
    }

    public String getLevel0Comment()
    {
        return this.level0Comment;
    }

    public String getLevel1Comment()
    {
        return this.level1Comment;
    }

    public String getLevel2Comment()
    {
        return this.level2Comment;
    }

    public String getLevel3Comment()
    {
        return this.level3Comment;
    }

    public String getLevel0Suggestion()
    {
        return this.level0Suggestion;
    }

    public String getLevel1Suggestion()
    {
        return this.level1Suggestion;
    }

    public String getLevel2Suggestion()
    {
        return this.level2Suggestion;
    }

    public String getLevel3Suggestion()
    {
        return this.level3Suggestion;
    }
}
