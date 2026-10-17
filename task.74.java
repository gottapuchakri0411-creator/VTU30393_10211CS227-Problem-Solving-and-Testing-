import java.io.*;
import java.util.*;

interface AdvancedArithmetic {
    int divisor_sum(int n);
}

class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisor_sum(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
      }

    /*
     *  Code added to print the name of the interfaces implemented by a class
     */
    static void ImplementedInterfaceNames(Object o){
        Class<?>[] theInterfaces = o.getClass().getInterfaces();
        for (Class<?> o1 : theInterfaces) {
            String name = o1.getName();
            System.out.println(name);
        }
    }
}


Input (stdin)
6
Expected Output
I implemented: AdvancedArithmetic
12
