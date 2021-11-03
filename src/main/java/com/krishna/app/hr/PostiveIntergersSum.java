package com.krishna.app.hr;
import java.io.*;
import java.util.*;

public class PostiveIntergersSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++) {
            int N = Integer.parseInt(br.readLine().trim());

            String out_ = Solve(N);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static String Solve(int N){
        int maxD = (int) Math.sqrt(N);
        Set<Integer> postiveDivisors = new HashSet<Integer>();
        for(int i=1; i <= maxD; i++) {
            if(N%i == 0) {
                postiveDivisors.add(i);
                int divisor = N/i;
                if(divisor != i && divisor != 1 && divisor != N) {
                    postiveDivisors.add(divisor);
                }
            }
        }
        int sum = postiveDivisors.stream().mapToInt(Integer::intValue).sum();
        return sum == N ? "YES" : "NO";
    }

   /* public static boolean is_perfect_number(int n)
    {
        int sum = 1;

        for (int i=2; i*i<=n; i++)
        {
            if (n%i==0)
            {
                if(i*i!=n)
                    sum = sum + i + n/i;
                else
                    sum=sum+i;
            }
        }

        if (sum == n && n != 1)
            return true;

        return false;
    }*/

   /* static String Solve(int N){
        // Write your code here
        int maxD = (int) Math.sqrt(N);
        Set<Integer> postiveDivisors = new HashSet<Integer>();
        for(int i=2; i*i <= N; i++) {
            if(N%i == 0) {
                postiveDivisors.add(i);
                if(i * i != N) {
                    postiveDivisors.add(N/i);
                }

            }
        }
        int sum = postiveDivisors.stream().mapToInt(Integer::intValue).sum();
        return sum == N ? "YES" : "NO";
    }*/
}
