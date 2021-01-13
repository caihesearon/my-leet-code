package 中等;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。 两个相邻元素间的距离为 1 。 0 0 0 0 1 0 0 0 0
 * 
 * 0 0 0 0 1 0 0 0 0
 * 
 * @author hecai
 * @date 2020年4月15日
 * 思路：
 * 	本题求的是其他元素到最近的0元素的距离
 * 	可以方向求解，首先收集所有的0元素的坐标并放入Queue<int[]>队列中保存
 * 	使其他元素设置为-1，从0元素的位置开始进行上下左右的扩散，0元素的周围不是0元素
 * 	就进行加1的操作，并且将得到的新坐标也放入队列中，用于后面的扩散
 */
public class _01矩阵 {

	public static void main(String[] args) {

	}

	public int[][] updateMatrix(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return null;
		int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
		Queue<int[]> queue = new LinkedList<int[]>();
		// 找到不等于0的 然后上下左右开始找到最近的一个0
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[] {i, j});
				}else {
					matrix[i][j] = -1;
				}
			}
		}
//		queue.offer(n1);
		while (!queue.isEmpty()) {
			int[] poll = queue.poll();
			int x = poll[0];
			int y = poll[1];
			for (int i = 0; i < 4; i++) {
				int xx = x + dir[i][0];
				int yy = y + dir[i][1];
				if(xx < 0 || yy < 0 || xx >= matrix.length || yy >= matrix[0].length) {
					continue;
				}
				if(matrix[xx][yy] == -1) {
					matrix[xx][yy] = matrix[x][y] + 1;
					queue.offer(new int[]{xx, yy});
				}
			}
		}
		return matrix;
	}
	
	

}
