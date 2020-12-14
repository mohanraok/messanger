package com.facebook.app.messanger.model;

public class RequestModel {

	private int year;

	private int start;

	private int size;

	public RequestModel() {
		super();
	}

	public RequestModel(int year, int start, int size) {
		super();
		this.year = year;
		this.start = start;
		this.size = size;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
		System.out.println("setYear()");
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
