import java.lang.reflect.Constructor;
import java.util.ArrayList;

public class Main {
    ArrayList<Board> Losing = new ArrayList<>();
    ArrayList<Board> Winning = new ArrayList<>();

    public static void main(String[] args) {
        Main ex = new Main();
    }

    public Main(){
        Losing.add(new Board(1,0,0));
        int pBoardNum = 0;
        for(int x=0; x<=3; x++) {
            for (int y=0; y<=x; y++) {
                for (int z=0; z<=y; z++) {
                    if (x==0 && y==0 && z==0) {
                        continue;
                    }
                    pBoardNum++;
                    System.out.println("Possible Board Number " + pBoardNum);
                    System.out.println(x + "," + y + "," + z);
                    reducer(x, y, z);
                    //Create all the boards and run them through the reducer
                }
            }
        }
    }


    public void reducer(int x, int y, int z) {
        Losing.add(new Board(1,0,0));
        System.out.println("Reduced Boards: ");
        int i=x, j=y, k=z;
        boolean isLosing = false;
        while (k>0){
            k--;
            if(i==0 && j==0 && k==0){
                System.out.println("game over");
                break;
            }
            for (Board board : Losing) {
                isLosing = false;
                if (i == board.a && j == board.b && k == board.c) {
                    Winning.add(new Board(x, y, z));
                    isLosing = true;
                }
            }
            if(!isLosing){
                Losing.add(new Board(x,y,z));
            }
            System.out.println(i+","+j+","+k);
        }

        k=z;
        while(j>0){
            j--;
            if(j<k) {
                k = j;
            }else if(i==0 && j==0 && k==0){
                System.out.println("game over");
                break;
            }
            for (Board board : Losing) {
                if (i == board.a && j == board.b && k == board.c) {
                    Winning.add(new Board(x,y,z));
                    isLosing = true;
                }
            }
            if(!isLosing){
                Losing.add(new Board(x,y,z));
            }
            System.out.println(i+","+j+","+k);
        }
        j=y;
        k=z;
        isLosing=false;
        while (i>0){
            i--;
            if (i < j && i < k) {
                j = i;
                k = i;
            } else if (i < j) {
                j = i;
            } else if (i < k) {
                k = i;
            } if(i==0 && j==0 && k==0){
                break;
            }
            for (Board board : Losing) {
                if (x == board.a && y == board.b && z == board.c) {
                    Winning.add(new Board(x,y,z));
                    isLosing = true;
                }
            }
            if(!isLosing){
                Losing.add(new Board(x,y,z));
            }
            System.out.println(i+","+j+","+k);
            //Prints reduced boards and adds them to an arraylist of winning or
            // losing working from downwards up
        }

        System.out.println("Is losing?");
        if (isLosing){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
    //AB.ADD(new Board(x,y,z,r,c);
}

