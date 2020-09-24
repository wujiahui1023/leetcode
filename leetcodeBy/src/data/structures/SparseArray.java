package data.structures;

import java.io.*;
import java.util.Arrays;

/**
 * 稀疏数组
 *
 * @author jiahui.wu
 */
public class SparseArray {

    public static void main(String[] args) {


        System.out.println(3 % 3);

        int i = 11;
        int j = 11;
        // 初始化 原始二维数组
        int[][] chessArray1 = new int[i][j];
        chessArray1[1][2] = 1;
        chessArray1[2][4] = 2;

        // 原始二维数组 输出
        for (int[] x : chessArray1) {
            for (int y : x) {

                System.out.printf("%d\t", y);
            }
            System.out.println();
        }

        // 原始二维数组转稀疏数组
        int[][] encodeArray = encodeArray(chessArray1);

        // 稀疏数组转原始数组
        int[][] decodeArray = decodeArray(encodeArray);


        //   输出流
        //从内存到硬盘
        //文件不存在 输出流会自动创建这样一个文件
        OutputStream out = null;
        try {
            out = new FileOutputStream("D:\\haha.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s1 = "再见";
        //输入还是输出流  操作的都是内存空间  字节数组
        try {
            out.write(s1.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //	输入流
        //从硬盘到内存，文件必须存在
        InputStream in = null;
        try {
            in = new FileInputStream("D:\\haha.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //1.分配一块内存空间 临时的空间 存放我文件的数据
        byte[] b = new byte[0];
        try {
            b = new byte[in.available()];

            //2.将数据读入到内存空间
            in.read(b);
            //3.将数据转换为字符串
            //如果编码是UTF-8 可以省略
            String s = new String(b, "GBK");
            System.out.println(s);
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int[][] encodeArray(int[][] chessArray1) {

        // 1 遍历原始二维组；计算有多少个非0的数据
        int sum = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[i].length; j++) {
                if (chessArray1[i][j] != 0) {
                    sum++;
                }
            }
        }

        // 2 创建对应的稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        sparseArray[0][0] = chessArray1.length;
        sparseArray[0][1] = chessArray1[0].length;
        sparseArray[0][2] = sum;

        // 3 遍历原始二维数组，将非0的 值填入稀疏数组
        int count = 0;
        for (int i = 0; i < chessArray1.length; i++) {
            for (int j = 0; j < chessArray1[0].length; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }

            }
        }

        // 4输出稀疏数组
        for (int[] sparseArray1 : sparseArray) {
            for (int sparse : sparseArray1) {
                System.out.printf("%d\t", sparse);
            }
            System.out.println();
        }

        return sparseArray;
    }

    private static int[][] decodeArray(int[][] encodeArray) {

        // 稀疏数组转原始二维数组
        // 1 初始化原始数组
        int[][] chessArray1 = new int[encodeArray[0][0]][encodeArray[0][1]];

        // 2 遍历稀疏数组
        for (int i = 1; i < encodeArray.length; i++) {

            chessArray1[encodeArray[i][0]][encodeArray[i][1]] = encodeArray[i][2];
        }

        // 原始二维数组 输出
        for (int[] x : chessArray1) {
            for (int y : x) {

                System.out.printf("%d\t", y);
            }
            System.out.println();
        }

        return chessArray1;
    }


}
