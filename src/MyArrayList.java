import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class MyArrayList <T>{
    private int countEmployedIndex =0;// Cчитает фактически занятое количество слотов
    private T[] mainArray;
    private int capacity; // Ёмкость массива

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.mainArray = (T[]) new Object [this.capacity];
    }


    public MyArrayList() {
        this.mainArray = (T[]) new Object[10];
    }

    public T get(int a){
        return this.mainArray[a];
    }

    public void addAll(MyArrayList<? extends T> addingArray){
        int emptySlots= mainArray.length- countEmployedIndex; // Вычислим кол-во свободных слотов

        if (emptySlots <= addingArray.size()){
            T[] copy= mainArray;
            int newCapacity= mainArray.length+(addingArray.size()-emptySlots);

            mainArray= (T[]) new Object[newCapacity];


            T[] copyOfAddingArray= (T[]) new Object[addingArray.size()];

            for (int i = 0; i <addingArray.size(); i++) {
                copyOfAddingArray[i]= addingArray.get(i);
            }


            System.arraycopy(copy,0,mainArray,0,copy.length);


            System.arraycopy(copyOfAddingArray,0,mainArray,copy.length,copyOfAddingArray.length);

            countEmployedIndex = mainArray.length;

        }
    }

    public void add(T number){
        check();
        mainArray[countEmployedIndex]=number;
        countEmployedIndex++;
    }

    public void add(int index, T number){
      check();
        for (int i = countEmployedIndex; i >index; i--) {
            mainArray[i]=mainArray[i-1];
        }
        mainArray[index]=number;

    }
    public void remove(int index){
        mainArray[index]=null;
        for (int i = index; i < mainArray.length-1; i++) {
            T num = mainArray[i+1];
            mainArray[i]= (T) num;
            mainArray[i+1]= null;
        }
        // Закоментируй этот метод чтобы увидеть сдвиг значений
         trimTosize();
    }

    public int size(){
        return mainArray.length;
    }


    private int initSize(){ // Инициализация размера массива
        return (int) (countEmployedIndex *1.5);
    }

    private boolean check(){ //Проверка длины массива.
        if (countEmployedIndex == mainArray.length){
            T[] copy= mainArray;
            mainArray =(T[]) new Object[initSize()];
            System.arraycopy(copy,0, mainArray,0,copy.length);
            return true;
        }
        return false;
    }


    private void trimTosize(){
        T[] copy = (T[]) new Object[mainArray.length-1];

        for (int i = 0; i <copy.length; i++) {
            copy[i]=mainArray[i];
        }
        countEmployedIndex--;
        mainArray=(T[]) new Object[copy.length];
        System.arraycopy(copy,0,mainArray,0,copy.length);
    }



}
