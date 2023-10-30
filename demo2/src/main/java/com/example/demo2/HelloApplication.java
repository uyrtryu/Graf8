package com.example.demo2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.canvas.GraphicsContext;

import java.io.IOException;

public class HelloApplication extends Application {

    public static void triacle(GraphicsContext gc, MyVector a, MyVector b, MyVector c){
//        Line drawEllipse = new Line();
        Line.DDALine( (int)a.x, (int)a.y, (int)b.x, (int)b.y, gc);
        Line.DDALine( (int)b.x, (int)b.y, (int)c.x, (int)c.y, gc);
        Line.DDALine( (int)a.x, (int)a.y, (int)c.x, (int)c.y, gc);

    }
    @Override
    public void start(Stage stage) throws IOException {
        int width = 1000; // Ширина холста
        int height = 600; // Высота холста
        int a = 300; // Большая полуось
        int b = 150; // Малая полуось


        Canvas canvas = new Canvas(width, height);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        MyVector A = new MyVector(100, 100, 0);
        MyVector B = new MyVector(350, 400, 0);
        MyVector C = new MyVector( 350, 200, 0);





        triacle(gc,A,B,C);

//        drawEllipse.DDALine( 100, 50, 200, 300, gc);

        Group root = new Group(canvas);
        Scene scene = new Scene(root, width, height);
        InterpolationTriacle.interpol(gc, A, B, C);

        stage.setTitle("Rasterization + interpolation ellipse");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}