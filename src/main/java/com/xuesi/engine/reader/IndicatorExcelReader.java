package com.xuesi.engine.reader;

import com.xuesi.engine.model.Indicator;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.util.List;
import java.util.ArrayList;

public class IndicatorExcelReader {
    public List<Indicator> read(String filePath){
        List<Indicator> indicators = new ArrayList<>();

        try(FileInputStream fis = new FileInputStream(filePath);
            Workbook workbook = WorkbookFactory.create(fis)){

            Sheet sheet = workbook.getSheetAt(0);
            for( int i = 1; i <= sheet.getLastRowNum(); i++)
            {
                Row row = sheet.getRow(i);
                if(row == null) continue;

                String name = getString(row,0);
                String fieldName = getString(row,1);

                if(name.isEmpty() || fieldName.isEmpty()){
                    continue;
                }
                double excellent = getDouble(row, 2);
                double good = getDouble(row, 3);
                double pass = getDouble(row, 4);
                String level3Comment = getString(row,5);
                String level2Comment = getString(row,6);
                String level1Comment = getString(row,7);
                String level0Comment = getString(row,8);
                String level3Suggestion = getString(row,9);
                String level2Suggestion = getString(row,10);
                String level1Suggestion = getString(row,11);
                String level0Suggestion = getString(row,12);

                Indicator indicator = new Indicator(name, fieldName, excellent, good, pass,
                        level0Comment,level0Suggestion,
                        level1Comment,level1Suggestion,
                        level2Comment,level2Suggestion,
                        level3Comment,level3Suggestion);

                indicators.add(indicator);
            }
        }catch(Exception e){
            throw new RuntimeException("读取指标Excel失败：" + filePath, e);
        }
        return indicators;
    }

    private String getString(Row row, int index)
    {
        Cell cell = row.getCell(index);
        if(cell == null){
            return "";
        }
        DataFormatter formatter = new DataFormatter();
        return formatter.formatCellValue(cell);
    }

    private double getDouble(Row row, int index){
        Cell cell = row.getCell(index);
        if(cell == null) {
            return 0;
        }
        return cell.getNumericCellValue();
    }
}
