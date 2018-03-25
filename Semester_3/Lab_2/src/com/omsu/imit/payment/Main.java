package com.omsu.imit.payment;

import java.io.*;

public class Main {
    static void testFinanceReport() throws BadDateParamException, NegativeValueException {
        Payment newPayment = new Payment("Алабанов Алабан Алабаевич", 9, 12, 14, 706354);
        Payment newPayment1 = new Payment("Алабенян Алабэн Аланидзе", 22, 1, 14, 7063);
        Payment newPayment2 = new Payment("Алабекян Алон Алонян", 5, 5, 11, 766354);
        Payment newPayment3 = new Payment("Аликов Алан Алькюзорян", 4, 10, 24, 321354);
        Payment newPayment4 = new Payment("Алонов Азазар Арович", 30, 2, 7, 842354);
        Payment newPayment5 = new Payment("Алоднин Алон Алононов", 9, 6, 4, 455424);
        FinanceReport report = new FinanceReport(6);
        report.setPayment(0, newPayment);
        report.setPayment(1, newPayment1);
        report.setPayment(2, newPayment2);
        report.setPayment(3, newPayment3);
        report.setPayment(4, newPayment4);
        report.setPayment(5, newPayment5);
        System.out.println();
        try {
            System.out.println("        Информация о платежах всех людей, чья фамилия начинается на указанный символ");
            report.filterByLastName('А', System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        try {
            System.out.println("        Вывод всех платежей, размер которых меньше заданной величины");
            report.allMinPayment(77000, System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        FinanceReport newReport = new FinanceReport(report);
        Payment payment6 = new Payment("Алов Ал Алолович", 19, 11, 15, 706414);
        report.setPayment(3, payment6);
        try {
            report.writeToStream(System.out);
            System.out.println();
            newReport.writeToStream(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTestFile() throws BadDateParamException, NegativeValueException {
        try {
            Payment newPayment = new Payment("Алабанов Алабан Алабаевич", 9, 12, 14, 995354);
            Payment newPayment1 = new Payment("Алабенян Алабэн Аланидзе", 22, 1, 14, 964354);
            Payment newPayment2 = new Payment("Алабекян Алон Алонян", 5, 5, 11, 835354);
            Payment newPayment3 = new Payment("Аликов Алан Алькюзорян", 4, 10, 24, 456354);
            Payment newPayment4 = new Payment("Алонов Азазар Арович", 28, 2, 7, 479854);
            Payment newPayment5 = new Payment("Алоднин Алон Алононов", 9, 6, 4, 325424);
            FinanceReport report = new FinanceReport(6);
            report.setPayment(0, newPayment);
            report.setPayment(1, newPayment1);
            report.setPayment(2, newPayment2);
            report.setPayment(3, newPayment3);
            report.setPayment(4, newPayment4);
            report.setPayment(5, newPayment5);

            FileOutputStream outputReport = new FileOutputStream("file");
            report.writeToStream(outputReport);
        } catch (IOException | BadDateParamException | NegativeValueException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws BadDateParamException, NegativeValueException {
        try {
            writeTestFile();

            testFinanceReport();
        } catch (BadDateParamException | NegativeValueException e) {
            e.getMessage();
        }
    }
}
