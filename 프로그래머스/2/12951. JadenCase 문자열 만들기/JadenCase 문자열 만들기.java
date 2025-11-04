class Solution {
    public String solution(String s) {
//         StringBuilder answer = new StringBuilder();
//         boolean toUpper = true;  // 다음 문자가 대문자여야 하는지
        
//         for (char c : s.toCharArray()) {
//             if (c == ' ') {
//                 answer.append(c);
//                 toUpper = true;  // 공백 다음에는 대문자
//             } else {
//                 if (toUpper) {
//                     answer.append(Character.toUpperCase(c));
//                     toUpper = false;
//                 } else {
//                     answer.append(Character.toLowerCase(c));
//                 }
//             }
//         }
        
//         return answer.toString();
        
        
        // =================
        StringBuilder st = new StringBuilder();
        boolean toUpper = true;
        
        for(char c : s.toCharArray()){
            if (c == ' ') {
                st.append(c);
                toUpper = true;
            }
            else {
                if (toUpper){
                    st.append(Character.toUpperCase(c));
                    toUpper = false;
                }
                else {
                    st.append(Character.toLowerCase(c));
                }
            }    
        }
        return st.toString();
        
        
        
        
        
    }
}
