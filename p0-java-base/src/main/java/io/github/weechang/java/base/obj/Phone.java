package io.github.weechang.java.base.obj;

/**
 * @author zhangwei
 * date 2018/6/7
 * time 16:56
 */
public class Phone implements Cloneable{

    private String phoneNumber;

    public Phone(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public int hashCode() {
        return phoneNumber.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Phone){
            if (phoneNumber.equals(((Phone) obj).phoneNumber)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
