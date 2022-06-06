package HomeWorkThree;

public class BracketChecker {
    private String line;

    public BracketChecker(String line) {
        this.line = line;
    }

    public void check() {
        Stack st = new Stack(line.length());

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') {
                st.push(ch);
            } else if (ch == ']' || ch == '}' || ch == ')') {
                if (!st.isEmpty()) {
                    char chr = st.pop();
                    if ((ch == '}' && chr != '{') || (ch == ']' && chr != '[') || (ch == ')' && chr != '(')) {
                        throw new RuntimeException("Неверный знак " + ch + " на " + (i+1)+ " позиции");
                    }
                } else {
                    throw new RuntimeException("Неверный знак " + ch + " на " + (i+1)+ " позиции");
                }
            }
        }
        if (!st.isEmpty()){
            throw new RuntimeException("Отсутствуют закрывающие скобки");
        }
    }
}
