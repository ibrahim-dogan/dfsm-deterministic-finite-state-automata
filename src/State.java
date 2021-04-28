import java.util.ArrayList;

/**
 * State represents the each state,
 * it can be accepted or not
 * it has multiple rules.
 */
public class State {

    public boolean isAccepted;
    public ArrayList<Rule> rules;

    /**
     * initialization of state class
     */
    public State() {
        rules = new ArrayList<>(); //default rules are empty arraylist
        isAccepted = false; //default value of accepted state is false
    }

}