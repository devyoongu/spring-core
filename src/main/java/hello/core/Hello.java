package hello.core;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Hello {

    private String name;
    private int age;

    public static void main(String[] args) {
        Hello hello = new Hello();
        hello.setName("lombok");// lombok 라이브러리로 setter 가 없어도 자동 생성되어 사용할 수 있다.
        String name = hello.getName();
        System.out.println("name = " + name);

        hello.setAge(111);
        int age = hello.getAge();
        System.out.println("age = " + age);
    }

}
