import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frog frog = frogByUser();
        Point[] route = route();
        aliveOrNot(frog,route);
    }

    public static Frog frogByUser(){
        System.out.print("Введите координаты лягушки и длину языка: ");
        Scanner read = new Scanner(System.in);
        int x, y, l;
        x=read.nextInt();
        y=read.nextInt();
        Point point = new Point(x,y);
        l=read.nextInt();
        return new Frog(point,l);
    }
    public static Point[] route(){
        System.out.print("Введите длину маршрута: ");
        Scanner read = new Scanner(System.in);
        int l;
        l=read.nextInt();
        Point[] route = new Point[l];
        for (int i = 0; i<l; i++)
        {
            System.out.print("Введите координаты точки: ");
            route[i] = new Point(read.nextInt(), read.nextInt());
        }
        return route;
    }
    public static void aliveOrNot(Frog frog, Point[] route){
        boolean j = true;
        for (int i = 0; i<route.length; i++){
            if (Point.calcDistance(route[i],frog.place)<= frog.tongueLength){
                System.out.println("Съели в точке "+(i+1));
                j = false;
                break;
            }
        }
        if (j) System.out.println("YES");
    }
    //TODO:
    //1 сделать функцию, которая спрашивает у пользователя координаты и длину языка и выдает в
    //  качестве результата новую Лягушку
    //2 сделать функцию, которая спрашивает у пользователя длину маршрута, затем запраивает
    //  много точек в виде пар координат
    //  результат этой функции - массив Точек
    //3 сделать функцию, которая проверяет проверяет работу вышеописанных функций
    //  и запускает проверку выживания кузнечика
}

class Point{
    int x,y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static double calcDistance(Point p1, Point p2){
        return Math.sqrt((p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
    }
}

class Frog{
    Point place;
    int tongueLength;
    public Frog() {
        this.place = new Point(0,0);
        this.tongueLength = 0;
    }

    public Frog(Point place, int tongueLength) {
        this.place = place;
        this.tongueLength = tongueLength;
    }

    public Frog(int x, int y, int len){
        place = new Point(x, y);
        tongueLength = len;
    }

}