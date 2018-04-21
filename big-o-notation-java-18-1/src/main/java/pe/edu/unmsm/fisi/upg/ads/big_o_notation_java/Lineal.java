package pe.edu.unmsm.fisi.upg.ads.big_o_notation_java;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

//Complexity: O(N)
public class Lineal {
	private final static int N = 90;
	private long[] fibonacciCache = new long[N + 1];
	
	public Lineal() {
	}
	
	public static void main(String[] args) {
		int NEEDLE = 64;
		Lineal lineal = new Lineal();
		LinealExampleType linealExampleType = LinealExampleType.FibonacciCache;
		switch (linealExampleType) {
			case Loop: lineal.loop(N); break;
			case Search: lineal.search(NEEDLE); break;
			case Factorial: lineal.printFactorial(N); break;
			case Fibonacci: lineal.printFibonacci(N, LinealExampleType.Fibonacci); break;
			case FibonacciCache: lineal.printFibonacci(N, LinealExampleType.FibonacciCache); break;
		}
	}
		
    public void loop(int N) {
    	int counter = 0;
        System.out.println("**********************loop**********************");
        while (counter < N) {
            System.out.println(counter);
            counter = counter + 1;
        }
    }
    
    public void search(int needle) {
    	List<Integer> valueList = Arrays.asList(2, 4, 4, 5, 7, 10, 23, 25, 64);
		boolean found = this.containsNeedle(needle, valueList);
		System.out.println("**********************search**********************");
		System.out.println(found);
    }
    
    public boolean containsNeedle(int needle, List<Integer> valueList) {
        for (long value : valueList) {
            if (value == needle) {
                return true;
            }
        }
        return false;
    }
    
    public void printFactorial(int N) {
    	long factorial = this.getFactorial(N);
    	System.out.println("**********************factorial**********************");
    	System.out.println(factorial);
    }
    
    public long getFactorial(int N) {
        if (N == 1) {
            return 1;
        }
        if (N > 20) { throw new IllegalArgumentException(N + " is out of range"); }
        return (N * getFactorial(N - 1));
    }
    
    public void printFibonacci(int N, LinealExampleType linealExampleType) {
    	Stopwatch stopwatch = Stopwatch.createStarted();
    	for (int i = 1; i <= N; i++) {
			try {
				long fibonacci = 0;
				switch (linealExampleType) {
					case Fibonacci: fibonacci = this.fibonacci(i); break;
					case FibonacciCache: fibonacci = this.fibonacciCache(i); break;
					default: fibonacci = this.fibonacci(i); break;
				}
				System.out.println(i + " => " + fibonacci);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
    	System.out.println(String.format("Time elapsed: %d milliseconds", stopwatch.elapsed(TimeUnit.MILLISECONDS)));
    }
    
    public long fibonacci(int N) throws Exception {
        if (N < 0) {
            throw new Exception("N can not be less than zero");
        }
        if (N <= 2) {
            return 1;
        }
        long fibonacci = 0;
        long previous = 1;
        long penultimate = 0;
        for (int i = 1; i <= N; i++) {
             penultimate = fibonacci;
             fibonacci = previous + fibonacci;
             previous = penultimate;
        }
        return fibonacci;
    }
    
    public long fibonacciCache(int N) throws Exception {
        if (N < 0) {
            throw new Exception("N can not be less than zero");
        }
        if (N <= 2) {
            fibonacciCache[N] = 1;
        }
        if (fibonacciCache[N] == 0) {
            fibonacciCache[N] = fibonacciCache(N - 1) + fibonacciCache(N - 2);
        }
        return fibonacciCache[N];
    }
}
