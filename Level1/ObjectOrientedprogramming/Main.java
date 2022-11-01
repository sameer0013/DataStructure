public class Main{
    public static class Person{
        int age;
        String name;
        Person(){
            System.out.println("instance");
            name = "-";
            age =1;
        }
        Person(String n , int a){
            name = n;
            age = a;
        }
        public void sayHi(){
            System.out.println(name+"["+age+"]"+"hello");

        }
    }
    public static void main(String[] args) {
        Person p1 = new Person("abc",7);
        p1.sayHi();
        // Person p1 =new Person();
        // p1.sayHi();
        // p1.age = 3;
        // p1.name = "pep";
        // p1.sayHi();
        // Person p2 = p1;
        // p2.sayHi();
        
        // Person p2 = new Person();
        // p2.name = "abc";
        // p2.age = 4;
        
        // p1.sayHi();
        // p2.sayHi();
        //swap(p1,p2); // swap nhi hoga serif value jati hai variable nhi
        // Person tmp =p1;
        // p1=p2;
        // p2=tmp;
        //game2(p1,p2);
        //game3(p1,p2);
        // game4(p1,p2);
        // game5(p1,p2);
        // p1.sayHi();
        // p2.sayHi();
        
    }

    public static void swap(Person p1,Person p2){
        Person tmp = p1;
        p1=p2;
        p2=tmp;
    }
    public static void game2(Person p1 ,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
    public static void game3(Person p1,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
        p1 = new Person();
        p2 = new Person();
    }
    public static void game4(Person p1,Person p2){
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;

        p1 = new Person();
        p2 = new Person();

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
    public static void game5(Person p1,Person p2){
        p2 = new Person();
        int tage = p1.age;
        p1.age = p2.age;
        p2.age = tage;

        p1 = new Person();

        String tname = p1.name;
        p1.name = p2.name;
        p2.name = tname;
    }
    }
