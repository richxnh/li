package li.spider;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class T {
	public static void main(String[] args) throws Exception {
		System.out.println("hello spaider");
		
		String url="http://tieba.baidu.com/f?kw=%B3%C9%B6%BC%B4%F3%D1%A7";
		Document document=Jsoup.connect(url).get();

		Elements threads=document.select("a[class=j_th_tit]");
		
		for (Element thread : threads) {
			System.out.println(thread.attr("href")+"\t"+thread.text());
		}
	}
}