package assignment2;

import java.math.BigInteger;

public class Polynomial implements DeepClone<Polynomial> {
	
	private SLinkedList<Term> polynomial;
	
	public int size() {
		return polynomial.size();
	}
	
	private Polynomial(SLinkedList<Term> p) {
		polynomial = p;
	}
 
	public Polynomial() {
		polynomial = new SLinkedList<Term>();
	}
 
 // Returns a deep copy of the object.
	public Polynomial deepClone() {
		return new Polynomial(polynomial.deepClone());
	}
 
 /* 
  * TODO: Add new term to the polynomial. Also ensure the polynomial is
  * in decreasing order of exponent.
  // Hint: Notice that the function SLinkedList.get(index) method is O(n), 
  // so if this method were to call the get(index) 
  // method n times then the method would be O(n^2).
  // Instead, use a Java enhanced for loop to iterate through 
  // the terms of an SLinkedList.
  /*
  for (Term currentTerm: polynomial)
  {
   // The for loop iterates over each term in the polynomial!!
   // Example: System.out.println(currentTerm.getExponent()) should print the exponents of each term in the polynomial when it is not empty.  
  }
  */
  
	public void addTerm(Term t) { // O(n) functionality - goes through the entire linked list

		//We use the BigInteger class for this.
		BigInteger zero = new BigInteger("0");	//initialize a BigInteger object with a value of zero, to be used later on
		
		//if the term it takes in, has an exponent that is greater than zero, and the coefficient is not zero
		//assignment stated that coefficients of 0 or less than 0 cannot be added!
		if (!(t.getExponent() < 0 && t.getCoefficient().equals(zero))) {

			// "Edge case": list is empty - commands below refer to the Term class
			if (polynomial.isEmpty()==true)	//if there are no polynomials present
				polynomial.addFirst(t);		//add the first term
			
			//if not... where algorithm commences
			else {
				int i=0;	//initialize a variable index
				boolean isAdded=false;	//initialize a boolean isAdded as false
				
					
				for(Term currentTerm: polynomial) {	//for: each loop
					BigInteger negativeOf = new BigInteger("-1");
					negativeOf = negativeOf.multiply((currentTerm.getCoefficient()));

					//EDGE CASE: if the first exponent is less than the "to be added" term's exponent
					if(t.getExponent() > currentTerm.getExponent()) {	//if the term's exponent is greater than the first exponent
																		
						polynomial.add(i, t); //add at i
						isAdded = true; //change boolean
						break;	//break from for each loop. done
					}
					
					//if exponents are the same (we have two cases for this)
					else if(t.getExponent() == currentTerm.getExponent()) {
											
						//if the coefficient equals it's negative value, use the multiply method in BigInteger and					
						//see if they are the same regardless of sign
						if(t.getCoefficient().equals(negativeOf)) {
							//removes the entry at the index
							polynomial.remove(i);
							isAdded=true;	//successful addition. boolean is updated
							break;		//break from for loop
						}
						
						//if not the same number, it can be added
						else {
							BigInteger total = zero;	//total is initialized
							total = t.getCoefficient().add(currentTerm.getCoefficient());	//coefficients are added together
							currentTerm.setCoefficient(total);	//set coefficient to the total
							isAdded = true;		//successful addition. boolean is updated
							break;			//break from for loop
						}
					}
					i++;
				}
				
				if(isAdded==false)	//if the boolean is false after iterating through the entire linked list
					polynomial.addLast(t);	//append to end of list
	
				
			}
		}
		else throw new IllegalArgumentException("Not a valid term.");
		

	}
	
	public Term getTerm(int index) {
		return polynomial.get(index);
	}
 
 //TODO: Add two polynomial without modifying either
	
	//will add based on the first entry through every iteration in the while loop
	public static Polynomial add(Polynomial p1, Polynomial p2) {
		
		if(p1.size()==0 && p2.size()==0)
			throw new IllegalArgumentException("Both polynomials are empty.");
		//deep clones the two polynomials that are input
		Polynomial clone1 = p1.deepClone();
		Polynomial clone2 = p2.deepClone();
		
		//result is the sum, which is returned at the end
		Polynomial sum = new Polynomial();
		//create a new linked list and append the polynomial to the linked list
		
		
		//while either the first or the second polynomial is not empty
		while(clone1.polynomial.isEmpty()==false || clone2.polynomial.isEmpty()==false) {
			
			//if the first clone is empty (EDGE CASE)
			if(clone1.polynomial.isEmpty()==true) {
				
				//the second polynomial is added
				//get element's exponent at first entry, as well as it's coefficient
				//or clone1.getTerm(0).deepClone();
				sum.polynomial.addLast(clone2.getTerm(0).deepClone());
				clone2.polynomial.removeFirst();
				
			}
			//if the second clone is empty (EDGE CASE)
			if(clone2.polynomial.isEmpty()==true) {
				
				sum.polynomial.addLast(clone1.getTerm(0).deepClone());
				clone1.polynomial.removeFirst();
				
			}
			if(clone1.getTerm(0).getExponent() > clone2.getTerm(0).getExponent()) {
				
				sum.polynomial.addLast(clone1.getTerm(0).deepClone());
				clone1.polynomial.removeFirst();
				
			}
			if(clone1.getTerm(0).getExponent() < clone2.getTerm(0).getExponent()) {
					sum.polynomial.addLast(clone2.getTerm(0).deepClone());
					clone2.polynomial.removeFirst();
					
			//if the first term's exponents are the same
			} else {
				
				//separate the addition to get the coefficients to add together using the add() method
				sum.polynomial.addLast(new Term(clone1.getTerm(0).getExponent(), clone1.getTerm(0).getCoefficient().add(clone2.getTerm(0).getCoefficient())));
				clone2.polynomial.removeFirst();
				clone1.polynomial.removeFirst();

			}
			
		}
		return sum;
	
	}
		
 
 //TODO: multiply this polynomial by a given term.
	public void multiplyTerm(Term t) { /**** ADD CODE HERE ****/ 
		
		BigInteger zero = new BigInteger("0");
		//if the exponent of the term is nonnegative
		if (!(t.getExponent() < 0)) {
			
			//if the coefficient is zero, clear the list
			if(t.getCoefficient().equals(zero))
				this.polynomial.clear();
			
			else {
				//initialize new coefficient and exponent
				int exp = 0;
				BigInteger coeff = zero;
				
				//for each loop that multiplies through every term
				for (Term currentTerm: polynomial) {
					exp=t.getExponent()+currentTerm.getExponent();
					coeff=t.getCoefficient().multiply(currentTerm.getCoefficient());
					
					//information is set
					currentTerm.setCoefficient(coeff);
					currentTerm.setExponent(exp);
				
				}
			}
		}
		
		
	}
 
