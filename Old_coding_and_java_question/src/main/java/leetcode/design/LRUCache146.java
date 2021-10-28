package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {
	Map<Integer, DoubleLinkedList> map = new HashMap<Integer, DoubleLinkedList>();
	int capacity;
	DoubleLinkedList head, end;

	public LRUCache146(int capacity) {
		this.capacity = capacity;
	}

	public static void main(String args[]) {
		LRUCache146 l = new LRUCache146(2);
		l.put(1, 1);
		l.put(2, 2);
		l.print();
		System.out.println("  value " + l.get(1)); // returns 1
		l.put(3, 3); // evicts key 2
		l.print();
		System.out.println("  value " + l.get(2));
		l.put(4, 4); // evicts key 1
		System.out.println("  value " + l.get(1)); // returns -1 (not found)
		System.out.println("  value " + l.get(3)); // returns 3
		System.out.println("  value " + l.get(4)); // returns 4
	}

	public void print() {
		DoubleLinkedList curr = head;
		while (curr != null) {
			System.out.print(curr.value + "   ");
			curr = curr.forward;
		}
		System.out.println();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedList value = map.get(key);
			if (head != null && value.forward != null && value.prev != null) {
				value.prev.forward = value.forward;
				value.forward = head;
				value.prev = null;
				head.prev = value;
				head = value;
			} else if (head != null && value.prev != null) {
				value.forward = head;
				value.prev = null;
				head.forward = null;
				head.prev = value;
				end = head;
				head = value;
			}

			return value.value;

		}
		return -1;

	}

	public void put(int key, int value) {

		if (map.containsKey(key)) {

			get(key);
		}
		DoubleLinkedList linked = new DoubleLinkedList(value, key);

		if (map.size() >= capacity) {
			remove(head, end);

		}

		if (head != null) {
			linked.forward = head;
			head.prev = linked;
			end = head;
		}
		map.put(key, linked);
		head = linked;

	}

	private void remove(DoubleLinkedList head, DoubleLinkedList end) {
		DoubleLinkedList prev = end.prev != null ? end.prev : null;
		if (prev != null) {
			prev.prev=prev;
			map.remove(end.key);
			prev.forward = null;
			end = prev;

		}
	}
}

class DoubleLinkedList {
	DoubleLinkedList prev, forward;
	int value;
	int key;

	public DoubleLinkedList(int value, int key) {
		this.value = value;
		this.key = key;
		prev = null;
		forward = null;
	}
}
