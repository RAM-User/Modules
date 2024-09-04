package com.chapter14;

import com.Entity.chapter14.Circle;
import com.Entity.chapter14.Shape;
import com.Entity.chapter14.Square;
import com.Entity.chapter14.Triangle;

import java.util.Arrays;
import java.util.List;

public class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square(), new Triangle());

        for (Shape shape : shapeList) {
            shape.draw();
        }
    }


}


