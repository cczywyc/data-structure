package com.wangyc.dataStructure.sparsearray;

/**
 * 稀疏数组和二维数组的相互转化
 *
 * @author wangyc
 */
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组11*11
        //0表示没有棋子，1表示黑字，2表示蓝子
        int chessArr[][] = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        //原始二维数组有效数据的个数
        int sum = 0;
        System.out.println("原始的二维数组为");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
                if (data != 0) {
                    sum ++;
                }
            }
            System.out.println();
        }

        //根据二维数组得到对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //第几个非0的数据
        int count = 0;
        //遍历原始的二维数组，给稀疏数组赋值
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count ++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }

        //转换后的稀疏数组为
        System.out.println("转换后的稀疏数组为");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();

        //再将上述的稀疏数组转化为原始的二维数组
        int chessArray[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArray[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        System.out.println("恢复后的二维数组为");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
