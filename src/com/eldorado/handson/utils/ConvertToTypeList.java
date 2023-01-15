package com.eldorado.handson.utils;

import com.eldorado.handson.models.Company;
import com.eldorado.handson.models.Invoice;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ConvertToTypeList {
    private StringConverter converter = new StringConverter();
    private final Logger LOGGER = Logger.getLogger(ReadFileUtil.class.getName());
    public List<Company> convertCompany(List<String> lines) {
        List<Company> companies = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] compArray = line.split(";", 9);
                Company company = new Company(
                        compArray[0],
                        Short.parseShort(compArray[1]),
                        Short.parseShort(compArray[2]),
                        compArray[3],
                        converter.convertToDouble(compArray[4]),
                        compArray[5],
                        converter.convertToDouble(compArray[6]),
                        compArray[7],
                        converter.convertToDouble(compArray[8]));
                companies.add(company);
            }
        } catch (ParseException e) {
            LOGGER.info(String.format("Error: %s", e));
        }
        return companies;
    }

    public List<Invoice> convertInvoice(List<String> lines) {
        List<Invoice> Invoices = new ArrayList<>();
        try {
            for (String line : lines) {
                String[] invArray = line.split(";", 6);

                Invoice invoice = new Invoice();
                invoice.setCompanyName(invArray[0]);
                invoice.setMonth(Short.parseShort(invArray[1]));
                invoice.setYear(Short.parseShort(invArray[2]));
                invoice.setValue(converter.convertToDouble(invArray[3]));
                invoice.setEmissionDate(invArray[4]);
                invoice.setInvoiceNumber(invArray[5]);

                Invoices.add(invoice);
            }
        } catch (ParseException e) {
            LOGGER.info(String.format("Error: %s", e));
        }
        return Invoices;
    }

}
