public interface IFunction {
    double value(double x) throws BadValueException;
    double getLeftBorder();
    double getRightBorder();
}