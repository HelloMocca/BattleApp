package org.nhnnext.android.battleapp;

/**
 * Created by mocca on 2015. 8. 11..
 */

import java.util.List;
import java.util.ArrayList;

public class FieldData {
    private String fieldName;
    private String[] columns;

    public FieldData(String fieldName) {
        this(fieldName, null);
    }

    public FieldData(String fieldName, String[] columns) {
        this.fieldName = fieldName;
        this.columns = columns;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public String[] getColumns() {
        return this.columns;
    }
}
