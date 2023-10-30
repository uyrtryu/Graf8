package com.example.demo2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.util.Vector;

import static com.example.demo2.Line.plotEllipsePoints;

public class InterpolationTriacle {

    public static boolean sito(float a){
        return a >= 0;
    }

    public static MyVector berecentric (MyVector ab, MyVector ac, MyVector ap){
        float det = ab.x * ac.y - ab.y * ac.x;

        float v = (ap.x * ac.y - ap.y * ac.x)/det;
        float w = (ab.x * ap.y - ab.y * ap.x)/det;
        float u = 1.0f - v - w;

        return new MyVector(u,v,w);

    }
    
    public static void interpol(GraphicsContext gc,MyVector a, MyVector b, MyVector c){

        if(a.y == b.y && b.y == c.y) {return;}

        MyVector ab = MyVector.sub(b,a);

        MyVector ac = MyVector.sub(c,a);

        Color l = Color.RED;
        MyVector p;

        int minx = Math.min((int)a.x, Math.min((int)b.x,(int)c.x));
        int miny = Math.min((int)a.y, Math.min((int)b.y,(int)c.y));
        int maxx = Math.max((int)a.x, Math.max((int)b.x,(int)c.x));
        int maxy = Math.max((int)a.y, Math.max((int)b.y,(int)c.y));

        for (int y = miny; y < maxy; y++){
            for(int x = minx; x < maxx; x++){

                p = new MyVector(x,y,0);
                MyVector ap = MyVector.sub(p,a);
                MyVector nwe = berecentric(ab,ac,ap);
                System.out.println(nwe.x +" " + nwe.y + " " + nwe.z);

                if(sito(nwe.x) && sito(nwe.y) && sito(nwe.z)){
                    
                plotEllipsePoints( x , y ,gc, l);}
                    }
                }
            }

        }

