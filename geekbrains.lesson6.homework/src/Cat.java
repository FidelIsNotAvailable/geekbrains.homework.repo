public class Cat extends Animal{
    private static double catMaxRunDistance = 200;
    //private static double catMaxSwimDistance = 0;
    private static double catMaxJumpHeight = 2;
    private static int catCount = 0;

    public Cat(String name){
        super();
        this.name = name;
        this.maxRunDistance = generateAnimalCapability(catMaxRunDistance);
        //this.maxSwimDistance = generateAnimalCapability(catMaxSwimDistance);
        this.maxJumpHeight = generateAnimalCapability(catMaxJumpHeight);
        catCount++;
    }

    public void run (double distance){
        if(this.maxRunDistance >= distance)
            System.out.println(this.getName() + " пробежал " + distance + " метров.");
        else
            System.out.println(this.getName() + " не смог пробежать " + distance + " метров.");
    }

    public void swim (double distance){
        System.out.println(this.getName() + " не хочет плавать.");
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

    public static void printCatCount(){
        System.out.println(catCount);
    }
}
