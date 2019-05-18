import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a= (int) ((Math.random()*100)+1);
        int n;
        System.out.println(a);
        Boolean flag=false;
        Scanner in=new Scanner(System.in);
        for(int i=0;i<10;i++){
        n=in.nextInt();
        if(n==a){
            System.out.print("you won!!");
            flag=true;
            break;
        }
        else if(n>a){
            System.out.println("Its smaller");
        }
        else {
            System.out.println("Its greater");
        }
        }
        if(!flag) System.out.print("you lost!!!");

    }
}
