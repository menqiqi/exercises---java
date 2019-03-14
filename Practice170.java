/**
 * 对于一个给定的井字棋盘，请设计一个高效算法，请判断当前玩家是否获胜。
 * 给定一个二维数组board，代表当前棋盘，其中元素为1代表当前玩家的棋子，为0代表没有棋子，为-1代表对方的棋子。
 */

class Board {
    public boolean checkWon(int[][] board) {
        // write code here
        if(board[0][0]+board[1][1]+board[2][2] == 3)
            return true;
        if(board[0][2]+board[1][1]+board[2][0] == 3)
            return true;
        for(int i = 0; i < 3; i++){
            if(board[i][0]+board[i][1]+board[i][2] == 3)
                return true;
            if(board[0][i]+board[1][i]+board[2][i] == 3)
                return true;
        }
        return false;
    }
}

public class Practice170 {
    public static void main(String[] args) {
        int[][] board = {{-1,-1,0},{-1,-1,1},{-1,-1,1}};
        Board board1 = new Board();
        System.out.println(board1.checkWon(board));
    }
}
