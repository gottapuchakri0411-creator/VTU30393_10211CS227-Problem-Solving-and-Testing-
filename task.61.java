
HackerRank Home
|
Prepare
Certify
Compete
Search

2
|
Switch to..

PrepareJavaData StructuresJava Generics
Java Generics
92 more points to get your gold badge!
Rank: 442796|Points: 158/250
Java
Your Java Generics submission got 15.00 points.  
You are now 92 points away from the gold level for your java badge.
Try the next challenge | Try a Random Challenge
Problem
Submissions
Leaderboard
Discussions
Editorial
Generic methods are a very efficient way to handle multiple datatypes using a single method. This problem will test your knowledge on Java Generic methods.

Let's say you have an integer array and a string array. You have to write a single method printArray that can print all the elements of both arrays. The method should be able to accept both integer arrays or string arrays.

You are given code in the editor. Complete the code so that it prints the following lines:

1
2
3
Hello
World
Do not use method overloading because your answer will not be accepted.

Language
Java 7
More
145678910111213141516

import java.io.IOException;
import java.lang.reflect.Method;

 
class Printer
{
   //Write your code here
   public <T> void printArray(T[] array) {
       for (T element : array) {
           System.out.println(element);
       }
   }
}

public class Solution {
Line: 37 Col: 2

Test against custom input
Java
You have earned 15.00 points!
You are now 92 points away from the gold level for your java badge.
8%158/250
Congratulations
You solved this challenge. Would you like to challenge your friends?Share on XShare on LinkedIn

Test case 0
Compiler Message
Success
Expected Output
1
2
3
Hello
World
AuthorShafaet
DifficultyEasy
Max Score15
Submitted By137403
Need Help?
View discussions
View editorial
View top submissions
rate this challenge

MORE DETAILS
Download problem statement
Download sample test cases
Suggest Edits
Share on XShare on LinkedIn
BlogScoringEnvironmentFAQAbout UsHelpdeskCareersTerms Of ServicePrivacy Policy

Java
Congrats!
You have earned your 4th star.
Share on XShare on LinkedIn
