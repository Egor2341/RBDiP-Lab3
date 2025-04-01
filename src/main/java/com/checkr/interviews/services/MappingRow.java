package com.checkr.interviews.services;

import java.util.HashMap;
import java.util.Map;

public class MappingRow {
    public static Map<String, String> getMappingRow(String[] row) {
        Map<String, String> result = new HashMap<>();

        result.put("permalink", row[0]);
        result.put("company_name", row[1]);
        result.put("number_employees", row[2]);
        result.put("category", row[3]);
        result.put("city", row[4]);
        result.put("state", row[5]);
        result.put("funded_date", row[6]);
        result.put("raised_amount", row[7]);
        result.put("raised_currency", row[8]);
        result.put("round", row[9]);

        return result;
    }
}
