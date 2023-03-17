package docrob.cag.framework.menu;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuChoice {
    private int id;
    private String label;

    private MenuAction action;

    private int myIntVal;

    private boolean hidden;

    public MenuChoice(String label) {
        this.label = label;
        this.action = null;
        this.myIntVal = -1;
        this.hidden = false;
    }

    public MenuChoice(String label, MenuAction action) {
        this(label);
        this.action = action;
        this.hidden = false;
    }

    public MenuChoice(String label, MenuAction action, boolean hidden) {
        this(label);
        this.action = action;
        this.hidden = hidden;
    }

    public MenuChoice(String label, int myIntVal) {
        this(label);
        this.myIntVal = myIntVal;
        this.hidden = false;
    }

    public MenuChoice(String label, MenuAction action, int myIntVal) {
        this(label, action);
        this.myIntVal = myIntVal;
        this.hidden = false;
    }

    @Override
    public String toString() {
        return id + ": " + label;
    }

    public void doAction() {
        action.doAction();
    }

}
