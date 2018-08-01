import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;

public class Aa {

	public static void main(String[] args) {
		ArrayList<DTO> arrayList = new ArrayList();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Calendar calendar = Calendar.getInstance();

		DTO dto1 = new DTO();
		DTO dto2 = new DTO();
		DTO dto3 = new DTO();
		DTO dto4 = new DTO();
		DTO dto5 = new DTO();

		try {
			dto1.setNum(1);
			dto1.setName("홍길동");
			dto1.setScore(60);
			dto1.setBir(sdf.parse("1993-9-17"));
			arrayList.add(dto1);

			dto2.setNum(2);
			dto2.setName("박보검");
			dto2.setScore(100);
			dto2.setBir(sdf.parse("1993-6-16"));
			arrayList.add(dto2);

			dto3.setNum(3);
			dto3.setName("최화정");
			dto3.setScore(90);
			dto3.setBir(sdf.parse("1961-2-10"));
			arrayList.add(dto3);

			dto4.setNum(4);
			dto4.setName("김숙");
			dto4.setScore(75);
			dto4.setBir(sdf.parse("1975-7-06"));
			arrayList.add(dto4);

			dto5.setNum(5);
			dto5.setName("박서준");
			dto5.setScore(85);
			dto5.setBir(sdf.parse("1988-12-16"));
			arrayList.add(dto5);			
			
			}catch(Exception e){
				System.out.println(e.getMessage());
				}
		
		Comparator<DTO> comparator = new Comparator<DTO>() {

			@Override
			public int compare(DTO o1, DTO o2) {
				DTO a = (DTO)o1;
						DTO b = (DTO)o2;
				
				return a.getScore()-b.getScore();
			}};
		arrayList.sort(comparator);
			
			for(DTO imsi : arrayList) {
				System.out.println(imsi);
				Calendar birthDay = Calendar.getInstance();
				/*birthDay.set(Calendar.YEAR, imsi.getYy());
				birthDay.set(Calendar.MONTH, imsi.getMm() - 1);
				birthDay.set(Calendar.DAY_OF_MONTH, imsi.getDd());
				*/
				String str = sdf.format(birthDay.getTimeInMillis()); 
				System.out.println(str);
				
			}
	}

}
