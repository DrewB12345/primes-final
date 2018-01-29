/**
 * Two examples of methods for determining whether an int is prime. 
 * You will be asked questions about this code on the loops test.
 * 
 * @author Jon Cooper
 * @version November 18, 2013
 */
public class Primes 
{
    /**
     * Determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime1(int n)
    {
        if (n < 2) return false;
        for (int i=2; i<n; i++)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    /**
     * A more efficient way to determine if an int is prime.
     * 
     * @param n     number to test
     * @return      true if number is prime, false otherwise
     */
    public static boolean isPrime2(int n)
    {
        if (n < 2) return false;
        else if (n == 2)   return true;
        else if (n % 2==0) return false;
        
        double limit = Math.sqrt(n);
        
        for (int i=3; i<=limit; i+=2)
        {
            if (n % i == 0) return false;
        }
        
        return true;
    }
    
    /**
    public static void printFiftyPrimes()
    {
        int count = 0;
        int i = 2;
        boolean isPrime = true;
        while (count < 50) {
            isPrime = true;
            if (i < 2 || i % 2 == 0) isPrime = false;
            double top = Math.sqrt(i);
            for (int j=3; j<top + 1; j+=2) {
                if (i%j==0) isPrime = false;
            }
            if (i == 2 || isPrime) { 
                count++;
                System.out.print(i);
                if (count < 50) System.out.print(", ");
            }
            i++;
        }
    }
    **/
    
    public static void printFiftyPrimes()
    {
        int count = 0;
        int i = 0;
        while (count < 50) {
            if (isPrime2(i)) {
                count++;
                System.out.print(i);
                if (count < 50) System.out.print(", ");
            }
            i++;
        }
    }
    
    /**
    public static int findNthPrime(int n)
    {
        int count = 0;
        int i = 2;
        boolean isPrime = true;
        while (count < n) {
            isPrime = true;
            if (i < 2 || i % 2 == 0) isPrime = false;
            double top = Math.sqrt(i);
            for (int j=3; j<top + 1; j+=2) {
                if (i%j==0) isPrime = false;
            }
            if (i == 2 || isPrime) count++;
            i++;
        }
        return i-1;
    }
    **/
    
    public static int findNthPrime(int n) {
        int count = 0;
        int i = 2;
        while (count < n) {
            if (isPrime2(i)) count++;
            i++;
        }
        return i-1;
    }

    public static int countTo(int n) {
        int count = 0;
        int i = 2;
        while (i <= n) {
            if (isPrime2(i)) count++;
            i++;
        }
        return count;
    }
    
    public static int sumTo(int n) {
        int count = 0;
        int i = 2;
        int sum = 0;
        while (i <= n) {
            if (isPrime2(i)){
                count++;
                sum += i;
            }
            i++;
        }
        return sum;
    }

    public static int sumToNPrimes(int n) {
        int count = 1;
        int i = 2;
        int sum = 0;
        while (count <= n) {
            if (isPrime2(i)){
                count++;
                sum += i;
            }
            i++;
        }
        return sum;
    }

    public static void main(String[] args)
    {
        // test isPrime1
        System.out.println( isPrime1(2) );
        System.out.println( isPrime1(9) );
        System.out.println( isPrime1(17) );
        
        // test isPrime2
        System.out.println( isPrime2(2) );
        System.out.println( isPrime2(9) );
        System.out.println( isPrime2(17) );
        
        
        // Study the isPrime1 and isPrime2 methods to answer the following:
        
        // 0. Study the method isPrime1. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.

        // 19: 2-18
        // 91: 2-90
        // 643: 2-642
        
        // 1. Study the method isPrime2. Describe the set of numbers that would be 
        //    tested as divisors when checking the value 19 for primality. Do the 
        //    same for 91 and 643.
        
        // 19: 2, 3
        // 91: 2, 3, 5, 7, 9
        // 643: 2, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25
        
        // 2. The number 15,485,863 is the 1 millionth prime number. Suppose it is 
        //    tested in both isPrime1 and isPrime2 for primality. About how much
        //    faster will isPrime2 finish testing. Show how you determined your answer.
        
        // With isPrime1, 15,485,861 numbers will be checked
        // With isPrime2, 1,968 numbers will be checked
        // 15485861/1968 = about 7868.8318 times faster
        
        // 3. In isPrime2, why is the limit calculated before the loop rather than
        //    writing the loop as for (int i=3; i<=Math.sqrt(n); i=i+2)?
        
        // If a square root function is in the loop, it will keep doing it, slowing
        // down the whole process.
        
        // 4. The number 1 is not prime, however both prime function say that it is.
        //    Negative numbers cannot be prime either. Fix each function so that all
        //    ints less than 2 return false.

        
        
        // Write blocks of code that use isPrime2 to solve the following problems:
        
        // 5. Generate a list of the first 50 prime numbers.
        
        System.out.println();
        printFiftyPrimes();
        System.out.println();
        System.out.println();
        
        // 6. What is the 100th prime? the 1000th? The 12847th?
        
        System.out.println(findNthPrime(100));
        System.out.println(findNthPrime(1000));
        System.out.println(findNthPrime(12847));
        System.out.println();
    
        // 7. In the set of integers from 2-1000000, how many are prime?
        
        System.out.println(countTo(1000000));
        System.out.println();
        
        // 8. What is the sum of the all prime numbers below 1000000?
        
        System.out.println(sumTo(1000000));
        System.out.println();
        
        // 9. What is the sum of the first 1000 prime numbers?

        System.out.println(sumToNPrimes(1000));
        System.out.println();
    }
    
}
