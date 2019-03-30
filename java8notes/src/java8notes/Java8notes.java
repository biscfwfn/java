package java8notes;

public class Java8notes {
    public static void main(String[] args) {
        boolean f = false;
        if(!f){
            log(f);
        }
    }
    private static void log(Object s){
        System.err.println(s);
    }
}