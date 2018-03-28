package com.app.test;

import java.util.ListIterator;
import java.util.Stack;

public class Test {
 public static void main(String[] args) {
	Stack s=new Stack();
	for(int i=0;i<10;i++) {
		s.push(i);
	}
	ListIterator iterator=s.listIterator();
	while(iterator.hasNext()) {
		Integer i=(Integer)iterator.next();
		if(i%2==0) {
			System.out.print(i);
		}
		else
			iterator.remove();
	}
}
}
