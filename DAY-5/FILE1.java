import java.util.Scanner;
public class FILE1 {
    public static void main(String[] args) {
        System.out.println("DAY-5");
  
    System.out.println("1. PERFECT NUMBER");
        Perfect();


    System.out.println("2. STRONG NUMBER");
        STRONG();


    System.out.println("3. FACTORS OF A NUMBER");
        factors();


    System.out.println("4. LARGEST PRIME FACTOR");
        largestPrimeFactor();


    }
  

    // PERFECT NUMBER
    public static void Perfect() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int s=0;
        for (int i=1;i<num;i++){
            if(num%i==0){
                s=s+i;
            }
        }
        if(s==num){
            System.out.println(num+" is a perfect number.\n");
        } 
        else {
            System.out.println(num+" is not a perfect number.\n");
        }
    }

      // STRONG NUMBER
    public static void STRONG() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int s=0;
        int temp=num;
        while(temp>0){
            int r=temp%10;
            int fact=1;
            for(int i=1;i<=r;i++){
                fact=fact*i;
            }
            s=s+fact;
            temp=temp/10;
        }
        if(s==num){
            System.out.println(num+" is a strong number.\n");
        } 
        else {
            System.out.println(num+" is not a strong number.\n");
        }
    }

// FACTORS OF A NUMBER
    public static void factors() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        System.out.print("Factors of "+num+" are: ");
        for(int i=1;i<=num;i++){
            if(num%i==0){
                System.out.println(i+" ");

            }
        }
        System.out.println(); 
    }
    
    //largest prime factor. 
    public static void largestPrimeFactor() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num=sc.nextInt();
        int maxPrime=-1;
        for(int i=2;i<=num;i++){
            while(num%i==0){
                maxPrime=i;
                num=num/i;
            }
        }
        if(maxPrime!=-1){
            System.out.println("Largest prime factor is: "+maxPrime+ "\n");
        } else {
            System.out.println("No prime factors found.\n");
        }
    }

        

}