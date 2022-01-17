package com.danilojakob.fastcsv;

import com.danilojakob.fastcsv.data.DataObject;
import com.danilojakob.fastcsv.data.DataRow;
import com.danilojakob.fastcsv.util.CsvToDataObjectConverter;
import de.siegmar.fastcsv.reader.CsvReader;
import de.siegmar.fastcsv.writer.CsvWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Path path = createTempCsv();
        readCsvFile(path);

    }

    private static Path createTempCsv() {
        try {
            Path path = Files.createTempFile("fastcsv-test", "csv");
            try (CsvWriter csvWriter = CsvWriter.builder().build(path)) {
                csvWriter.writeRow("Header 1", "Header 2", "Header 3", "Header 4");
                csvWriter.writeRow("Value 1", "Value 2", "Value 3", "Value 4");
                csvWriter.writeRow("Value 12", "Value 14", "Value 15", "Value 16");
            }
            return path;
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    private static void readCsvFile(Path path) {
        try {
            try (CsvReader csvReader = CsvReader.builder().build(path)) {
                CsvToDataObjectConverter converter = new CsvToDataObjectConverter();
                DataObject dataObject = converter.toDataObject(csvReader);

                for (DataRow row : dataObject.getRows()) {
                    System.out.println(row.toString());
                }
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
