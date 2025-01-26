package com.abz.techlab.standalone.medium.MinRemoveToMakeValidParentheses;

import java.util.Stack;

// Time complexity = O(N)
// Space complexity = O(N)
public class MinRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        char[] sarray = s.toCharArray();
        Stack<Integer> openParaIndex = new Stack<>();
        StringBuilder resultBuilder = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            Character resultChar = null;
            if('('==sarray[i]){
                if(i!=s.length()-1){
                    resultChar=sarray[i];
                    openParaIndex.push(resultBuilder.length());
                }
            } else if(')'==sarray[i]) {
                if(!openParaIndex.empty()) {
                    resultChar = sarray[i];
                    openParaIndex.pop();
                }
            } else {
                resultChar = sarray[i];
            }

            if(resultChar!= null) {
                resultBuilder.append(resultChar);
            }
        }

        if(!openParaIndex.empty()) {
            while(!openParaIndex.empty()) {
                resultBuilder.deleteCharAt(openParaIndex.pop());
            }
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        MinRemoveToMakeValidParentheses problem = new MinRemoveToMakeValidParentheses();
        String s1 = "abz(-)try-la)b";
        String result1 = problem.minRemoveToMakeValid(s1);
        System.out.println(s1+" -> "+result1);

        String s2 = "(((((";
        String result2 = problem.minRemoveToMakeValid(s2);
        System.out.println(s2+" -> "+result2);

        String s3 = ")))))";
        String result3 = problem.minRemoveToMakeValid(s3);
        System.out.println(s3+" -> "+result3);

        String s4 = ")))(((";
        String result4 = problem.minRemoveToMakeValid(s4);
        System.out.println(s4+" -> "+result4);

        String s5 = "(()((";
        String result5 = problem.minRemoveToMakeValid(s5);
        System.out.println(s5+" -> "+result5);
    }
}
