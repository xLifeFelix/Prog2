package v2;

public interface AI {
	
	int getInt(char[][] board, char player);
	
	default void playerMove(int column) {};
	
}
