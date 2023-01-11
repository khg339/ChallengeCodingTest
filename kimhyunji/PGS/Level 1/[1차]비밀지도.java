class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];

        String[] bArr1 = new String[n];
        String[] bArr2 = new String[n];

        for (int i = 0; i < n; i++) { //10진수 지도 값을 2진수로 변환
            bArr1[i] = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr1[i])));
            bArr2[i] = String.format("%0" + n + "d", Long.parseLong(Long.toBinaryString(arr2[i])));
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (bArr1[i].charAt(j) == '0' && bArr2[i].charAt(j) == '0') {
                    sb.append(" ");
                } else sb.append("#");
            }

            answer[i] = sb.toString();
            System.out.println(sb);
            sb.delete(0, sb.length());
        }
        return answer;
    }
}