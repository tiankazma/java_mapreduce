package tian.bigdata.my_mapreduce;

public class App 
{
    public static void main( String[] args )
    {
        // read TXT file
        String txt_in_path = "../my_mapreduce/testing_files/file1.txt";
        String txt_out_path = "../my_mapreduce/testing_files/file2.txt";

        file_reader.txt_reader(txt_in_path, txt_out_path);
    }
}
