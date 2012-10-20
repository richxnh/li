package li.spider;

import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class T {
	public static void main(String[] args) throws Exception {
		final String url = "";

		for (int i = 0; i < 10000; i++) {
			new Thread() {
				public void run() {
					try {
						for (int j = 0;; j++) {
							Document document = Jsoup.connect(url).get();
							System.out.println(new Date() + "\t" + Thread.currentThread() + "\t" + j + "\t" + document.text());
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				};
			}.start();
		}
	}

	public static void chengda_yaowen() throws Exception {
		String url = "";
		Document document = Jsoup.connect(url).get();

		Elements threads = document.select("div.list ul li a");

		for (Element thread : threads) {
			System.out.println(thread.attr("href") + "\t" + thread.text());
		}
	}

	public static void baidu_tieba() throws Exception {
		String url = "";
		Document document = Jsoup.connect(url).get();

		Elements threads = document.select("a[class=j_th_tit]");

		for (Element thread : threads) {
			System.out.println(thread.attr("href") + "\t" + thread.text());
		}
	}
}