package com.meesho.rest.client;

public enum RestRequestType {

	PUT(1),POST(2);
	private int type;
	
	private RestRequestType(int type) {
		this.type = type;
	}
	
	public int getType() {
		return this.type;
	}
	
}
