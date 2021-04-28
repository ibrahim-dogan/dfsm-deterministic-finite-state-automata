/**
 * Rule is the one of rules of a state
 * It is basically rule of,
 * which char will carry from current state to next state
 */
public class Rule {
    char ch;
    int goToState;

    /**
     * initialization of rule class
     */
    public Rule(char ch, int goToState) {
        this.ch = ch;
        this.goToState = goToState;
    }
}