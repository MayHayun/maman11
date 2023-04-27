package q2.weather;

import java.util.Random;
import java.util.stream.IntStream;
public class Temps {

    final int MAX_VAL = 2000;
    final int MIN_VAL = -2000;


    private int[][] temp; //an int array to contain temperatures data
    private int years;
    private int months;

/* constructor to init the size needed*/
    public Temps(int years, int months){
        this.temp = new int[6][12];
        this.years = years;
        this.months = months;
    }
/*a method to get the array*/
    public int[][] get()
    {
        return this.temp;
    }
    /*a method to fill the data randomly*/
    public int[][] fillTemps() {
        Random r = new Random();
        for (int i = 0; i < this.years; i++) {
            IntStream temp = r.ints(months, 70, 330);
            this.temp[i] = temp.toArray();
        }
        return temp;
    }
/*a method to find the min val = max temp in array of months per year*/
    public int findMin(int[] arr) {
        int min = MAX_VAL;
        for (int j : arr) {
            if (j < min)
                min = j;
        }
        return min;
    }
    /*a method to find the max val = min temp in array of months per year*/
    public int findMax(int[] arr) {
        int max = MIN_VAL;
        for (int j : arr) {
            if (j > max)
                max = j;
        }
        return max;
    }
}