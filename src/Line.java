import mayflower.ui.Button;

public class Line extends Button
{
    private String act;
    public Line(String img, String action) {
        super(img, action);
        this.act = action;
    }

    public String getAct() {
        return act;
    }
}
