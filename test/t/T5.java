package t;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

public class T5 {
	static Integer index = 0;

	public static void main(String[] args) throws Exception {
		String pageUrl = "http://www.iimmgg.com/image/55b3478fb99bbaee31ca92673cc2b7ab";
		analyse(pageUrl);
	}

	public static void analyse(String pageUrl) throws Exception {
		System.out.println((++index) + " " + new Date() + " analyse " + pageUrl);

		URL url = new URL(pageUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "MSIE 7.0");
		connection.setReadTimeout(20000);
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF8"));
		String line = null;
		String pageUrl2 = null;
		while ((line = br.readLine()) != null) {
			// System.out.println(line);

			if (line.contains("<img id=\"laimagen\" src=\"http://v1.iimmgg.com/images/is14gr/")) {
				final String imgUrl = line.substring(line.indexOf("http"), line.indexOf("jpg") + 3);
				System.err.println(imgUrl);
			} else if (line.contains("id=\"next_a\">Next picture</a></div>")) {
				pageUrl2 = line.substring(32, line.length() - 36);
			}
		}
		analyse(pageUrl2);
	}

	public static void download(String imgUrl) throws Exception {
		System.out.println(new Date() + " download " + imgUrl);

		URL url = new URL(imgUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestProperty("User-Agent", "MSIE 7.0");
		connection.setReadTimeout(20000);
		DataInputStream in = new DataInputStream(connection.getInputStream());
		DataOutputStream out = new DataOutputStream(new FileOutputStream("D:/Users/明伟/Desktop/新建文件夹/" + imgUrl.substring(imgUrl.lastIndexOf("/"))));
		byte[] buffer = new byte[4096];
		int count = 0;
		while ((count = in.read(buffer)) > 0) {
			out.write(buffer, 0, count);
		}
		out.close();/* 后面三行为关闭输入输出流以及网络资源的固定格式 */
		in.close();
		connection.disconnect();
	}
}