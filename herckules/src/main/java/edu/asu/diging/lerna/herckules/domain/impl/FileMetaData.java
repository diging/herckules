package edu.asu.diging.lerna.herckules.domain.impl;

import edu.asu.diging.lerna.herckules.domain.IFileMetaData;



/**
 * 
 * @author bhargavdesai
 *
 */
public class FileMetaData implements IFileMetaData {
	 
    private String fileOriginalName;
    private String fileSize;
    private String fileType;
    private String id;
    private String fileNewName;
    private String user;
    private String project;
 
    private byte[] bytes;

    
    @Override
	public String getFileOriginalName() {
		return fileOriginalName;
	}

    
    @Override
	public void setFileOriginalName(String fileName) {
		this.fileOriginalName = fileName;
	}

    
    @Override
	public String getFileSize() {
		return fileSize;
	}

    @Override
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

    @Override
	public String getFileType() {
		return fileType;
	}

    @Override
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getFileNewName() {
		return fileNewName;
	}

	@Override
	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	@Override
	public String getUser() {
		return user;
	}

	@Override
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String getProject() {
		return project;
	}

	@Override
	public void setProject(String project) {
		this.project = project;
	}
 
    
}