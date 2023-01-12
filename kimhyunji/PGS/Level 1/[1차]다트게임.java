class Solution {
    static class Score{ //점수, 보너스, 옵션 저장
        String num;
        String bonus;
        String option;

        Score(String num, String bonus, String option){
            this.num = num;
            this.bonus = bonus;
            this.option = option;
        }
    }
    public int solution(String dartResult) {
        Score[] scores = new Score[3];
        int index = 0;

        for(int i=0; i<3; i++){ //객체 초기화
            scores[i] = new Score("", "", "");
        }

        for(int i=0; i<dartResult.length(); i++){
            if('0' <= dartResult.charAt(i) && '9' >= dartResult .charAt(i)){ //숫자라면
                scores[index].num += dartResult.substring(i, i+1);
            }
            else if('D' <= dartResult.charAt(i) && 'T' >= dartResult .charAt(i)){ //알파벳이면
                scores[index].bonus = dartResult.substring(i, i+1);
            }
            else{ //특수기호면
                scores[index].option = dartResult.substring(i, i+1);
                index++;
                continue;
            }

            if(i == dartResult.length() - 1) continue; //마지막 글자인 경우
            //숫자, 보너스를 모두 읽었는데 다음 글자가 숫자인 경우(한 턴이 끝났다는 뜻)
            if(!scores[index].num.equals("") && !scores[index].bonus.equals("") && '0' <= dartResult.charAt(i+1) && '9' >= dartResult .charAt(i+1)) index++;
        }

        int[] finalScore = new int[3];
        for(int i=0; i<3; i++){ //최종 점수 계산
            if(scores[i].bonus.equals("S")) finalScore[i] = Integer.parseInt(scores[i].num);
            if(scores[i].bonus.equals("D")) finalScore[i] = (int)Math.pow(Integer.parseInt(scores[i].num), 2);
            if(scores[i].bonus.equals("T")) finalScore[i] = (int)Math.pow(Integer.parseInt(scores[i].num), 3);

            if(scores[i].option.equals("*")){
                if(i==0) finalScore[i] = finalScore[i]*2;
                else{
                    finalScore[i] = finalScore[i]*2;
                    finalScore[i-1] = finalScore[i-1]*2;
                }
            }
            if(scores[i].option.equals("#")){
                finalScore[i] = finalScore[i]*(-1);
            }
        }

        return finalScore[0] + finalScore[1] + finalScore[2];
    }
}