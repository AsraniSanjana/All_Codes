// Java Program to Implement the RSA Algorithm
import java.math.*;
import java.util.*;

class rsa {
	public static void main(String args[])
	{
		int p, q, n,d=0, z, e, i;

		// The number to be encrypted and decrypted
		int msg = 8;
		double c;
		BigInteger msgback;

		// 1st prime number p
		p = 7;

		// 2nd prime number q
		q = 11;


        BigInteger biginteger1, biginteger2, MI;

        


		n = p * q;
		z = (p - 1) * (q - 1);
        // z is phi of ϕ(n)
		System.out.println(" phi(n) = " + z);



        



// calculating value of e
		// for (e = 2; e < z; e++) {

		// 	// e is for public key exponent
		// 	if (gcd(e, z) == 1) {
		// 		break;
		// 	}
		// }


        e=17;
		System.out.println(" e = " + e);

        biginteger1=BigInteger.valueOf(e);
        biginteger2=BigInteger.valueOf(z);
        BigInteger mi;
        mi = biginteger1.modInverse(biginteger2);

        
        d = mi.intValue();

		for (i = 0; i <= 9; i++) {
			int x = 1 + (i * z);

			// d is for private key exponent
			if (x % e == 0) {
				d = x / e;
				break;
			}
		}
		System.out.println(" d = " + d);
		c = (Math.pow(msg, e)) % n;

       

		// converting int value of n to BigInteger
		BigInteger N = BigInteger.valueOf(n);

		// converting float value of c to BigInteger
		BigInteger C = BigDecimal.valueOf(c).toBigInteger();
		msgback = (C.pow(d)).mod(N);
        System.out.println("msg or pt is: "+msg);
        System.out.println("decrypted ct is: "+ msgback);
		System.out.println("N is: "+ N);
		System.out.println("C is: "+C);
	} 

	static int gcd(int e, int z)
	{
		if (e == 0)
			return z;
		else
			return gcd(z % e, e);
	}
}
