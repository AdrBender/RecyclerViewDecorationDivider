package com.adriano.recyclerviewdecorationdivider;

public class AndroidList {
	String name; 
	String version;
	int desc;
	int image;
			 
	AndroidList(String name, String version, int desc, int image) { 
		this.name = name; 
		this.version = version;
		this.image = image;
		this.desc = desc;
	}
	
	public String getName(){
		return name;
	}
	
	public String getVersion(){
		return version;
	}
	
	public int getDesc(){
		return desc;
	}
	
	public int getImage(){
		return image;
	}
}
