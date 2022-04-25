package com.example.test.model;

import java.util.Scanner;

public class asdas {
        public static void main(String args[])
        {
            int sum = 0;
            int n;
            int status = 1;
            int num = 3;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập vào n số nguyên tố đầu tiên:");
            n = scanner.nextInt();
            if (n >= 1)
            {
                System.out.println(n+ " Số nguyên tố đầu tiên là:");

            }
            for ( int i = 2 ; i <=n ;  )
            {
                for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
                {
                    if ( num%j == 0 )
                    {
                        status = 0;
                        break;
                    }
                }
                if ( status != 0 )
                {
                    System.out.println(num);
                    i++;
                }
                status = 1;
                num++;


            }
            System.out.println(sum+=num);
        }

}
