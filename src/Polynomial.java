/**
 * This interface defines an ADT linked list that represents a polynomial.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public interface Polynomial {

  /**
   * Takes a coefficient and a power and adds the resulting term to the polynomial.
   *
   * @param coefficient the coefficient of the term
   * @param power       the power to which this term is raised
   * @throws IllegalArgumentException if a negative power is passed to it
   */
  void addTerm(int coefficient, int power) throws IllegalArgumentException;

  /**
   * Takes a power and removes any terms in the polynomial with that power.
   *
   * @param power the power to remove
   * @throws IllegalArgumentException if a negative power is passed to it
   */
  void removeTerm(int power) throws IllegalArgumentException;

  /**
   * Returns the degree of this polynomial.
   *
   * @return the degree of this polynomial
   */
  int getDegree();

  /**
   * Returns the coefficient for the term with the specified power.
   *
   * @param power the power of the term to find
   * @return the coefficient of the term with the specified power
   * @throws IllegalArgumentException if a negative power is passed to it
   */
  int getCoefficient(int power) throws IllegalArgumentException;

  /**
   * Evaluates the polynomial at the given value.
   *
   * @param number the given value to evaluate
   * @return the evaluated polynomial value
   */
  double evaluate(double number);

  /**
   * Takes another polynomial object and returns the polynomial obtained by adding the two
   * polynomials.
   *
   * @param other the other Polynomial to addTerm
   * @return a new Polynomial representing the sum of both Polynomials
   * @throws IllegalArgumentException if other is of a different concrete class than this
   */
  Polynomial add(Polynomial other) throws IllegalArgumentException;
}
