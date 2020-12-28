/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

import java.util.Arrays;

/**
 *
 * @author Mr
 */
public class LRUU {
        void process(String Process,int frames,int noOfPages){
            int noPagefaults=0;
          int g = 0 ;
        String faults = "";
       
        //Split The array From The ","
          String pr[] =Process.split(",");
              int box []=new int[frames];
              //Arrays.fill(box,0);
          String pagefaults []= new String [frames] ;

          String pagerec="";
          boolean found=false ;
          boolean n=false;
          int max=box[0];
          int Maxindex=0;
                
         
         
  
    for(int j=0;j<pr.length;j++)
    {for(int k=0;k<frames;k++)
    
    {if(pr[j].equals(pagefaults[k])){found=true;
       for(int i=0;i<frames;i++)
        {box[i]+=1; 
        
       }
   
    box[k]=0;
    
    break;}
    }
    
    if(!found){
        
        for(int i=0;i<frames;i++)
        {if (box[i]>max){max=box[i];Maxindex=i;}
        
       }
         for(int i=0;i<frames;i++)
        {box[i]+=1;
        
       }
         
         
         
        pagefaults[Maxindex]=pr[j];
           faults+=pagefaults[Maxindex];
        box[Maxindex]=0;
        Maxindex=0;
        max=0;
          g++;
        
        
 
            pagerec+="\t"+pr[j]+" is a page fault"+"\n";
          //if the g = to the frame number clear the string and assign its values again
          if(g==frames||n==true){
              faults="";
                      for(int k=0;k<frames;k++)
                      {
                             faults+=pagefaults[k];
                      }
          }
           
          //Increamet The Peage Faults and printing the frames
           noPagefaults+=1;
          System.out.println(faults);}
    
    
     else if (found==true)
         {System.out.println("hit");n=true;   pagerec+="\t"+pr[j]+" is a page hit"+"\n";}
         
         found=false;
    
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
