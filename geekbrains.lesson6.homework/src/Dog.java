public class Dog extends Animal {

    private static double dogMaxRunDistance = 500;
    private static double dogMaxSwimDistance = 10;
    private static double dogMaxJumpHeight = 0.5;
    private static int dogCount = 0;

    public Dog(String name){
        super();
        this.name = name;
        this.maxRunDistance = generateAnimalCapability(dogMaxRunDistance);
        this.maxSwimDistance = generateAnimalCapability(dogMaxSwimDistance);
        this.maxJumpHeight = generateAnimalCapability(dogMaxJumpHeight);
        dogCount++;
    }

    public void run (double distance){
        if(this.maxRunDistance >= distance)
            System.out.println(this.getName() + " пробежал " + distance + " метров.");
        else
            System.out.println(this.getName() + " не смог пробежать " + distance + " метров.");
    }

    public void swim (double distance){
        if(this.maxSwimDistance >= distance)
            System.out.println(this.getName() + " проплыл " + distance + " метров.");
        else
            System.out.println(this.getName() + " не смог проплыть " + distance + " метров.");
    }

    public void jump (double distance){
        if(this.maxJumpHeight >= distance)
            System.out.println(this.getName() + " прыгнул  на высоту " + distance + " метров.");
        else
            System.out.println(this.getName() + " не смог прыгнуть на высоту " + distance + " метров.");
    }

    public String getName(){
        return this.name;
    }

    public static void printDogCount(){
        System.out.println(dogCount);
    }
}
