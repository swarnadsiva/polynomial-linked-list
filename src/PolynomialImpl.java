import java.util.Scanner;

/**
 * This class implements behavior of the Polynomial interface.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public class PolynomialImpl implements Polynomial {

  /**
   * Represents the first term in this linked list.
   */
  private TermNode head;

  /**
   * Default constructor that represents a Polynomial with no terms (the polynomial 0).
   */
  public PolynomialImpl() {
    head = new EmptyTermNode();
  }

  /**
   * Creates a Polynomial from a string representation.
   *
   * @param strPolynomial string representation of the polynomial to create
   */
  public PolynomialImpl(String strPolynomial) throws IllegalArgumentException {
    this();

    Scanner reader = new Scanner(strPolynomial);

    while (reader.hasNext()) {
      try {
        String current = reader.next();

        if (!isZeroTerm(current)) {
          Term newTerm = new Term(current);
          this.addTerm(newTerm.getCoefficient(), newTerm.getPower());
        }

      } catch (NumberFormatException e) {
        // invalid format
        throw new IllegalArgumentException("String polynomial is not in correct format.");
      }
    }
  }

  /**
   * Private constructor that creates a Polynomial from a specified head.
   *
   * @param head the TermNode that is the head of the Polynomial
   */
  private PolynomialImpl(TermNode head) {
    this.head = head;
  }

  /**
   * Returns a string representation of this Polynomial.
   *
   * @return a string representation of this polynomial
   */
  @Override
  public String toString() {
    String strPolynomial = head.toString().trim();
    if (!strPolynomial.isEmpty()) {
      if (strPolynomial.charAt(0) == '+') {
        // remove first +
        strPolynomial = strPolynomial.substring(1);
      }
    } else {
      strPolynomial = "0";
    }
    return strPolynomial;
  }

  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power of terms cannot be negative in this Polynomial.");
    }
    if (coefficient != 0) {
      head = head.addTerm(new Term(coefficient, power));
    }
  }

  @Override
  public void removeTerm(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power of terms cannot be negative in this Polynomial.");
    }
    head = head.remove(new Term(1, power));
  }

  @Override
  public int getDegree() {
    return head.getDegree();
  }

  @Override
  public int getCoefficient(int power) throws IllegalArgumentException {
    if (power < 0) {
      throw new IllegalArgumentException("Power of terms cannot be negative in this Polynomial.");
    }
    return head.getCoefficient(new Term(1, power));
  }

  @Override
  public double evaluate(double number) {
    return head.evaluate(number);
  }

  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException(
              "Cannot addTerm invalid Polynomial type to this Polynomial.");
    }

    PolynomialImpl otherCast = (PolynomialImpl) other;
    TermNode resultHead = head.add(otherCast.head);
    return new PolynomialImpl(resultHead);
  }

  /**
   * Determines if the specified string equates to a 0 integer value.
   *
   * @param current the string to evaluate
   * @return true if the string is 0, false if not
   */
  private boolean isZeroTerm(String current) {
    boolean result = false;
    try {
      // try to parse 0 from the string
      if (Integer.parseInt(current) == 0) {
        result = true;
      }
    } catch (NumberFormatException e) {
      // the term is not zero since it could not be parsed
      result = false;
    }
    return result;
  }
}
