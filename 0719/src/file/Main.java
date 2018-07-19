package file;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String acgt = "ACCGCCGACDGCCG";
		String codon = "GCCG";
		for(int i=0; i<acgt.length(); i++) {
			char ch = acgt.charAt(i);
			if(ch==codon.charAt(0)) {
				int idx = i;
				int j;
				for(j=1; j<codon.length(); j++) {
					if(acgt.charAt(idx+j) != codon.charAt(j)) {
						break;
					}
					
				}
				if(j==codon.length()) {
					System.out.println(idx);
					i = i+codon.length()-1;
				}
			}
		}
	}

}
