package leetcode.String;

public class WordSearch79 {
	public static void main(String args[]) {

		
		/*String board = "SEE";
		char word[][] = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		 */
		String board = "a";
		char word[][] = { { 'a' } };
		WordSearch79 wordSearch79 =new WordSearch79();
		System.out.println(wordSearch79.exist(word, board));
	}

	/*public static boolean exist(char[][] board, String word) {
		System.out.println(board[0].length);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				boolean b = exist(board, word, i, j, 0);

				if (b == true)
					return true;
			}
		}

		return false;
	}

	public static boolean exist(char[][] board, String word, int i, int j, int start) {
		if (start == word.length()) {
			return true;
		}
		if (i >= 0 && i <= board.length - 1 && j >= 0 && j <= board[0].length - 1) {
			char ch = word.charAt(start);
			char ch1 = board[i][j];
			if (ch == ch1) {
				 char temp = board[i][j];
			        board[i][j]='#';
				if (exist(board, word, i - 1, j, start + 1))
					return true;
				if (exist(board, word, i + 1, j, start + 1))
					return true;
				if (exist(board, word, i, j - 1, start + 1))
					return true;
				if (exist(board, word, i, j + 1, start + 1))
					return true;
				board[i][j]=temp;
			}
		}

		return false;

	}*/

	public boolean exist(char[][] board, String word) {
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				if(board[i][j]==word.charAt(0)){
					if(dfs( board,  word, i, j, board.length-1, board[0].length-1,0)){
						return true;
					}
				}
			}

		}
		return false;
	}
	public boolean dfs(char[][] board, String word,int i,int j,int row,int col,int post){
		if(post==word.length()){
			return true;
		}
		if(i>=0 && i<=row && j>=0 && j<=col){
			char c= board[i][j];
			board[i][j]='#';
			if(c==word.charAt(post)){
				if( dfs( board,  word, i+1, j, board.length-1, board[0].length-1,post+1))
					return true;
				if( dfs( board,  word, i, j+1, board.length-1, board[0].length-1,post+1))
					return true;
				if( dfs( board,  word, i-1, j, board.length-1, board[0].length-1,post+1))
					return true;
				if( dfs( board,  word, i, j-1, board.length-1, board[0].length-1,post+1))
					return true;
			}
			board[i][j]=c;
			return false;

		}
		return false;
	}

}
