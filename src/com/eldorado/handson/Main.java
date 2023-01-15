package com.eldorado.handson;

import com.eldorado.handson.models.Company;
import com.eldorado.handson.models.Invoice;
import com.eldorado.handson.utils.ConvertToTypeList;
import com.eldorado.handson.utils.ReadFileUtil;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        final Logger LOGGER = Logger.getLogger(ReadFileUtil.class.getName());
        final Scanner SCANNER = new Scanner(System.in);
        ReadFileUtil readerUtilComp = new ReadFileUtil();
        ReadFileUtil readerUtilInv = new ReadFileUtil();
        ConvertToTypeList convert = new ConvertToTypeList();

        List<String> linesFaturamento = readerUtilComp.readFile("src/com/eldorado/handson/resources/faturamento.txt");
        List<String> linesNota = readerUtilInv.readFile("src/com/eldorado/handson/resources/nota.txt");
        List<Company> companies = convert.convertCompany(linesFaturamento);
        List<Invoice> invoices = convert.convertInvoice(linesNota);

        Map <String, Map<Short, List<Company>>> companiesGroupedBy = companies.parallelStream()
                        .collect(Collectors.groupingBy(Company::getName, Collectors.groupingBy(Company::getYear)));
        while (true) {
            System.out.println("Press:\n1 to show annual value paid to each company \n2 to show annual value paid per installment to each company \n3 to exit");
            var option = SCANNER.nextLine();

            if (Objects.equals(option, "1")) {
                companiesGroupedBy.entrySet().stream().forEach(byName -> {
                    System.out.println("Company: " + byName.getKey());
                    byName.getValue().entrySet().stream().forEach(byYear -> {
                        System.out.println("Year: " + byYear.getKey());
                        double total = byYear.getValue().stream().collect(Collectors.summarizingDouble(
                                Company::getTotalInstalmments
                        )).getSum();
                        System.out.println("Total: " + total);
                    });
                });
            } else if (Objects.equals(option, "2")) {
                companiesGroupedBy.entrySet().stream().forEach(byName -> {
                    System.out.println("Company: " + byName.getKey());
                    byName.getValue().entrySet().stream().forEach(byYear -> {
                        System.out.println("Year: " + byYear.getKey());
                        double total1 = byYear.getValue().stream().collect(Collectors.summarizingDouble(Company::getInstallment1)).getSum();
                        double total2 = byYear.getValue().stream().collect(Collectors.summarizingDouble(Company::getInstallment2)).getSum();
                        double total3 = byYear.getValue().stream().collect(Collectors.summarizingDouble(Company::getInstallment3)).getSum();
                        System.out.println("Total Installment 1: " + total1);
                        System.out.println("Total Installment 2: " + total2);
                        System.out.println("Total Installment 3: " + total3);
                    });
                });
            } else if (Objects.equals(option, "3")) {
                break;
            } else {
                LOGGER.info("Wrong value!");
            }
        }
    }
}