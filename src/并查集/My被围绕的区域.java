package 并查集;

import java.util.Arrays;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

/**
*
*给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
X X X X
X O O X
X X O X
X O X X

X X X X
X X X X
X X X X
X O X X
被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 
任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，
则称它们是“相连”的。
* @author hecai
* @date 2020年4月15日
* 思路：并查集
* 	将和边界相邻的所有0使用一个father
* 	将被包围的所有0使用另一个father
*/
public class My被围绕的区域 {
	
	static int[] father;
	
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},
						  {'X' ,'O', 'O', 'X'},
						  {'X', 'O' ,'O', 'X'},	
						  {'X' ,'O', 'X' ,'X'}	};
//		[["O","X","X","O","X"],
//		 ["X","O","O","X","O"],
//		 ["X","O","X","O","X"],
//		 ["O","X","O","O","O"],
//		 ["X","X","O","X","O"]]
		new My被围绕的区域().solve(board);
	}
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0)
			return ;
		int row = board.length;
		int col = board[0].length;
		father = new int[row * col + 10];
		initFather(row*col+10);
		//定义个边界father  AllFather
		int AllFather = row * col;
		//首先遍历边界
		for(int i = 0; i < row; i++) {
			
		}
		
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'O') {
					//如果在边界上
					if(i == 0 || j == 0 || i == row-1 || j == col-1) {
						union(getIndex(i, j, col), AllFather);
					}else {
						//上下左右
						if(i > 0 && board[i-1][j] == 'O') {
							union(getIndex(i,j,col), getIndex(i-1,j,col));
						}else if(i < row-1 && board[i+1][j]=='O') {
							union(getIndex(i,j,col), getIndex(i+1,j,col));
						}else if(j > 0 && board[i][j-1] == 'O') {
							union(getIndex(i,j,col), getIndex(i,j-1,col));
						}else if(j < col - 1 && board[i][j+1] == 'O') {
							union(getIndex(i,j,col), getIndex(i,j+1,col));
						}
					}
				}
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(board[i][j] == 'O' && isConnect(getIndex(i, j, col), AllFather)) {
					board[i][j] = 'O';
				}else {
					board[i][j] = 'X';
				}
			}		
//			System.out.println(Arrays.toString(board[i]));
		}
		
	}
	
	//初始化father数组
	static void initFather(int len) {
		for(int i = 1; i < len; i++)
			father[i] = i;
	}
	
	//将二维的坐标计算为一维的下标
	static int getIndex(int x, int y, int col) {
		return x * col + y;
	}
	
	//实现并查集的方法
	//找父节点
	static int find(int node) {
		if(node == father[node])
			return node;
		//如果没有找到 使当前结点的父结点等于父节点的父节点
		return father[node] = find(father[node]);
	}
	//连接两个节点
	static void union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);
		if(root1 != root2) {
			father[root2] = root1;
		}
	}
	//判断是否指向同一个father
	static boolean isConnect(int node1, int node2) {
		return find(node1) == find(node2);
	}
	
	
}
