package java8notes;
public class Java8notes {
    public static void main(String[] args) {
        Integer[] l = new Integer[10];
        for(int i=1;i<11;i++){
            l[i-1] = i;
        }
        Stack s = new Stack();
        for(int v:l){
            s.push(v);
        }
        for(int i=1;i<11;i++){
            log(s.pop());
        }
        log("sdfdfasdfasdfadsf");
        String regionCode = "500000000000";
        log(regionCode.replaceAll("(0+)$", ""));
    }
    private static void log(Object s){
        System.out.println(s);
    }
}
