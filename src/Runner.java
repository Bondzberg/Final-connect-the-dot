import mayflower.Mayflower;
import mayflower.World;

public class Runner extends Mayflower
{
    public Runner(){
        super("Project ultra secret", 800, 800);
    }
    public static void main(String[] args){
        new Runner();
    }
    public void init()
    {
        Mayflower.setWorld(new World() {
            @Override
            public void act() {
                System.out.println(System.currentTimeMillis());
            }
        });
    }
    public void main()
    {
        System.out.println();
    }
}
