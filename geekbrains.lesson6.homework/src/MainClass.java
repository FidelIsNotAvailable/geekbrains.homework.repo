public class MainClass {

    public static void main(String[] args) {

            //Для практики сделал и через массив, как в прошлом уроке и путем ручного создания экземпляров классов.
            //Dog dog1 = new Dog("Рекс");
            //Dog dog2 = new Dog("Бродяга");
            //Horse horse1 = new Horse("Инцитат");
            //Horse horse2 = new Horse("Буцефал");
            Animal[] arr = {new Dog("Рекс"), new Dog("Бродяга"), new Horse("Инцитат"), new Horse("Буцефал")};
            Bird bird1 = new Bird("Яго");
            Bird bird2 = new Bird("Кеша");
            Cat cat1 = new Cat("Том");
            Cat cat2 = new Cat("Просто кот");

            //Проверка работоспособности счетчиков
            Animal.printAnimalCount();
            Dog.printDogCount();
            Horse.printHorseCount();
            Bird.printBirdCount();
            Cat.printCatCount();

            for(Animal i: arr){
                    i.run(500);
                    i.swim(50);
                    i.jump(0.5);
            }
//            dog1.run(100);
//            dog2.run(500);
//
//            dog1.swim(10);
//            dog2.swim(1);
//
//            dog1.jump(0.1);
//            dog2.jump(0.2);
//
//            horse1.run(1000);
//            horse2.run(750);
//
//            horse1.swim(100);
//            horse2.swim(50);
//
//            horse1.jump(1);
//            horse2.jump(2);

            bird1.run(5);
            bird2.run(10);

            bird1.swim(10);
            bird2.swim(5);

            bird1.jump(0.1);
            bird2.jump(0.2);

            cat1.run(100);
            cat2.run(200);

            cat1.swim(5);
            cat2.swim(2);

            cat1.jump(0.1);
            cat2.jump(0.2);
    }
}
