package io.github.weechang.java.base.obj;

/**
 * @author zhangwei
 * date 2018/6/7
 * time 15:42
 */
public class User {

    private Long id;
    private String name;
    private Integer age;

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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User){
            if (id.equals(((User) obj).id)
                    && name.equals(((User) obj).name)
                    && age.equals(((User) obj).age)){
                return true;
            }
        }
        return false;
    }
}
