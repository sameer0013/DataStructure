public class Basic {
    public static void main(String[] args){
        int n1 = 5;//101
        int n2 = 3;//011
        
        System.out.println("Bitwise or: "+(n1 | n2));
        System.out.println("Bitwise AND: "+(n1 & n2));
        System.out.println("Bitwise xor: "+(n1 ^ n2));
        System.out.println("negation: "+(~n1));
        // Signes (+ve,-ve) of integer is maintained in left and right shift
        // right shift
        System.out.println(n1>>1);//2
        System.out.println(n1>>2);//1

        System.out.println(101>>2); //25
        System.out.println(-101>>2);//-26 floor(-101/2^2)

        // Left shift
        System.out.println(n1<<1); // 10
        System.out.println(101<<2); //404
        System.out.println(-101<<2); // -404

        //unsigned right shift -> result always positive
        System.out.println(101>>>2);//25
        System.out.println(-101>>>2);//1073741798

        System.out.println(isEven(n1));
        System.out.println(firstSetBitFromLeft(n1));
        System.out.println(firstSetBitFromRight(n1));

        System.out.println(numberOfFlipsRequiredToMakeEqualNumber(n1, n2));

        System.out.println(numberOfSetBits(n1));
    }

    public static boolean isEven(int num){
        return (num & 1) ==0;
    }

    public  static int numberOfSetBits(int num){
        int count=0;
        for(int pos=0;pos<=31;pos++){
            int mask =(1<<pos);
            if((num&mask)!=0) count++;
        }

        return count;
    }

    public static int numberOfFlipsRequiredToMakeEqualNumber(int num1,int num2){
        int count=0;
        for(int pos=0;pos<=31;pos++){
            int mask = (1<<pos);
            boolean x = (num1&mask)==0;
            boolean y = (num2&mask)==0;
            if(x ^ y) count++;
        }
        return count;
    }

    public static int firstSetBitFromLeft(int num){
        int pos=31;
        while(pos>=0){
            int mask = (1<<pos);
            if((num&mask)!=0) return pos;
            pos--;
         }
         return -1;
    }
    public static int firstSetBitFromRight(int num){
        int pos =0;
        while(pos<=31){
            int mask = (1<<pos);
            if((num&mask)!=0) return pos;
            pos++;
        }
        return -1;

    }
    public static boolean isKthBitSet(int num,int k){
            int mask = (1<<k);
            if((num&mask)!=0) return true;
            else return false;

    }
    public static boolean isKthBitUnset(int num,int k){
            int mask = (1<<k);
            if((num&mask)==0) return true;
            else return false;

    }

    public static int flipKthBit(int num,int k){
        int mask = (1<<k);
        int ans = (num ^ mask);
        return ans;
    }

    


}
