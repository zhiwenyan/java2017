package com.fumi.java8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinCalculate extends RecursiveTask<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 123456L;
	private long start;
	private long end;

	private static final long THRESHOLD = 1000L;

	
	public ForkJoinCalculate(long start, long middle) {
		this.start=start;
		this.end=middle;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if (length <= THRESHOLD) {
			long sum = 0;
			for (long i = start; i <= end; i++) {
				sum += i;
			}
			return sum;
		} else {
			long middle = (end + start) / 2;
			ForkJoinCalculate left=new ForkJoinCalculate(start,middle);
			left.fork();//拆分子任务，同时压入线程队列。
			ForkJoinCalculate right=new ForkJoinCalculate(middle+1,end);
			right.fork();
			return left.join()+right.join();
			
		}
	}

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		ForkJoinTask<Long> task=new ForkJoinCalculate(0, 10000000L);
		long sum=forkJoinPool.invoke(task);
		System.out.println("sum=="+sum);
	}

}
