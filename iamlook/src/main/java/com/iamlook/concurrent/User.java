package com.iamlook.concurrent;

/**
 * @program: notes
 * @description:
 * @author: Created by youxun
 * @create: 2019-02-22 11:37
 **/
public class User {
    static
    {
        i=0;
      System.out.println("AAAAAAAAAAAAAAAAAAAA:");
    }
    static int i=1;

    private String name;

    private Integer age;

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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age != other.age)
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}
