//Sudoko game
//import java.util.*;


public class Sudoko{

    public static void main(String[] args) {

        Sudoko obj = new Sudoko();
        int[][] ar ={{5,3,0,0,7,0,0,0,0},
                     {6,0,0,1,9,5,0,0,0},
                     {0,9,8,0,0,0,0,6,0},
                     {8,0,0,0,6,0,0,0,3},
                     {4,0,0,8,0,3,0,0,1},
                     {7,0,0,0,2,0,0,0,6},
                     {0,6,0,0,0,0,2,8,0},
                     {0,0,0,4,1,9,0,0,5},
                     {0,0,0,0,8,0,0,7,9}};
        
        obj.Print_board(ar);
        obj.Find_zero(ar);
        obj.Print_board(ar);
    }
    int n=0;
    int k=0,u=0;
    int value=0;
    int[] pos ;
    boolean tf;
    public void Print_board(int[][] ar){
        
        for (int i=0;i<9;i++) {
            if (i==0) {
                System.out.print("|-------+-------+-------|\n");
            }
            for (int j = 0; j < 9 ; j++) {
                if(j==0 )
                    System.out.print("| ");
                System.out.print(ar[i][j]+" ");
                if ((j+1)%3==0 )
                    System.out.print("| ");
            }
            System.out.print("\n");
            if ((i+1)%3==0 )
                System.out.print("|-------+-------+-------|\n");
        }
    }

    public void Find_zero(int[][] ar){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(ar[i][j]==0){
                    pos[n]=i;
                    pos[n+1]=j;
                    k=i;
                    u=j;
                    Valid(ar, 1);
                }
            }
        }
    }

    public void Valid(int[][] ar,int value){

        //Check among the row
        for (int i = 0; i < 9; i++) {
            if(ar[pos[n]][i]==value)
                tf = false;
            else
                tf=true;
        }

        //To check among the column
        for (int i = 0; i < 9; i++) {
            if(ar[i][pos[n+1]]==value)
                tf = false;
            else
                tf=true;
        }

        //to check among the box
        int box_row=pos[n]/3;
        int box_column=pos[n+1]/3;

        for (int i = box_row*3 ; i < box_row+2; i++) 
            for (int j = box_column*3 ; j < box_column+2; j++) 
                if(ar[i][j]==value)
                    tf=false;
                else
                    tf=true;
        
        if(tf){
            n=n+2;
            Solve(ar, k, u, value);
        }
    }

    public void Solve(int[][] ar,int k,int u,int value){

        if(tf){
            ar[k][u]=value;
            value=0;
        }
        else{
            if(value<9)
                value++;
            else{
                k=pos[n-2];
                u=pos[n-3];
                value=ar[k][u];
                ar[k][u]=0;
                Solve(ar, k, u, value);
            }
        }
        Find_zero(ar);
        
    }
}