package lop.matrix;

import java.util.*;

public class Matrix {
    int n, m, matrix[][];

    public Matrix (int n, int m) {
        this.n = n;
        this.m = m;
    }

    public Matrix (int n, int m, int matrix[][]) {
        this.n = n;
        this.m = m;
        this.matrix=matrix;
    }

    public Matrix () {
    }

    public void nhapMatrix () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("nhap so hang: ");
        n = scanner.nextInt();
        System.out.print("nhap so cot: ");
        m = scanner.nextInt();
        matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("phanTu[" + i + "," + j + "]=");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public void xuatMatrix () {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println("");
        }
    }

    public static Matrix tongHaiMatrix (Matrix matrix1, Matrix matrix2) {
        Matrix tong = new Matrix(matrix1.n, matrix1.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix1.m; j++) {
                tong.matrix[i][j] = matrix1.matrix[i][j] + matrix2.matrix[i][j];
            }
        }
        return tong;
    }

    public static Matrix nhanMatrixVoiMotSo (int x, Matrix matrix) {
        for (int i = 0; i < matrix.n; i++) {
            for (int j = 0; j < matrix.m; j++) {
                matrix.matrix[i][j] *= x;
            }
        }
        return matrix;
    }

    public static Matrix hieuHaiMatrix (Matrix matrix1, Matrix matrix2) {
        Matrix hieu = tongHaiMatrix(matrix1, nhanMatrixVoiMotSo(- 1, matrix2));
        return hieu;
    }

    public static Matrix nhanHaiMatrix (Matrix matrix1, Matrix matrix2) {
        Matrix tich = new Matrix(matrix1.n, matrix2.m);
        for (int i = 0; i < matrix1.n; i++) {
            for (int j = 0; j < matrix2.m; j++) {
                tich.matrix[i][j] = 0;
                for (int k = 0; k < matrix1.m; k++) {
                    tich.matrix[i][j] += matrix1.matrix[i][k] * matrix2.matrix[k][j];
                }
            }
        }
        return tich;
    }

    public static void main (String[] args) {
        Matrix matrix1=new Matrix();
        Matrix matrix2=new Matrix();
        System.out.println("Nhap matrix1:");
        matrix1.nhapMatrix();
        System.out.println("Nhap matrix2:");
        matrix2.nhapMatrix();
        if(matrix1.m != matrix2.m||matrix1.n!= matrix2.n){
            System.out.println("Hai matrix khong cung co!");
        }
        else {
            System.out.println("Tong hai ma tran: "+tongHaiMatrix(matrix1,matrix2));
            System.out.println("Hieu hai ma tran: "+hieuHaiMatrix(matrix1,matrix2));
        }
        if(matrix1.m!= matrix2.n) System.out.println("Khong the nhan hai matrix!");
        else System.out.println("Tich hai matrix: "+nhanHaiMatrix(matrix1,matrix2));
    }
}
