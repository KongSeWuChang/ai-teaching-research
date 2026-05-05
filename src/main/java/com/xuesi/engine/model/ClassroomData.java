package com.xuesi.engine.model;

import java.util.Map;
import java.util.HashMap;

public class ClassroomData {
    private double participationRate;
    private double headUpRate;
    private double behaviorActivityRate;
    private Map<String, Double> extraData = new HashMap<>();

    public ClassroomData(double participationRate, double headUpRate, double behaviorActivityRate) {
        this.participationRate = participationRate;
        this.headUpRate = headUpRate;
        this.behaviorActivityRate = behaviorActivityRate;
    }

    public void putExtraData(String fieldName, Double fieldValue){
        extraData.put(fieldName, fieldValue);
    }

    public double getParticipationRate() {
        return participationRate;
    }
    public double getHeadUpRate() {
        return headUpRate;
    }
    public double getBehaviorActivityRate() {
        return behaviorActivityRate;
    }

    public double getValue(String fieldName){
        switch(fieldName){
            case "participationRate":
                return this.participationRate;
            case "headUpRate":
                return this.headUpRate;
            case "behaviorActivityRate":
                return this.behaviorActivityRate;
            default:
                if(extraData.containsKey(fieldName)){
                    return extraData.get(fieldName);
                }
                throw new RuntimeException("未知字段：" + fieldName);
        }
    }

    public void setValue(String fieldName,double fieldValue){
        switch(fieldName){
            case "participationRate":
                this.participationRate = fieldValue;
                break;
            case "headUpRate":
                this.headUpRate = fieldValue;
                break;
            case "behaviorActivityRate":
                this.behaviorActivityRate = fieldValue;
                break;
            default:
                extraData.put(fieldName, fieldValue);
        }
    }
}
