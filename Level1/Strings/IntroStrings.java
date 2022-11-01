public class IntroStrings{
    public static void main(String args[]){
        // int v1=10,v2=20;
        // String s1="Hello";
        // System.out.println(v1+v2+s1);
        // System.out.println(v1+s1+v2);
        // System.out.println(s1+v1+v2); // jdk execute print statement from left to right
        // System.out.println(s1+v1*v2); // precendence based * has > priority then +
        // System.out.println(v1*v2+s1);

        // String s1="hello my name is sameer";
        // System.out.println(s1.length());  // for string length we use .length()
        // String[] word =s1.split(" ");       /*spilt returns a string array,
        //                                    it is necessary to give separator inside spilt(separator)*/
        // System.out.println(word.length);  // in array we use .length
        // for (String i:word){
        //     System.out.println(i);
        // }

        // String s2="hello my name is sameer";
        
        // String[] word =s2.split("");
    
        // for (String i:word){
        //     System.out.println(i);
        // }

        String s3="hello my name is sameer";
        
        String[] word =s3.split("apple"); // only one element in  word array which is {"hello my name is sameer"}
        for (String i:word){
            System.out.println(i);
        }
    }
}