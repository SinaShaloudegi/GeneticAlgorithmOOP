/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticalgorithmoop;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author sina
 */
public class GeneticAlgorithmOOP {

    private static int m;
    private static int counter;
    private static int result;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Welcome to Genetic Algorithm...");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Initial Population : ");
        m = in.nextInt();
        System.out.println("Enter Iteration# :");
        counter = in.nextInt();
        System.out.println("Let's Go...");
        GA ga = new GA(m, counter);
        result = ga.start();
        System.out.println("Final Result is : " + result);

        
    
        
    }
  
}
