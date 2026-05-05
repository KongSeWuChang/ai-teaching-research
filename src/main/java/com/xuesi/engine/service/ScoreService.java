package com.xuesi.engine.service;

import com.xuesi.engine.model.ClassroomData;
import com.xuesi.engine.model.Indicator;
import com.xuesi.engine.model.ScoreResult;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ScoreService {

    private int scoreByThreshold(double value, double excellent, double good, double pass){
        if(value >= excellent){
            return 3;
        } else if(value >= good){
            return 2;
        } else if(value >= pass){
            return 1;
        } else {
            return 0;
        }
    }

    public ScoreResult score(Indicator indicator, double value){
        int score = scoreByThreshold(
                value,
                indicator.getExcellent(),
                indicator.getGood(),
                indicator.getPass());

        return new ScoreResult(indicator.getName(), value, score);
    }

    public List<ScoreResult> scoreAll(List<Indicator> indicators, ClassroomData data){
        List<ScoreResult> results = new ArrayList<>();

        for(Indicator indicator: indicators)
        {
            results.add(score(indicator, data.getValue(indicator.getFieldName())));
        }

        return results;
    }

    private double getValueByFieldName(ClassroomData data, String fieldName){
        try{
            String getterName = "get"
                    + fieldName.substring(0,1).toUpperCase()
                    + fieldName.substring(1);
            Method method = ClassroomData.class.getMethod(getterName);
            Object value = method.invoke(data);
            return ((Number)value).doubleValue();
        }catch(Exception e){
            throw new RuntimeException("无法读取课堂数据字段" + fieldName,e);
        }
    }
}
