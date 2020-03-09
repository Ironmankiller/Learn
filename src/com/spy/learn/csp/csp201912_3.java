package com.spy.learn.csp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class csp201912_3 {

//	public static Stack<Integer> ss = new Stack<>();
//	public static Stack<String> sp = new Stack<>();
//	public static Map<String,Integer> map = new HashMap<>();
//	public static Stack<Integer> ss0 = new Stack<>();
//
//	public static void main(String[] args) {
//
//		@SuppressWarnings("resource")
//		Scanner scan=new Scanner(System.in);
//        Integer num=Integer.parseInt(scan.nextLine());
//        while(num--!=0){
//            String s=scan.nextLine();
//            if(check(s)==true) {
//            	System.out.println("Y");
//            } else {
//            	System.out.println("N");
//            }
//        }
//	}
//
//	public static boolean check(String s) {
//
//		int len = s.length();
//		boolean after = false;    //是否在等号之后;
//		boolean f = true;         //代表新的项
//		int xishu=0;              //代表新的项的系数
//
//		ss.clear();
//		ss0.clear();
//		sp.clear();
//		map.clear();
//
//		for(int i=0;i<len;i++) {
//
//			/***************************************/
//			if(f==true) {           //开始了新的一项 记录系数
//				while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
//					xishu = xishu*10 + s.charAt(i)-48;
//					i++;
//				}
//				if(xishu == 0) {
//					xishu = 1;
//				}
//				f = false;
//			}
//			/***************************************/
//
//
//			/***************************************/
//			if(i<len&&s.charAt(i) == '(') {
//				ss.push(-1);    //-1表示左括号
//			}
//			/***************************************/
//
//			/***************************************/
//			if(i<len&&s.charAt(i) == ')') {
//				ss0.clear();
//				int u = 0;
//				i++;
//				while(i<len&&s.charAt(i)>='0' && s.charAt(i) <= '9') {
//					u = u*10+s.charAt(i)-'0';
//					i++;
//				}
//
//				if(u==0) {
//					u=1;
//				}
//				while(!ss.isEmpty()) {
//					int k = ss.pop();
//					if(k==-1) {
//						break;
//					}
//					ss0.push(k*u);
//				}
//				while(!ss0.isEmpty()) {
//					int k = ss0.pop();
//					ss.push(k);
//				}
//				i--;
//			}
//			/***************************************/
//
//			/***************************************/
//			if(i<len&&s.charAt(i)>='A'&&s.charAt(i)<='Z') {        //大写开头
//
//				int xx=0;
//				StringBuilder sb = new StringBuilder();
//				sb.append(s.charAt(i));
//				i++;
//				while(i<len&&s.charAt(i)>='a'&&s.charAt(i)<='z') {    //一系列小写字母
//					sb.append(s.charAt(i));
//					i++;
//				}
//				while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
//					xx = xx*10 + s.charAt(i)-48;
//					i++;
//				}
//				if(xx == 0) {
//					xx=1;
//				}
//				i--;
//
//
//				sp.push(sb.toString());
//				ss.push(xx);
//
//			}
//			/***************************************/
//
//			/***************************************/
//
//			if(i<len&&(s.charAt(i) == '+'|| s.charAt(i) == '=' || i==len-1)) {
//
//				while(!ss.isEmpty()) {
//					int k = ss.pop();
//					String sss = sp.pop();
//
//					if(after == true) {
//						if(!map.containsKey(sss)) {
//							map.put(sss, xishu*k);
//						} else {
//							map.put(sss, map.get(sss)-k*xishu);
//						}
//					} else {
//						if(!map.containsKey(sss)) {
//							map.put(sss, xishu*k);
//						} else {
//							map.put(sss, map.get(sss)+xishu*k);
//						}
//					}
//					//System.out.println(sss+map.get(sss)+" "+xishu);
//
//				}
//
//				if(s.charAt(i) == '=') {
//					after = true;
//				}
//				xishu = 0;
//				f = true;
//			}
//			/***************************************/
//
//
//		}
//		for(String sa:map.keySet()) {
//			if(map.get(sa) != 0) {
//				return false;
//			}
//		}
//		return true;
//	}
	
	private static boolean[] flag = new boolean[101];



	public static void main(String[] args) {
		FileInputStream fin =null;
		InputStreamReader iin = null;
		BufferedReader in = null;
		Integer num = null;
		try {
			fin = new FileInputStream("1.txt");
			iin = new InputStreamReader(fin,"UTF-8");
			in = new BufferedReader(iin);
			String line = null;
            int i = 0;
            num = Integer.parseInt(in.readLine());
            while (i != num){
            	line = in.readLine();
                flag[i++] = check(line);
                System.out.println(line);
            }

		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			try {
				fin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
			try {
				iin.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

		for(int i=0;i<num;i++) {
			System.out.println(flag[i]);
		}
	}

	public static boolean check(String s) {

		int len = s.length();
		boolean after = false;    //是否在等号之后;
		boolean f = true;         //代表新的项
		int xishu=0;              //代表新的项的系数
		Stack<Integer> ss = new Stack<>();
		Stack<String> sp = new Stack<>();
		Map<String,Integer> map = new HashMap<>();
		for(int i=0;i<len;i++) {

			/***************************************/
			if(f==true) {           //开始了新的一项 记录系数
				while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
					xishu = xishu*10 + s.charAt(i)-48;
					i++;
				}
				if(xishu == 0) {
					xishu = 1;
				}
				f = false;
			}
			/***************************************/


			/***************************************/
			if(i<len&&s.charAt(i) == '(') {
				ss.push(-1);    //-1表示左括号
			}
			/***************************************/

			/***************************************/
			if(i<len&&s.charAt(i) == ')') {
				Stack<Integer> ss0 = new Stack<>();
				int u = 0;
				i++;
				while(i<len&&s.charAt(i)>='0' && s.charAt(i) <= '9') {
					u = u*10+s.charAt(i)-'0';
					i++;
				}

				if(u==0) {
					u=1;
				}
				while(!ss.isEmpty()) {
					int k = ss.pop();
					if(k==-1) {
						break;
					}
					ss0.push(k*u);
				}
				while(!ss0.isEmpty()) {
					int k = ss0.pop();
					ss.push(k);
				}
				i--;
			}
			/***************************************/

			/***************************************/
			if(i<len&&s.charAt(i)>='A'&&s.charAt(i)<='Z') {

				int xx=0;
				String sb = ""+s.charAt(i);
				i++;
				while(i<len&&s.charAt(i)>='a'&&s.charAt(i)<='z') {
					sb=sb+(s.charAt(i));
					i++;
				}
				while(i<len&&s.charAt(i)>='0'&&s.charAt(i)<='9') {
					xx = xx*10 + s.charAt(i)-48;
					i++;
				}
				if(xx == 0) {
					xx=1;
				}
				i--;


				sp.push(sb.toString());
				ss.push(xx);

			}
			/***************************************/

			/***************************************/

			if(i<len&&(s.charAt(i) == '+'|| s.charAt(i) == '=' || i==len-1)) {

				while(!ss.isEmpty()) {
					int k = ss.pop();
					String sss = sp.pop();

					if(after == true) {
						if(!map.containsKey(sss)) {
							map.put(sss, xishu*k);
						} else {
							map.put(sss, map.get(sss)-k*xishu);
						}
					} else {
						if(!map.containsKey(sss)) {
							map.put(sss, xishu*k);
						} else {
							map.put(sss, map.get(sss)+xishu*k);
						}
					}
					//System.out.println(sss+map.get(sss)+" "+xishu);

				}

				if(s.charAt(i) == '=') {
					after = true;
				}
				xishu = 0;
				f = true;
			}
			/***************************************/


		}
		for(String sa:map.keySet()) {
			if(map.get(sa) != 0) {
				return false;
			}
		}
		return true;
	}
	
}
