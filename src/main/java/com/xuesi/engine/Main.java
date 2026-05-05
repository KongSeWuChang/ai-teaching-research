package com.xuesi.engine;

import com.xuesi.engine.model.ClassroomData;
import com.xuesi.engine.model.Indicator;
import com.xuesi.engine.reader.IndicatorExcelReader;
import com.xuesi.engine.service.ReportService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        IndicatorExcelReader reader = new IndicatorExcelReader();
        List<Indicator> indicators = reader.read(
                IndicatorExcelReader.class
                        .getClassLoader()
                        .getResource("indicators.xlsx")
                        .getPath());

        // 测试数据来源：课堂观察分析报告《单式折线统计图》
        // 课堂时间：2026-04-10 10:03 - 10:47
        // 班级：2021五一班
        // 当前用于验证 v0.1 诊断报告生成功能
        ClassroomData data = new ClassroomData(84.7, 74.6, 12.3);
        data.putExtraData("highLevelQuestionRate",32.0);
        data.putExtraData("longAnswerRate", 41.5);
        data.putExtraData("groupLearningRate", 18.0);

        ReportService reportService = new ReportService();
        String report = reportService.generateReport(indicators, data);
        System.out.println(report);
    }
}
