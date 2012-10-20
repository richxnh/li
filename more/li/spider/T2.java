package li.spider;

import java.util.HashMap;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class T2 {
	public static void main(String[] args) {

	}

	public static void main2(String[] args) throws Exception {
		String url = "http://bbs.cduer.com/forum.php?mod=post&action=reply&fid=243&tid=197226&extra=page%3D1&replysubmit=yes&infloat=yes&handlekey=fastpost&inajax=1";

		Map<String, String> map = new HashMap<String, String>();

		map.put("message", "消息内容");
		map.put("posttime", "1350724284");
		map.put("formhash", "89b20919");
		map.put("subject", "");

		Document document = Jsoup.connect(url).data(map).post();

		System.out.println(document);
	}
}