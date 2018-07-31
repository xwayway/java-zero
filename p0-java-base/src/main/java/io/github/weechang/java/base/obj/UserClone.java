package io.github.weechang.java.base.obj;


import java.util.Date;

/**
 * @author zhangwei
 * date 2018/6/7
 * time 16:25
 */
public class UserClone implements Cloneable{

    private Long id;
    private String name;
    private Integer age;
    private Date birthDay;
    private Phone phone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        return id.hashCode() + name.hashCode() + age.hashCode()  + birthDay.hashCode() + phone.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserClone){
            if (id.equals(((UserClone) obj).id)
                    && name.equals(((UserClone) obj).name)
                    && age.equals(((UserClone) obj).age)
                    && birthDay.equals(((UserClone) obj).birthDay)
                    && phone.equals(((UserClone) obj).phone)){
                return true;
            }
        }
        return false;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserClone cloned = (UserClone) super.clone();
        cloned.birthDay = (Date) birthDay.clone();
        return cloned;
    }
}
