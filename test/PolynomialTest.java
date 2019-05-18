import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * This is a JUnit test class for the Polynomial interface and derived classes.
 */
public class PolynomialTest {

  /**
   * Polynomial variable representing 0.
   */
  private Polynomial zero;

  /**
   * Polynomial variable with two terms.
   */
  private Polynomial twoTerms;

  /**
   * Polynomial variable with one term.
   */
  private Polynomial oneTerm;

  /**
   * Polynomial variable with three terms, coefficient of 1.
   */
  private Polynomial oneCoefficient;

  /**
   * Polynomial variable with four terms.
   */
  private Polynomial fourTerms;

  /**
   * Polynomial with zero coefficient.
   */
  private Polynomial zeroCoefficient;

  /**
   * Polynomial with -1 coefficient.
   */
  private Polynomial negativeOneCoefficient;

  /**
   * Crazy long Polynomial.
   */
  private Polynomial crazyLong1;

  /**
   * Crazy long Polynomial.
   */
  private Polynomial crazyLong2;

  private Polynomial fuckingTest;

  /**
   * Sets up variables for testing.
   */
  @Before
  public void setUp() {
    /*
     * Term with power of 0
     * Term with power > 0
     * terms that need to be simplified
     */
    zero = new PolynomialImpl();
    twoTerms = new PolynomialImpl("4x^1 -8x^2 +3x^2");
    oneTerm = new PolynomialImpl("15x^4");
    oneCoefficient = new PolynomialImpl("x^1 -5x^6 +2");
    fourTerms = new PolynomialImpl("3x^4 -5x^3 +2x^1 -4");
    zeroCoefficient = new PolynomialImpl("0 +9");
    negativeOneCoefficient = new PolynomialImpl("-x^7 -8x^1");
    crazyLong1 = new PolynomialImpl("73x^197 -95x^196 -60x^195 +154x^193 +20x^191 -54x^187 "
            + "+76x^178 -19x^174 +96x^172 +24x^169 +41x^168 -51x^166 +94x^165 -91x^163 +53x^161 "
            + "+184x^160 -23x^157 +87x^155 -46x^152 -40x^151 +64x^150 +51x^149 -148x^147 +228x^146 "
            + "+26x^145 +83x^142 +51x^141 +61x^140 -80x^133 +98x^131 +36x^130 -14x^127 +49x^125 "
            + "-74x^123 -53x^122 +33x^118 +30x^117 +32x^116 +10x^108 +47x^107 -7x^105 +158x^103 "
            + "-89x^101 +14x^100 +53x^98 -24x^96 -32x^95 -11x^94 +89x^91 -170x^89 +18x^85 +43x^80 "
            + "+180x^79 +55x^76 -41x^75 -x^72 +41x^68 -65x^67 -51x^66 -92x^65 -55x^61 +21x^51 "
            + "+10x^50 -45x^49 -41x^48 +180x^46 -74x^45 -67x^44 +34x^42 +98x^41 -12x^32 -78x^31 "
            + "-55x^29 -75x^28 -38x^24 -15x^23 -61x^21 -56x^17 +74x^15 +67x^12 -47x^10 +52x^7 "
            + "-9x^2");
    crazyLong2 = new PolynomialImpl(
            "192x^197 +43x^195 -46x^194 +26x^193 +82x^187 -52x^179 +81x^176 +16x^174 +60x^171 "
                    + "+96x^168 +176x^165 +20x^161 -24x^158 +19x^157 -6x^153 +93x^151 -29x^149 "
                    + "+97x^146 +50x^144 +88x^143 -46x^141 -39x^138 +75x^137 -88x^128 "
                    + "-70x^120 +12x^112  +132x^111 +33x^109 -61x^107 -52x^106 -7x^105 +14x^104 "
                    + "-196x^101 -72x^95 -279x^93 -248x^88 +82x^87 +176x^85 -33x^78 -22x^76 "
                    + "+21x^75 +194x^73 +66x^70 +51x^69 +55x^68 -84x^66 -84x^65 -16x^59 -3x^58 "
                    + "-100x^56 -76x^54 -84x^53 +91x^50 +56x^45 -124x^44 +12x^43 +93x^41 +26x^40 "
                    + "+51x^36 -23x^33 +52x^28 +16x^26 +36x^25 -85x^23 -142x^19 -12x^17 -16x^13 "
                    + "+62x^12 +144x^11 +19x^9 -44x^8 -12x^3 -34x^2 -50");
    fuckingTest = new PolynomialImpl("+55x^2");
  }

