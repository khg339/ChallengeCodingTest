import java.util.Stack;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> box = new Stack<>();

        for(int move : moves){
            for(int i=0; i<board.length; i++){ //위에부터 집기
                if(board[i][move-1] != 0) { //게임기 안에 인형이 있음
                    if(!box.isEmpty()){ //box에 인형이 있음
                        if(box.peek() == board[i][move-1]){ //box 제일 위에 있는거랑 지금 집으려는 인형이랑 같음
                            box.pop(); //box에서 인형 지우기
                            board[i][move-1] = 0; //지금 뽑은 인형 0처리
                            answer+=2; //2개 지움
                            break;
                        }
                    }
                    //box 제일 위에 있는거랑 지금 집으려는 인형이랑 다르면
                    box.push(board[i][move-1]); //box에 지금 인형 넣기
                    board[i][move-1] = 0; //지금 뽑은 인형 0처리
                    break;
                }
            }
        }
        return answer;
    }
}