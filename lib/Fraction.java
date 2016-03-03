package lib;

/** @author SAMRIDDHA BANIK
 * The Fraction class implements fractions, i.e., rational numbers.   
 *  The class represents each fraction as its numerator part and denominator part
 *  @version 1.0 
 *  
 */

public class Fraction {
	 
	/** Constructs a Fraction n/d. 
	   *  @param n is the decimal number.
	   *  @param d is the denominator Fraction.
	   *  6 is the default precision.
	   */
	public Fraction(double n,Fraction d){
		this(new Fraction(n),d);
	}
	/** Constructs a Fraction n/d. 
	   *  @param n is the decimal number.
	   *  6 is the default precision.
	   */
	public Fraction(double n){
		this(n,6);
	}
	 /** Constructs a Fraction n/d. 
	   *  @param n is the decimal number.
	   *  @param p is the number of precision bits.
	   */
	public Fraction(double n,int p){
		if(p>8){
			p=8;
		}
		if(p<0){
			p=1;
		}
		int multiplier=(int)Math.pow(10, p);
		numerator=(int)(n*multiplier);
		denominator=multiplier;
		minimize();
	}
	/** Constructs a Fraction n/d. 
	   *  @param n is the numerator decimal number.
	   *  @param d is the denominator decimal number.
	   *  6 is default precision.
	   */
	public Fraction(double n,double d){
		this(n,d,6);
	}
	
	 /** Constructs a Fraction n/d. 
	   *  @param n is the numerator decimal number.
	   *  @param d is the denominator decimal number.
	   *  @param p is the number of precision bits.
	   */
	public Fraction(double n,double d,int p){
		if(p>8){
			p=8;
		}
		if(p<0){
			p=1;
		}
		int multiplier=(int)Math.pow(10, p);
		numerator=(int)(n*multiplier);
		denominator=(int)(d*multiplier);
		minimize();
	}
	
	
  /** Constructs a Fraction n/d. 
   *  @param n is the numerator, assumed integer.
   *  @param d is the denominator, assumed integer.
   */
	
	public Fraction(int n, int d) {
   this(n, d, false);
  }
  
  /** Constructs a Fraction n/d from another fraction. 
   *  @param f is the fraction, whose value is to be copied .
   */
  
	public Fraction(Fraction f){
	  numerator=f.getNumerator();
	  denominator=f.getDenominator();
  }
  
  /** Constructs a Fraction n/d. 
   *  @param n is the numerator, assumed integer.
   *  @param d is the denominator, assumed integer.
   *  @param minimize is a boolean variable, it tells the constructor whether this fraction needs to be minimized to its simplest form. 
   */
  
	public Fraction(int n, int d,boolean minimize) {
  // this(new Fraction(n),new Fraction(d),minimize);
	  numerator=n;
	  denominator=d;
	  if(minimize==true){
	    	minimize();
	    }  
  }
  
  /** Constructs a Fraction n/d. 
   *  @param n is the numerator Fraction, assumed Fraction.
   *  @param d is the denominator Fraction, assumed Fraction.
   *  @param minimize is a boolean variable, it tells the constructor whether this fraction needs to be minimized to its simplest form. 
   */
  
	public Fraction(Fraction n,Fraction d,boolean minimize){
	  numerator=n.getNumerator()*d.getDenominator();
	  denominator=n.getDenominator()*d.getNumerator();
	  if(minimize==true){
	    	minimize();
	    }
  }
  /** Constructs a Fraction n/d. 
   *  @param n is the numerator Fraction, assumed Fraction.
   *  @param d is the denominator Fraction, assumed Fraction.
   * this would be minimized by default.
   */
  
	public Fraction(Fraction n,Fraction d){
	 this(n,d,true);
  }

  /** Constructs a Fraction n/1. 
   *  @param n is the numerator, assumed integer.
   */
  
  public Fraction(int n) {
    this(n,1);
  }

  /** Constructs a Fraction 0/1. 
   */
  
  public Fraction() {
    numerator = 0;
    denominator = 1;
  }
  
  /**
   * checks if calling Fraction is equal to Fraction in parameter.
   * @param f2 is the fraction to compare to.
   * @return true or false based on the result.
   */

  public boolean equals(Fraction f2){
	if((numerator*f2.getDenominator())-(denominator*f2.getNumerator())==0){
		return true;
	}
	 return false;
  }
  
  
  /** Converts this fraction to a string format: "numerator/denominator." 
   *  Fractions are printed in reduced form (part of your assignment is 
   *  to make this statement true).  
   *  @return a String representation of this Fraction.
   */
  
  public String toString()   {
    int thisGcd = gcd(numerator, denominator);
    
    return (numerator/thisGcd + "/" + denominator/thisGcd);
  }

  /** Calculates and returns the double floating point value of a fraction.
   *  @return a double floating point value for this Fraction.
   */
  
  public double toDouble()
    {
      double n = numerator;	// convert to double
      double d = denominator;	
      return (n / d);		
    }
  
  /** Add n to this fraction and return the result. 
   * @param n is the integer to be added.
   * @return the result of adding n to this Fraction.
   */
  
  public Fraction add (int n){
	  return add(new Fraction(n));
  }

  /** Add f2 to this fraction and return the result. 
   * @param f2 is the fraction to be added.
   * @return the result of adding f2 to this Fraction.
   */
  
  public Fraction add (Fraction f2) {
    Fraction r = new Fraction((numerator * f2.denominator) + 
			      (f2.numerator * denominator),
			      (denominator * f2.denominator));    
    return r;
  }
  
  /** returns the Fraction raised to the power of the argument. 
   * @param n is the power to be raised to.
   * @return the result of raising this Fraction to the nth power.
   */
  
