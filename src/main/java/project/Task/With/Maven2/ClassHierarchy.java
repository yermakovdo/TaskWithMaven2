package project.Task.With.Maven2;

import java.util.ArrayList;

import java.util.Scanner;

public class ClassHierarchy {

    public static class Shape{
        double volume;
        public Shape(double volume) {
            this.volume = volume;
        }
        public double getVolume() {
            return volume;
        }
    }

    public static class SolidOfRevolution extends Shape{
        double radius;
        public SolidOfRevolution(double volume, double radius){
            super(volume);
            this.radius = radius;
        }
        public double getRadius() {
            return radius;
        }
    }

    public static class Cylinder extends SolidOfRevolution{
        double height;
        public Cylinder(double radius, double height){
            super(Math.PI*radius*radius*height,radius); // π*r^2*h
            this.height = height;
        }
    }

    public static class Ball extends SolidOfRevolution{
        public Ball(double radius){
            super(Math.PI*Math.pow(radius,3)*4/3,radius); // 4/3*π*r^3
        }
    }

    public static class Pyramid extends Shape{
        double height;
        double s;
        public Pyramid(double height, double s){
            super(height * s * 4 / 3); // 1/3*s*h
            this.height = height;
            this.s = s;
        }
    }

    public static class Box extends Shape{
        ArrayList<Shape> shapes = new ArrayList<>();
        private double available;

        public Box(double available){
            super(available);
            this.available = available;
        }

        public boolean add(Shape shape){
            if (available >= shape.getVolume()){
                shapes.add(shape);
                available = available - shape.getVolume();
                return true;
            } else{
                return false;
            }
        }
    }

    public static class Main{
        public void main(String[] args){
            Scanner input = new Scanner(System.in);
            int a = input.nextInt();
            int b = input.nextInt();
            int c = input.nextInt();
            int d = input.nextInt();
            int e = input.nextInt();
            int f = input.nextInt();
            Cylinder cylinder = new Cylinder(a,b);
            Ball ball = new Ball(c);
            Pyramid pyramid = new Pyramid(d,e);
            Box box = new Box(f);
            System.out.println(box.add(ball));
            System.out.println(box.add(cylinder));
            System.out.println(box.add(pyramid));
        }
    }
}
