import com.ilovethislanguagesomuch.parse;

import java.io.FileNotFoundException;
import java.util.ArrayList;
public class testMain {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        parse.parser("C:\\Users\\hoshi\\Desktop\\file.txt", result);
        for (String x : result){
            System.out.println(x);
        }
    }
}
