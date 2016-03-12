package mx.mobilestudio.buscadornoticias.dto;

import java.util.ArrayList;

/**
 * Created by CGUZMANM01 on 8/22/15.
 */
public class ResponseData {

    private ArrayList<Result> results;
    private Cursor cursor;

    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    public Cursor getCursor() {
        return cursor;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }
}
