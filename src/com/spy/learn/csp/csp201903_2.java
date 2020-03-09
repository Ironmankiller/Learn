package com.spy.learn.csp;

import java.util.Scanner;
import java.util.Stack;

public class csp201903_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        Stack<String> ss = new Stack<>();
        for(int q=0;q<n;q++){

            ss.clear();
            String s = scanner.nextLine();
            int len = s.length();
            for(int i=0;i<len;i++) {
                if(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
                    int num = s.charAt(i)-'0';
                    i++;
                    while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
                        num = num*10+s.charAt(i)-'0';
                        i++;
                    }
                    ss.push(new Integer(num).toString());
                }
                if(i<len&&s.charAt(i)=='+') {
                    ss.push("+");
                }
                if(i<len&&s.charAt(i)=='-') {
                    ss.push("-");
                }
                if(i<len&&s.charAt(i)=='x'){
                    int num1 = Integer.parseInt(ss.pop());
                    i++;
                    int num2 = s.charAt(i)-'0';
                    i++;
                    while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
                        num2 = num2*10+s.charAt(i)-'0';
                        i++;
                    }
                    i--;
                    ss.push(new Integer(num1*num2).toString());
                }
                if (i < len && s.charAt(i) == '/') {
                    int num1 = Integer.parseInt(ss.pop());
                    int num2 = s.charAt(++i)-'0';
                    i++;
                    while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
                        num2 = num2*10+s.charAt(i)-'0';
                        i++;
                    }
                    i--;
                    ss.push(new Integer(num1/num2).toString());
                }
            }
            int result = 0;
            Stack<String> ss0 = new Stack<>();
            while(!ss.isEmpty()){
                ss0.push(ss.pop());
            }
            result = Integer.parseInt(ss0.pop());
            while(!ss0.isEmpty()) {

                String str = ss0.pop();
                //System.out.println(str);
                if(str.equals("+")) {
                    result += Integer.parseInt(ss0.pop());
                } else if(str.equals("-")){
                    result -= Integer.parseInt(ss0.pop());
                }
            }
            if(result == 24) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            //System.out.println(result);
        }
    }
}
