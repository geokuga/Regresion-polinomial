import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Action extends Agent {
    protected void setup() {

        DataSet dataSet = new DataSet();
        MatematicasDiscretas sumatorias = new MatematicasDiscretas();
        AlgebraLineal algebraLineal = new AlgebraLineal();
        SimpleRegresion simpleRegresion = new SimpleRegresion();
        CuadraticRegresion cuadraticRegresion = new CuadraticRegresion();
        CubicRegresion cubicRegresion = new CubicRegresion();

        double[] exogena = dataSet.exogena;
        double[] endogena = dataSet.endogena;
        double init = 80;
        double end = 90;

        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {

                //(X^TX)^-1 X^T Y
                double[][] lineal = sumatorias.generarSumatorias(exogena,1);
                double[][] cuadratica = sumatorias.generarSumatorias(exogena,2);
                double[][] cubica = sumatorias.generarSumatorias(exogena,3);

                //Lineal
                System.out.println("Lineal");
                double[][] linealT = algebraLineal.generarTranspuesta(lineal);
                lineal = AlgebraLineal.multiplicarMatrices(linealT,lineal);
                lineal = AlgebraLineal.obtenerInversa(lineal);
                lineal = AlgebraLineal.multiplicarMatrices(lineal,linealT);
                double[] coeficientes1 = AlgebraLineal.multiplicarMatrizVector(lineal,endogena);

                System.out.println("B0 = " + coeficientes1[0]);
                System.out.println("B1 = " + coeficientes1[1]);
                simpleRegresion.generarPronostico(coeficientes1[0],coeficientes1[1], init, end);


                //Cuadratica
                double[][] cuadraticaT = algebraLineal.generarTranspuesta(cuadratica);
                cuadratica = AlgebraLineal.multiplicarMatrices(cuadraticaT,cuadratica);
                cuadratica = AlgebraLineal.obtenerInversa(cuadratica);
                cuadratica = AlgebraLineal.multiplicarMatrices(cuadratica,cuadraticaT);
                double[] coeficientes2 = AlgebraLineal.multiplicarMatrizVector(cuadratica,endogena);
                System.out.println();
                System.out.println();
                System.out.println("Cuadratica");
                System.out.println("a = " + coeficientes2[0]);
                System.out.println("b = " + coeficientes2[1]);
                System.out.println("c = " + coeficientes2[2]);
                cuadraticRegresion.generarPronostico(coeficientes2, init, end);


                //Cubica
                double[][] cubicaT = algebraLineal.generarTranspuesta(cubica);
                cubica = AlgebraLineal.multiplicarMatrices(cubicaT,cubica);
                cubica = AlgebraLineal.obtenerInversa(cubica);
                cubica = AlgebraLineal.multiplicarMatrices(cubica,cubicaT);
                double[] coeficientes3 = AlgebraLineal.multiplicarMatrizVector(cubica,endogena);
                System.out.println();
                System.out.println();
                System.out.println("Cubica");
                System.out.println("a = " + coeficientes3[0]);
                System.out.println("b = " + coeficientes3[1]);
                System.out.println("c = " + coeficientes3[2]);
                System.out.println("d = " + coeficientes3[3]);
                cubicRegresion.generarPronostico(coeficientes3, init, end);
                doDelete();
            }
        });
    }

    @Override
    protected void takeDown() {
        System.out.println("C murio el agente");
    }
}
