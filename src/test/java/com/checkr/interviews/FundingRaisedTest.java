package com.checkr.interviews;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class FundingRaisedTest {

    /**
     * Rigourous Test :-)
     */
    @Test
    public void getAllRowsByOptionsGivenCompany() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");

        assertEquals(7, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void getAllRowsByOptionsGivenCity() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("city", "Tempe");

        assertEquals(3, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void getAllRowsByOptionsGivenState() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("state", "CA");

        assertEquals(873, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void getAllRowsByOptionsGivenRound() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");

        assertEquals(582, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void multipleOptions() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("round", "a");
        options.put("company_name", "Facebook");

        assertEquals(1, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void getAllRowsByOptionsNotExists() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "NotFacebook");

        assertEquals(0, FundingRaised.getAllRowsByOptions(options).size());
    }

    @Test
    public void getAllRowsByOptionsCorrectKeys() throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");

        Map<String, String> row = FundingRaised.getAllRowsByOptions(options).get(0);

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get("round"));
    }

    @Test
    public void getFirstRowByOptionsGivenCompanyName() throws IOException, NoSuchEntryException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");

        Map<String, String> row = FundingRaised.getFirstRowByOptions(options);

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Sep-04", row.get("funded_date"));
        assertEquals("500000", row.get("raised_amount"));
        assertEquals("angel", row.get("round"));
    }

    @Test
    public void getFirstRowByOptionsGivenState() throws IOException, NoSuchEntryException {
        Map<String, String> options = new HashMap<>();
        options.put("state", "CA");

        Map<String, String> row = FundingRaised.getFirstRowByOptions(options);

        assertEquals("digg", row.get("permalink"));
        assertEquals("Digg", row.get("company_name"));
        assertEquals("60", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("San Francisco", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Dec-06", row.get("funded_date"));
        assertEquals("8500000", row.get("raised_amount"));
        assertEquals("b", row.get("round"));
    }

    @Test
    public void getFirstRowByOptionsMultipleOptions() throws IOException, NoSuchEntryException {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "Facebook");
        options.put("round", "c");

        Map<String, String> row = FundingRaised.getFirstRowByOptions(options);

        assertEquals("facebook", row.get("permalink"));
        assertEquals("Facebook", row.get("company_name"));
        assertEquals("450", row.get("number_employees"));
        assertEquals("web", row.get("category"));
        assertEquals("Palo Alto", row.get("city"));
        assertEquals("CA", row.get("state"));
        assertEquals("1-Oct-07", row.get("funded_date"));
        assertEquals("300000000", row.get("raised_amount"));
        assertEquals("c", row.get("round"));
    }

    @Test
    public void getFirstRowByOptionsNotExists() {
        Map<String, String> options = new HashMap<>();
        options.put("company_name", "NotFacebook");
        options.put("round", "c");

        assertThrows(NoSuchEntryException.class, () -> FundingRaised.getFirstRowByOptions(options));
    }
}

