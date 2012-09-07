package li.dao;

public class DataSource extends SimpleDataSource {
	public String getUrl() {
		return "jdbc:mysql://127.0.0.1/framework_forum?characterEncoding=UTF-8";
	}

	public String getUsername() {
		return "root";
	}

	public String getPassword() {
		return "";
	}
}