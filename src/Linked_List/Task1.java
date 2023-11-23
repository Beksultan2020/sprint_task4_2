package Linked_List;

import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer>arrayList=new ArrayList<>();
        int n=scanner.nextInt();
        int m=scanner.nextInt();
        int[][] arr=new int[n][m];
        int row=0;
        int column=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j]=scanner.nextInt();
            }
        }

        for(int i=0; i<n; i++){
                for (int j = 0; j < m; j++) {
                    if(arr[i][j]==0){
                        arr[i][j]=0;
                        arr[i+1][j]=0;
                    }
                    System.out.print(arr[i][j]+" ");
                }

        }

    }
}
