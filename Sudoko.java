

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

        obj.Solve(ar);
        System.out.print("_____________________________\n");
        obj.Print_board(ar);
    }
        
    public void Print_board(int[][] ar) {
        
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
    
    public boolean valid(int[][] ar,int num,int row,int column){

        for (int i = 0; i < 9; i++){
            if (ar[row][i]==num && column!=i){
                return false;
            }
        }

        for (int i = 0; i < 9; i++){
            if(ar[i][row]==num && row!=i){
                return false;
            }
        }
        int box_row=row/3;
        int box_column=column/3;
        for (int i = box_row*3; i < box_row*3+3; i++) {
            for (int j = box_column*3; j <box_column*3+3; j++) {
                if(ar[i][j]==num && row!=i&&column!=j){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean Solve(int[][] ar) {
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(ar[i][j]==0){
                    int row=i;
                    int column=j;
                    for (int k = 1; k < 10; k++) {
                        ar[i][j]=k;
                        if(valid(ar, k, i, j)){
                            if(Solve(ar))
                                return true;  
                        }
                        ar[row][column]=0;
                    }
                }
            }
        }

        return true;
    }
}