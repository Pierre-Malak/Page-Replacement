/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

/**
 *
 * @author Mr
 */import java.util.Scanner;

public class JavaApplication34 {

    
    public static void main(String[] args) {
        // TODO code application logic here
               Scanner fi =new Scanner(System.in);
        Scanner f =new Scanner(System.in);
       System.out.println("How Many Pages ?");
    int noOfPages=fi.nextInt(); 
    System.out.println("How Many Frames ?");
          int frames = fi.nextInt();
        Scanner sc=new Scanner(System.in);
       System.out.println("Enter The number of the Pages Like : 1,2,1,3,4,2,4");
 String Process = sc.nextLine();
    
           System.out.println("Choose :");
                System.out.println("1)Fifo");
        System.out.println("2)Optimal");
        System.out.println("3)LRU");
  
        int choice = fi.nextInt();  System.out.println( );
        if(choice==1)
        {
         Fifo p=new Fifo();
        p.process(Process, frames, noOfPages);
 
        }
        
        else if(choice==2)
        {
         Optimal p=new Optimal();
        p.process(Process, frames, noOfPages);
 
        }
         else if(choice==3)
        {
         LRUU p=new LRUU();
        p.process(Process, frames, noOfPages);
 
        }
         else{System.err.println("Invalid Input");}
        
                if(noOfPages!= Process.split(",").length)System.err.println("Wrong entered number of pages!");
    }
    
}
//pages=entered pages as string,noOf faults,pagefaults as an array