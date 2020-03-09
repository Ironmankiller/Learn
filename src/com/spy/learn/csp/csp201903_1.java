package com.spy.learn.csp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class csp201903_1 {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        int maxn=Integer.MIN_VALUE,minn=Integer.MAX_VALUE;
        int midn=-1;double res=-1;
        int t=n;
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,sum=0;
        while(t--!=0){
            int i=scan.nextInt();
            if(i>maxn)
                maxn=i;
            if(i<minn)
                minn=i;
            if(n%2==1){//n为奇数
                if(t==n/2){
                    midn=i;
                }
            }
            if(n%2==0){//n为偶数
                if(t==n/2-1){
                    left=i;
                }
                if(t==n/2){
                    right=i;
                }
                sum=left+right;
                if(sum%2==0) {
                    midn = sum / 2;
                }
                else
                    res=sum / 2.0;
            }
        }
        if(sum%2==0)
            System.out.println(maxn+" "+midn+" "+minn);
        else
            System.out.println(maxn+" "+res+" "+minn);
    }
}
