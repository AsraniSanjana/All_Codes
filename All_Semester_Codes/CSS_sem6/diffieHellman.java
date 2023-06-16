// This program calculates the Key for two persons
// using the Diffie-Hellman Key exchange algorithm
class diffieHellman{
	
    // Power function to return value of a ^ b mod P
    private static long power(long a, long b, long p)
    {
        if (b == 1)
            return a;
        else
            return (((long)Math.pow(a, b)) % p);
    }
    
    // Driver code
    public static void main(String[] args)
    {
        long P, G, x, a, y, b, ka, kb;
        
        // Both the persons will be agreed upon the
        // public keys G and P
        
        // A prime number P is taken
        P = 13;
        System.out.println("The value of P:" + P);
        
        // A primitive root for P, G is taken
        G = 6;
        System.out.println("The value of G:" + G);
        
        // Alice will choose the private key a
        // a is the chosen private key
        a = 3;
        System.out.println("The private key a for Alice:" + a);
        
        // Gets the generated key
        x = power(G, a, P);
        
        // Bob will choose the private key b
        // b is the chosen private key
        b = 10;
        System.out.println("The private key b for Bob:" + b);
        
        // Gets the generated key
        y = power(G, b, P);
        
        // Generating the secret key after the exchange
        // of keys
        ka = power(y, a, P); // Secret key for Alice
        kb = power(x, b, P); // Secret key for Bob
        
        System.out.println("Shared Secret key for Alice & Bob :");
        System.out.println("for Alice : " + ka);
        System.out.println("for Bob : " + kb);
    }
    }
    
    