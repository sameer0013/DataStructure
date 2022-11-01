public class IntroStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("hello");

        System.out.println(sb+" length:"+sb.length());

        sb.append("world");

        System.out.println(sb+" length: "+sb.length());

        System.out.println(sb.charAt(1));

        System.out.println(sb.deleteCharAt(1));

        System.out.println(sb.insert(1,'e'));

        sb.setCharAt(0, 'e');;

        System.err.println(sb);

        System.err.println(sb.reverse());
        
        System.out.println(sb.substring(5));
    }
}
