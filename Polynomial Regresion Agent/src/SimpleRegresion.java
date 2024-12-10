import java.text.DecimalFormat;

public class SimpleRegresion {
    private double pronostico;
    private double numx;
    private int year;

    public void generarPronostico(double b1, double b0, double init, double end) {
        DecimalFormat formato = new DecimalFormat("#.##");
        System.out.println("year  (X)   (Y)");
        for (double i = init; i < end; i++) {
            numx = i;
            pronostico = b0 + b1 * numx;
            System.out.print(" " + year + "    " + numx + "    " + formato.format(pronostico));
            System.out.println("        ŷ = " + b0 + " + " + b1 + " ( " + numx + " ) ");
            year++;
        }
    }
}
