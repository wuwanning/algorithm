package cn.mikulove.algorithm;

/**
 * 二分查找
 * 二分查找就是将查找的键和子数组的中间键作比较，如果被查找的键小于中间键，就在左子数组继续查找；
 * 如果大于中间键，就在右子数组中查找，否则中间键就是要找的元素。
 */
public class BinarySerach {

	public static void main(String[] args) {
		int[] arr = new int[]{1,3,6,7,9,33};
		int key = 33;
		int i = BinarySerach.binarySerach(arr, key);
		if(i==-1){
			System.out.println("查找的元素不存在");			
		}else{
			System.out.println("查找的元素为第"+(i+1)+"个");
		}
	}
	
	/**
	 * 思路：
	 * 1 先确定左右边界 
	 * 2 将key与中间值对比 然后确定新的左右边界
	 * 3 循环直到找到key值所在下标
	 */
	public static int binarySerach(int[] arr,int key){
		int left = 0;
		int right = arr.length - 1;
		while(left<=right){
			int mid = (right+left)/2;
			if(arr[mid]==key){
				return mid;
			}else if(arr[mid]>key){
				right = mid-1;
			}else if(arr[mid]<key){
				left = mid+1;
			}
		}
		return -1;
	}

}
