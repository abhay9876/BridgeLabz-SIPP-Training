package Level1;

import java.util.Scanner;
public class CheckAge {
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	
    	int[] studentsAge = new int[10];
    	for(int i = 0 ; i < 10 ; i++) {
    		System.out.println("Enter the age of student "+(i+1)+ " :");
    		studentsAge[i] = input.nextInt();
    		if(studentsAge[i] >= 18) {
    			System.out.println("The student with the age "+ studentsAge[i]+" can vote.");
    			
    		}
    		else {
    			System.out.println("The student with the age "+ studentsAge[i]+" can not vote.");
    		}
    	}
    	
    }
}
