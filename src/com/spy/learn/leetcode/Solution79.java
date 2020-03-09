package com.spy.learn.leetcode;
public class Solution79 {
	
	
	
	public static void main(String[] args) {
//		char[][] board = {
//				{'A','B','C','E'},
//				{'S','F','C','S'},
//				{'A','D','E','E'}
//				};
//		char[][] board = {
//				{'A','B'}
//				};
//		char[][] board = {
//				{'C','A','A'},
//				{'A','A','A'},
//				{'B','C','D'}
//				};
		char[][] board = {
				{'A','B','C','E'},
				{'S','F','E','S'},
				{'A','D','E','E'}
				};
		boolean max = exist(board,"ABCESEEEFS");
		System.out.println(max);
	}
	
	public static boolean exist(char[][] board, String word) {
        if(word==null) {
            return false;
        }
        
        int length = word.length();
        if(length == 0) {
        	return false;
        }
        
        int width = board[0].length;
        int height = board.length;
        
        
        for(int i=0;i<height;i++) {
        	for(int j=0;j<width;j++) {
        		if(board[i][j] == word.charAt(0)) {
        			boolean[][] flag = new boolean[height][width];
        			if(dfs(board,word,i,j,1,flag)==true) {
        				return true;
        			}
        		}
        	}
        }
        return false;
    }
	
	public static boolean dfs(char[][] board,String word,int i,int j,int num,boolean[][] flag) {
		
		//System.out.println("i:"+i+"j:"+j+"num:"+num+"board[i][j]"+board[i][j]);
		int width = board[0].length;
        int height = board.length;
        flag[i][j] = true;
        if(num == word.length()) return true;
        if((i+1<height)&&flag[i+1][j]!=true&&board[i+1][j] == word.charAt(num)) {
        	if(dfs(board,word,i+1,j,num+1,flag) == true) {
        		return true;
        	}
        	flag[i+1][j] = false;
        }
        if((i-1>=0)&&flag[i-1][j]!=true&&board[i-1][j] == word.charAt(num)) {
        	if(dfs(board,word,i-1,j,num+1,flag) == true) {
        		return true;
        	}
        	flag[i-1][j] = false;
        }
       
        if((j+1<width)&&flag[i][j+1] != true&&board[i][j+1] == word.charAt(num)) {
        	if(dfs(board,word,i,j+1,num+1,flag)) {
        		return true;
        	}
        	flag[i][j+1] = false;
        }
        if((j-1>=0)&&flag[i][j-1] != true&&board[i][j-1] == word.charAt(num)) {
        	if(dfs(board,word,i,j-1,num+1,flag)) {
        		return true;
        	}
        	flag[i][j-1] = false;
        }
        
        return false;
	}



	public static boolean dfs(char[][] board, String word, int i, int j,int index){
		if(index==word.length())
			return true;
		if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!=word.charAt(index))
			return false;
		char temp=board[i][j];
		board[i][j]='*';//改变搜索过的状态
		if(dfs(board,word,i+1,j,index+1) || dfs(board,word,i-1,j,index+1)
				|| dfs(board,word,i,j+1,index+1) || dfs(board,word,i,j-1,index+1)){
			return true;
		}
		board[i][j]=temp;//该分支的DFS已经完成，需要回溯还原现场！！！
		return false;
	}

}
