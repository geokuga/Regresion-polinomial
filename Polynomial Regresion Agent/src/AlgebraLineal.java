public class AlgebraLineal  extends DataSet{
    protected double[][] matriz;

    public double[][] generarTranspuesta(double[][] exogena) {
        matriz = new double[exogena[0].length][exogena.length];

        for (int i = 0; i < exogena.length; i++) {
            for (int j = 0; j < exogena[0].length; j++) {
                matriz[j][i] = exogena[i][j];
            }
        }
        return matriz;
    }


    public static double[][] multiplicarMatrices(double[][] exogena, double[][] exogenaT) {
        double[][] matriz = new double[exogena.length][exogenaT[0].length];

        for (int i = 0; i < exogena.length; i++) {
            for (int j = 0; j < exogenaT[0].length; j++) {
                double sum = 0.0;
                for (int k = 0; k < exogena[0].length; k++) {
                    sum += exogena[i][k] * exogenaT[k][j];
                }
                matriz[i][j] = sum;
            }
        }
        return matriz;
    }

    public static double[] multiplicarMatrizVector(double[][] exogena, double[] endogena) {

        double[] vector = new double[exogena.length];

        for (int i = 0; i <  exogena.length; i++) {
            double suma = 0.0;
            for (int j = 0; j < exogena[0].length; j++) {
                suma += exogena[i][j] * endogena[j];
            }
            vector[i] = suma;
        }
        return vector;
    }


    public static double[][] obtenerInversa(double[][] matriz) {
        int n = matriz.length;
        double[][] augmentada = new double[n][2 * n];

        // Crear la matriz aumentada [matriz | identidad]
        for (int i = 0; i < n; i++) {
            System.arraycopy(matriz[i], 0, augmentada[i], 0, n);
            augmentada[i][i + n] = 1.0;
        }

        // Aplicar Gauss-Jordan
        for (int i = 0; i < n; i++) {
            // Escalar la fila actual al pivote
            double pivot = augmentada[i][i];
            for (int j = 0; j < 2 * n; j++) {
                augmentada[i][j] /= pivot;
            }

            // Eliminación hacia abajo y hacia arriba
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = augmentada[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        augmentada[k][j] -= factor * augmentada[i][j];
                    }
                }
            }
        }

        // Extraer la matriz inversa
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(augmentada[i], n, inversa[i], 0, n);
        }

        return inversa;
    }

}


