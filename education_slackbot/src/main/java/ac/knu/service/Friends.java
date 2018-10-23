package ac.knu.service;

public class Friends {
    String name;
    Gender gender;
    int age;
    public Friends (String n, Gender g, int a) {
        name = n;
        gender = g;
        age = a;
    }
    public String getName() {
        return name;
    }
    public Gender getGender() {
        return gender;
    }
    public int getAge() {
        return age;
    }
}
