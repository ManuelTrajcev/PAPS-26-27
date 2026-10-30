package AV0;

import java.io.File;
import java.nio.file.FileStore;
import java.util.Scanner;


class Student {
    private String name;
    private String lastName;
    private Integer age;
    private Boolean isInternational;

    public Student(String name, String lastName, Integer age, Boolean isInternational) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.isInternational = isInternational;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    public Boolean getInternational() {
        return isInternational;
    }

    public void setInternational(Boolean international) {
        isInternational = international;
    }

    public Integer getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Student: " +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isInternational=" + isInternational ;
    }
}

class MasterStudent extends Student {
    private String thesisTitle;

    public MasterStudent(String name, String lastName, Integer age, Boolean isInternational, String thesisTitle) {
        super(name, lastName, age, isInternational);
        this.thesisTitle = thesisTitle;
    }

    @Override
    public String toString() {
        return ", thesisTitle='" + thesisTitle + '\'';
    }
}


class PhdStudent extends MasterStudent {
    private String researchArea;

    public PhdStudent(String name, String lastName, Integer age, Boolean isInternational, String thesisTitle, String researchArea) {
        super(name, lastName, age, isInternational, thesisTitle);
        this.researchArea = researchArea;
    }

    @Override
    public String toString() {
        return super.toString() + ", researchArea='" + researchArea + '\'';
    }
}

public class ex1 {
    public static void main(String[] args) {
        Student student1 = new Student("Jack", "Smith", 20, true);
        MasterStudent masterStudent1 = new MasterStudent("John", "Doe", 25, false, "AI in Healthcare");

        student1.setAge(21);

        System.out.println(student1);
        System.out.println(masterStudent1);
    }
}
