/**
 * This interface represents union data shared in empty and element nodes in a Polynomial linked
 * list.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public interface TermNode {
  /**
   * Adds and returns a new TermNode.
   *
   * @param other the new Term to add
   * @return a new TermNode representing this Term
   */
  TermNode addTerm(Term other);

  /**
   * Adds and returns a new TermNode from the specified one.
   *
   * @param other the new TermNode to add
   * @return a new TermNode representing the added terms
   */
  TermNode add(TermNode other);

  /**
   * Removes any and all Terms that compare to the specified Term.
   *
   * @param toRemove the Term to compare and determine removal
   * @return a new TermNode representing this Term
   */
  TermNode remove(Term toRemove);

  /**
   * Returns the degree of this node.
   *
   * @return the degree of this node
   */
  int getDegree();

  /**
   * Returns the coefficient of the node with the same power as the specified Term.
   *
   * @param other the Term to compare powers
   * @return the coefficient of the Term with the specified power
   */
  int getCoefficient(Term other);

  /**
   * Evaluates the result of this node according to specified values.
   *
   * @param number the value to evaluate this node
   * @return the evaluated value
   */
  double evaluate(double number);
}
