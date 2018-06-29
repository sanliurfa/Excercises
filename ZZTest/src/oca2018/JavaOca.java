package oca2018;

public class JavaOca {
    
    private int eindresultaat = 30;
    private static boolean geslaagd;
    
    public JavaOca() {
        super();
    }

    public static void main(String[] args) {
        JavaOca javaOca = new JavaOca();
        javaOca.oefenen(40);
    }
    
    public void oefenen(int eindresultaat) {
        while (!geslaagd) {
            this.eindresultaat += 5;
            if (eindresultaat >= 65) {
                geslaagd = true;
                System.out.println("Je bent geslaagd!!");
            }
            else {
                System.out.println("Nog even blijven oefenen..");
            }
        }
    }
}
