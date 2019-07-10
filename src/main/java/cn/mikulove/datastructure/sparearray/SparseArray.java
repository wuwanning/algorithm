package cn.mikulove.datastructure.sparearray;

public class SparseArray {
	
	public static void main(String[] args) {
		int[][] array = new int[9][9];
		array[3][4] = 1;
		array[4][4] = 2;
		array[4][3] = 1;
		
		SparseArray.printArray(array);
		
		SparseArray.printArray(SparseArray.normalToSparse(array));
		
		SparseArray.printArray(SparseArray.sparseToNormal(SparseArray.normalToSparse(array)));
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

}
