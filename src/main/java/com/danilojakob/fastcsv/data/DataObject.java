package com.danilojakob.fastcsv.data;

import java.util.List;

public class DataObject {

    private List<DataRow> rows;

    public DataObject(List<DataRow> rows) {
        this.rows = rows;
    }

    public List<DataRow> getRows() {
        return rows;
    }

    public void setRows(List<DataRow> rows) {
        this.rows = rows;
    }
}
