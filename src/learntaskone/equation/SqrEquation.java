package learntaskone.equation;



public class SqrEquation {

    //массив, содержащий коэффициенты соответствующие c0*x^2 + c1*x + c2 = 0
    private final double[] coef;

    // Конструктор принимает массив коэффициентов. Если длина массива меньше чем 3, считаем,
    // что неуказанные коэффициенты = 0. Если длина больше 3 или коэффициент при x^2 = 0 - ошибка
    SqrEquation(double[] arr){
        coef = new double[3];

        if( arr.length == 0 || arr[0] == 0){
            System.out.println("Error. Not quadratic equation.");
            System.exit(-1);
        }

        if(arr. length > 3) {
            System.out.println("Error. Too much coefficients. 3 or less required.");
            System.exit(-1);
        }

        System.arraycopy(arr, 0, coef, 0, arr.length);
    }

    //Просто геттер...
    public double[] getCoef() {
        return coef;
    }

    // Метод, решающий квадратное уравнение. В конце печатает решения.
    public void solve(){
        // Вложенный класс, который считающий и хранит дискриминант.
        class Discriminant{
            private final double dis;

            public double getDis(){
                return dis;
            }

            Discriminant(){
                dis = Math.pow(getCoef()[1], 2) - 4 * getCoef()[0] * getCoef()[2];
            }


        }

        Discriminant d = new Discriminant();

        // Смотрим, сколько корней, ниходим их и печатаем.
        if(d.getDis() < 0){
            printRoots();
        }
        else if (d.getDis() == 0)
            printRoots(-1 * coef[1] / (2*coef[0]));
        else
            printRoots((-1 * coef[1] - Math.sqrt(d.getDis())) / (2*coef[0]), (-1 * coef[1] + Math.sqrt(d.getDis())) / (2*coef[0]));
    }

    // Печатает, что нет корней. Вызывается, если дискриминант меньше 0
    private void printRoots(){
        System.out.println("No roots");
    }

    // Печатает корень. Вызывается, если дискриминант = 0.
    private void printRoots(double x1){
        System.out.println("One root: x = " + x1);
    }

    // Печатает корни.
    private void printRoots(double x1, double x2){
        System.out.println("Two roots: x1 = " + x1 + "\tx2 = " + x2);
    }

}
