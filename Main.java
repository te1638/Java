import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Иванов Иван Иванович", "Инженер", "IIIwD@mail.ru", "89204344921", 30000, 59);
        persArray[1] = new Employee("Петров Пётр Петрович", "Фрезеровщик", "PPPwD@mail.ru", "89204344922", 43000, 45);
        persArray[2] = new Employee("Кочетова Татьяна Геннадьевна", "Главный бухгалтер", "KTGbuh@mail.ru", "89204344912", 40000, 39);
        persArray[3] = new Employee("Филина Ирина Евгеньевна", "Бухгалтер", "FIGbuh@mail.ru", "89204344913", 26000, 24);
        persArray[4] = new Employee("Чернов Александр Витальевич", "Генеральный директор", "CHAV@mail.ru", "89204344901", 60000, 59);


        choseWhoPrint(persArray);

    }

    public static Scanner sc = new Scanner(System.in);

    public static void choseWhoPrint(Employee[] persArray) {
        System.out.println("Эта программа выводит список сотрудников, которым больше 'n' лет" +
                "\nВведите 'n'");
        int age = sc.nextInt();
        printWhoMore(persArray, age);
    }




    public static void printWhoMore (Employee[] pers, int age){
        int i;
        System.out.println("Список сотрудников, которым больше " + age +":\n");
        for (i = 0; i < pers.length; i++){
                while (pers[i].getAge() >= age) {
                    pers[i].info();
                    break;
            }
        }
    }
}
