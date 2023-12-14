import java.util.Scanner;

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите выражение в формате: ");
        System.out.print("'a' 'операция' 'b', важно поставить между числами и операцией пробел : ");
        String inp = scanner.nextLine();

        // Разделение строки на операнды и операцию
        String[] parts = inp.split(" ");
        if (parts.length != 3) { // если длина массива больше 3 элементов то выбрасывается ошибка.
            throw new IllegalArgumentException("Неправильный формат выражения");
        }
        String x = parts[0];
        String y = parts[2];
        String op = parts[1];

        solve(x, y, op);
    }


    public static void solve(String x, String y, String op){
        if(isNumber(x, y)){
            if(ifLegal (Byte.parseByte(x), Byte.parseByte(y))){
                System.out.println(ariphmetic(Byte.parseByte(x), Byte.parseByte(y), op));
            }
        }// методом isNumber проверяем числа ли это, если числа, то переводим из строки в байт,и проверям входят ли числа в диапозон от 1 до 10, если входят, то выводим на экран результат метода ariphmetic с данными числами и операндой
        else{
                 throw new IllegalArgumentException("Введены неверные значения");
                }
    }


   public static boolean isNumber(String x, String y) {
        try {
            Integer.parseInt(x);
            Integer.parseInt(y);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    public static boolean ifLegal (int x, int y){
        int[] num = {x, y};
        for (int number : num) {
            if (number < 1 || number > 10) {
                throw new IllegalArgumentException("Введите числа от 1 до 10");
            }
        }
        return true;
    }

    public static int ariphmetic (byte x, byte y,String op){
        int result;
        switch (op) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "*":
                result = x * y;
                break;
            case "/":
           /*     if (y == 0) {
                    throw new IllegalArgumentException("Деление на ноль недопустимо");
                }*/
                result = x / y;
                break;
            default: // default срабатывает если ни одно из условий не выполнено
                throw new IllegalArgumentException("Неправильная операция");
        }
        return result;
    }
}