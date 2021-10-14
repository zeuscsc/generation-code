package com.zeuschiu.types;

import java.util.Calendar;

public class UserProfile {
    public static UserProfile Instant=new UserProfile();
    public String name;
    public int age;
    public String gender;
    private String nationality;
    private char bloodType;
    public UserProfile(){
        name="Zeus Chiu";
        age=33;
        gender="Male";
        nationality="Hong Kong";
        bloodType='A';
    }
    public static void main(String[] args) {
        UserProfile profile=UserProfile.Instant;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int birthYear=year-profile.age;
        System.out.println("Birth Year: "+birthYear);
    }
}
