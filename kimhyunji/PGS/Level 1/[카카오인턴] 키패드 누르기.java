class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        //0~9 키패드 위치
        int[][] keypad = {{3,1}, {0,0}, {0,1}, {0,2}, {1,0}, {1,1}, {1,2}, {2,0}, {2,1}, {2,2}};
        //왼손, 오른손의 현재 위치
        int[] left = {3,0};
        int[] right = {3,2};

        for(int i : numbers) {
            switch (i){
                case 1 : case 4: case 7: //1,4,7이면 왼손
                    answer+="L";
                    left=keypad[i];
                    break;
                case 3: case 6: case 9: //3,6,9면 오른손
                    answer+="R";
                    right=keypad[i];
                    break;

                default: //2,5,8,0이면
                    //왼손, 오른손 거리
                    int distanceFromLeft = Math.abs(left[0] - keypad[i][0]) + Math.abs(left[1] - keypad[i][1]);
                    int distanceFromRight = Math.abs(right[0] - keypad[i][0]) + Math.abs(right[1] - keypad[i][1]);

                    if(distanceFromLeft<distanceFromRight){ //왼손이 더 가까움
                        answer+="L";
                        left=keypad[i];
                        break;
                    }
                    else if(distanceFromLeft>distanceFromRight){ //오른손이 더 가까움
                        answer+="R";
                        right=keypad[i];
                        break;
                    }
                    else{ //같음
                        if(hand.equals("left")){
                            answer+="L";
                            left=keypad[i];
                            break;
                        }
                        else{
                            answer+="R";
                            right=keypad[i];
                            break;
                        }
                    }
            }
        }

        return answer;
    }
}