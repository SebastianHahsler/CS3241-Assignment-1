import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int count = 0;
        int error = 0;
        int info = 0;
        int warn = 0;
        int err;
        int memWarn = 0;

        Queue<String> queue = new Queue<>();
        Stack<String> stack = new Stack<>();

        List<String> recentErrors = new ArrayList<>();

        while (!StdIn.isEmpty()) {
            String token = StdIn.readLine();
            if (!token.equals(" ")) {
                queue.enqueue(token);
                count = count + 1;
                //StdOut.println(count + " " + token);
            }
        }

        while (count > 0){
            String token = queue.dequeue();
           // System.out.println(token);
            count--;
            if (token.contains("ERROR")) {
                stack.push(token);
                error++;
            }
            if (token.contains("INFO")) {
                info++;
            }
            if (token.contains("WARN")) {
                warn++;
                if (token.contains("Memory")) {
                    memWarn++;
                }
            }
        }
        err = error;

        while(err > 0){
            String token = stack.pop();
            err--;
            if(err < 100){
                recentErrors.add(token);

            }
        }

        StdOut.println("Number of ERROR: " + error);
        StdOut.println("Number of INFO: " + info);
        StdOut.println("Number of WARN: " + warn);
        StdOut.println("Number of Memory Warnings: " + memWarn);
        StdOut.println("List of recent errors: " + recentErrors);

    }
}