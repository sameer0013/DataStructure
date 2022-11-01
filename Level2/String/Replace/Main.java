public class Main {
    public static void main(String[] args) {
        String str ="hello world";
        String ans = "";
        String str2 = "tcolqfge";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (!str2.contains(Character.toLowerCase(ch) + "")) {
                ans += str.charAt(i);
            }
        }
    }
}