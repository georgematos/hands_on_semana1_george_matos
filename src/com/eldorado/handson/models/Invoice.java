package com.eldorado.handson.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Invoice {
    private String companyName;
    private short month;
    private short year;
    private double value;
    private String emissionDate;
    private String invoiceNumber;

    public Invoice() {}

    public Invoice(String companyName, short month, short year, double value, String emissionDate, String invoiceNumber) {
        this.companyName = companyName;
        this.month = month;
        this.year = year;
        this.value = value;
        this.emissionDate = emissionDate;
        this.invoiceNumber = invoiceNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public short getMonth() {
        return month;
    }

    public void setMonth(short month) {
        this.month = month;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getEmissionDate() {
        return emissionDate;
    }

    public void setEmissionDate(String emissionDate) {
        this.emissionDate = emissionDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return month == invoice.month && year == invoice.year && Double.compare(invoice.value, value) == 0 && Objects.equals(companyName, invoice.companyName) && Objects.equals(emissionDate, invoice.emissionDate) && Objects.equals(invoiceNumber, invoice.invoiceNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyName, month, year, value, emissionDate, invoiceNumber);
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "companyName='" + companyName + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", value=" + value +
                ", emissionDate='" + emissionDate + '\'' +
                ", invoiceNumber='" + invoiceNumber + '\'' +
                '}';
    }
}
