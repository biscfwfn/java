package java8notes;

/**
 *
 * @author pc
 */
public class Stack {
    private int[] stck = new int[10];
    private int tos;

    public Stack() {
        this.tos = -1;
    }
    public void push(int item){
        if(this.tos == 9){
            System.out.println("堆栈满");
            return;
        }
        this.stck[++this.tos] = item;
    }
    public int pop(){
        if(this.tos == -1){
            System.out.println("堆栈空");
            return 0;
        }
        return this.stck[this.tos--];
    }
    
}
