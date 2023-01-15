package com.eldorado.handson.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Company {
    private String name;
    private short month;
    private short year;
    private String installmentDate1;
    private double installment1;
    private String installmentDate2;
    private double installment2;
    private String installmentDate3;
    private double installment3;

    public Company() {}

    public Company(String name, short month, short year, String installmentDate1, double installment1,
                   String installmentDate2, double installment2, String installmentDate3, double installment3) {
        this.name = name;
        this.month = month;
        this.year = year;
        this.installmentDate1 = installmentDate1;
        this.installment1 = installment1;
        this.installmentDate2 = installmentDate2;
        this.installment2 = installment2;
        this.installmentDate3 = installmentDate3;
        this.installment3 = installment3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getInstallment1() {
        return installment1;
    }

    public void setInstallment1(double installment1) {
        this.installment1 = installment1;
    }

    public double getInstallment2() {
        return installment2;
    }

    public void setInstallment2(double installment2) {
        this.installment2 = installment2;
    }

    public double getInstallment3() {
        return installment3;
    }

    public void setInstallment3(double installment3) {
        this.installment3 = installment3;
    }

    public String getInstallmentDate1() {
        return installmentDate1;
    }

    public void setInstallmentDate1(String installmentDate1) {
        this.installmentDate1 = installmentDate1;
    }

    public String getInstallmentDate2() {
        return installmentDate2;
    }

    public void setInstallmentDate2(String installmentDate2) {
        this.installmentDate2 = installmentDate2;
    }

    public String getInstallmentDate3() {
        return installmentDate3;
    }

    public void setInstallmentDate3(String installmentDate3) {
        this.installmentDate3 = installmentDate3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return month == company.month && year == company.year && Double.compare(company.installment1, installment1) == 0
                && Double.compare(company.installment2, installment2) == 0 && Double.compare(company.installment3,
                installment3) == 0 && Objects.equals(name, company.name) && Objects.equals(installmentDate1,
                company.installmentDate1) && Objects.equals(installmentDate2, company.installmentDate2) &&
                Objects.equals(installmentDate3, company.installmentDate3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, month, year, installment1, installment2, installment3, installmentDate1,
                installmentDate2, installmentDate3);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", installmentDate1='" + installmentDate1 + '\'' +
                ", installment1=" + installment1 +
                ", installmentDate2='" + installmentDate2 + '\'' +
                ", installment2=" + installment2 +
                ", installmentDate3='" + installmentDate3 + '\'' +
                ", installment3=" + installment3 +
                '}';
    }

    public double getTotalInstalmments() {
        return installment1 + installment2 + installment3;
    }
}
