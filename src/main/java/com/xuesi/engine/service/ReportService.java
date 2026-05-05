package com.xuesi.engine.service;

import com.xuesi.engine.model.ClassroomData;
import com.xuesi.engine.model.Indicator;

import java.util.List;

public class ReportService {

    public String generateReport(List<Indicator> indicators, ClassroomData data){
        StringBuilder report = new StringBuilder();

        report.append("课堂教学智能诊断报告\n");
        report.append("=================\n\n");

        for (Indicator indicator: indicators){
            double value = data.getValue(indicator.getFieldName());
            int level = getLevel(value, indicator);

            report.append("【").append(indicator.getName()).append("】\n");
            report.append("数据值：").append(value).append("%\n");
            report.append("等级：").append(level).append("分\n");
            report.append("评价：").append(getComment(indicator, level)).append("\n");
            report.append("建议：").append(getSuggestion(indicator, level)).append("\n\n");
        }

        return report.toString();
    }

    private int getLevel(double value, Indicator indicator){
        if(value >= indicator.getExcellent()){
            return 3;
        } else if (value >= indicator.getGood()){
            return 2;
        } else if(value >= indicator.getPass()){
            return 1;
        } else {
            return 0;
        }
    }

    public String getComment(Indicator indicator, int level)
    {
        switch (level){
            case 3:
                return indicator.getLevel3Comment();
            case 2:
                return indicator.getLevel2Comment();
            case 1:
                return indicator.getLevel1Comment();
            default:
                return indicator.getLevel0Comment();
        }
    }

    public String getSuggestion(Indicator indicator, int level)
    {
        switch (level){
            case 3:
                return indicator.getLevel3Suggestion();
            case 2:
                return indicator.getLevel2Suggestion();
            case 1:
                return indicator.getLevel1Suggestion();
            default:
                return indicator.getLevel0Suggestion();
        }
    }
}
