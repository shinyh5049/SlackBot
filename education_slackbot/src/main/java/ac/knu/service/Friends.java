package ac.knu.service;

public class Friends {
    String name, sex;
    int age;
    public Friends (String n, String s, int a) {
        name = n;
        sex = s;
        age = a;
    }
    public String getName() {
        return name;
    }
    public String getSex() {
        return sex;
    }
    public int getAge() {
        return age;
    }
}
