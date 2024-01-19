package tek.bdd.utility;

public class CommonUtilities {

    public static void waitTime(int wait){
        try{
            Thread.sleep(wait);
        }catch (InterruptedException ex){
            Thread.currentThread().interrupt();
        }
    }
}
