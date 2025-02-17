import java.text.DecimalFormat;

import static java.lang.Math.pow;

public class CubicRegresion {
    private double res;
    private double numx;

    public void generarPronostico(double[] recta, double init, double end) {
        DecimalFormat formato = new DecimalFormat("#.##");
        System.out.println(" X     Y");
        for (double i = init; i < end; i++) {
            numx = i;

            res = recta[0] + recta[1] * numx + recta[2] *  pow(numx, 2) + recta[3] * pow(numx, 3);

            System.out.print(numx + "  " + formato.format(res));
            System.out.println("       y = " + recta[0] + "  +  " + recta[1] + " ( " + numx + " )" + "  +  " + recta[2] + " ( " + pow(numx, 2) + " )" + "  +  " + recta[3] + " ( " + pow(numx, 3) + " )");
        }
    }

}
