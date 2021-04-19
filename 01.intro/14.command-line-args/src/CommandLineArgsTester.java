public class CommandLineArgsTester {
    public static void main(String[] args) {

        System.out.format(
            "ぼくは %s 歳の %s です. ", 
            args[0], args[1]);
            
        System.out.format("体重は %s キロです. %n", args[2]);
    }
}
