#include <stdio.h>
#include <string.h>

void solve() {
    char s[1005];
    scanf("%s", s);
    int len = strlen(s);
    int count1[26] = {0};
    int count2[26] = {0};
    
    int mid1 = len / 2;
    int mid2 = (len % 2 == 0) ? (len / 2) : (len / 2 + 1);
    
    for (int i = 0; i < mid1; i++) {
        count1[s[i] - 'a']++;
    }
    
    for (int i = mid2; i < len; i++) {
        count2[s[i] - 'a']++;
    }
    
    int is_lapindrome = 1;
    for (int i = 0; i < 26; i++) {
        if (count1[i] != count2[i]) {
            is_lapindrome = 0;
            break;
        }
    }
    
    if (is_lapindrome) {
        printf("YES\n");
    } else {
        printf("NO\n");
    }
}

int main() {
    int t;
    if (scanf("%d", &t) == 1) {
        while (t--) {
            solve();
        }
    }
    return 0;
}



Sample Input
6
gaga
abcde
rotor
xyzxy
abbaab
ababc
Your Output
YES
NO
YES
YES
NO
NO
