
public class TrappingRainWater {
	public static void main(String[] args) {
		int mat[] = {2,0,2};
	
		int area = 0;
		for (int j = 0; j < mat.length; j++) {
			int max = Integer.MIN_VALUE;

			int second = Integer.MIN_VALUE;
			int p = 0;
			for (int i = 0; i < mat.length; i++) {
				if (mat[i] > max) {
					second = max;
					p = i;
					max = mat[i];
				}

				if (mat[i] > second && (max != mat[i] || mat[i] == mat[p])) {
					if (i != p) {
						second = mat[i];
						area = Math.max(area, Math.abs(i - p) * second);
					}
				}
				
			}
			mat[p]= Integer.MIN_VALUE;

			
		}
		System.out.println(area);
	}
}
