package testing;

public class test {
	public static void main(String... args) throws Exception {
//		int val1=0;
//		int val2=1;
//		int val3;
//		System.out.print(val1+" ");
//		System.out.println(val2+" ");
//		for(int i=2;i<=100;i++) {
//			val3=val1+val2;
//			if(val3>100) 
//				break;
//			System.out.print(val3+" ");
//			val1=val2;
//			val2=val3;
//		}
		int[][] a= {{1,2,3},{4,5}};
		int[][] b= {{5,6},{9,4,2}};
		int[][] arr=new int[3][3];
		
		try {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<b.length;j++) {
				sum=a[i][j] + b[i][j];
				arr[i][j]=sum;
				System.out.print(arr[i][j]+" ");
			}
			//System.out.println(sum);
		}
		}catch(Exception e) {
			throw new Exception("Array Index is wrong");
		}
		
		
	}
	
}
