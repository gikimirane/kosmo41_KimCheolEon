import java.util.ArrayList;

import com.project01.DB.B01chat_usersDO;
import com.project01.DB.B02chat_usersDAO;
import com.project01.DB.C01roomlistDO;
import com.project01.DB.C02roomlistDAO;

public class WhyQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		B02chat_usersDAO chuDAO = new B02chat_usersDAO();
		ArrayList<B01chat_usersDO> list2 = chuDAO.checkUSERS("LOCATION", "1");
		
		String result = "";
		int size = list2.size();
		for(int index = 0; index < size; index++) {
			String name = list2.get(index).getNAME();
			String loc = list2.get(index).getLOCATION();
			String login = list2.get(index).getLOGIN();
			
			result += name + ", " + loc + ", " + login + "\n";
		}
		System.out.println(result);
		
		
	
		C02roomlistDAO roomDAO = new C02roomlistDAO();
		ArrayList<C01roomlistDO> list = roomDAO.getRoomList();

		int totalElements = list.size();// arrayList의 요소의 갯수를 구한다.
		String sResult = "";
		
		for (int index = 0; index < totalElements; index++) {
			String rnumber = list.get(index).getRNUMBER();
			String rmax = list.get(index).getRMAX();
			String rusercount = list.get(index).getRUSERCOUNT();
			String rname = list.get(index).getRNAME();
			String rhidden = list.get(index).getRHIDDEN();

			sResult += "\n\t[No." + rnumber + "]\t" + "[총원:" + rmax + "]\t" + "[현재원:" + rusercount + "]\t" + "[상태:"
					+ rhidden + "]\n\t[" + rname + "]\n";
		}
		System.out.println("sResult 전문 : " + sResult);

	}
}
