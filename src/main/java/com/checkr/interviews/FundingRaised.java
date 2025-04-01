package com.checkr.interviews;

import java.util.*;

import com.checkr.interviews.services.FindAllService;
import com.checkr.interviews.services.MappingRow;

import java.io.IOException;

public class FundingRaised {
    private static final String[] keys = {"company_name", "city", "state", "round"};
    private static final Map<String, Integer> CSVFields = Map.of(
            "company_name", 1,
            "city", 4,
            "state", 5,
            "round", 9
    );
    public static List<Map<String, String>> getAllRowsByOptions(Map<String, String> options) throws IOException {
        List<String[]> data = CSVData.getData();


        for (String key : keys) {
            if(options.containsKey(key)) {
                data = FindAllService.getRows(data, key, options.get(key));
            }
        }

        List<Map<String, String>> result = new ArrayList<>();

        for(String[] row : data) {
            result.add(MappingRow.getMappingRow(row));
        }

        return result;
    }

    public static Map<String, String> getFirstRowByOptions(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> data = CSVData.getData();
        Map<String, String> result = new HashMap<> ();
        boolean find;

        for (String[] row : data) {
            find = true;
            for (String key : keys) {
                if(options.containsKey(key)){
                    if(row[CSVFields.get(key)].equals(options.get(key))) {
                        result = MappingRow.getMappingRow(row);
                    }
                    else {
                        find = false;
                        break;
                    }
                }
            }
            if (find) {
                System.out.println(result);
                return result;
            }
        }

        throw new NoSuchEntryException();
    }
}

