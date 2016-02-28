import java.io.IOException;
import java.util.HashMap;

public class WcMain {
    public static void main(String[] args) {
        CommandLineArgsReader argsReader = new CommandLineArgsReader(args);
        String options = argsReader.getOptions();
        options = options.length()>0?options:"lwc";
        String[] files = argsReader.getFiles();
        FileOperation filesReader = new FileOperation(files);
        fileReader(filesReader, options,files);
    }

    public static void fileReader(FileOperation fileReader, String options,String[] files) {
        String [] result = new String[files.length+1];
        int [] total = new int[options.length()];
        for (int i =0;i<files.length;i++)
            try {
                Wc wc = new Wc(fileReader.readNext());
                provideScanner(options, wc);
                wc.count();
                result[i] = wc.summery();
                accumulator(result[i],total);
                result[i] = result[i]+"\t"+files[i];
            } catch (IOException e) {
                result[i] =e.getMessage();
            }
        result[files.length] = new PrepareResult("\t").add(total);
        printResult(result);
    }

    private static void printResult(String[] result) {
        System.out.println(new PrepareResult("\n").add(result));
    }

    private static void accumulator(String s, int[] total) {
        String [] counts = s.split("\t");
        for (int i = 0; i <counts.length ; i++)
            total[i] += Integer.parseInt(counts[i]);

    }

    private static void provideScanner(String options, Wc wc) {
        HashMap scanners = new AllScanner().get();
        for (int i = 0; i < options.length(); i++){
            Scanner scanner = (Scanner) scanners.get(String.valueOf(options.charAt(i)));
            wc.addScanner(scanner);
        }
    }


}