  /**
   * Tests the variables were set up correctly by the constructor.
   */
  @Test
  public void testConstructors() {
    assertEquals("-5x^2 +4x^1", twoTerms.toString());
    assertEquals("15x^4", oneTerm.toString());
    assertEquals("0", zero.toString());
    assertEquals("3x^4 -5x^3 +2x^1 -4", fourTerms.toString());
    assertEquals("-5x^6 +x^1 +2", oneCoefficient.toString());
    assertEquals("9", zeroCoefficient.toString());
    assertEquals("-x^7 -8x^1", negativeOneCoefficient.toString());
    assertEquals("73x^197 -95x^196 -60x^195 +154x^193 +20x^191 -54x^187 "
            + "+76x^178 -19x^174 +96x^172 +24x^169 +41x^168 -51x^166 +94x^165 -91x^163 +53x^161 "
            + "+184x^160 -23x^157 +87x^155 -46x^152 -40x^151 +64x^150 +51x^149 -148x^147 +228x^146 "
            + "+26x^145 +83x^142 +51x^141 +61x^140 -80x^133 +98x^131 +36x^130 -14x^127 +49x^125 "
            + "-74x^123 -53x^122 +33x^118 +30x^117 +32x^116 +10x^108 +47x^107 -7x^105 +158x^103 "
            + "-89x^101 +14x^100 +53x^98 -24x^96 -32x^95 -11x^94 +89x^91 -170x^89 +18x^85 +43x^80 "
            + "+180x^79 +55x^76 -41x^75 -x^72 +41x^68 -65x^67 -51x^66 -92x^65 -55x^61 +21x^51 "
            + "+10x^50 -45x^49 -41x^48 +180x^46 -74x^45 -67x^44 +34x^42 +98x^41 -12x^32 -78x^31 "
            + "-55x^29 -75x^28 -38x^24 -15x^23 -61x^21 -56x^17 +74x^15 +67x^12 -47x^10 +52x^7 "
            + "-9x^2", crazyLong1.toString());
    assertEquals("192x^197 +43x^195 -46x^194 +26x^193 +82x^187 -52x^179 +81x^176 +16x^174 +60x^171 "
            + "+96x^168 +176x^165 +20x^161 -24x^158 +19x^157 -6x^153 +93x^151 -29x^149 "
            + "+97x^146 +50x^144 +88x^143 -46x^141 -39x^138 +75x^137 -88x^128 "
            + "-70x^120 +12x^112 +132x^111 +33x^109 -61x^107 -52x^106 -7x^105 +14x^104 "
            + "-196x^101 -72x^95 -279x^93 -248x^88 +82x^87 +176x^85 -33x^78 -22x^76 "
            + "+21x^75 +194x^73 +66x^70 +51x^69 +55x^68 -84x^66 -84x^65 -16x^59 -3x^58 "
            + "-100x^56 -76x^54 -84x^53 +91x^50 +56x^45 -124x^44 +12x^43 +93x^41 +26x^40 "
            + "+51x^36 -23x^33 +52x^28 +16x^26 +36x^25 -85x^23 -142x^19 -12x^17 -16x^13 "
            + "+62x^12 +144x^11 +19x^9 -44x^8 -12x^3 -34x^2 -50", crazyLong2.toString());
    assertEquals("55x^2", fuckingTest.toString());
  }

  /**
   * Tests addTerm() method.
   */
  @Test
  public void testAddTerm() {
    // 1. adding term of same power, ensure they simplify
    // 2. adding term of negative power should throw exception
    // 3. adding term of 0 coefficient should't addTerm a term
    // 4. terms should be added in decreasing order of their power
    twoTerms.addTerm(3, 2);
    assertEquals("-2x^2 +4x^1", twoTerms.toString());
    fourTerms.addTerm(0, 1);
    assertEquals("3x^4 -5x^3 +2x^1 -4", fourTerms.toString());
    oneCoefficient.addTerm(3, 5);
    assertEquals("-5x^6 +3x^5 +x^1 +2", oneCoefficient.toString());

    try {
      zeroCoefficient.addTerm(1, -3);
      fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals("Power of terms cannot be negative in this Polynomial.", e.getMessage());
    }
  }

  /**
   * Tests the removeTerm() method.
   */
  @Test
  public void testRemoveTerm() {
    // term is present and more than 1 term
    oneCoefficient.removeTerm(6);
    assertEquals("x^1 +2", oneCoefficient.toString());

    // term is not present and more than 1 term
    fourTerms.removeTerm(8);
    assertEquals("3x^4 -5x^3 +2x^1 -4", fourTerms.toString());

    // term is not present and only 1 term
    oneTerm.removeTerm(5);
    assertEquals("15x^4", oneTerm.toString());

    // term is present and only 1 term
    zeroCoefficient.removeTerm(0);
    assertEquals("0", zeroCoefficient.toString());

    // try to remove negative term
    try {
      twoTerms.removeTerm(-1);
      fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals("Power of terms cannot be negative in this Polynomial.", e.getMessage());
    }
  }

