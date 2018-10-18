package cn.mikulove.algorithm;

/**
 * @author miku
 * 斐波那契数列的定义：它的第一项和第二项均为1，以后各项都为前两项之和
 */
public class Fibonacci {
	
	public static void main(String[] args) {
		Fibonacci.printFibonacci(10);
	}
	
	
	private static void printFibonacci(int n){
		int a = 1,b = 1,c = 2;
		if(n==1) System.out.println(a);;
		if(n==2) System.out.println(a+"\n"+b);
		if(n>2){
			System.out.println(a+"\n"+b);
			while(n>c){
				a = a + b;
				System.out.println(a);
				b = a + b;
				System.out.println(b);
				c++;
			}
		}
		
	}

}
