public class RationalFunction implements IFunction {
    private double a;
    private double b;
    private LinearFunction numerator;
    private LinearFunction denominator;

    public RationalFunction() {
        a = 0.0;
        b = 1.0;
        this.numerator = new LinearFunction();
        this.denominator = new LinearFunction();
    }

    public RationalFunction(LinearFunction numerator, LinearFunction denominator) throws BadValueException {
        a = Math.max(numerator.getLeftBorder(), denominator.getLeftBorder());
        b = Math.min(numerator.getRightBorder(), denominator.getRightBorder());
        this.numerator = new LinearFunction(a, b, numerator.getCoefA(), numerator.getCoefB());
        this.denominator = new LinearFunction(a, b, denominator.getCoefA(), denominator.getCoefB());
    }

    public RationalFunction(double a, double b, double coefA, double coefB, double coefC, double coefD) throws BadValueException {
        if (coefA == 0 && coefC == 0) {
            throw new BadValueException("The coefficient by x cannot equal 0");
        }

        if (a > b) {
            double temp = a;
            a = b;
            b = temp;
        }
        this.a = a;
        this.b = b;
        this.numerator = new LinearFunction(a, b, coefA, coefB);
        this.denominator = new LinearFunction(a, b, coefC, coefD);
    }

    public double getLeftBorder() {
        return a;
    }

    public double getRightBorder() {
        return b;
    }

    public double value(double x) throws BadValueException {
        if (denominator.value(x) == 0) {
            throw new BadValueException("The denominator cannot equal 0");
        }
        return numerator.value(x) / denominator.value(x);
    }

    public void setNumerator(double coefA, double coefB) {
        numerator.setCoefA(coefA);
        numerator.setCoefB(coefB);
    }

    public void setDenominator(double coefC, double coefD) {
        numerator.setCoefA(coefC);
        numerator.setCoefB(coefD);
    }

    public double getCoefA() {
        return numerator.getCoefA();
    }

    public double getCoefB() {
        return numerator.getCoefB();
    }

    public double getCoefC() {
        return denominator.getCoefA();
    }

    public double getCoefD() {
        return denominator.getCoefB();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RationalFunction)) return false;

        RationalFunction that = (RationalFunction) o;

        if (Double.compare(that.a, a) != 0) return false;
        if (Double.compare(that.b, b) != 0) return false;
        if (!numerator.equals(that.numerator)) return false;
        return denominator.equals(that.denominator);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(a);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(b);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numerator.hashCode();
        result = 31 * result + denominator.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + a + ", " +
                b + "]\n" +
                "f(x) = " + numerator.getCoefA() + "*x + " +
                numerator.getCoefB() + " / " + denominator.getCoefA() + "*x + " + denominator.getCoefB();
    }
}