 //TODO: multiply two polynomials
	public static Polynomial multiply(Polynomial p1, Polynomial p2) {
		
		Polynomial clone1 = p1.deepClone();
		Polynomial clone2 = p2.deepClone();
		Polynomial c2product = new Polynomial();
		
		//clone1 multiplies clone2 (Horner's method)
		for (int i =0; i < clone1.size(); i++) {
			clone2.multiplyTerm(clone1.getTerm(i));
			Polynomial c2tmp = add(clone2, c2product);
			c2product = c2tmp;
			//clone2 is cloned
			clone2=p2.deepClone();
		
		}
		return c2product;
		
	}
 
 // TODO: evaluate this polynomial.
 // Hint:  The time complexity of eval() must be order O(m), 
 // where m is the largest degree of the polynomial. Notice 
 // that the function SLinkedList.get(index) method is O(m), 
 // so if your eval() method were to call the get(index) 
 // method m times then your eval method would be O(m^2).
 // Instead, use a Java enhanced for loop to iterate through 
 // the terms of an SLinkedList.

	public BigInteger eval(BigInteger x) {
		
		BigInteger zero = new BigInteger("0");
		BigInteger horner = new BigInteger("0");
		BigInteger[] arrayPolynomial = new BigInteger[this.getTerm(0).getExponent()+1];
		int firstExponent = this.getTerm(0).getExponent();
		
		//fill up the arrayPolynomial array with just 0 (so no null pointers)
		for(int i = 1; i < arrayPolynomial.length; i++)
			arrayPolynomial[i] = zero;
		
        if(!this.polynomial.isEmpty()) {

        	//for coefficients only
			if(firstExponent == 0) {
        		horner = this.getTerm(0).getCoefficient();
    	        BigInteger multiplied = zero;

	        	multiplied = horner.multiply(x);
	        	horner=multiplied;
        		
        	} else 
        	{
					
				arrayPolynomial[0] = this.getTerm(0).getCoefficient();

				Polynomial polyClone = this.deepClone();
				polyClone.polynomial.removeFirst();
				
				while(polyClone.polynomial.isEmpty()==false) {
					BigInteger coefficient = polyClone.getTerm(0).getCoefficient();
					int exp = polyClone.getTerm(0).getExponent();
					polyClone.polynomial.removeFirst();
					arrayPolynomial[this.getTerm(0).getExponent() - exp] = coefficient;
							
				}
	     	
				horner = arrayPolynomial[0];
		    			  
				//horner's method
		        for (int i = 1; i < arrayPolynomial.length; i++) {
		        	BigInteger tempProduct = horner.multiply(x);
		        	horner = tempProduct.add(arrayPolynomial[i]);
		        }
		        
			}
	        return horner;
	        
        } else 
        {
        	return zero;
        	
        }
        
        
	}
 
 // Checks if this polynomial is a clone of the input polynomial
	public boolean isDeepClone(Polynomial p) { 
		if (p == null || polynomial == null || p.polynomial == null || this.size() != p.size())
			return false;

		int index = 0;
		for (Term term0 : polynomial) {
			Term term1 = p.getTerm(index);

   // making sure that p is a deep clone of this
			if (term0.getExponent() != term1.getExponent() ||
					term0.getCoefficient().compareTo(term1.getCoefficient()) != 0 || term1 == term0)  
				return false;

			index++;
		}
		return true;
	}
 
 // This method blindly adds a term to the end of LinkedList polynomial. 
 // Avoid using this method in your implementation as it is only used for testing.
	public void addTermLast(Term t) {
		polynomial.addLast(t);
	}
 
 
 @Override
 	public String toString() { 
	 	if (polynomial.size() == 0) return "0";
	 	return polynomial.toString();
 	}
 
 
}
