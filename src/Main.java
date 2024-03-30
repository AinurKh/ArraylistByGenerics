import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
       MyArrayList<Integer> arrayList = new MyArrayList<>(3);

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

       // ЕСЛИ НУЖНО ПОКАЗАТЬ КАК ПРОИСХОДИТ СДВИГ ЗНАЧЕНИЙ УБЕРИТЕ МЕТОД trimToSize() в методе remove
        // в классе MyArrayList
        arrayList.remove(0);




        MyArrayList<Integer> arrayList1 = new MyArrayList<>(3);
        arrayList1.add(4);
        arrayList1.add(5);
        arrayList1.add(6);

        //Раскоментируй метод trimToSize()
        arrayList.addAll(arrayList1);

       for (int i = 0; i < arrayList.size(); i++) {
            System.out.print(arrayList.get(i)+" ");
        }
    }
}