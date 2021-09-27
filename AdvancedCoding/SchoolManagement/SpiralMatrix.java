public class SpiralMatrix {
	
	public static void main(String[] args) {
		
		int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

		int left = 0, right = 3, top = 0, bot = 3;

		while (left <= right && top <= bot) {

			for (int i = left; i <= right; left++) {
				System.out.print(arr[top][i] + "  ");
				top++;
			}

			for (int i = top; )
		}	
	}
}