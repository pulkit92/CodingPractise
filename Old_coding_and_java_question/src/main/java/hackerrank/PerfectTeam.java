/*
package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class PerfectTeam {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = null;
		if (fileName != null) {
			bw = new BufferedWriter(new FileWriter(fileName));
		} else {
			bw = new BufferedWriter(new OutputStreamWriter(System.out));
		}

		int res;
		String skills;
		try {
			skills = in.nextLine();
		} catch (Exception e) {
			skills = null;
		}

		res = differentTeams(skills);
		bw.write(String.valueOf(res));
		bw.newLine();

		bw.close();
	}

	static int differentTeams(String skills) {
		String s = "pcmbz";
		int min = skillscount(skills, "p");
		if (!skills.contains(s)) {
			return 0;
		}
		// int min = Integer.MAX_VALUE;
		for (String subj : "pcmbz".split("")) {
			min = Math.min(count(skills, subj), min);
			// skills.String skillsRem = skills.replaceAll(subj, "");
			// min = Math.min(skills.length() - skillsRem.length(), min);
			// skills = skillsRem;
		}
		return min;

	}

	*/
/*static int count(String skills, String s) {
		int count = 0;

		for (int i = 0; i < skills.length(); i++) {
			if (skills.charAt(i) == s.charAt(0)) {
				count++;
			}
		}
		return count;
	}*//*

}
*/
