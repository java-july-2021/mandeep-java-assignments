import java.util.ArrayList;
public class Basics{
	public static void main(String[] args) {
		OneTo255();
		PrintOdds();
		PrintSum();
		int[] nums = {23,234,2345,-23,42};
		int[] arr = {2,10,3};
		LoopArray(nums);
		FindMax(nums);
		FindMin(nums);
		GetAverage(nums);
		SquareArray(nums);
		EliminateNegatives(nums);
		MaxMinAverage(nums);
		ShiftArrayValues(nums);
		GreaterThanY(arr, 3);
		System.out.println(GetArraySum(nums));
			
	}
	// Print 1-255
	public static void OneTo255() {
		for(int i = 0; i <= 255; i++)
			System.out.println(i);
	}
	//	Print odd numbers between 1-255
	public static void PrintOdds() {
		for(int i = 0; i <= 255; i++) {
			if(i % 2 == 0)
				System.out.println(i);
		}
	}
	public static int GetArraySum(int[] numbers) {
		int sum = 0;
		for(int i = 0; i < numbers.length; i++) {
			sum += numbers[i];			
		}
		return sum;
	}
	//	Print Sum
	public static void PrintSum() { 
		int sum = 0;
		for(int i = 0; i <= 255; i++) {
			sum += 0;
			System.out.println(String.format("New number: %d, Sum: %d", i, sum));
		}
	}
	// Iterating through an array
	public static void LoopArray(int[] arr) {
		for(int val: arr)
			System.out.println(val);
	}
	// Find Max
	public static int FindMax(int[] arr) {
		int currMax = Integer.MIN_VALUE;
		for(int val: arr){
			if(val > currMax)
				currMax = val;
		}
		System.out.println(currMax);
	}
	public static int FindMin(int[] arr) {
		int currMin = Integer.MAX_VALUE;
		for(int val: arr){
			if(val < currMin)
				currMin = val;
		}
		System.out.println(currMin);
	}
	// Get Average
	public static double GetAverage(int[] nums) {
		int sum = GetArraySum(nums);
		double avg =(double)sum/nums.length;
		System.out.println(String.format("Sum: %d, Average: %f", sum, avg));
		return avg;
	}
	// Array with Odd Numbers
	public static ArrayList<Integer> OddArray() {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for(int i = 0; i <= 255; i++) {
			if(i % 2 != 0)
				nums.add(i);
		}
		return nums;
	}
	// Greater Than Y
	public static int GreaterThanY(int[] arr, int y) {
		int count = 0;
		for(int num: arr) {
			if(num > y)
				count++;
		}
		System.out.println(count);
	}
	// Square the values
	public static void SquareArray(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			nums[i] = nums[i] * nums[i];	
		}
		System.out.println(Arrays.toString(nums));
	}
	// Eliminate Negative Numbers
	public static void EliminateNegatives(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] < 0)
				nums[i] = 0;
		}
		System.out.println(Arrays.toString(nums));
	}
	// Max, Min, and Average
	public static void MaxMinAverage(int[] nums) {
		int min = FindMin(nums);
		int max = FindMax(nums);
		double avg = GetAverage(nums);
		System.out.println(String.format("Max: %d, Min: %d, Average: %f", max, min, avg));
	}
	// Shifting the Values in the Array
	public static void ShiftArrayValues(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			arr[i-1] = arr[i];
		}
		arr[arr.length-1] = 0;
	}
}