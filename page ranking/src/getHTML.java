import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class getHTML{
	static int a=0,n=3;
	// n= no of pages
	// k= x/n;
  static double x=0.5,k;
  public  void pagerank(String str1,JTextArea ja) throws Exception{
	  String address1="";
	  String address2="";
	  String address3="";
	  String[] arr1=new String[n];
      if(str1.equals("deadlock"))
	  {
   address1 = "https://github.com/pg17111998/page-ranking/blob/master/deadlock_def.html";
   address2 = "https://github.com/pg17111998/page-ranking/blob/master/methods_of_handling_deadlock.html";
   address3 = "https://github.com/pg17111998/page-ranking/blob/master/conditions_of_deadlock.html";
  
   arr1[0]="deadlock_def.html";
   arr1[1]="methods_of_handling_deadlock.html";
   arr1[2]="conditions_of_deadlock.html";
	  }
      if(str1.equals("polymorphism"))
	  {
   address1 = "https://github.com/pg17111998/page-ranking/blob/master/polymorphism.html";
   address2 = "https://github.com/pg17111998/page-ranking/blob/master/runtime_polymorphism.html";
   address3 = "https://github.com/pg17111998/page-ranking/blob/master/runtime_polymorphism_with_dm.html";
  
   arr1[0]="polymorphism.html";
   arr1[1]="runtime_polymorphism.html";
   arr1[2]="runtime_polymorphism_with_dm.html";
	  } 
      if(str1.equals("constructor"))
	  {
   address1 = "https://github.com/pg17111998/page-ranking/blob/master/constructor.html";
   address2 = "https://github.com/pg17111998/page-ranking/blob/master/default_constructor.html";
   address3 = "https://github.com/pg17111998/page-ranking/blob/master/parameterized_constructor.html";
  
   arr1[0]="constructor.html";
   arr1[1]="default_constructor.html";
   arr1[2]="parameterized_constructor.html";
	  }  
  URL pagelocation = new URL(address1);
  Scanner in = new Scanner(pagelocation.openStream());
  double[][] arr=new double[n][n];
  int[] counter=new int[n];
  /*String[] arr1=new String[n];
  arr1[0]="deadlock_def.html";
  arr1[1]="methods_of_handling_deadlock.html";
  arr1[2]="conditions_of_deadlock.html";*/
  for(int i=0;i<n;i++)
	  counter[i]=0;
	  while(in.hasNext()) {
	  String line = in.next();
	  if(line.contains(arr1[0]))
	  arr[0][0]=1;
	  if(line.contains(arr1[1]))
	  arr[0][1]=1;
	  if(line.contains(arr1[2]))
	  arr[0][2]=1;
	  if(line.contains("deadlock") || line.contains("Deadlock") || line.contains("DEADLOCK"))
		  counter[0]++;
	  if(line.contains("polymorphism") || line.contains("Polymorphism") || line.contains("POLYMORPHISM"))
		  counter[0]++;
	  if(line.contains("constructor") || line.contains("Constructor") || line.contains("CONSTRUCTOR"))
		  counter[0]++;
	 }
  //address2 = "file:///C:/Users/Prakul/Desktop/Page Ranking/methods_of_handling_deadlock.html";
  pagelocation = new URL(address2);
  in = new Scanner(pagelocation.openStream());
  while(in.hasNext()) {
	  String line = in.next();
	  if(line.contains(arr1[0]))
	  arr[1][0]=1;
	  if(line.contains(arr1[1]))
	  arr[1][1]=1;
	  if(line.contains(arr1[2]))
	  arr[1][2]=1;
	  if(line.contains("deadlock") || line.contains("Deadlock") || line.contains("DEADLOCK"))
		  counter[1]++;
	  if(line.contains("polymorphism") || line.contains("Polymorphism") || line.contains("POLYMORPHISM"))
		  counter[1]++;
	  if(line.contains("constructor") || line.contains("Constructor") || line.contains("CONSTRUCTOR"))
		  counter[1]++;
  }
  //address3 = "file:///C:/Users/Prakul/Desktop/Page Ranking/conditions_of_deadlock.html";
  pagelocation = new URL(address3);
  in = new Scanner(pagelocation.openStream());
  while(in.hasNext()) {
	  String line = in.next();
	  if(line.contains(arr1[0]))
	  arr[2][0]=1;
	  if(line.contains(arr1[1]))
	  arr[2][1]=1;
	  if(line.contains(arr1[2]))
	  arr[2][2]=1;
	  if(line.contains("deadlock") || line.contains("Deadlock") || line.contains("DEADLOCK"))
		  counter[2]++;
	  if(line.contains("polymorphism") || line.contains("Polymorphism") || line.contains("POLYMORPHISM"))
		  counter[2]++;
	  if(line.contains("constructor") || line.contains("Constructor") || line.contains("CONSTRUCTOR"))
		  counter[2]++;
  }
  // counter matrix
  for(int i=0;i<n;i++){
	  System.out.print(counter[i]-1+" ");
  }
  System.out.println(); 
  // adjacency matrix
  for(int i=0;i<n;i++){  
	  for(int j=0;j<n ;j++){  
      System.out.print(arr[i][j]+" ");  
	  }  
	  System.out.println();  
	  }  
  
  for(int i=0;i<n;i++){  
	  for(int j=0;j<n;j++){ 
		if(arr[i][j]==1)
		a++;}
      for(int j=0;j<n;j++)	
    	  arr[i][j]=arr[i][j]/a;
		a=0;  
  }
  k=x/n;
  for(int i=0;i<n;i++){  
	  for(int j=0;j<n;j++){ 
		arr[i][j]=x * arr[i][j];  
		arr[i][j]=arr[i][j] + k;
	  }}
  
  // transition probability matrix
  System.out.println();
  for(int i=0;i<n;i++){  
	  for(int j=0;j<n ;j++){  
      System.out.print(arr[i][j]+" ");  
	  }  
	  System.out.println();  
	  }  
  double[] dv=new double[n];
  double[] dv1=new double[n];
  double[] s1=new double[n];
  dv[0]=1;
  dv[1]=0;
  dv[2]=0;
  double sum=0;
  int y=0,count=0;
     
  while(count<15)
     {
     y=0;
     sum=0;
     for(int i=0;i<n;i++)
    	 s1[i]=0;
	 for(int j=0;j<n;j++)
	 {
	 for(int i=0;i<n;i++)
	 {
     sum=sum + dv[i] * arr[i][y];
     }
	 s1[y]=sum;
	 sum=0;	
	 y=y+1;
     } 
	 for(int i=0;i<n;i++)
	 dv[i]=s1[i];
	 count++;
	 }//}
     System.out.println();
	 for(int i=0;i<n;i++)
     System.out.print(dv[i]+" ");
	 System.out.println();
	 for(int i=0;i<n;i++)
	 {
		dv1[i]= dv[i]+counter[i]-1;
		 }
	 for(int i=0;i<n;i++)
	     System.out.print(dv1[i]+" ");
	 System.out.println();
	 System.out.println();
	 
		 if(dv1[0]>dv1[1] && dv1[0]>dv1[2]) {
	     System.out.println(arr1[0]);
	     ja.setText(arr1[0]+"\n");
	     if(dv1[1]>dv1[2]) {
	    	System.out.println(arr1[1]);
	    	ja.append(arr1[1]+"\n");
	    	System.out.println(arr1[2]);
	    	ja.append(arr1[2]+"\n");
	     }
	     else {
	    	 System.out.println(arr1[2]);
	    	 ja.append(arr1[2]+"\n");
	    	 System.out.println(arr1[1]);
	    	 ja.append(arr1[1]+"\n");
	     }}
		 
		 
		 else if(dv1[1]>dv1[0] && dv1[1]>dv1[2]) {
		 System.out.println(arr1[1]);
		 ja.setText(arr1[1]+"\n");
		 
		 if(dv1[0]>dv1[2]) {
		    	System.out.println(arr1[0]);
		    	ja.append(arr1[0]+"\n");
		    	System.out.println(arr1[2]);
		    	ja.append(arr1[2]+"\n");
		     }
		     else {
		    	 System.out.println(arr1[2]);
		    	 ja.append(arr1[2]+"\n");
		    	 System.out.println(arr1[0]);
		    	 ja.append(arr1[0]+"\n");
		     }}
		 
		 else if(dv1[2]>dv1[1] && dv1[2]>dv1[0]) {
		 System.out.println(arr1[2]);
		 ja.setText(arr1[2]+"\n");
		 if(dv1[0]>dv1[1]) {
		    	System.out.println(arr1[0]);
		    	ja.append(arr1[0]+"\n");
		    	System.out.println(arr1[1]);
		    	ja.append(arr1[1]+"\n");
		     }
		     else {
		    	 System.out.println(arr1[1]);
		    	 ja.append(arr1[1]+"\n");
		    	 System.out.println(arr1[0]);
		    	 ja.append(arr1[0]+"\n");
		 }}}
		 public static void main(String[] args) throws Exception{
		 }}

