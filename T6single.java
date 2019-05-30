package ppt10;
import java.util.Scanner;


public class T6single {
	
    private Integer mutex = 1;
    
    private static int num = 0;
    
	private static Scanner sc;
	
    public static void main(String[] args) {
    	
    	System.out.print("Enter a num : ");
    	sc = new Scanner(System.in);
    	int num1 = sc.nextInt();
        T6single pn = new T6single();
        
        Thread1 t1 = pn.new Thread1(1, num1);  // run() 方法每次从 arg1 + 1 开始
       
        t1.start();
        
        try {
            Thread.sleep(1000);  //等待1s，处理异常
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Prime numbers : "+num);
        
    }
    class Thread1 extends Thread {
    	
        private int start;
        private int end;
        
        public Thread1(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public void run() {
            for (int i = start + 1; i <= end; i++) {
            	
                synchronized (mutex) {
                    int flag = 1;
                
                    for (int j = 2; j <= (int)Math.floor((Math.sqrt(i))); j++) {
                    	if (i % j == 0) {
                            flag = 0;
                        }
                    }
                    
                    if (flag == 1) {
                        num++;
                        System.out.print(i+" ");
                        if (num % 10 == 0) System.out.println();
                    }
                    
                }
            }
            System.out.println();
        }
    }
}
