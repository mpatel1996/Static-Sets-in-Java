/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mpjv1
 */

import java.util.Scanner;
import java.util.Arrays;

public class Driver {
    static int iteration = 20000;
    static final int MAX_SIZE = 1000;
    static Scanner input = new Scanner(System.in);
    
    public static void enterSets(int[] arr1, int[] arr2){
       
        Boolean check = false;
        int i = 0;
        int userInt; 
        
        System.out.println("Enter First Set of Non-Zero positive numbers. (Type 0 to end input): ");
        while(!check){
            userInt = input.nextInt();
            if(userInt != 0){
                arr1[i] = userInt;
                i++;	
            }
            else{
                    check = true;  
            }
        }// end of while
        
        i = 0;
        check = false;
        
        System.out.println("Enter Second Set of Non-Zero positive numbers. (Type 0 to end input): ");
        while(!check){
            userInt = input.nextInt();
            if(userInt != 0){
                arr2[i] = userInt;
                i++;	
            }
            else{
                    check = true;  
            }
        }// end of while 
        
        Arrays.sort(arr2);
        Arrays.sort(arr1);
  
    }// Enter Sets  
    
    public static void unionTwo(int[] arr1, int[] arr2){
       
        for(int k =0; k < 1000; k++){
            if(arr1[k] != 0){
                System.out.print(arr1[k]+" ");
            }
        }
        for(int k = 0; k<iteration; k++){
            for(int i = 0; i < MAX_SIZE; i++){
                if(binarySearch(arr1, 0, MAX_SIZE -1, arr2[i]) == -1){
                    if(k == 0)
                        System.out.print(arr2[i] + " ");
                }
            }
        }
        System.out.println();
    }// unionTwo
    
    public static void intersectTwo(int[] arr1, int[] arr2){
        
        for(int k = 0; k <iteration; k++){
            for (int i=0; i<MAX_SIZE; i++) {
                if (binarySearch(arr1, 0, MAX_SIZE-1, arr2[i]) != -1) {
                    if(k == 0){
                        if(arr2[i] != 0) {
                            System.out.print(arr2[i] + " ");
                        }
                    }
                }
            }
        }

        System.out.println();
        
    }//IntersectTwo
    
    public static void differenceTwo(int[] arr1, int[] arr2){        
        
        for(int k = 0; k < iteration; k++){
            int i = 0, j =0;
            while(i < MAX_SIZE && j < MAX_SIZE){
                if(arr1[i] < arr2[j]){
                    if(k==0){
                        if(arr1[i] != 0)
                            System.out.print(arr1[i] + " ");
                    }
                    i++;
                }else if(arr2[j] < arr1[i]){
                    if(k==0){
                        if(arr2[i] != 0)
                            System.out.print(arr2[i] + " ");         
                    }
                    j++;
                }else{
                    i++;
                    j++;
                }                
            }// while
        } // For k < iteration
        
        System.out.println();
    }//DifferenceTwo
    
    public static int binarySearch(int arr[], int i, int j, int k){
        if(j >= i){
            int mid = i + (j - i)/2;
            
            if (arr[mid] == k) {
                return mid;
            }
            
            if (arr[mid] > k){
                return binarySearch(arr, i, mid-1,k);
            }
            
            return binarySearch(arr, mid+1, j, k);
        }
        return -1;
    }
    
    public static void main(String[] args){
        
        int arr1[] = new int[1000];
        int arr2[] = new int[1000];
        int userChoice;
        long startTime;
        long endTime;
        long unTm = 0, itTm =0, difTm =0;
        do{
            System.out.print("1) Enter Two Array sets"
                + "\n2) Union of Sets"
                + "\n3) Intersect of Sets"
                + "\n4) Difference of sets"
                + "\n5) Exit"
                + "\nEnter Your Choice from menu: ");
            userChoice = input.nextInt();
        
            switch(userChoice){
                case 1:
                    enterSets(arr1, arr2);
                    break;
                case 2:                    
                    startTime = System.currentTimeMillis();
                    unionTwo(arr1, arr2);
                    endTime = System.currentTimeMillis();
                    unTm = endTime - startTime;
                    System.out.println();
                    break;
                case 3:                    
                    startTime = System.currentTimeMillis();
                    intersectTwo(arr1, arr2);
                    
                    endTime = System.currentTimeMillis();
                    itTm = endTime - startTime;
                    System.out.println();
                    break;
                case 4:                    
                    startTime = System.currentTimeMillis();
                    differenceTwo(arr1, arr2);
                    
                    endTime = System.currentTimeMillis();
                    difTm = endTime - startTime;
                    System.out.println();
                    break;
                case 5:  
                    System.out.print("\nTime Displayed. 0 means not used."
                                    +"\nUnion Time in ms: " + unTm 
                                    +"\nIntersect Time in ms: " + itTm
                                    +"\nDifference Time in ms: " + difTm + "\n");
                    break;
                default:
                    System.out.println("Enter one of the following options! ");
                    break;
            }
        }while(userChoice != 5);
        
    }// end of main
    
}// end of class
