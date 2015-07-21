/**
 * 
 */
package com.myIbatis.test;

/**
 * @author donglujie
 * @创建日期 2015-6-3
 */
public class HelloA {
    public HelloA() {
        System.out.println("HelloA");
    }
    
    { System.out.println("I'm A class"); }
    
    static { System.out.println("static A"); }

}
