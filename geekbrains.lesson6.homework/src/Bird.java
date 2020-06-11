public class Bird extends Animal{
    private static double birdMaxRunDistance = 5;
    //private static double birdMaxSwimDistance = 0;
    private static double birdMaxJumpHeight = 0.1;
    private static int birdCount = 0;

    public Bird(String name){
        super();
        this.name = name;
        this.maxRunDistance = generateAnimalCapability(birdMaxRunDistance);
        //this.maxSwimDistance = generateAnimalCapability(birdMaxSwimDistance);
        this.maxJumpHeight = generateAnimalCapability(birdMaxJumpHeight);
        birdCount++;
    }

    public void run (double distance){
        if(this.maxRunDistance >= distance)
            System.out.println(this.getName() + " пробежал " + distance + " метров.");
        else
            System.out.println(this.getName() + " не смог пробежать " + distance + " метров.");
    }

    public void swim (){
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

    public static void printBirdCount(){
        System.out.println(birdCount);
    }
}
