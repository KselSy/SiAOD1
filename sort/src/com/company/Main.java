package com.company;

import java.util.Arrays;

import java.util.Scanner;

import static com.company.Sort.quickSort;
import static com.company.Sort.viborSort;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        System.out.println("Input line size");
        n = in.nextInt();
        int l;
        System.out.println("Input column size");
        l = in.nextInt();
        int[][] a = new int[n][l];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < l; j++) {
                a[i][j] = (int) ( Math.random() * 100 );
            }
        }
        int[] forVibor = ToVektor(a);
        int[] forQuick = forVibor.clone();
        int[] forDefault = forVibor.clone();

        long start1=System.currentTimeMillis();
        forQuick = quickSort(forQuick,0,forQuick.length-1);
        long end1=System.currentTimeMillis();
        System.out.println("Быстрая сортировка:");
        System.out.println("Время: " + (end1-start1));

        long start2=System.currentTimeMillis();
        forVibor = viborSort(forVibor);
        long end2=System.currentTimeMillis();
        System.out.println("Сортировка выбором:");
        System.out.println("Время: " + (end2-start2));

        long start3=System.currentTimeMillis();
        Arrays.sort(forDefault);
        long end3=System.currentTimeMillis();
        System.out.println("Дэфолтная сортировка:");
        System.out.println("Время: " + (end3-start3));

    }

    //Вспомогательные функции
    public static int[] ToVektor(int[][] arr){
        int[] result = new int[arr.length*arr[0].length];
        int size = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                result[size]=arr[i][j];
                size++;
            }
        }
        return result;
    }
    public static int[][] ToArr2x2(int[] arr, int a, int b){
        int[][] result = new int[a][b];
        int help = 0;
        for (int i = 0; i<a; i++){
            for (int j = 0; j<b; j++){
                result[i][j]=arr[help];
                help++;
            }
        }
        return result;
    }
}
