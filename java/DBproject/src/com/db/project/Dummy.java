package com.db.project;

import java.util.Arrays;
import java.util.Random;

public class Dummy {
    
    public static void main(String[] args) {

//        checkTime();
//        checkTimeLate();
//        System.out.println();
//        System.out.println();
//        checkOutTime();
//        checkOutTimeLate();
//        weekend();
//        test();
        holiday();
        

    } //main

    private static void holiday() {
        int[] weekend = {50,51,87};

        for (int i = 0; i < 179; i++) {
            for (int j = 0; j < 3; j++) {
                weekend[j] = weekend[j] + 123;
            }
            System.out.println(Arrays.toString(weekend));
        }
    }

    private static void test() {
        Random random = new Random();
        int range = 21; // (40 - 0) / 2 + 1
        for(int j = 0; j < 66; j++) {
            for (int i = 0; i < 10; i++) {
                int randomEvenNumber = random.nextInt(range) * 2;
                System.out.println(randomEvenNumber);
            }
        }
    }

    private static void weekend() {
        
        
        int[] weekend = {6,7,13,14,20,21,27,28,34,35,41,42,48,49,55,56,62,63,69,70,76,77,83,84,90,91,97,98,104,105,111,112,118,119};
        
        for (int i = 0; i < 179; i++) {
            for (int j = 0; j < 34; j++) {
                weekend[j] = weekend[j] + 123;
            }
            System.out.println(Arrays.toString(weekend));
        }

        
    }

    private static void checkOutTimeLate() {
        
        int[] hours = new int[22141];
        String[] minutes = new String[22141];


        for(int i = 0; i <= 22140; i++) {

            int hour = (int)(Math.random() * 6) + 12;
            hours[i] = hour;

            if(hours[i] == 17) {
                int minute = (int)(Math.random()*50);
               
                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }

            } else {
                int minute = (int)(Math.random()*60);

                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }
                
            }

        }

        for(int i = 0; i < 22141; i++) {
            
            System.out.println(hours[i] + ":" + minutes[i]);

        }
        
    }

    private static void checkOutTime() {
        
        int[] hours = new int[22141];
        String[] minutes = new String[22141];


        for(int i = 0; i <= 22140; i++) {

            int hour = (int)(Math.random() * 2) + 17;
            hours[i] = hour;

            if(hours[i] == 17) {
                int minute = (int)(Math.random() * 10) + 50;
                minutes[i] = minute+"";
                
            } else {
                int minute = (int)(Math.random() * 31);
                
                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }
                
            }

        }

        for(int i = 0; i < 22141; i++) {

            System.out.println(hours[i] + ":" + minutes[i]);

        }
        
    }

    private static void checkTimeLate() {

        int[] hours = new int[30];
        String[] minutes = new String[30];


        for(int i = 0; i <= 29; i++) {

            int hour = (int)(Math.random() * 3) + 9;
            hours[i] = hour;

            if(hours[i] == 9) {
                int minute = (int)(Math.random()*49) + 11;
               
                minutes[i] = "" + minute;

            } else {
                int minute = (int)(Math.random()*59) + 1;

                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }
                
            }

        }

        for(int i = 0; i < 30; i++) {
            if(hours[i] == 9) {
                System.out.println("0" + hours[i] + ":" + minutes[i]);
            } else {
                System.out.println(hours[i] + ":" + minutes[i]);
            }

        }
        
    }

    private static void checkTime() {
     
        int[] hours = new int[22141];
        String[] minutes = new String[22141];


        for(int i = 0; i <= 22140; i++) {

            int hour = (int)(Math.random() * 2) + 8;
            hours[i] = hour;

            

            if(hours[i] == 8) {
                int minute = (int)(Math.random()*59) + 1;
                
                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }
                
            } else {
                int minute = (int)(Math.random()*10) + 1;
                
                if(minute < 10) {
                    minutes[i] = "0" + minute;

                } else {
                    minutes[i] = "" + minute;
                }
                
            }

        }

        for(int i = 0; i < 22141; i++) {

            System.out.println("0"+ hours[i] + ":" + minutes[i]);

        }
        
    }
    
}
