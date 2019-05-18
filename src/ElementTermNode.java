/**
 * This class represents the node of a term with a coefficient and power in a Polynomial linked
 * list.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public class ElementTermNode implements TermNode {

  /**
   * Represents the coefficient of this term.
   */
  private Term data;
  /**
   * Represents the next node this node links to.
   */
  private TermNode nextNode;

  /**
   * Creates a new ElementTermNode from a Term and reference to the next node in the list.
   *
   * @param data     the Term of this node
   * @param nextNode the next node this node links to
   * @throws IllegalArgumentException if either parameter is null
   */
  public ElementTermNode(Term data, TermNode nextNode) throws IllegalArgumentException {
    if (data == null || nextNode == null) {
      throw new IllegalArgumentException("Data or next node cannot be null.");
    }
    this.data = data;
    this.nextNode = nextNode;
  }

  @Override
  public TermNode addTerm(Term other) {

    // if other term is greater than this term
    if (other.compareTo(this.data) > 0) {
      // create the term here
      return new ElementTermNode(other, this);
    } else if (other.compareTo(this.data) == 0) {
      // terms have same power, should be simplified
      return new ElementTermNode(this.data.add(other), this.nextNode);
    } else {
      // new term should be added later on
      nextNode = nextNode.addTerm(other);
      return this;
    }
  }

  @Override
  public TermNode add(TermNode other) {
    if (other instanceof ElementTermNode) {
      ElementTermNode otherCast = (ElementTermNode) other;

      if (otherCast.data.compareTo(this.data) > 0) {
        // add the new other node here

        return new ElementTermNode(otherCast.data, otherCast.nextNode.add(this));

      } else if (otherCast.data.compareTo(this.data) == 0) {

        // simplify the terms
        return new ElementTermNode(this.data.add(otherCast.data),
                otherCast.nextNode.add(this.nextNode));

      } else {
        // needs to be added further down the line
        return new ElementTermNode(this.data, this.nextNode.add(other));
      }

    } else {
      return new ElementTermNode(this.data, this.nextNode.add(other));
      //return this.clone();
    }
  }

  @Override
  public TermNode remove(Term toRemove) {

    // power of this term is same as other term
    if (toRemove.compareTo(this.data) == 0) {
      return this.nextNode.remove(toRemove);

      // power of term to remove is greater than this term, meaning we don't need to recurse
    } else if (toRemove.compareTo(this.data) > 0) {
      return this;

    } else {
      this.nextNode =  this.nextNode.remove(toRemove);
      return this;
    }
  }

  @Override
  public int getDegree() {
    return this.data.getPower();
  }

  @Override
  public int getCoefficient(Term other) {
    if (other.compareTo(this.data) == 0) {
      return this.data.getCoefficient();
    } else {
      return this.nextNode.getCoefficient(other);
    }
  }

  @Override
  public double evaluate(double number) {
    return this.data.evaluate(number) + this.nextNode.evaluate(number);
  }

  @Override
  public String toString() {
    return this.data.toString() + " " + this.nextNode.toString();
  }
}
