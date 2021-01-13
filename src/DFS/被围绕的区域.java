package DFS;
/**
*
* @author hecai
* @date 2020年4月15日
*/
public class 被围绕的区域 {
	public static void main(String[] args) {
		
	}
	
	
	public void solve(char[][] board) {
		if(board == null || board.length == 0)
			return ;
		int rows = board.length;
		int cols = board[0].length;
		//遍历所有边界开始
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				boolean ok = i == 0 || j == 0 || i == rows-1 || j == cols-1;
				if(ok && board[i][j] == 'O') {
					//开始进行标记
					dfs(board, i, j);
				}
			}
		}
		//进行判断
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j <cols; j++) {
				if(board[i][j] == 'O')
					board[i][j] = 'X';
				if(board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}
	static void dfs(char[][] board, int i, int j) {
		if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j]=='*') {
			return ;
		}
		board[i][j] = '*';
		//上下左右
		dfs(board, i-1, j);
		dfs(board, i+1, j);
		dfs(board, i,  j-1);
		dfs(board, i, j+1);
	}

}
