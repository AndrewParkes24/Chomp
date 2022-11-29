import java.util.ArrayList;

public class Board {
    static int a;
    static int b;
    static int c;
    int myrow;
    int mycol;

    public Board(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c= c;
    }

    public Board(int a, int b, int c, int x, int y){
        this.a = a;
        this.b = b;
        this.c = c;
        myrow = x;
        mycol = y;
    }
}
