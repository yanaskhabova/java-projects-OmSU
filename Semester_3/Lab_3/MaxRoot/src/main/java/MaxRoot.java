import yana.Quadratic;
import yana.HasNoRootsExceptoin;
import yana.IncorrectValueException;

public class MaxRoot {
    private Quadratic quadratic;

    public MaxRoot() {
        quadratic = new Quadratic();
    }

    public MaxRoot(double[] arr) throws IncorrectValueException {
        quadratic = new Quadratic(arr);
    }

    public double maxRoot() throws HasNoRootsExceptoin {
        if (quadratic.solve().length == 0) {
            throw new HasNoRootsExceptoin("Equation has no roots.");
        }
        if (quadratic.solve().length == 1) {
            return quadratic.solve()[0];
        }
        if (quadratic.solve()[0] > quadratic.solve()[1]) {
            return quadratic.solve()[0];
        }
        return quadratic.solve()[1];
    }
}
