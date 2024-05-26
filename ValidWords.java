import java.util.List;

public class ValidWords {
    public static int countValidWords(String s) {
        String[] temp = s.split(" ");
        int out = 0;
        List<Character> alphabets = List.of('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z');
        char[] punctuations = {'!','.',','};

        for(int i=0; i<temp.length; i++){
            String word = temp[i];
            if(word.equals("")){
                continue;
            }
            boolean isHyphen = false;
            boolean isPun = false;
            int j = 0;
            for(j=0; j<word.length(); j++){
                char ch = word.charAt(j);
                if(alphabets.contains(ch)){
                    continue;
                }else if(ch == '-'){
                    if(isHyphen){
                        break;
                    }
                    isHyphen = true;
                    if(j==0 || j==word.length()-1){
                        break;
                    }else{
                        char a = word.charAt(j-1);
                        char b = word.charAt(j+1);
                        if(alphabets.contains(a) && alphabets.contains(b)){
                            continue;
                        }else{
                            break;
                        }
                    }
                }else if(ch=='!' || ch=='.' || ch==','){
                    if(isPun){
                        break;
                    }
                    isPun = true;
                    if(j!=word.length()-1){
                        break;
                    }
                }else {
                    break;
                }
            }
            if(j==word.length()){
                out++;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        System.out.println(countValidWords("!this  1-s b8d!"));
    }
}
