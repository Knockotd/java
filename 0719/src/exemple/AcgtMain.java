package exemple;

import java.util.ArrayList;
import java.util.Scanner;

public class AcgtMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("비교할 코드 입력 : ");

		String acgtSequence = sc.nextLine();
		System.out.println("찾아야 하는 코드 입력: ");
		String codon = sc.nextLine();

		findCodon(acgtSequence, codon);
		sc.close();
	}

	private static void findCodon(String acgtSequence, String codon) {
		String a = acgtSequence;
		String b = codon;
		/*
		 * String a = "ACCGGCCGAGACAGCGAGCATATGCCGCCGAGACAGGCCGGACCGGCCGAGA"; String b =
		 * "GCCG";
		 */
		ArrayList<Character> ar = new ArrayList();
		ArrayList<Character> br = new ArrayList();

		int i, j;
		for (i = 0; i < a.length(); i++) {
			ar.add(a.charAt(i));
			if (i < b.length()) {
				br.add(b.charAt(i));
			}
		}
		for (i = 0; i < a.length(); i++) {
			if (i >= a.length() - 3) {
				break;
			}
			int cnt = 0;
			int k;
			// 같은 위치의 ar과 br이 같은지를 비교
			for (j = i, k = 0; j < i + b.length(); j++, k++) {
				if (ar.get(j) != br.get(k)) {
					continue;
				} else {
					cnt = cnt + 1;
				}

			}
			if (cnt == b.length()) {
				System.out.println(i);
				i = i + b.length() - 1;

			}
		}
	}
}
