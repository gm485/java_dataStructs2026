package head_first_ch_1.sim_u_duck;

public abstract class Duck {
    public void quack(){
        System.out.println("quack");
    }

    public void swim(){
        System.out.println("swim");
    }

    public void display(){
        System.out.println("Parent class: " + this.getClass().getSimpleName());
    }
}
