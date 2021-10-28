package leetcode.design;

import java.util.HashMap;
import java.util.Map;

public class TinyUrl535 {
	static int count = 1;
	static Map<String, String> shorturlMap = new HashMap<>();
	String alphabet = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl) {
		int encode = count;
		StringBuffer sna = new StringBuffer();
		while (encode >0) {
			encode=encode-1;
			sna.append(alphabet.charAt(encode % 62));
			encode = encode / 62;
		}
		shorturlMap.put(sna.toString(), longUrl);
		count++;
		return sna.toString();

	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return shorturlMap.get(shortUrl);
	}

	public static void main(String args[]) {
		TinyUrl535 l = new TinyUrl535();
		System.out.println(l.encode("ddd"));
		System.out.println(l.encode("yyyy"));
	}

}
