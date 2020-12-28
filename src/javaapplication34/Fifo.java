/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

import java.util.Scanner;

/**
 *
 * @author Mr
 */
public class Fifo {
    void process(String Process,int frames,int noOfPages){
      
        int noPagefaults=0;
          int g = 0 ;
        String faults = "";
        
        //Split The array From The ","
          String pr[] =Process.split(",");
          String pagefaults []= new String [frames] ;
          String pagerec="";
          boolean found=false ;
          boolean n=false;
         // n is true 
      
for(int i=0;i<pr.length;i++)
{  
    //Compare Arrays 
           for(int j=0;j<frames;j++)
                  {if(pr[i].equals(pagefaults[j])){found=true; break; }}
        
           
           // IF Not Found Put THe Value IN The pagefaults Array
         if(found==false)
           {
               pagefaults[g]=pr[i];
           g++;
          faults+=pagefaults[i%frames];
            pagerec+="\t"+pr[i]+" is a page fault"+"\n";
          //if the g = to the frame number clear the string and assign its values again
          if(g==3||n==true){
              faults="";
                      for(int k=0;k<frames;k++)
                             faults+=pagefaults[k];
                 //     pagerec+="\t"+pr[i]+" is a page fault"+"\n";
          }
           
          //Increamet The Peage Faults and printing the frames
           noPagefaults+=1;
          System.out.println(faults);
          
           }
         
         // if found there is no faults
         else if (found==true)
         {System.out.println("hit");n=true;   pagerec+="\t"+pr[i]+" is a page hit"+"\n";}
         
         found=false;
         
         // Return g to 0 to replace the first page entered
         if(g==frames)
         {g=0;
         faults="";
         n=true;
         }
 

}
           
      
           
    System.out.println( );
            System.out.println( "no of page faults = "+noPagefaults+"\n"+"\n"+"   Pages summary(hit or fault)"
                    + ""+ "\n"+pagerec+"\n");
       
       
    }

    }


  
