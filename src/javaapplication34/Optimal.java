/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication34;

/**
 *
 * @author Mr
 */
public class Optimal { 
    
    
    void process(String Process,int frames,int noOfPages){

       //Split The array From The "," And make a copy of it and Array to count the periority 
          String pr[] =Process.split(",");
          String prcopy[]=Process.split(",");
          int counter[]=new int[pr.length];
           int box[]=new int[frames];
          int min=box[0];
          int max=0;
          int smallcount=0;
         
          int g=0;
          int replacer=0;
          String pagefaults []= new String [frames] ;
          String pagerec="";
           String faults = "";
          boolean found=false ;
          boolean n=false;
          boolean hit=false;
           boolean condition=false;
         int  noPagefaults=0;
          
         
         
         
         
         
         
         
            //Counting Priority (Setting the Counter Array
    for(int i=0;i<pr.length;i++)
{
           for(int j=i;j<pr.length;j++)
          {    if (pr[i].equals(prcopy[j]))
                 counter[i]+=1;
          }
}
    
    
        
          
        //Main Loop
for(int i=0;i<pr.length;i++)
{  
    //Compare Arrays to find if it hit or no
           for(int j=0;j<frames;j++)
                  {if(pr[i].equals(pagefaults[j])){found=true;box[j]=counter[i]-1;hit=true; break; }}

           
         if(!found&&pagefaults[frames-1]!=null&&i<=pr.length-frames)
         {for(int j=0;j<frames;j++)
         { 
            for (int m=i+1;m<i+frames;m++)
               {
               
                   if(pagefaults[j].equals(pr[m]))
                         {smallcount+=1;condition=true;break;}
                   
                   
                }
                if(!condition){replacer=j;}
                condition=false;
            } 
             if(smallcount==frames-1)
             {pagefaults[replacer]=pr[i];
             box[replacer]=counter[i]-1;
             smallcount=0;
             found=true;
             n=true;
             hit=false;
                pagerec+="\t"+pr[i]+" is a page fault"+"\n";
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
          System.out.println(faults);
             
             
             }
             else{smallcount=0;
             replacer=0;
             }
         
         }
           
           
           
if (!found)
{ 
  
    //Finding Minimum box Counter To replace it
    for(int j=0;j<frames;j++)
{  if(box[j]<min){min=box[j];replacer=j;}     }
  
    
    //Finding If There's 2 or more box counters have the same value IF THE ARRAY IS FULL
   if(pagefaults[frames-1]!=null)
   {
   for(int j=0;j<frames;j++)
    {if (min==box[j])
    {smallcount+=1;}}
   }
    //If There's 2 or more box counters have the same value Finding who is The Latest
    if(smallcount>1)
    {
        //Getting The index of the boc counters values
    for(int k=0;k<frames;k++)
    {if(box[k]==min)
    
        //Finding The latest value 
    {for(int j=i;j<pr.length;j++)
     {   
         
         if(pagefaults[k].equals(pr[j])&&j>max)
         {max=j;replacer=k;}
     
     
     } } }
    
 
    
    }
    
   
    
    
    //Setting Tha values In The arrays
    pagefaults[replacer]=pr[i];
    box[replacer]=counter[i]-1;
    faults+=pagefaults[replacer];
    
    //Setting The Values Of some Variables To zero again

    if(replacer==frames-1){replacer=0;}
    else{replacer+=1;}
      min=box[replacer];
        max=0;
   
           smallcount=0;

                g++;
        
        
 
            pagerec+="\t"+pr[i]+" is a page fault"+"\n";
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
          System.out.println(faults);
    }
  else if (hit)
         {System.out.println("hit");   pagerec+="\t"+pr[i]+" is a page hit"+"\n";}
        
  
 

         found=false;
        hit=false;
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
