package com.parkho.sqlite;

public class PhStudentEntity {

    // Cursor id
    private int mId;

    // 학년
    private int mGrade;

    // 학번
    private int mNumber;

    // 이름
    private String mStrName;

    // 나이
    private int mAge;

    PhStudentEntity(int a_id, int a_grade, int a_number, String a_strName, int a_age) {
        mId = a_id;
        mGrade = a_grade;
        mNumber = a_number;
        mStrName = a_strName;
        mAge = a_age;
    }

    public int getId() {
        return mId;
    }

    public int getGrade() {
        return mGrade;
    }

    public int getNumber() {
        return mNumber;
    }

    public String getName() {
        return mStrName;
    }

    public int getAge() {
        return mAge;
    }
}