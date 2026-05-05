package com.xuesi.engine;

import com.xuesi.engine.model.ClassroomData;
import com.xuesi.engine.model.Indicator;
import com.xuesi.engine.model.ScoreResult;
import com.xuesi.engine.reader.IndicatorExcelReader;
import com.xuesi.engine.service.ReportService;
import com.xuesi.engine.service.ScoreService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        IndicatorExcelReader reader = new IndicatorExcelReader();
        List<Indicator> indicators = reader.read(
                IndicatorExcelReader.class
                        .getClassLoader()
                        .getResource("indicators.xlsx")
                        .getPath());

        ClassroomData data = new ClassroomData(84.7, 74.6, 12.3);
        data.putExtraData("highLevelQuestionRate",32.0);
        data.putExtraData("longAnswerRate", 41.5);
        data.putExtraData("groupLearningRate", 18.0);

        ReportService reportService = new ReportService();
        String report = reportService.generateReport(indicators, data);
        System.out.println(report);
    }
}
