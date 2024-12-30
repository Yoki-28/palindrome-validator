package com.palindrome.validator;

public class InputClass {
	private String input;
	private String yes;
	private String no;
	InputClass(){
		super();
	}
	InputClass(String input, String yes, String no){
		this.input=input;
		this.yes=yes;
		this.no=no;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getYes() {
		return yes;
	}
	public void setYes(String yes) {
		this.yes = yes;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
}
