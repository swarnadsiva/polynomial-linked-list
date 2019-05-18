/**
 * This class represents a secondary concrete class that implements the Polynomial interface.
 * Its only purpose is to validate correct implementation in PolynomialImpl in the test class.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public class IncorrectPolynomialImpl implements Polynomial {
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    // do nothing
  }

  @Override
  public void removeTerm(int power) throws IllegalArgumentException {
    // do nothing
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(int power) throws IllegalArgumentException {
    return 0;
  }

  @Override
  public double evaluate(double number) {
    return 0;
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    return null;
  }
}
