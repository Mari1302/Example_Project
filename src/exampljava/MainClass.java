package exampljava;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mariappan
 */
class ExampleCoolNess {
    public void findCoolNess(int r, int k){
        int coolnessCount=0;
        for(int i=1;i<=r;i++){
           String binaryNum = findBinaryNum(i); 
           int coolnessValue=findnof101(binaryNum,i);
           if(coolnessValue>=k)
        	   coolnessCount++;
           //System.out.println("BINARYNUM=====>"+binaryNum);
        }
        System.out.println(coolnessCount);
    }

    private String findBinaryNum(int i) {
        StringBuilder s= new StringBuilder();
        while(i > 0){
            s.append( i%2);
            i = i/2;
        }
        return s.reverse().toString();
    }

    private int findnof101(String binaryNum,int i) {
        int index = Integer.MAX_VALUE;
        int coolness=0;
       // binaryNum="101010101";
        String findStr="101";
        int processedLength=0;
        try{
            while(processedLength<binaryNum.length()){
                index = binaryNum.indexOf(findStr);
                processedLength=(index==0)?(index+findStr.length()-1):Integer.MAX_VALUE;
                binaryNum=binaryNum.substring(index+findStr.length()-1, binaryNum.length());
                if(processedLength!=Integer.MAX_VALUE)
                	coolness++;               
            }
        }
        catch(Exception e){
           
        }
        
       return coolness; 
    }
}
public class MainClass{
    public static void main(String args[]){
        int r[],k[];
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        r =new int[t+1];
        k=new int[t+1];
        for(int i=0;i<t;i++){
        	r[i]=in.nextInt();
        	k[i]=in.nextInt();
        }
        ExampleCoolNess ex = new ExampleCoolNess();
        if(t<=100&&t>=0){
        	for(int i=0;i<t;i++){
        		if(r[i]<=105&&k[i]<=100&&r[i]>=0&&k[i]>=0){
        			ex.findCoolNess(r[i], k[i]);
        		}
        	}
        }
    }
}