  public Fraction pow (int n){
	 
	  Fraction r=new Fraction(Math.pow(this.toDouble(),n));
	  return r;
  }
  /** Returns the correctly rounded positive square root of the Fraction. 
   * this is still now a demo function and does not works correctly
   * @return the result of square root of this Fraction.
   * default precision is 6.
   */
  public Fraction sqrt(){
	  return sqrt(6);
  }
  /** Returns the correctly rounded positive square root of the Fraction. 
   * this is a faster implementation of sqrt function. 
   * this is 5.6 time faster than the other implementation.
   * @return the result of square root of this Fraction.
   * default precision is 6.
   */
  public Fraction fastSqrt(){
	  return fastSqrt(6);
  }
  /** Returns the correctly rounded positive square root of the Fraction. 
   * this is still now a demo function and does not works correctly
   * @param p value should range from 0 to 8 .
   * @return the result of square root of this Fraction.
   */
  
  public Fraction sqrt (int p){
	  if(p>8){
		  p=8;
	  }
	  if(p<0){
		  p=6;
	  }
	  Fraction r=new Fraction((Math.sqrt(numerator)),(Math.sqrt(denominator)),p);
	  return r;
  }
  
  /** Returns the correctly rounded positive square root of the Fraction. 
   * this method is 5.6 times faster than the standard implementation.
   * the only drawback being the approximation. 
   * @param p value should range from 0 to 8.
   * @note this being faster neglects accuracy. 
   * @return the result of square root of this Fraction.
   */
  
  public Fraction fastSqrt (int p){
	  if(p>8){
		  p=8;
	  }
	  if(p<0){
		  p=6;
	  }
	  Fraction r=new Fraction((Math.sqrt(this.toDouble())),p);
	  return r;
  }
  
  /** Subtract n from this fraction and return the result. 
   * @param n is the integer to be subtracted.
   * @return the result of subtracting n from this Fraction.
   */

  public Fraction substract(int n){
	  return substract(new Fraction(n));
  }
  
  /** Subtract f2 from this fraction and return the result. 
   * @param f2 is the fraction to be subtracted.
   * @return the result of subtracting f2 from this Fraction.
   */
  
  public Fraction substract(Fraction f2){
	  Fraction r=new Fraction(this.toDouble()-f2.toDouble());
	  return r;
  }
  /** Multiplies n to this fraction and return the result. 
   * @param n is the integer to be multiplied.
   * @return the result of multiplying n to this Fraction.
   */
  public Fraction multiply(int n){
	  return multiply(new Fraction(n));
  }
  
  /** Multiplies f2 to this fraction and return the result. 
   * @param f2 is the fraction to be multiplied.
   * @return the result of multiplying f2 from this Fraction.
   */
  public Fraction multiply(Fraction f2) {
	    Fraction r = new Fraction((numerator*f2.getNumerator()),
	    				(denominator*f2.getDenominator()),
	    				true);    
	    return r;
	  }
  
  /** Divides this fraction by n and return the result. 
   * @param n is the Dividend.
   * @return the result of Dividing this Fraction by n.
   */
  public Fraction divide(int n){
	  return divide(new Fraction(n));
  }
  
  /** Divides this fraction by f2 and return the result. 
   * @param f2 is the Dividend.
   * @return the result of Dividing this Fraction by f2.
   */
  public Fraction divide(Fraction f2) {
	    Fraction r = new Fraction((numerator*f2.getDenominator()),
	    				(denominator*f2.getNumerator()),
	    				true);    
	    return r;
	  }
  /** Computes the greatest common divisor (gcd) of the two inputs. 
   * @param x is assumed positive
   * @param y is assumed non-negative
   * @return the gcd of x and y
   */
  static private int gcd (int x, int y) {
	  int greater = 1;
	  int smaller = 1;
	  boolean xisnegative=false;
	  boolean yisnegative=false;
	  
	  int gcd=1;
	  
	  if(x<0){
		  x=-1*x;
		  xisnegative=true;
	  }
	  if(y<0){
		  y=-1*y;
		  yisnegative=true;
	  }
	  
	  
	  if(x>y){
		  greater=x;
		  smaller=y;
	  }
	  else if(x<y){
		  greater=y;
		  smaller=x;
	  }
	  else if(x==y){
		  return x;
	  }
	  
	  for(int i=smaller;i>1;i--){
		  if((greater%i==0)&&(smaller%i==0)){
			  gcd=i;
			 break;
		  }
	  }
	  
	  if((xisnegative==true)&&(yisnegative==true)){
		  gcd=(gcd*(-1));
	  }
	  
	 
    return gcd;
  }
    
  /* private fields within a Fraction. */ 
  
  private int numerator;
  private int denominator;
  
  /**makes the fraction to its simplest form
   * @param void 
   * @return void 
   */
  
  public void minimize(){
	  int thisGcd = gcd(numerator, denominator);
	    numerator=numerator/thisGcd;
	    denominator=denominator/thisGcd;
  }  
  
  /**compares the two values and returns the greater of the two values  
   * @param a is the first fraction.
   * @param b is the second fraction.
   * @return the fraction which is greater.
   */
  
  public static Fraction max(Fraction a, Fraction b) {
    if(a.toDouble()>b.toDouble()){
    	return a;
    }
    return b;
  }
  /**
   * returns the numerator of the fraction.
   * @return numerator of the fraction.
   */
  public int getNumerator() {
	return numerator;
  }
  /**
   * returns the denominator of the fraction.
   * @return denominator of the fraction.
   */
  public int getDenominator() {
	return denominator;
  }
  
}