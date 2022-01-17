package com.danilojakob.fastcsv.util;

import com.danilojakob.fastcsv.data.DataObject;
import com.danilojakob.fastcsv.data.DataRow;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.reader.CsvRow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvToDataObjectConverter {

    public DataObject toDataObject(CsvReader csvReader) {
        List<DataRow> rows = new ArrayList<>();
        // We want ot skip the header
        boolean isHeader = true;
        for (CsvRow row : csvReader) {
            if (isHeader) {
                isHeader = false;
                continue;
            }
            List<String> fields = row.getFields();
            DataRow dataRow = new DataRow(fields.get(0), fields.get(1), fields.get(2), fields.get(3));
            rows.add(dataRow);
        }
        return new DataObject(rows);
    }
}
