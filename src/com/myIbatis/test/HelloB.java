/**
 * 
 */
package com.myIbatis.test;

/**
 * @author donglujie
 * @创建日期 2015-6-3
 */
public class HelloB extends HelloA{
	 public HelloB() {
	        System.out.println("HelloB");
	    }
	    
	    { System.out.println("I'm B class"); }
	    
	    static { System.out.println("static B"); }
	    
	    public static void main(String[] args) {
	        System.out.println("-------main start-------");
	        new HelloB();
	        System.out.println("-------main end-------");
	    }
}
