package com.omsu.imit.payment;

public class Payment {
    private String fullName;
    private int day = 1;
    private int month = 1;
    private int year = 1999;
    private int pay;

    public Payment() {
        this.fullName = "";
        this.day = 0;
        this.month = 0;
        this.year = 0;
        this.pay = 0;
    }

    public Payment(Payment payment) {
        this.fullName = payment.fullName;
        this.day = payment.day;
        this.month = payment.month;
        this.year = payment.year;
        this.pay = payment.pay;
    }

    public Payment(String fullName, int d, int m, int y, int pay) throws BadDateParamException, NegativeValueException {
        if (!checkDay(d, m, y) || !checkMonth(m) || !checkYear(y)) {
            throw new BadDateParamException();
        }
        if (pay < 0) {
            throw new NegativeValueException();
        }
        this.day = d;
        this.month = m;
        this.year = y;
        this.pay = pay;
        this.fullName = fullName;
    }

    private static boolean checkYear(int year) {
        return (year > 0);
    }

    private static boolean checkMonth(int month) {
        return (month > 0 && month < 13);
    }

    private static boolean checkDay(int d, int m, int y) {
        if (d < 1 && d > 31) {
            return false;
        }
        int[] countDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] countDaysLeak = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return (y % 400 == 0) || (y % 4 == 0) && (y % 100 != 100) ? d <= countDaysLeak[m - 1] :
                d <= countDays[m - 1];
    }

    @Override
    public String toString() {
        return this.fullName + "," + this.day + "." + this.month + "." + this.year +
                "," + this.pay / 100 + " RUB " + this.pay % 100 + " kop ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (getDay() != payment.getDay()) return false;
        if (getMonth() != payment.getMonth()) return false;
        if (getYear() != payment.getYear()) return false;
        if (getPay() != payment.getPay()) return false;
        return getFullName().equals(payment.getFullName());
    }

    @Override
    public int hashCode() {
        int result = getFullName().hashCode();
        result = 31 * result + getDay();
        result = 31 * result + getMonth();
        result = 31 * result + getYear();
        result = 31 * result + getPay();
        return result;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPay() {
        return pay;
    }

    public void setPay(int pay) {
        this.pay = pay;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public static void main(String[] args) {
        try {
            Payment payment = new Payment("Ivanov Ivan Ivanovich", 28, 2, 2015, 2356);
            System.out.println(payment.toString());
            payment.setFullName("Skhabova Yana Mikhailovna");
            payment.setDay(1);
            payment.setMonth(10);
            payment.setYear(1997);
            payment.setPay(13557);
            System.out.println(payment);
        } catch (BadDateParamException | NegativeValueException e) {
            System.err.println(e.getMessage());
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

