import java.io.*;

public class DFSM {
    String[] alphabet;
    State[] states;

    public DFSM(String filePath) {
        readFromTxt(filePath);
    }

    public void readFromTxt(String filePath) {

        // Open the file
        try (FileInputStream fStream = new FileInputStream(filePath)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fStream));

            String strLine;
            int lineIndex = 0;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null) {
                strLine = strLine.replaceAll("\\s", ""); // remove white spaces of current line

                //First line is for alphabet
                if (lineIndex == 0) {
                    this.alphabet = strLine.split(","); //ex: "a,b,c".split(",") => ["a", "b",  "c"]
                } else if (lineIndex == 1) {//Second line is for count of states
                    this.states = new State[Integer.parseInt(strLine)]; //It creates X number of states
                    for (int i = 0; i < states.length; i++) {
                        states[i] = new State(); //Initializes States (if you do not initialize it will be null)
                    }
                    //Third line is for accepted state
                } else if (lineIndex == 2) {
                    int acceptState = Integer.parseInt(strLine);
                    states[acceptState].isAccepted = true;
                    //The rest of lines for collecting the rules
                } else {
                    strLine = strLine.replaceAll("\\s", "");
                    String[] rule = strLine.split(",");
                    int state = Integer.parseInt(rule[0]);
                    char ch = rule[1].charAt(0);
                    int nextState = Integer.parseInt(rule[2]);
                    states[state].rules.add(new Rule(ch, nextState));
                }

                lineIndex++;
            }
            System.out.println("Read successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public boolean checkString(String str) {
        int currentState = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            for (Rule rule : states[currentState].rules) {
                if (rule.ch == ch) {
                    currentState = rule.goToState;
                    break;
                }
            }
        }
        return states[currentState].isAccepted;
    }


}