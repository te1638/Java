public class Employee {
    private String name;
    private String occupancy;
    private String email;
    private String phoneNumber;
    private int wages;
    private int age;

    public Employee(String name,String occupancy, String email, String phoneNumber, int wages, int age) {
        this.name = name;
        this.occupancy = occupancy;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.wages = wages;
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void info(){
        System.out.println(String.format(" Имя сотрудника: %s;\n Должность: %s;\n E-mail: %s;\n Номер телефона: %s;\n Зарплата: %s;\n Возраст: %s\n",
        name, occupancy, email, phoneNumber, wages, age));
    }
}
