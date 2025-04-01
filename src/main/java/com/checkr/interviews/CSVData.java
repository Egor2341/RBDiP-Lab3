package com.checkr.interviews;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVData {
    private static final String filename = "startup_funding.csv";

    public static List<String[]> getData()  throws IOException {
        List<String[]> data = new ArrayList<>();
        CSVReader reader = new CSVReader(new FileReader(filename));
        String[] row;

        while((row = reader.readNext()) != null) {
            data.add(row);
        }

        reader.close();
        data.remove(0);

        return data;
    }
}
