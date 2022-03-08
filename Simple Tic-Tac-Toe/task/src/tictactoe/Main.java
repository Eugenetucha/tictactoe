package tictactoe;

import java.util.Scanner;

public class Main {
    public static void start(int[][]arr2,int current,boolean falsh) {
        if(falsh) {
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int x, y;
            if (in.hasNextInt()) {
                x = in.nextInt();
                y = in.nextInt();
                if ((x > 3 || y > 3) || (x < 1 || y < 1)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    start(arr2, current,true);
                } else {
                    if (arr2[x - 1][y - 1] == -1) {
                        if (current == 1) {
                            arr2[x - 1][y - 1] = 1;
                            enter(arr2);
                            start(arr2, 0,check(arr2,1));
                        } else {
                            arr2[x - 1][y - 1] = 0;
                            enter(arr2);
                            start(arr2, 1,check(arr2,0));
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        start(arr2, current,true);
                    }
                }
            } else {
                System.out.println("You should enter numbers!");
            }
        }
        }
        public static boolean check (int[][] arr2,int current){
            boolean a = false;
            boolean b = false;
            for (int[] ints : arr2) {
                if (ints[0] ==current && ints[1] == ints[0] && ints[2] == ints[0]) {
                    if (ints[0] == 1) {
                        a = true;
                    } else {
                        b = true;
                    }
                }
            }
            for (int i = 0; i < arr2.length; i++) {
                if (arr2[0][i] == current && arr2[1][i] == arr2[0][i] && arr2[0][i] == arr2[2][i]) {
                    if (arr2[0][i] == 1) {
                        a = true;
                    } else {
                        b = true;
                    }
                }
            }
            if (arr2[0][0] == current && arr2[1][1] == arr2[0][0] && arr2[2][2] == arr2[0][0]) {
                if (arr2[0][0] == 1) {
                    a = true;
                } else {
                    b = true;
                }
            }
            if (arr2[0][2] == current && arr2[1][1]== arr2[0][2] && arr2[0][2] == arr2[2][0]) {
                if (arr2[0][2] == 1) {
                    a = true;
                } else {
                    b = true;
                }
            }
            boolean finish = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (arr2[i][j] == -1) {
                        finish = true;
                        break;
                    }
                }
            }
            return result(a, b,finish);
        }
        public static boolean result (boolean a, boolean b,boolean finish){
            if (a) {
                System.out.println("X wins");
                return false;
            } else if (b) {
                System.out.println("O wins");
                return false;
            } else if(!finish) {
                    System.out.println("Draw");
                return false;
            }
            return true;
        }
        public static void enter ( int[][] ab){
            char[] a1 = new char[9];
            int b = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (ab[i][j] == 1) {
                        a1[b] = 'X';
                        ++b;
                    } else if (ab[i][j] == 0) {
                        a1[b] = 'O';
                        ++b;
                    }else if (ab[i][j] == -1){
                        a1[b] = ' ';
                        ++b;
                    }

                }
            }
            System.out.println("---------");
            System.out.printf("| %s %s %s | \n", a1[0], a1[1], a1[2]);
            System.out.printf("| %s %s %s | \n", a1[3], a1[4], a1[5]);
            System.out.printf("| %s %s %s | \n", a1[6], a1[7], a1[8]);
            System.out.println("---------");
        }
        public static void main (String[]args){
            int[][] arr2 = new int[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    arr2[i][j] = -1;
                }
            }
            System.out.println("---------");
            System.out.print("|       | \n");
            System.out.print("|       | \n");
            System.out.print("|       | \n");
            System.out.println("---------");
            start(arr2, 1,true);
        }
}
