package com.omsu.imit.payment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FinanceReport {
    private Payment[] arrayPayment;

    public FinanceReport(int size) {
        arrayPayment = new Payment[size];
        for (int i = 0; i < size; i++) {
            arrayPayment[i] = new Payment();
        }
    }

    // получение количества платежей
    public int lengthArrayPayment() {
        return arrayPayment.length;
    }

    //получить i-ый платеж
    public Payment getPayment(int index) {
        if (index > arrayPayment.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return arrayPayment[index];
    }

    //изменить i-ый платеж
    public void setPayment(int index, Payment payment) {
        if (index > arrayPayment.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        arrayPayment[index] = new Payment(payment);
    }

    //ввод из потока
    public void reader(InputStream is) throws IOException, BadDateParamException, NegativeValueException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String buffer;
            List<Payment> list = new ArrayList<Payment>();
            for (int i = 0; reader.ready(); ++i) {

                buffer = reader.readLine();
                String[] data = buffer.split(",");
                String[] date = data[1].split("[.]");
                String[] pay = data[2].split("[0-9]+");
                int day = Integer.parseInt(date[0]);
                int month = Integer.parseInt(date[1]);
                int year = Integer.parseInt(date[2]);
                int summa = Integer.parseInt(pay[0]) * 100 + Integer.parseInt(pay[1]);
                list.add( new Payment(data[0], day, month, year, summa));
            }
            arrayPayment = new Payment[list.size()];
        } catch (FileNotFoundException e) {
            e.getMessage();
        }
    }

    // вывод в поток
    public void writeToStream(OutputStream os) throws IOException {
        for (int i = 0; i < arrayPayment.length; i++) {
            String str = String.format("%1s %2$d.%3$d.%4$d %5$d RUB %6$d kop\n",
                    arrayPayment[i].getFullName(),
                    arrayPayment[i].getDay(),
                    arrayPayment[i].getMonth(),
                    arrayPayment[i].getYear(),
                    arrayPayment[i].getPay() / 100,
                    arrayPayment[i].getPay() % 100);
            os.write(str.getBytes());
        }
    }

    // вывод в поток информации о платежах всех людей, чья фамилия начинается на указанный символ
    public void filterByLastName(char chr, OutputStream os) throws IOException {
        for (int i = 0; i < arrayPayment.length; ++i) {
            if (arrayPayment[i] != null) {
                char[] arr = arrayPayment[i].getFullName().toCharArray();
                if (arr[0] == chr) {
                    Payment p = arrayPayment[i];
                    String str = String.format("%1s %2$d.%3$d.%4$d %5$d RUB %6$d kop\n",
                            p.getFullName(), p.getDay(), p.getMonth(), p.getYear(), p.getPay() / 100, p.getPay() % 100);
                    os.write(str.getBytes());
                }
            }
        }
    }

    // конструктор копирования
    public FinanceReport(FinanceReport other) {
        arrayPayment = new Payment[other.arrayPayment.length];
        for (int i = 0; i < other.arrayPayment.length; ++i) {
            arrayPayment[i] = new Payment();
            arrayPayment[i].setFullName(other.arrayPayment[i].getFullName());
            arrayPayment[i].setDay(other.arrayPayment[i].getDay());
            arrayPayment[i].setMonth(other.arrayPayment[i].getMonth());
            arrayPayment[i].setYear(other.arrayPayment[i].getYear());
            arrayPayment[i].setPay(other.arrayPayment[i].getPay());
        }
    }

    //вывод в поток всех платежей, размер которых меньше заданной величины(sum)
    public void allMinPayment(int sum, OutputStream os) throws IOException {
        for (int i = 0; i < arrayPayment.length; ++i) {
            if (arrayPayment[i] == null) {
                continue;
            }
            if (arrayPayment[i].getPay() < sum) {
                Payment p = arrayPayment[i];
                String str = String.format("%1s %2$d.%3$d.%4$d %5$d RUB %6$d kop\n",
                        p.getFullName(), p.getDay(), p.getMonth(), p.getYear(), p.getPay() / 100, p.getPay() % 100);
                os.write(str.getBytes());
            }
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < arrayPayment.length; ++i) {
            return i + " " + arrayPayment[i];
        }
        return null;
    }
}