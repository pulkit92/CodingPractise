package leetcode.design;

import java.util.Map;

public class ImplementTrie208 {
	TrieNode root;

	public ImplementTrie208() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (!node.containsKey(currentChar)) {
				node.put(currentChar, new TrieNode());
			}
			node = node.get(currentChar);
		}
		node.setEnd();
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			char currentChar = word.charAt(i);
			if (node.containsKey(currentChar)) {
				node = node.get(currentChar);
			} else {
				return false;
			}
		}
		if (node.isEnd())
			return true;
		return false;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (int i = 0; i < prefix.length(); i++) {
			char currentChar = prefix.charAt(i);
			if (node.containsKey(currentChar)) {
				node = node.get(currentChar);
			}
			else {
				return false;
			}
			
		}
		return true;
		
	}

	public static void main(String args[]) {
		ImplementTrie208 trie = new ImplementTrie208();

		trie.insert("apple");
		trie.search("apple"); // returns true
		trie.search("app"); // returns false
		// trie.startsWith("app"); // returns true
		trie.insert("app");
		trie.search("app");
		trie.search("apple");

	}

}

class TrieNode {

	// R links to node children
	private TrieNode[] links;

	private final int R = 26;

	private boolean isEnd;

	public TrieNode() {
		links = new TrieNode[R];
	}

	public boolean containsKey(char ch) {
		return links[ch - 'a'] != null;
	}

	public TrieNode get(char ch) {
		return links[ch - 'a'];
	}

		public void put(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}
	
		public void setEnd() {
			isEnd = true;
		}
	
		public boolean isEnd() {
			return isEnd;
		}
}