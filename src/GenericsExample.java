import java.sql.SQLOutput;
import java.util.ArrayList;

public class GenericsExample {
    public static void main(String[] args) {
        // Create a Gen reference for Integers
        Gen<Integer, Double> intOb = new Gen<Integer, Double>(53, 10.0);
        intOb.showType();
        Gen<Integer, Double> intOb2 = new Gen<>(53, 10.0); //it is also possible
        intOb2.showType();
        Gen<Integer, Integer> intob3;
        intob3 = new Gen<>(53, 10); //it is also possible
        intob3.showType();
        //usages of generics
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(arrayList.get(0) + arrayList.get(1));
        System.out.println(arrayList.get(2));
    }
    public static class Gen<T1, T2> {
        T1 ob1;
        T2 ob2;
        Gen(T1 o1, T2 o2) {
            ob1 = o1;
            ob2 = o2;
        }
        public T1 getObj() {
            return ob1;
        }
        public T2 getObj2() {
            return ob2;
        }
        public void showType() {
            System.out.println("Type of T1 is " + ob1.getClass().getName());
            System.out.println("Type of T2 is " + ob2.getClass().getName());
        }
    }
}
