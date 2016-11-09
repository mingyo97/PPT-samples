package zeroSumSubsequence;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZeroSumSubsequence {
	
	public static int getMaximumLength(List<Integer> sequence) {
		List<Integer> lengths = new LinkedList<Integer>();
		List<Integer> list = new LinkedList<Integer>(sequence);
				
		int n=0;
		int count=0;
		getLengths(lengths, n, count, list);
		
		System.out.println(lengths);		
		
		if(lengths.size()==0)
			return 0;
		
		int max=lengths.get(0);
		
		for(int i: lengths) {
			if(i>max){
				max=i;
			}
		}
		return max; // Change This
	}
	
	private static void getLengths(List<Integer> lengths, int n, int ncount, List<Integer> sequence) {
		System.out.println(sequence);
		if(sequence.isEmpty()) {
			return;
		}else {
			int sum=0;
			for(int i:sequence) {
				sum+=i;
			}
			System.out.println(n+" " + sum);
			
			if(n+sum==0) {
				lengths.add(sequence.size()+ncount);
			} else {
				int next=sequence.remove(0);
				
				List<Integer> copy = new LinkedList<Integer>(sequence);
				getLengths(lengths,n+next, ncount+1, copy);
				getLengths(lengths,n,ncount, sequence);
			}
		}
	}
	
}
