package br.com.erudio.data.vo.v1;

import java.io.Serializable;

public class UploadFileResponseVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String fileName;
	private String fileDownLoadUri;
	private String fileType;
	private long size;
	
	public UploadFileResponseVO() {
	}
	
	public UploadFileResponseVO(String fileName, String fileDownLoadUri, String fileType, long size) {
		this.fileName = fileName;
		this.fileDownLoadUri = fileDownLoadUri;
		this.fileType = fileType;
		this.size = size;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileDownLoadUri() {
		return fileDownLoadUri;
	}
	public void setFileDownLoadUri(String fileDownLoadUri) {
		this.fileDownLoadUri = fileDownLoadUri;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
}
