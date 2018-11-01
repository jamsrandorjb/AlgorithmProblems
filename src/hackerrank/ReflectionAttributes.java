package hackerrank;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

/**
 * problem url: https://www.hackerrank.com/challenges/java-reflection-attributes/problem
 * solved by jama
 */

class Student{
    private String name;
    private String id;
    private String email;

    public String getName() {
        return name;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void anothermethod(){  }
    
}

public class ReflectionAttributes {

    public static void main(String[] args){
        Student student = new Student();
        Class s = student.getClass();
        Method[] methods = s.getDeclaredMethods();
        //Method myMethod;
        //myMethod = myTarget.getDeclaredMethod("getValue");  // Works!
        //System.out.println("Method Name: " + myMethod.toString());
        
        ArrayList<String> methodList = new ArrayList<>();
        for(Method a : methods){
            methodList.add(a.getName());
        }
        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }

}
