package io.github.weechang.java.base.obj;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * java 之 Object
 *
 * @author zhangwei
 * date 2018/6/7
 * time 14:53
 */
public class JavaObject {

    /**
     * getClass方法
     * <p>
     * 返回此Object的运行时类类型。
     * 不可重写，要调用的话，一般和getName()联合使用，如getClass().getName();
     */
    public void getClassMethod() {
        Class clazz = this.getClass();
        System.out.println("class:" + clazz);
        String className = clazz.getName();
        System.out.println("className:" + className);
    }

    /**
     * hashCode方法
     * <p>
     * 返回该对象的哈希值
     */
    public void hashCodeMethod() {
        int hashCode = this.hashCode();
        System.out.println("hashCode:" + hashCode);

        // user
        User u1 = new User();
        u1.setId(1L);
        u1.setName("name");
        u1.setAge(1);

        User u2 = new User();
        u2.setId(1L);
        u2.setName("name");
        u2.setAge(1);

        System.out.println("User u1.hashCode:" + u1.hashCode());
        System.out.println("User u2.hashCode:" + u2.hashCode());
        System.out.println("User u1.equals(u2):" + u1.equals(u2));
        Set<User> userHashSet = new HashSet<User>();
        userHashSet.add(u1);
        userHashSet.add(u2);
        System.out.println("User hashSet size:" + userHashSet.size());

        // UserHashCode
        UserHashCode uh1 = new UserHashCode();
        uh1.setId(1L);
        uh1.setName("name");
        uh1.setAge(1);

        UserHashCode uh2 = new UserHashCode();
        uh2.setId(1L);
        uh2.setName("name");
        uh2.setAge(1);

        System.out.println("UserHashCode uo1.hashCode:" + uh1.hashCode());
        System.out.println("UserHashCode uo2.hashCode:" + uh2.hashCode());
        System.out.println("UserHashCode uo1.equals(uo2):" + uh1.equals(uh2));
        Set<UserHashCode> userHashCodeHashSet = new HashSet<UserHashCode>();
        userHashCodeHashSet.add(uh1);
        userHashCodeHashSet.add(uh2);
        System.out.println("UserHashCode hashSet size:" + userHashCodeHashSet.size());

        // UserAll
        UserAll uo1 = new UserAll();
        uo1.setId(1L);
        uo1.setName("name");
        uo1.setAge(1);

        UserAll uo2 = new UserAll();
        uo2.setId(1L);
        uo2.setName("name");
        uo2.setAge(1);

        System.out.println("UserAll uo1.hashCode:" + uo1.hashCode());
        System.out.println("UserAll uo2.hashCode:" + uo2.hashCode());
        System.out.println("UserAll uo1.equals(uo2):" + uo1.equals(uo2));
        Set<UserAll> userAllHashSet = new HashSet<UserAll>();
        userAllHashSet.add(uo1);
        userAllHashSet.add(uo2);
        System.out.println("UserAll hashSet size:" + userAllHashSet.size());

    }

    /**
     * clone 方法
     *
     * 实现对象的浅复制
     */
    public void cloneMethod() throws CloneNotSupportedException {
        Date birthDay1 = new Date(1);
        Phone phone1 = new Phone("123");

        UserClone uc1 = new UserClone();
        uc1.setId(1L);
        uc1.setName("name");
        uc1.setAge(1);
        uc1.setBirthDay(birthDay1);
        uc1.setPhone(phone1);

        UserClone uc2 = (UserClone) uc1.clone();
        Date birthDay2 = uc2.getBirthDay();
        Phone phone2 = uc2.getPhone();

        birthDay2.setTime(1000000000);
        phone2.setPhoneNumber("456");
        uc2.setBirthDay(birthDay2);
        uc2.setPhone(phone2);

        System.out.println("uc1.birthday:" + uc1.getBirthDay());
        System.out.println("uc2.birthday:" + uc2.getBirthDay());

        System.out.println("uc1.phone:" + uc1.getPhone().getPhoneNumber());
        System.out.println("uc2.phone:" + uc2.getPhone().getPhoneNumber());

        System.out.println(uc2.equals(uc1));
    }

    public void toStringMethod(){
        User user = new User();
        System.out.println(user.toString());
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        JavaObject javaObject = new JavaObject();
//        javaObject.getClassMethod();
//        javaObject.hashCodeMethod();
//        javaObject.cloneMethod();
        javaObject.toStringMethod();
    }
}
