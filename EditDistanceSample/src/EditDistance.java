
public class EditDistance {

	
	public static void main (String[] args) {
		String s1 = "geek";
		String s2 = "gesek";
		
	}
	
	public void editDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
	 
		// len1+1, len2+1, because finally return dp[len1][len2]
		int[][] dp = new int[len1 + 1][len2 + 1];
	 
		for (int i = 0; i <= len1; i++) {
			dp[i][0] = i;
		}
	 
		for (int j = 0; j <= len2; j++) {
			dp[0][j] = j;
		}
		
		//iterate though, and check last char
		for (int i = 0; i <= len1; i++) {
			char c1 = word1.charAt(i);
			for (int j = 0; j <= len2; j++) {
				char c2 = word2.charAt(j);
				if (c1 == c2) {
					dp[i+1][j+1] = dp[i][j];
				} else {
					int replace = dp[i+1][j+1];
					int delete = dp[i+1][j];
					int insert = dp[i][j+1];
					int min = replace > delete ? delete : replace;
					min = min > insert ? insert : min;
					dp[i+1][j+1] = min;
				}
			}
			
		}

	}
}
