package example;

package example;

import lib.Fraction;

public class example {


	  public static void main(String[] argv) {
			
		    /* Test all constructors and toString. */
		    Fraction f0 = new Fraction();
		    Fraction f1 = new Fraction(3);
		    Fraction f4 = new Fraction(23,41);
		    Fraction f2 = new Fraction(-12, 20);
		    Fraction f3 = new Fraction(f4);
		    Fraction f5 = new Fraction(3.14285,3);
		    Fraction f7 =new Fraction(6.66, f2);
		    Fraction f6 =new Fraction(22,7,-3);
		    Fraction f8 =new Fraction(123445667,453437782);
		    Fraction f9=new Fraction(67573657,6457676);
		    
		    System.out.println(f9.toDouble());
		    System.out.println(f8.toDouble());
		    System.out.println("f9-f8: "+f9.substract(f8));
		    System.out.println("f9-f8: "+f9.substract(f8).toDouble());
		    System.out.println(f2.substract(f1));
		    System.out.println(f2.substract(3*2));
		    System.out.println(f5);
		    System.out.println(f6);
		    System.out.println(f7);
		    System.out.println(f6.toDouble());
		    System.out.println(f5.toDouble());
		    System.out.println("\nTesting constructors (and toString):");
		    System.out.println("The fraction f0 is " + f0.toString()); 
		    System.out.println("The fraction f1 is " + f1); // toString is implicit
		    System.out.println("The fraction f2 is " + f2);
		    System.out.println(f3.toDouble());
		    System.out.println(f3.divide(f2));
		    System.out.println(f3);
		    System.out.println(f3.sqrt(4).toDouble());
		    System.out.println(f3.fastSqrt(4).toDouble());
		   
		    System.out.println(f3.sqrt(-8).pow(2));
		    System.out.println(f3.sqrt(9).pow(2).toDouble());
		  }
}
