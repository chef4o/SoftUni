package BasicSyntax;

import com.sun.tools.jconsole.JConsoleContext;

public class DivisableBy3 {
    public static void main(String[] args) {

        for (int i = 3; i < 100; i += 3) {
            System.out.println(i);
        }
    }
}
