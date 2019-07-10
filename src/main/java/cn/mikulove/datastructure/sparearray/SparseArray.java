package cn.mikulove.datastructure.sparearray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SparseArray {
	
	public static void main(String[] args) throws IOException {
		int[][] array = new int[9][9];
		array[3][4] = 1;
		array[4][4] = 2;
		array[4][3] = 1;
		
		/*SparseArray.printArray(array);
		
		SparseArray.printArray(SparseArray.normalToSparse(array));
		
		SparseArray.printArray(SparseArray.sparseToNormal(SparseArray.normalToSparse(array)));
	
		SparseArray.arrayToFile(SparseArray.normalToSparse(array),new File("D:/map.data"));*/
		
		SparseArray.printArray(SparseArray.arrayToFile(new File("D:/map.data")));
	}
	
	/**
	 * 稀疏数组转普通数组
	 * @param array
	 * @return
	 */
	private static int[][] sparseToNormal(int[][] sparseArray){
		// 1 根据稀疏数组第一行 初始化 普通数组
		int col = sparseArray[0][0]; //列
		int row = sparseArray[0][1]; //行
		int[][] array = new int[col][row]; 
		
		// 2 遍历稀疏数组 给二维数组赋值
		for(int a=1;a<sparseArray.length;a++ ){
			int[] arr = sparseArray[a];
			array[arr[0]][arr[1]]=arr[2];
		}
		
		return array;
	}
	
	/**
	 * 二维数组转稀疏数组
	 * @param array
	 * @return
	 */
	private static int[][] normalToSparse(int[][] array){
		// 1 遍历查出总共 需要挑出的数据个数
		int sum = 0;
		for(int[] arr:array){
			for(int i:arr){
				if(i!=0)
				sum++;
			}
		}
		
		// 2 初始化稀疏数组 并 给第一列赋值
		int[][] sparseArray = new int[sum+1][3];
		sparseArray[0][0] = array.length;
		sparseArray[0][1] = array[0].length;
		sparseArray[0][2] = sum;
				
		// 3 再次遍历 并为稀疏数组填充值
		int count = 0;
		for(int a=0;a<array.length;a++){
			int[] arr = array[a];
			for(int b=0;b<arr.length;b++){
				int i = arr[b];
				if(i!=0){
					count ++;
					sparseArray[count][0] = a;
					sparseArray[count][1] = b;
					sparseArray[count][2] = i;
				}
			}
		}
		
		return sparseArray;
	}
	
	/**
	 * 打印 二维数组
	 * @param sparseArray
	 */
	private static void printArray(int[][] array){
		
		for(int[] arr:array){
			for(int i:arr){
				System.out.print(i+" ");
			}
			System.out.println();
		}
		
	}
	
	/**
	 * 将二维数组 转成 文件
	 * @param array
	 * @param file
	 * @throws IOException 
	 */
	private static void arrayToFile(int[][] array,File file) throws IOException{
		//如果文件不存在 新建文件
		if(!file.exists())
			file.createNewFile();
		
		//选择文件流
		Writer fw = new FileWriter(file);
		
		//使用流写入文件
		for(int[] arr:array){
			for(int i:arr){
				fw.write(i+"\t");
			}
			fw.write("\r\n");
		}
		//最后关闭文件流
		fw.close();
		
	}
	
	
	private static int[][] arrayToFile(File file) throws IOException{
		//1.如果文件不存在 新建文件
		if(!file.exists())
			return null;
	    //2.选择流
	    BufferedReader in = new BufferedReader(new FileReader(file));
	    //3.1进行数据的搬移，但是数组首要考虑的事情是数组要多大？
	    int row =0;//用于创建要创建的二维稀疏数组的大小确定
	    String line; //一行数据
	    //逐行读取，并将每个数组放入到数组中
	    while ((line = in.readLine()) != null) {
	        row++;
	    }
	    //由于读取完毕整个文本文档，所以重启流
	    in.close();
	    int[][] sparseArr = new int [row][3];
	    //3.2文本数据转移到稀疏数组中
	    int rowtmp = 0;
	    in = new BufferedReader(new FileReader(file));
	    while ((line = in.readLine()) != null) {
	        String[] temp = line.split("\t");
	        for (int j = 0; j < temp.length; j++) {
	        	sparseArr[rowtmp][j]=Integer.parseInt(temp[j]);
	        }
	        rowtmp++;
	    }
	    //4.关闭流
	    in.close();


		return sparseArr;
	}

}
