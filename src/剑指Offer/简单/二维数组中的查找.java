package 剑指Offer.简单;

/**
 * 题曰 ：在一个二维数组中，每一行都按照从左到右递增的顺序排序
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的 个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author hecai
 * @date 2020/11/24
 */
public class 二维数组中的查找 {

    /**
     * 思路：从右上角或左下角开始
     * 如果数组中的元素大于查找的元素，则说明要查找的元素在左侧，因为数组该列上的所有元素都比该数大，所以排除该列
     * 如果小于，则说明要查找的元素在下侧
     *
     * @param matrix
     * @param num
     * @return
     */
    public static boolean find(int[][] matrix, int num) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int row = 0, column = columns - 1;
        while (row < rows && column >= 0) {
            if (matrix[row][column] == num) {
                System.out.println(row + " " + column);
                return true;
            } else if (matrix[row][column] > num) {
                --column;
            } else {
                row++;
            }
        }
        return false;
    }

    //左下角开始
    public static boolean leftFind(int[][] matrix, int num) {
        int rows = matrix.length, columns = matrix[0].length;
        int row = rows - 1, column = 0;
        while (row >= 0 && column < columns) {
            if (matrix[row][column] == num) {
                System.out.println(row + " " + column);
                return true;
            } else if (matrix[row][column] < num) {
                row--;
            } else {
                column++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}};
        int num = 10;
        System.out.println(find(matrix, num));
        System.out.println(find(matrix, num));
    }

}
