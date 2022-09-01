package implementations;

import interfaces.Solvable;

import java.util.Set;

public class BalancedParentheses implements Solvable {

    private static final Set<String> OPENING_TYPES = Set.of("{", "(", "[");
    private static final Set<String> CLOSING_TYPES = Set.of("}", ")", "]");
    private final char[] array;

    public BalancedParentheses(String parentheses) {
        this.array = parentheses.toCharArray();
    }

    @Override
    public Boolean solve() {

        boolean balanceOK = true;
        int endIndex = this.array.length - 1;
        char openParentheses;
        char closeParentheses;

        for (int i = 0; i <= endIndex; i++) {
            openParentheses = ' ';
            closeParentheses = ' ';

            if (OPENING_TYPES.contains(String.valueOf(this.array[i]))
                    || CLOSING_TYPES.contains(String.valueOf(this.array[i]))) {
                openParentheses = this.array[i];

                if (CLOSING_TYPES.contains(String.valueOf(openParentheses))) {
                    balanceOK = false;
                }

                for (int j = endIndex; j > i; j--) {
                    if (CLOSING_TYPES.contains(String.valueOf(this.array[j]))) {
                        closeParentheses = this.array[j];
                        endIndex = j - 1;
                        break;
                    }
                }

                if (openParentheses == '{' && closeParentheses != '}'
                        || openParentheses == '[' && closeParentheses != ']'
                        || openParentheses == '(' && closeParentheses != ')') {
                    balanceOK = false;
                }
            }

            if (!balanceOK) {
                return false;
            }
        }
        return true;
    }
}
