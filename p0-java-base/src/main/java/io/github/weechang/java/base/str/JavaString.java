package io.github.weechang.java.base.str;

/**
 * java String
 *
 * @author zhangwei
 * date 2018/6/7
 * time 19:34
 */
public class JavaString {

    /**
     * 创建String
     */
    public void buildString() {
        char[] chars = new char[]{'a', 'b', 'c'};
        String str = new String(chars, 1, 2);
        System.out.println(str);
        System.out.println(str.length());
    }

    /**
     * 创建方式的比较
     */
    public void createMethod() {
        String str1 = "str";
        String str2 = new String("str");
        String str3 = str1;
        String str4 = str2;
        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str2 == str4);
        System.out.println(str1 == str4);
    }

    /**
     * 字符串手工入池
     */
    public void intern(){
        String str1 = new String("str").intern();
        String str2 = "str";
        System.out.println(str1 == str2);
    }

    public void stringBuffer(){
       StringBuffer sf =  new StringBuffer();

    }

    public void stringBuilder(){
        StringBuilder sb =  new StringBuilder();

    }

    public static void main(String[] args) {
        JavaString javaString = new JavaString();
//        javaString.buildString();
//        javaString.createMethod();
        javaString.intern();
    }
}
