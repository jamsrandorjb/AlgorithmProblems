package hackerrank;

/**
 * problem url: https://www.hackerrank.com/challenges/java-singleton/problem
 * hackerrank profile url:  https://www.hackerrank.com/jamsrandorjb?hr_r=1
 * solved by jama
 */



import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class SingletonPattern{
    private volatile static SingletonPattern instance;
    public static String str;
    private SingletonPattern() {}
    
    static SingletonPattern getSingleInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                if (instance == null) {
                    instance = new SingletonPattern();
                }
            }
        }
        return instance;
    }
    
}