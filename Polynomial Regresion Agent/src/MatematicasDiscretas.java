public class MatematicasDiscretas {

    public double[][] generarSumatorias(double[] exogena, int exponente) {
        double[][] matriz = new double[exogena.length][exponente + 1];

        for (int i = 0; i < exogena.length; i++) {
            for (int j = 0; j <= exponente; j++) {
                matriz[i][j] = Math.pow(exogena[i], j);
            }
        }
        return matriz;
    }

    // Método de impresión para verificar la matriz generada
    public void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double valor : fila) {
                System.out.printf("%10.4f ", valor);
            }
            System.out.println();
        }
    }
}
