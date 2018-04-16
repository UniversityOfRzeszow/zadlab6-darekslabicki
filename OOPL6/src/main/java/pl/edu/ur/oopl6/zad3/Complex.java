package pl.edu.ur.oopl6.zad3;

import java.util.Scanner;

public class Complex {

    double Re;
    double Im;

    public static double moduł(double Re, double Im) {
        return Math.sqrt(Math.pow(Re, 2) + Math.pow(Im, 2));
    }

    public static double sprzężenie(double Im) {
        Im = -Im;
        return Im;
    }

    public static double kat(double Re, double Im) {
        double cos = Re / moduł(Re, Im);
        double sin = Im / moduł(Re, Im);

        if (Math.toDegrees(Math.asin(sin)) > 0 && Math.toDegrees(Math.acos(cos)) > 0) {
            return Math.toDegrees(Math.asin(sin));
        } else if (Math.toDegrees(Math.asin(sin)) > 0 && Math.toDegrees(Math.acos(cos)) < 0) {
            return Math.toDegrees(Math.asin(sin) + (Math.PI / 2));
        } else if (Math.toDegrees(Math.asin(sin)) < 0 && Math.toDegrees(Math.acos(cos)) < 0) {
            return Math.toDegrees(Math.asin(sin) + (Math.PI * 3 / 2));
        } else {
            return Math.toDegrees(Math.asin(sin) + (Math.PI * 2));
        }
    }

    public static String naWykladnicza(double Re, double Im) {
        String s = "z1 w postaci wykladniczej: " + moduł(Re, Im) + "*e^(" + kat(Re, Im) + "*i)";
        return s;
    }

    public static String naAlgebraiczna(double moduł, double kąt) {
        String s = "z1 w postaci algebraicznej: " + (moduł * Math.cos(Math.toRadians(kąt))) + "+(" + (moduł * Math.sin(Math.toRadians(kąt))) + ")i";
        return s;
    }

    public static String dodawanieAlgRe(double Re1, double Re2, double Im1, double Im2) {
        String s = "Algebraicznie z1+z2=" + (Re1 + Re2) + "+(" + (Im1 + Im2) + ")i";
        return s;
    }

    public static double dodawanieAlgIm(double Im1, double Im2) {
        return Im1 + Im2;
    }

    public static double dodawanieWyk(double mod1, double kat1, double mod2, double kat2) {
        Math.toRadians(kat1);
        Math.toRadians(kat2);
        double x = mod1 * Math.cos(kat1) + mod2 * Math.cos(kat2);
        double y = mod1 * Math.sin(kat1) + mod2 * Math.sin(kat2);
        return kat(x, y);
    }

    public static String odejmowanieAlg(double Re1, double Im1, double Re2, double Im2) {
        String s = "Algebraicznie z1-z2=" + (Re1 - Re2) + "+(" + (Im1 - Im2) + ")i";
        return s;
    }

    public static String mnozenieAlg(double Re1, double Im1, double Re2, double Im2) {
        String s = "Algebraicznie z1*z2=" + (Re1 * Re2 - Im1 * Im2) + "+(" + (Re2 * Im1 + Re1 * Im2) + ")i";
        return s;
    }

    public static String dzielenieAlg(double Re1, double Im1, double Re2, double Im2) {
        String s = "Algebraicznie z1/z2=" + (Re1 * Re2 - Im1 * Im2) / (Math.pow(Re2, 2) + Math.pow(Im2, 2)) + "+(" + (Re1 * (-Im2) + Im1 * Re2) / (Math.pow(Re2, 2) + Math.pow(Im2, 2)) + ")i";
        return s;
    }

    public static String dzielenieWyk(double mod1, double kat1, double mod2, double kat2) {
        double mod = mod1 / mod2;
        double kat = kat1 - kat2;
        String s = "Wykladniczo z1/z2=" + mod + "*e^(" + kat + "*i)";
        return s;
    }

    public static String trzyPostacie(double Re, double Im) {
        String s = "z1 w postaci algebraicznej: " + Re + "+(" + Im + ")i\n" + naWykladnicza(Re, Im) + "\n" + "z1 w postaci trygonometrycznej: " + moduł(Re, Im) + "*(cos" + kat(Re, Im) + "+" + "i*sin" + kat(Re, Im) + ")";
        return s;
    }

    public static void main(String[] args) {
        Scanner c = new Scanner(System.in);
        System.out.println("Podaj Re1");
        double Re = c.nextDouble();
        System.out.println("Podaj Im1");
        double Im = c.nextDouble();
        /*System.out.println("Podaj Re2");
        double Re1 = c.nextDouble();
        System.out.println("Podaj Im2");
        double Im1 = c.nextDouble();
        System.out.println("Podaj modul");
        double mod = c.nextDouble();
        System.out.println("Podaj kat");
        double kat = c.nextDouble();
        */
        System.out.println(trzyPostacie(Re,Im));
    }

}
