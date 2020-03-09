package com.spy.learn.leetcode;


public class Solution5 {

	public static void main(String[] args) {
		String max = new Solution5().longestPalindrome("baaab");
		System.out.println(max);
	}

	public String longestPalindrome(String s) {

		int len = s.length();
		if(len == 0) {
			return "";
		}
		int leftmax=0;
		int rightmax=0;
		char[] str = s.toCharArray();
		for(int i=0;i<len;i++) {
			int left = i;
			int right = i;
			while(right<len-1 && str[right] == str[right+1]) {
				right++;
			}
			while(left>0 && right<len-1 && str[right+1] == str[left-1]) {
				left--;
				right++;
			}
			if(right-left>rightmax-leftmax) {
				rightmax = right;
				leftmax = left;
			}
		}
		return s.substring(leftmax,rightmax+1);
	}
	
//	public static String longestPalindrome(String s) {
//		int max = 0;
//		String maxStr = "";
//		if(s == null) {
//			return null;
//		}
//		int len = s.length();
//		if(len == 0) {
//			return "";
//		}
//		boolean[][] a = new boolean[len][len];
//		for(int i=1;i<=len;i++) {
//			for(int j=0;j<len;j++) {
//				int start = j;
//				int end = j+i-1;
//	            if (end >= len) //下标已经越界，结束本次循环
//	                break;
//				if(s.charAt(start) == s.charAt(end)&&(i == 2||i == 1||a[start+1][end-1])) {
//					a[start][end] = true;
//				}
//				if(a[start][end]&&i>max) {
//					maxStr = s.substring(start,end+1);
//				}
//			}
//		}
//		return maxStr;
//
//
//	}
	
//	public static String longestPalindrome(String s) {
//		
//		int maxStrLen = 0;
//		int maxStrIndex = 0;
//		if(s==null) {
//			return null;
//		}
//		String reverse = new StringBuilder(s).reverse().toString();
//		int len = s.length();
//		if(len == 0) {
//			return "";
//		}
//		int dp[] = new int[len];
//		for(int i=0;i<len;i++) {
//			for(int j=len-1;j>=0;j--) {
//				if(s.charAt(i) == reverse.charAt(j)) {
//					if(i==0||j==0) {
//						dp[j] = 1;
//					} else {
//						dp[j] = dp[j-1] + 1;
//					}
//				} else {
//					dp[j] = 0;
//				}
//				if(dp[j]>maxStrLen) {
//					if(len-1-i+dp[j]-1 == j) {
//						maxStrLen = dp[j];
//						maxStrIndex = j;
//					}
//				}
//			}
//		}
//		return reverse.substring(maxStrIndex-maxStrLen+1,maxStrIndex+1);
//	}
	
//	public static String longestPalindrome(String s) {
//		
//		int maxStrLen = 0;
//		int maxStrIndex = 0;
//		if(s==null) {
//			return null;
//		}
//		String reverse = new StringBuilder(s).reverse().toString();
//		int len = s.length();
//		if(len == 0) {
//			return "";
//		}
//		int dp[][] = new int[len][len];
//		for(int i=0;i<len;i++) {
//			for(int j=0;j<len;j++) {
//				if(s.charAt(i) == reverse.charAt(j)) {
//					if(i==0||j==0) {
//						dp[i][j] = 1;
//					} else {
//						dp[i][j] = dp[i-1][j-1] + 1;
//					}
//				}
//				if(dp[i][j]>maxStrLen) {
//					if(len-1-i+dp[i][j]-1 == j) {
//						maxStrLen = dp[i][j];
//						maxStrIndex = j;
//					}
//				}
//			}
//		}
//		return reverse.substring(maxStrIndex-maxStrLen+1,maxStrIndex+1);
//	}
	
//	 public static String longestPalindrome(String s) {
//			
//			int max = 0;
//			String maxStr = null;
//	        if(s==null){
//	            return null;
//	        }
//			int len = s.length();
//			if(len==0) {
//				return "";
//			}
//			for(int i=0;i<len;i++) {
//				for(int j=i+1;j<=len;j++) {
//					String substr = s.substring(i,j);
//					if(isHuiWen(substr)>max) {
//						maxStr = substr;
//	                    max = substr.length();
//					}
//				}
//			}
//			return maxStr;
//	    }
//		
//		public static int isHuiWen(String s) {
//			int len = s.length();
//	        if(len==1){
//	            return 1;
//	        }
//			for(int i=0;i<len/2;i++) {
//				if(s.charAt(i)!=s.charAt(len-1-i))
//					return 0;
//			}
//			return len;
//		}
}
