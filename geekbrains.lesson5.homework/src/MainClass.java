public class MainClass {
    public static void main(String[] args) {

        Employee[] arr = {new Employee("Ivan", "Economist1", "ivan@mail.com", "88005353535", 35000, 25),
                new Employee("Oleg", "Economist2", "oleg@mail.com", "88005353535", 45000, 26),
                new Employee("Igor", "Economist3", "igor@mail.com", "88005353535", 25000, 27),
                new Employee("Olga", "Economist4", "olga@mail.com", "88005353535", 15000, 28),
                new Employee("Roman", "Economist5", "roman@mail.com", "88005353535", 5000, 41)};

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].getEmployeeAge() > 40)
                arr[i].printEmployeeData();
        }
    }
}
