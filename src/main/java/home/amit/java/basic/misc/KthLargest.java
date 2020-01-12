package home.amit.java.basic.misc;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
	
	
	 public static void main(String[] args) {
	        int[] array = new int[] {4, 10, 3, 5, 1};
	        System.out.println(new KthLargest().findKthLargest(array, 2));
	    }
	 
	    public int findKthLargest(int[] nums, int k) {
	        Queue<Integer> q = new PriorityQueue<Integer>(k);
	        for (int i : nums) {
	            q.offer(i);
	 
	            if (q.size() > k) {
	                q.poll();
	            }
	        }
	        System.out.println(q); //To print all k Largest elements
	        return q.peek(); //To print kth Largest element
	    }

}
