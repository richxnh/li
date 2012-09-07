package li.mvc;

import java.io.File;

public class TempFile {
	private File file;
	private String contentType;
	private String name;
	private String fileLocalPath;
	private String fileLocalName;
	private String fileExtension;
	private String contentDisposition;

	public File getFile() {
		return this.file;
	}

	public String getContentType() {
		return this.contentType;
	}

	public String getName() {
		return this.name;
	}

	public String getFileLocalPath() {
		return this.fileLocalPath;
	}

	public String getFileLocalName() {
		return this.fileLocalName;
	}

	public String getFileExtension() {
		return this.fileExtension;
	}

	public String getContentDisposition() {
		return this.contentDisposition;
	}
}