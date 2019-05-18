/**
 * Represents a Term in a Polynomial.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public class Term implements Comparable<Term> {

  /**
   * Constant representing "x" in this one-variable Term.
   */
  public static final String VARIABLE = "x^";

  /**
   * The coefficient of this term.
   */
  private int coefficient;

  /**
   * The power of this term.
   */
  private int power;

  /**
   * Creates a new term from the specified coefficient and power.
   *
   * @param coefficient the coefficient of this term
   * @param power       the power of this term
   */
  public Term(int coefficient, int power) {
    this.power = power;
    this.coefficient = coefficient;
  }

  /**
   * Creates a new term from the specified string version of the term.
   *
   * @param strTerm string version of the term to create
   */
  public Term(String strTerm) {
    if (strTerm.contains(VARIABLE)) {

      strTerm = strTerm.replace(VARIABLE, " ").trim();
      String[] termInfo = strTerm.split(" ");

      if (termInfo.length > 1) {
        // handle special cases -1 and +1 coefficient
        if (termInfo[0].equals("-")) {
          coefficient = -1;
        } else if (termInfo[0].equals("+")) {
          coefficient = 1;
        } else {
          coefficient = Integer.parseInt(termInfo[0]);
        }
        power = Integer.parseInt(termInfo[1]);
      } else {
        // just power with coefficient of 1 (ex: 1x^2 = x^2)
        power = Integer.parseInt(termInfo[0]);
        coefficient = 1;
      }

    } else {
      // does not contain a variable, is just a coefficient with power of 0 (ex: 5x^0 = 5 * 1 = 5)
      coefficient = Integer.parseInt(strTerm);
      power = 0;
    }
  }

  /**
   * Evaluates the result of this Term according to a specific value.
   *
   * @param x the value to evaluate this Term
   * @return the result of this evaluated Term
   */
  public double evaluate(double x) {
    return this.coefficient * Math.pow(x, this.power);
  }

  /**
   * Adds this Term to another.
   *
   * @param other other Term to addTerm
   * @return the sum of the Terms
   * @throws IllegalArgumentException if the two Terms are not of the same concrete class or if
   *                                  powers of the two terms are not equal
   */
  public Term add(Term other) throws IllegalArgumentException {
    if (this.power != other.power) {
      throw new IllegalArgumentException("Cannot addTerm two terms of different powers.");
    }
    return new Term(this.coefficient + other.coefficient, this.power);
  }

  /**
   * Returns the coefficient of this Term.
   *
   * @return the coefficient of this Term
   */
  public int getCoefficient() {
    return this.coefficient;
  }

  /**
   * Returns the power of this Term.
   *
   * @return the power of this term
   */
  public int getPower() {
    return this.power;
  }

  @Override
  public int compareTo(Term o) {
    if (this.power > o.power) {
      return 1;
    } else if (this.power < o.power) {
      return -1;
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    String sign = this.coefficient > 0 ? "+" : "-";
    String strPower = this.power > 0 ? VARIABLE + this.power : "";
    String strCoefficient = Math.abs(this.coefficient) > 1 ? "" + Math.abs(this.coefficient) : "";

    return sign + strCoefficient + strPower;
  }
}
