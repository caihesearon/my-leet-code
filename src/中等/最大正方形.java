package 中等;
/**
*在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
示例:
输入: 
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
输出: 4
* @author hecai
* @date 2020年5月8日
*/
public class 最大正方形 {
	public static void main(String[] args) {
//		char[][] matrix = {{'1','0','1','0','0'},
//				{'1','0','1','1','1'},
//				{'1','1','1','1','1'},
//				{'1','0','0','1','0'}};
		char[][] matrix = {{'0','1'}};
		System.out.println(new 最大正方形().maximalSquare(matrix ));
	}
	
	char[][] map;
	int max = 0;
    public int maximalSquare(char[][] matrix) {
    	if(matrix.length == 0 || matrix[0].length == 0)
    		return 0;
    	map = matrix;
    	for(int i = 0; i < matrix.length; i++) {
    		for(int j = 0; j < matrix[0].length; j++) {
    			if(map[i][j] == '1') {
    				int len = 0;
    				while(deal(i, j, len)) {
    					len++;
    					max = Math.max(max, len*len);
    				}
    			}
    		}
    	}
    	
    	return max;
    }
    
    boolean deal(int x, int y, int len) {
    	if(x+len >= map.length || y+len >= map[0].length)
    		return false;
    	for(int i = x; i <= x + len; i++) {
    		for(int j = y; j <= y +len; j++) {
    			if(map[i][j] != '1')
    				return false;
    		}
    	}
    	return true;
    }

}
