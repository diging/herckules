package edu.asu.diging.lerna.herckules.domain;

public interface IFileMetaData {

	public String getFileOriginalName();

	public void setFileOriginalName(String fileName);

	public String getFileSize();

	public void setFileSize(String fileSize);

	public String getFileType();

	public void setFileType(String fileType);

	public byte[] getBytes();

	public void setBytes(byte[] bytes);

	public String getId();

	public void setId(String id);

	public String getFileNewName();

	public void setFileNewName(String fileNewName);

	public String getUser();

	public void setUser(String user);

	public String getProject();

	public void setProject(String project);

}