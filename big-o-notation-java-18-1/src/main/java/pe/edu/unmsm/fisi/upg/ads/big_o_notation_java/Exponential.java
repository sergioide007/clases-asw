package pe.edu.unmsm.fisi.upg.ads.big_o_notation_java;

import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

//Complexity: O(2^N)
public class Exponential {

	public static void main(String[] args) {
		long N = 45;
		Exponential exponential = new Exponential();
		Stopwatch stopwatch = Stopwatch.createStarted();
		long[] secuencia = new long[(int) N];
		for (int i = 1; i <= N; i++) {
			try {
				//long fibonacci = exponential.fibonacci(i);
				//System.out.println(i + " => " + fibonacci);
				long fibonacci = exponential.fibonacciLineal(i, secuencia);
				System.out.println(i + " => " + fibonacci);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		System.out.println(String.format("Time elapsed: %d seconds", stopwatch.elapsed(TimeUnit.SECONDS)) + "\n");
	}
	
	public long fibonacci(int n) throws Exception {
        if (n < 0) {
            throw new Exception("N can not be less than zero");
        }
        if (n <= 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
	

	public static long fibonacciLineal(int i, long[] secuencia) {		
		if(i-1 <= 1) {
			secuencia[i-1] = 1; //se engloban dos estados
		} else { 
		secuencia[i-1] = secuencia[i-2] + secuencia[i-3]; //tercer estado
		}
		return secuencia[i-1];			
		
	} 
}
