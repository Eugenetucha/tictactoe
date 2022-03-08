import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int a1 = --a;
        int b = scanner.nextInt();
        int b1 = --b;
        int c = scanner.nextInt();
        int c1 = --c;
        int d = scanner.nextInt();
        int d1 = --d;
        System.out.println(String.format("%s %s %s %s", a1, b1, c1, d1));

    }
}