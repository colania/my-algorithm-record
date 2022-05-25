package main.java.com.leetcode.everyday;

/**
 * @description:
 * @author：wwei
 * @date: 2022/4/25
 */
public class SearchMatrix74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        int length = matrix.length;
        int weight = matrix[0].length;
        int row = -1;
        for (int i = 0; i < length; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][weight - 1]) {
                row = i;
            }
        }
        if (row == -1) {
            return false;
        }
        for (int j = 0; j < weight; j++) {
            if (matrix[row][j] == target) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        SearchMatrix74 searchMatrix74 = new SearchMatrix74();
        System.out.println(searchMatrix74.searchMatrix2(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int length = matrix.length;
        int weight = matrix[0].length;
        int row = 0;
        int cow = weight - 1;
        while (row < length && cow >= 0) {
            int data = matrix[row][cow];
            if (data == target) {
                return true;
            } else if (data < target) {
                row++;
            } else {
                cow--;
            }
        }
        return false;
    }
}
