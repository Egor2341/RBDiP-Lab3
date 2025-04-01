package com.checkr.interviews.services;

import java.util.*;

public class FindAllService {
    // HashMap containing the name of fields in the CSV file and their index
    private static final Map<String, Integer> CSVFields = Map.of(
            "company_name", 1,
            "city", 4,
            "state", 5,
            "round", 9
    );

    // a method that returns all rows found by a given parameter
    public static List<String[]> getRows(List<String[]> data, String parameter, String value) {
        List<String[]> results = new ArrayList<>();

        for (String[] row : data) {
            if (row[CSVFields.get(parameter)].equals(value)) {
                results.add(row);
            }
        }
        return results;
    }
}
