import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Zadanie_3
{
    public static void differentialNumber()
    {
        DecimalFormat numberF = new DecimalFormat("0.00000000000");
        NumberFormat percentF = NumberFormat.getPercentInstance();
        double x = 0.5;
        double Em = 2.220446049250313E-16;
        double f = Math.exp(Math.sin(2*x)); // Valor de la funcion en el punto dado.
        double fDev = 2 * Math.cos(2*x)*Math.exp(Math.sin(2*x)); // Primera derivada.
        double fDev2 = -4 * Math.exp(Math.sin(2*x)) * (Math.sin(2*x) - Math.pow(Math.cos(2*x),2)); // Segunda derivada.
        double fDev3 = 8 * Math.exp(Math.sin(2*x)) * Math.cos(2*x) * (-3*Math.sin(2*x) + Math.pow(Math.cos(2*x),2) - 1); // Tercera derivada
        double h;
        double n = 1.0;

        System.out.println("TABLE ORDER: " + "(1)h Value, " + "(2)Common Method, " + "(3)Central Method, " + "(4)Total Error Common Method, " + "(5)Total Error Central Method, " +  "(6)Relative Error Common Method, " + "(7)Relative Error Central Method.");
        do
        {
            h = Math.pow(10, -n);
            double f2 = Math.exp(Math.sin(2*(x+(h/2)))); // Valor de la funcion en x + h/2.
            double diffCommon = ((Math.exp(Math.sin(2*(x + h))) - Math.exp(Math.sin(2 * x))) / h) - (0.5*fDev2*h);
            double diffCentral = ((f2 - Math.exp(Math.sin(2*(x-(h/2) )))) / h) - ((0.041667)*fDev3*Math.pow(h,2));
            double errorDiffCommon = Math.abs(((2 * Em * f)/h) + ((h * fDev2)/2));
            double errorDiffCentral = Math.abs(((2 * Em * f2)/h) + ((Math.pow(h,2) * fDev3) /24));

            double relativeErrorCommon = Math.abs((fDev - diffCommon)/ fDev);
            double relativeErrorCentral = Math.abs((fDev - diffCentral)/ fDev);
            n++;

            System.out.println(numberF.format(h) + "\t\t\t" + numberF.format(diffCommon) + "\t\t\t" + numberF.format(diffCentral) + "\t\t\t" + numberF.format(errorDiffCommon) + "\t\t\t" + numberF.format(errorDiffCentral) + "\t\t\t" + numberF.format(relativeErrorCommon) + "\t\t\t" + numberF.format(relativeErrorCentral));
        }
        while(n <= 11);
    }
}
