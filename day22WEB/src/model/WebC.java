package model;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.ChampionDAO;
import model.ChampionVO;

public class WebC {

	public static void main(String[] args) {
		
		final String url="https://www.op.gg/champions"; // 웹크롤링할 웹 주소 
		Document doc=null; // try 밖에서도 사용하기 때문에 밖에서 선언(스코프)
		try {
			doc=Jsoup.connect(url).get(); // Jsoup은 외부클래스 이기때문에 jar 파일을 자바빌드패스에 넣기
			// 이제 저 url과 이클립스가 연동됨
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 태그명, class속성명, id속성명(유일한 요소)
		Elements eles=doc.select("strong"); // 
		Elements eles2=doc.select("td.css-1wvfkid");
		
		Iterator<Element> itr=eles.iterator();
		Iterator<Element> itr2=eles2.iterator();
		ChampionDAO mDAO=new ChampionDAO();
		while(itr2.hasNext()) {
			ChampionVO mVO=new ChampionVO();
			
			mVO.setName(itr.next().text());
			
			String str=itr2.next().text();
			str=str.substring(0, str.length()-4);
			mVO.setWin(Integer.parseInt(str));
			String str2=itr2.next().text();
			str2=str2.substring(0, str2.length()-4);
			mVO.setPick(Integer.parseInt(str2));
			String str3=itr2.next().text();
			str3=str3.substring(0, str3.length()-4);
			mVO.setBan(Integer.parseInt(str3));
			
			mDAO.insert(mVO);
			System.out.println(mVO);
		}
		System.out.println("로그: 샘플데이터 저장완료!");
		
	}

}
