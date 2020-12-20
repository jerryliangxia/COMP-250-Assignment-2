package assignment2;

import java.math.BigInteger;

public class Megatester {

	private static int failedTests = 0;
	private static final int TOTALTESTS = Megatester.class.getDeclaredMethods().length - 3;

	public static void runMinitester() {
		System.out.println("Running Minitester...\n");
		MiniTester.main(new String[0]);
		System.out.println();
	}
	
	public static void testAddTerm1() {
		Polynomial p1 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(9, new BigInteger("3")));
		p1.addTerm(new Term(3, new BigInteger("4")));
		p1.addTerm(new Term(4, new BigInteger("5")));
		
		pExpected.addTermLast(new Term(9, new BigInteger("3")));
		pExpected.addTermLast(new Term(4, new BigInteger("5")));
		pExpected.addTermLast(new Term(3, new BigInteger("4")));
		
		if (p1.size() != 3 || pExpected.size() != 3 || !p1.isDeepClone(pExpected)) {
			System.out.println("testAdd1(): add() does not add polynomials properly");
			failedTests++;
		}
	}

	public static void testAdd1() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(9, new BigInteger("3")));
		p1.addTerm(new Term(4, new BigInteger("5")));
		p1.addTerm(new Term(3, new BigInteger("4")));

		p2.addTerm(new Term(9, new BigInteger("3")));
		p2.addTerm(new Term(4, new BigInteger("2")));
		p2.addTerm(new Term(0, new BigInteger("1")));

		pExpected.addTermLast(new Term(9, new BigInteger("6")));
		pExpected.addTermLast(new Term(4, new BigInteger("7")));
		pExpected.addTermLast(new Term(3, new BigInteger("4")));
		pExpected.addTermLast(new Term(0, new BigInteger("1")));


		Polynomial pStudent = Polynomial.add(p1, p2);

		if (pStudent.size() != 4 || pExpected.size() != 4 || !pStudent.isDeepClone(pExpected)) {
			System.out.println("testAdd1(): add() does not add polynomials properly");
			failedTests++;
		}
	}

	public static void testAdd2() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(9, new BigInteger("3")));
		p1.addTerm(new Term(8, new BigInteger("2")));
		p2.addTerm(new Term(7, new BigInteger("1")));
		p2.addTerm(new Term(8, new BigInteger("-2")));

		pExpected.addTermLast(new Term(9, new BigInteger("3")));
		pExpected.addTermLast(new Term(7, new BigInteger("1")));

		Polynomial pStudent = Polynomial.add(p1, p2);
		
		if (pStudent.size() != 2 || pExpected.size() != 2 || !pStudent.isDeepClone(pExpected)) {
			System.out.println("testAdd2(): add() does not add polynomials properly");
			failedTests++;
		}


	}
	public static void testAdd3() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(9, new BigInteger("3")));
		p1.addTerm(new Term(4, new BigInteger("5")));
		p1.addTerm(new Term(3, new BigInteger("4")));


		pExpected.addTermLast(new Term(9, new BigInteger("3")));
		pExpected.addTermLast(new Term(4, new BigInteger("5")));
		pExpected.addTermLast(new Term(3, new BigInteger("4")));



		Polynomial pStudent = Polynomial.add(p1, p2);

		if (pStudent.size() != 3 || pExpected.size() != 3 || p2.size() != 0 || !pStudent.isDeepClone(pExpected)) {
			System.out.println("testAdd3(): add() does not add polynomials properly");
			failedTests++;
		}
	}
	public static void testAdd4() {
		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(9, new BigInteger("3")));
		p2.addTerm(new Term(9, new BigInteger("-3")));

		Polynomial pStudent = Polynomial.add(p1, p2);

		if (pStudent.size() != 0 || pExpected.size() != 0 || p2.size() != 1 || !pStudent.isDeepClone(pExpected)) {
			System.out.println("testAdd4(): add() does not add polynomials properly");
			failedTests++;
		}
	}
	
	public static void testMultiplyTerm1() {
		Polynomial p1 = new Polynomial();
		Polynomial pExpected = new Polynomial();
		
		p1.addTerm(new Term(1, new BigInteger("1")));
		p1.addTerm(new Term(0, new BigInteger("1")));
		
		Term t = new Term(1, new BigInteger("1"));
		t.setCoefficient(BigInteger.ZERO);
		
		p1.multiplyTerm(t);
		
		if (!p1.isDeepClone(pExpected) || p1.size() != 0) {
			System.out.println("testMultiplyTerm1(): multiplyTerm() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiplyTerm2() {
		Polynomial p1 = new Polynomial();
		Polynomial pExpected = new Polynomial();
		
		Term t = new Term(1, new BigInteger("1"));
		t.setCoefficient(BigInteger.ZERO);
		
		p1.multiplyTerm(t);
		
		if (!p1.isDeepClone(pExpected) || p1.size() != 0) {
			System.out.println("testMultiplyTerm2(): multiplyTerm() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiplyTerm3() {
		Polynomial p1 = new Polynomial();
		Polynomial pExpected = new Polynomial();
		
		Term t = new Term(1, new BigInteger("1"));
		
		p1.multiplyTerm(t);
		
		if (!p1.isDeepClone(pExpected) || p1.size() != 0) {
			System.out.println("testMultiplyTerm3(): multiplyTerm() doesn't multiply properly");
			failedTests++;
		}
	}

	public static void testMultiply1() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(1, new BigInteger("1")));
		p1.addTerm(new Term(0, new BigInteger("1")));
		p2.addTerm(new Term(1, new BigInteger("1")));
		p2.addTerm(new Term(0, new BigInteger("-1")));

		Polynomial pActual = Polynomial.multiply(p1, p2);

		pExpected.addTermLast(new Term(2, new BigInteger("1")));
		pExpected.addTermLast(new Term(0, new BigInteger("-1")));
		
		if (!pActual.isDeepClone(pExpected) || p1.size() != 2 || p2.size() != 2) {
			System.out.println("testMultiply1(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiply2() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(1, new BigInteger("1")));
		p1.addTerm(new Term(0, new BigInteger("1")));

		Polynomial pActual = Polynomial.multiply(p1, p2);

		if (!pActual.isDeepClone(pExpected) || p1.size() != 2 || p2.size() != 0) {
			System.out.println("testMultiply2(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiply3() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p2.addTerm(new Term(1, new BigInteger("1")));
		p2.addTerm(new Term(0, new BigInteger("1")));

		Polynomial pActual = Polynomial.multiply(p1, p2);

		if (!pActual.isDeepClone(pExpected) || p1.size() != 0 || p2.size() != 2) {
			System.out.println("testMultiply3(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiply4() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial p3 = new Polynomial();
		Polynomial pExpected = new Polynomial();
		
		p1.addTerm(new Term(1, new BigInteger("1")));
		p1.addTerm(new Term(0, new BigInteger("1")));
		p2.addTerm(new Term(1, new BigInteger("1")));
		p2.addTerm(new Term(0, new BigInteger("-1")));
		p3.addTerm(new Term(2, new BigInteger("1")));
		p3.addTerm(new Term(0, new BigInteger("1")));
		
		pExpected.addTermLast(new Term(4, new BigInteger("1")));
		pExpected.addTermLast(new Term(0, new BigInteger("-1")));

		Polynomial pTemp = Polynomial.multiply(p1, p2);
		Polynomial pActual = Polynomial.multiply(pTemp, p3);

		if (!pActual.isDeepClone(pExpected) || p1.size() != 2 || p2.size() != 2 || p3.size() != 2) {
			System.out.println("testMultiply4(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiply5() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(54, new BigInteger("13")));
		p2.addTerm(new Term(13, new BigInteger("54")));
		
		pExpected.addTermLast(new Term(67, new BigInteger("702")));

		Polynomial pActual = Polynomial.multiply(p1, p2);

		if (!pActual.isDeepClone(pExpected) || p1.size() != 1 || p2.size() != 1) {
			System.out.println("testMultiply5(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}
	
	public static void testMultiply6() {

		Polynomial p1 = new Polynomial();
		Polynomial p2 = new Polynomial();
		Polynomial pExpected = new Polynomial();

		p1.addTerm(new Term(50, new BigInteger("1")));
		p1.addTerm(new Term(30, new BigInteger("1")));
		p2.addTerm(new Term(3, new BigInteger("1")));
		p2.addTerm(new Term(2, new BigInteger("1")));
		
		pExpected.addTermLast(new Term(53, new BigInteger("1")));
		pExpected.addTermLast(new Term(52, new BigInteger("1")));
		pExpected.addTermLast(new Term(33, new BigInteger("1")));
		pExpected.addTermLast(new Term(32, new BigInteger("1")));

		Polynomial pActual = Polynomial.multiply(p1, p2);

		if (!pActual.isDeepClone(pExpected) || p1.size() != 2 || p2.size() != 2) {
			System.out.println("testMultiply6(): multiply() doesn't multiply properly");
			failedTests++;
		}
	}

	public static void testDeepClone1() {
		Polynomial pStudent = new Polynomial();

		pStudent.addTerm(new Term(9, new BigInteger("3")));
		pStudent.addTerm(new Term(4, new BigInteger("5")));
		pStudent.addTerm(new Term(3, new BigInteger("4")));
		pStudent.addTerm(new Term(2, new BigInteger("3")));
		pStudent.addTerm(new Term(1, new BigInteger("2")));
		pStudent.addTerm(new Term(0, new BigInteger("1")));

		Polynomial pCopy = pStudent.deepClone();

		if (!pCopy.isDeepClone(pStudent)) {
			System.out.println("testDeepClone1(): deepClone() does not make a deep copy");
			failedTests++;
		}

	}
	public static void testDeepClone2() {
		Polynomial pStudent = new Polynomial();
		Polynomial pNotCopy = new Polynomial();

		pStudent.addTerm(new Term(9, new BigInteger("3")));
		pStudent.addTerm(new Term(4, new BigInteger("5")));
		pStudent.addTerm(new Term(3, new BigInteger("4")));

		pNotCopy.addTermLast(new Term(9, new BigInteger("3")));
		pNotCopy.addTermLast(new Term(4, new BigInteger("5")));
		pNotCopy.addTermLast(new Term(3, new BigInteger("4")));

		Polynomial pCopy = pStudent.deepClone();

		if (!pCopy.isDeepClone(pStudent) || pCopy.size() != 3 || !pStudent.isDeepClone(pNotCopy)) {
			System.out.println("testDeepClone2(): deepClone() does not make a deep copy");
			failedTests++;
		}
	}
	public static void testDeepClone3() {
		Polynomial pStudent = new Polynomial();

		Polynomial pCopy = pStudent.deepClone();

		if (!pCopy.isDeepClone(pStudent) || pCopy.size() != 0 || pStudent.size() != 0) {
			System.out.println("testDeepClone3(): deepClone() does not make a deep copy");
			failedTests++;
		}
	}

	public static void testEval1() {
		Polynomial pStudent = new Polynomial();

		pStudent.addTerm(new Term(3, new BigInteger("2")));
		pStudent.addTerm(new Term(1, new BigInteger("5")));
		pStudent.addTerm(new Term(0, new BigInteger("2")));


		BigInteger result = pStudent.eval(new BigInteger("5"));
		if (!result.equals(new BigInteger("277"))) {
			System.out.println("testEval1(): eval() does not evaluate polynomial properly");
			failedTests++;
		}
	}
	public static void testEval2() {
		Polynomial pStudent = new Polynomial();

		pStudent.addTerm(new Term(3, new BigInteger("2")));
		pStudent.addTerm(new Term(1, new BigInteger("5")));
		pStudent.addTerm(new Term(0, new BigInteger("2")));


		BigInteger result = pStudent.eval(new BigInteger("0"));
		if (!result.equals(new BigInteger("2"))) {
			System.out.println(result);
			System.out.println("testEval2(): eval() does not evaluate polynomial properly");
			failedTests++;
		}
	}
	public static void testEval3() {
		Polynomial pStudent = new Polynomial();

		BigInteger result = pStudent.eval(new BigInteger("129"));
		if (!result.equals(new BigInteger("0"))) {
			System.out.println("testEval3(): eval() does not evaluate polynomial properly");
			failedTests++;
		}
	}
	public static void testEval4() {
		Polynomial pStudent = new Polynomial();

		BigInteger result = pStudent.eval(new BigInteger("0"));
		if (!result.equals(new BigInteger("0"))) {
			System.out.println("testEval4(): eval() does not evaluate polynomial properly");
			failedTests++;
		}
	}

	public static void Horner() {
		int[] poly = {2, 0, 5, 2};
		int x = 5;
		int result = poly[0];
		for (int i=1; i<poly.length;i++) {
			result = result * x + poly[i];
		}
		failedTests++;

	}

	public static void runMegatester() {
		System.out.println("Running Megatester...\n");
		testAddTerm1();
		testAdd1();
		testAdd2();
		testAdd3();
		testDeepClone1();
		testDeepClone2();
		testDeepClone3();
		testEval1();
		testEval2();
		testEval3();
		testEval4();
		testMultiplyTerm1();
		testMultiplyTerm2();
		testMultiplyTerm3();
		testMultiply1();
		testMultiply2();
		testMultiply3();
		testMultiply4();
		testMultiply5();
		testMultiply6();

		if (failedTests == 0) System.out.println("Passed all Megatester tests!");
		else System.out.println("Failed " + failedTests + " out of " + TOTALTESTS + " Megatester tests");

	}
	// Things to test for:
	// addTerm() 1) adding terms in weird order
	// add same object twice, multiple nodes referring to same object?
	// multiply() tests that evaluate the whole thing to 0 or almost 0 (telescoping)
	// empty polynomial

	public static void main(String[] args) {
		
		 

		runMinitester();
		runMegatester();
		
		
	}
}

