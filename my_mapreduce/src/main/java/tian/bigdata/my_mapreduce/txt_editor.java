package tian.bigdata.my_mapreduce;

import java.io.File;
import java.io.InputStreamReader;

import org.apache.commons.io.output.WriterOutputStream;
import org.apache.tools.ant.taskdefs.TempFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class txt_editor {
	public static void reader(String inpath, String outpath) {
		// initializing file_in and file_out for read and write data 
		File file_in = new File(inpath);
		File file_out = new File(outpath);
		
		String data = "";
		
		try {
			// check the target file is existted or not:
			if (!file_in.exists()) {
				file_in.createNewFile();
			}
			if(!file_out.exists()) {
				file_out.createNewFile();
			}
			
			//for read txt
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file_in), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			//for write-in txt
			BufferedWriter bw = new BufferedWriter(new FileWriter(file_out));
			
			String temp = null;
			while ((temp = br.readLine()) != null) {
				//split by '-' and space
				data = new String();
				
				// traversal the data in the same line
				for(String sub_temp: temp.split("-| ")) {
					data += sub_temp + " && ";
				}
				data += "\n";
				
				// write data into target file.
				bw.write(data);
			}
			
			//close buffer writer
			bw.close();
			
			//close buffer reader
			br.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}