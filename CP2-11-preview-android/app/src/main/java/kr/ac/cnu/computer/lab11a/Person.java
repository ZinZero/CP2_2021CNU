package kr.ac.cnu.computer.lab11a;
public class Person {
    private int profile;
    private String name;
    private String mobile;

    public Person(int profile, String name, String mobile){
        this.profile = profile;
        this.name = name;
        this.mobile = mobile;
    }
    public int getProfile() { return profile;}
    public void setProfile(int profile) { this.profile = profile;}

}
