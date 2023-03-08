package ua.ithillel.lesson5;

import java.util.Objects;

public class HillelArrayList implements HillelList {
    private String[] array;

    public HillelArrayList(String[] array) {
        this.array = array;
    }

    public HillelArrayList() {
        array = new String[0];
    }

    @Override
    public void add(String item) {
        String[] newArray = new String[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        newArray[array.length] = item;
        array = newArray;

    }

    @Override
    public String remove(int index) {

        String deleteWord = array[index];
        String[] newArray = new String[array.length - 1];
        if (index > 0) {
            System.arraycopy(array, 0, newArray, 0, index);
        }
        System.arraycopy(array, index + 1, newArray, index, array.length - 1 - index);

        array = newArray;
        return deleteWord;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (Objects.equals(array[i], item)) {
                index = i;
                break;
            }
            //else   index=-1;
        }
        return index;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public String get(int index) {
        return array[index];
    }

    @Override
    public String[] getAll() {
        return array;
    }
}