public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    // Вывод в консоль
    public void printEmployeeData(){
        System.out.println("Данные по сотруднику. Имя - " + this.name + ", должность - " + this.position + ", контактные данные - "
                + this.email + " " + this.phoneNumber + ", зарплата -" + this.salary + ", возраст - " + this.age + ".");
    }

    // Получить возраст для условия
    public int getEmployeeAge() {
        return this.age;
    }
}
