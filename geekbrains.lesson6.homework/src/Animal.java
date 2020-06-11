public abstract class Animal {

    double maxRunDistance;
    double maxSwimDistance;
    double maxJumpHeight;
    String name;
    private static int animalCount = 0;

    public Animal (){
        animalCount++;
    }

    public void run (double distance){
    }

    public void swim (double distance){
    }

    public void jump (double height){
    }

    double generateAnimalCapability(double maxValue){
        return Math.random()*maxValue;
    }

    public static void printAnimalCount(){
        System.out.println(animalCount);
    }
}
