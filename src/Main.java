import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] a = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        Matrix matrix = new Matrix(n, a);
        System.out.println(matrix.getDeterminant());

    }

    static class Matrix{

        private int[][] a;
        private int size;

        Matrix(int n, int[][] a){
            this.a = a;
            this.size = n;
        }

        int getDeterminant(){
            return getDeterminant(a, size);
        }

        private int getDeterminant(int[][] a, int size){
            if(size == 2){
                return (a[0][0] * a[1][1]) - (a[1][0] * a[0][1]);
            }

            int result = 0;

            for(int i = 0; i < size; i++){
                result += Math.pow(-1, i) * a[0][i] * getDeterminant(
                        getNewA(a, size, 0, i), size-1
                );
            }

            return result;
        }

        private int[][] getNewA(int[][] a, int size, int n, int m){
            int[][] result = new int[size-1][size-1];
            for(int x = 0, xx = -1; x < size; x++){
                if(x == n)
                    continue;
                xx++;
                for(int y = 0, yy = -1; y < size; y++){
                    if(y == m)
                        continue;
                    yy++;
                    result[xx][yy] = a[x][y];
                }
            }
            return result;
        }
    }

}
