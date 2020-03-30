package com.mvc;

import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Transient;

@Entity
public class Slika {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	
	@Lob
	private byte[] file;
	private String base64Image;
	
	@Transient
	public String getBase64Image() {
		base64Image = Base64.getEncoder().encodeToString(this.file);
		return base64Image;
	}
	
	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		return "Slika [id=" + id + ", name=" + name + ", file=" + Arrays.toString(file) + ", base64Image=" + base64Image
				+ "]";
	}
	
}
