/**
 * This class represents the node of an empty term (0) in a Polynomial linked list.
 *
 * @author Durga Sivamani
 * @version 1.0
 */
public class EmptyTermNode implements TermNode {

  @Override
  public TermNode addTerm(Term other) {
    return new ElementTermNode(other, this);
  }

  @Override
  public TermNode add(TermNode other) {
    if (other instanceof EmptyTermNode) {
      return new EmptyTermNode();
    } else {
      return other.add(this);
    }
  }

  @Override
  public TermNode remove(Term toRemove) {
    return this;
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public int getCoefficient(Term other) {
    return 0;
  }

  @Override
  public double evaluate(double number) {
    return 0;
  }

  @Override
  public String toString() {
    return "";
  }
}
