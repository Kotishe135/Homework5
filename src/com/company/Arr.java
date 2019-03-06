package com.company;

import javax.swing.*;

public class Arr <Type> {
    private Type[] arr;

    public void setArr(Type[] arr) {
        this.arr = arr;
    }

    private String toString(int i){
        return arr[i].toString();
    }

    public String[] toArrayString(){
        String[] arrS = new String[arr.length];
        for (int i = 0; i < arr.length; i++){
            arrS[i] = arr[i].toString();
        }
        return arrS;
    }

    public void print(int i){
        System.out.print("[<" + i + ">=<" + toString(i) + ">]");
    }

    public void printArray(){
        for (int i = 0; i < arr.length; i++){
            print(i);
        }
        System.out.println();
    }

    public Type[] change(int i, int j){
        try {
            Type x = arr[i];
            arr[i] = arr[j];
            arr[j] = x;
        }catch (ArrayIndexOutOfBoundsException AIOOBE){
            JOptionPane.showMessageDialog(null, "Индекс находится вне границ массива");
        }
        return arr;
    }

    public Type[] reverce(){
        for(int i = 0; i < arr.length/2; i++){
            Type x = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = x;
        }
        return arr;
    }

    public Type[] getArr(){
        return arr;
    }

}
