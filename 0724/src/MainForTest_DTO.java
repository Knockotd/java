import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;

public class MainForTest_DTO {

	public static void main(String[] args) {
		DTO dto1 = new DTO();
		DTO dto2 = new DTO();
		DTO dto3 = new DTO();
		DTO dto4 = new DTO();
		DTO dto5 = new DTO();

		ArrayList<DTO> arrayList = new ArrayList();
		
		Calendar calendar = Calendar.getInstance();

		dto1.setNum(1);
		dto1.setName("홍길동");
		dto1.setScore(60);
		dto1.setYy(1000);
		dto1.setMm(9);
		dto1.setDd(17);
		arrayList.add(dto1);

		dto2.setNum(2);
		dto2.setName("박보검");
		dto2.setScore(100);
		dto2.setYy(1993);
		dto2.setMm(6);
		dto2.setDd(28);
		arrayList.add(dto2);

		dto3.setNum(3);
		dto3.setName("최화정");
		dto3.setScore(90);
		dto3.setYy(1980);
		dto3.setMm(10);
		dto3.setDd(23);
		arrayList.add(dto3);

		dto4.setNum(4);
		dto4.setName("김숙");
		dto4.setScore(75);
		dto4.setYy(1986);
		dto4.setMm(11);
		dto4.setDd(1);
		arrayList.add(dto4);

		dto5.setNum(5);
		dto5.setName("박서준");
		dto5.setScore(85);
		dto5.setYy(1990);
		dto5.setMm(1);
		dto5.setDd(14);
		arrayList.add(dto5);


		
		
		
		Comparator<DTO> comparator = new Comparator<DTO>() {

			@Override
			public int compare(DTO o1, DTO o2) {
				DTO a = (DTO) o1;
				DTO b = (DTO) o2;
				return a.getScore() - b.getScore();
			}
		};
		arrayList.sort(comparator);

		for (DTO imsi : arrayList) {
			System.out.println(imsi);
				Calendar birthDay = Calendar.getInstance();
				birthDay.set(Calendar.YEAR, imsi.getYy());
				birthDay.set(Calendar.MONTH, imsi.getMm() - 1);
				birthDay.set(Calendar.DAY_OF_MONTH, imsi.getDd());
				long gap = calendar.getTimeInMillis() - birthDay.getTimeInMillis();
				SimpleDateFormat csdf = new SimpleDateFormat("yyyy년 MM월 dd일");
				String str = csdf.format(birthDay.getTimeInMillis());
				System.out.println(str);
			}
		}

	}


