import java.util.Arrays;

public class MyArrayList {
    private int num=0;
    private int[] array;
    private int capacity;

    public MyArrayList(int capacity) {
        this.capacity = capacity;
        this.array= new int[this.capacity];
    }

    public MyArrayList() {
        this.array=new int[10];
    }

    public int get(int a){
        return this.array[a];
    }

    public void addAll(int[]array2){
        int emptySlots=array.length-num; // Вычислим кол-во свободных слотов

        if (emptySlots <= array2.length){
            int[] copy= array;
            int newCapacity= (array2.length-emptySlots)+array.length;

            array=new int[newCapacity];

            System.arraycopy(copy,0,array,0,copy.length);
        }
        System.arraycopy(array2,0,array,num,array2.length);
    }

    public void add(int number){
        check();
        array[num]=number;
        num++;
    }

    public void add(int index, int number){
        check();
        array[index]=number;
        num++;
    }
    public void remove(int index){
        array[index]=0;

        for (int i = index; i < array.length-1; i++) {
            int num = array[i+1];
            array[i]=num;
            array[i+1]=0;
        }

    }

    public int length(){
        return array.length;
    }


    private int initSize(){ // Инициализация размера массива
        return (int) (num*1.5);
    }

    private boolean check(){ //Проверка длины массива.
        if (num==array.length){
            int[] copy= array;
            array=new int[initSize()];
            System.arraycopy(copy,0,array,0,copy.length);
            return true;
        }
        return false;
    }
}
