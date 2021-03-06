package 中等;
/**
*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
输入:
11110
11010
11000
00000
输出: 1
输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
* @author hecai
* @date 2020年4月20日
*/
public class 岛屿数量 {
	
	char[][] map;
	public int numIslands(char[][] grid) {
		int count = 0;
		map = grid;
		for(int i= 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == '1') {
					deal(i, j);
					count++;
				}
			}
		}		
		return count;
    }
	
	public void deal( int x, int y) {
		if(x < 0 || x >= map.length || y < 0 || y >= map[0].length)
			return ;
		if(map[x][y] != '1')
			return ;
		map[x][y] = '2';
		deal( x-1, y);
		deal( x+1, y);
		deal( x, y-1);
		deal( x, y+1);
	}
	
	
	public static void main(String[] args) {
		char[][] map = {{'1','1','1','1','0'},
				{'1','1','0','1','0'},
				{'1','1','0','0','0'},
				{'0','0','0','0','0'}};
		
//		int numIslands = numIslands(map);
//		//System.out.println((int)map[0][0]);
//		System.out.println(numIslands);
	}
	
}
