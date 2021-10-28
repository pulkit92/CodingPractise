class Ideone {
	public static void main(String[] args) throws Exception {
		String input = "|name|address|~n|Patrick|patrick@test.com|pat@test.com|~n|Annie|annie@test.com|~n|Zoe|~n";
System.out.println(validate(input));
	}

	static String validate(String input) {
		if (input.contains("~~~"))
			return "0:0:0:format_error";
		input = input.replaceAll("~\\|", "|");
		input = input.replaceAll("~~", "~");
		String[] s = input.split("~n");
		int output1 = 0;
		if (input.charAt(input.length() - 2) == '~' && input.charAt(input.length() - 1) == 'n')
			output1 = s.length - 1;
		else
			output1 = s.length;
		int output2 = 0, count1 = 0;
		for (int i = 0; i < s[1].length(); i++)
			if (s[1].charAt(i) == '|')
				count1++;
		output2 = count1 - 1;
		int flag = 0;
		int output3 = 0;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '~' && input.charAt(i + 1) == 'n') {
				flag = 1;
				continue;
			}
			if (flag == 1) {
				if (input.charAt(i) == '|' && input.charAt(i + 1) == '|')
					output3++;
			}
		}

		int output4 = 0, flag1 = 0;
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == '~' && input.charAt(i + 1) == 'n') {
				flag1 = 1;
				continue;
			}
			if (flag1 == 0) {
				if (input.charAt(i) == '|')
					output4++;
			}
		}
		String output5 = input.substring(s[0].lastIndexOf('|', s[0].lastIndexOf('|') - 1) + 1, s[0].lastIndexOf('|'))
				+ "_" + (output2 - (output4 - 1));
		return (output1 + ":" + output2 + ":" + output3 + ":" + output5);

	}
}