package com.example.demo2;

public class MyVector {
    float x, y, z;


    public MyVector(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static MyVector sub(MyVector a, MyVector b){
        return new MyVector(a.x - b.x, a.y - b.y, 0);
    }
}
