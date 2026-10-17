import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String[] pair1 = new String[t];
        String[] pair2 = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair1[i] = s.next();
            pair2[i] = s.next();
        }

        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < t; i++) {
            set.add(pair1[i] + " " + pair2[i]);
            System.out.println(set.size());
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
