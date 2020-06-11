public class Horse extends Animal{
    private static double horseMaxRunDistance = 1500;
    private static double horseMaxSwimDistance = 100;
    private static double horseMaxJumpHeight = 3;
    private static int horseCount = 0;

    public Horse(String name){
        super();
        this.name = name;
        this.maxRunDistance = generateAnimalCapability(horseMaxRunDistance);
        this.maxSwimDistance = generateAnimalCapability(horseMaxSwimDistance);
        this.maxJumpHeight = generateAnimalCapability(horseMaxJumpHeight);
        horseCount++;
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

    public static void printHorseCount(){
        System.out.println(horseCount);
    }
}