  /**
   * Tests the getDegree() method.
   */
  @Test
  public void testGetDegree() {
    assertEquals(0, zero.getDegree());

    // polynomial with more than 1 term
    assertEquals(2, twoTerms.getDegree());
    assertEquals(6, oneCoefficient.getDegree());

    // polynomial with 1 term
    assertEquals(0, zeroCoefficient.getDegree());

    assertEquals(2, fuckingTest.getDegree());
  }

  /**
   * Tests the getCoefficient() method.
   */
  @Test
  public void testGetCoefficient() {
    // zero polynomial
    assertEquals(0, zero.getCoefficient(0));

    // polynomial with negative coefficient
    assertEquals(-4, fourTerms.getCoefficient(0));

    // polynomial with positive coefficient
    assertEquals(15, oneTerm.getCoefficient(4));
    assertEquals(2, fourTerms.getCoefficient(1));

    // polynomial coefficient for that power is not found
    assertEquals(0, zeroCoefficient.getCoefficient(3));

    assertEquals(55, fuckingTest.getCoefficient(2));

    // negative power
    try {
      crazyLong2.getCoefficient(-1);
      fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals("Power of terms cannot be negative in this Polynomial.", e.getMessage());
    }
  }

  /**
   * Tests the evaluate() method.
   */
  @Test
  public void testEvaluate() {
    // zero polynomial
    assertEquals(0, zero.evaluate(-4), 0.0001);

    assertEquals(40.0625, fourTerms.evaluate(2.5), 0.0001);
    assertEquals(-60.45, twoTerms.evaluate(-3.1), 0.0001);
    assertEquals(42.8415, oneTerm.evaluate(-1.3), 0.0001);
    assertEquals(2, oneCoefficient.evaluate(0), 0.00001);
    assertEquals(9, zeroCoefficient.evaluate(5.0), 0.00001);
    assertEquals(-2287744.0454961, negativeOneCoefficient.evaluate(8.1), 0.0001);
  }

  /**
   * Tests the addTerm() method.
   */
  @Test
  public void testAdd() {
    /*
    1) this is empty, other is empty
    2) this is empty, other is one node
    3) this is empty, other is several nodes
    4) this is one node, other is empty
    5) this is several nodes, other is empty
    6) this is several nodes and other is several nodes
     */
    assertEquals("0", zero.add(zero).toString());

    assertEquals("15x^4", zero.add(oneTerm).toString());
    assertEquals("15x^4", oneTerm.toString());
    assertEquals("0", zero.toString());

    assertEquals("3x^4 -5x^3 +2x^1 -4", zero.add(fourTerms).toString());
    assertEquals("0", zero.toString());
    assertEquals("3x^4 -5x^3 +2x^1 -4", fourTerms.toString());

    assertEquals("15x^4", oneTerm.add(zero).toString());
    assertEquals("15x^4", oneTerm.toString());
    assertEquals("0", zero.toString());

    assertEquals("-x^7 -8x^1", negativeOneCoefficient.add(zero).toString());
    assertEquals("-x^7 -8x^1", negativeOneCoefficient.toString());
    assertEquals("0", zero.toString());

    assertEquals("-x^7 -5x^6 -7x^1 +2", negativeOneCoefficient.add(oneCoefficient).toString());
    assertEquals("-x^7 -8x^1", negativeOneCoefficient.toString());
    assertEquals("-5x^6 +x^1 +2", oneCoefficient.toString());

    // invalid concrete class
    try {
      zero.add(new IncorrectPolynomialImpl());
      fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals("Cannot addTerm invalid Polynomial type to this Polynomial.", e.getMessage());
    }
  }

  /**
   * Tests the creation of valid and invalid Polynomials.
   */
  @Test
  public void testInvalidPolynomial() {
    try {
      Polynomial invalid = new PolynomialImpl("this is an invalid format");
      fail("Expected exception was not thrown.");
    } catch (IllegalArgumentException e) {
      assertEquals("String polynomial is not in correct format.", e.getMessage());
    }

    // zero
    Polynomial zeroString = new PolynomialImpl(" 0000");
    assertEquals("0", zeroString.toString());

    Polynomial zerosInString = new PolynomialImpl("100    ");
    assertEquals("100", zerosInString.toString());
  }
}