import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

 public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

//Write your code here
HashSet<String> pairs = new HashSet<>();
for (int i = 0; i < t; i++) {
    pairs.add(pair_left[i] + " " + pair_right[i]);
    System.out.println(pairs.size());
}

   }
}


Input (stdin)
1000
ae ec
jl jj
gj ja
mc de
jc lj
ca mg
ni kg
cm id
an dd
if kj
nl ia
la el
ac gh
bh lc
ac im
nd ba
cm bl
bn fi
ik ia{-truncated-}
Expected Output
1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
20{-truncated-}
 
