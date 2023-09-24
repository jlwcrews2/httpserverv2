package no.jlwcrews;

public class Main {
    public static void main(String[] args) {
        try {
            new MathServer().start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}