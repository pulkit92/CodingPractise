package leetcode.greedy;

public class QueueReconByHeight {
	public static int[][] reconstructQueue(int[][] people) {
		int l = people.length;
		int c = people[0].length;
		System.out.println(l);
		System.out.println(c);
		return people;
	}

	public static void main(String args[]) {
		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int a[][] = reconstructQueue(people);
	}

}
