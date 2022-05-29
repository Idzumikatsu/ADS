package HomeWorkOne;

public class Main {

    public static void main(String[] args) {
//        System.out.print(exponentiation(5, -4) + " ")
//        System.out.print(exponentiation(5, 4) + " ");
//        System.out.println(exponentiation(-5, -4));
//        System.out.println(evenExponentiation(5, 10));
//        System.out.println(summary(100));
    }

    public static double exponentiation(double num, double exp) {
        if (num == 0 || exp == 0) {
            return 0;
        } else if (num == 1 || exp == 1) {
            return num;
        } else {
            if (num < 0) {
                throw new RuntimeException(
                        "Для предсказуемого результата основание степени должно быть положительным");
            } else{
                double res = num;
                while ((exp - 1) != 0) {
                    if (exp > 0) {
                        num *= res;
                        exp--;
                    } else {
                        num *= (1.0 / res);
                        exp++;
                    }
                }
                return num;
            }
        }
    }

    public static double evenExponentiation(double num, double exp) {
        while (exp % 2 == 0) {
            exp = exp /2;
            num = exponentiation(num,2);
        }
        num = exponentiation(num, exp);
        return num;
    }

    public static int summary(int num) {
        int rep = num;
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        }
        if (num % 2 != 0) {
            num = num / 2;
            return num + (rep * num - 1);
        }
        return num + (num / 2) * (num - 1);
    }
}
