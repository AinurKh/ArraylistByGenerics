import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
       MyArrayList arrayList = new MyArrayList();
       arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.remove(0);

        for (int i = 0; i < arrayList.length(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}