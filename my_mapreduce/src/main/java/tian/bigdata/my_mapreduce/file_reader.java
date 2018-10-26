package tian.bigdata.my_mapreduce;

import java.io.File;
import java.io.InputStreamReader;

import org.apache.tools.ant.taskdefs.TempFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file_reader {
	public static void txt_reader(String inpath, String outpath) {
		// initializing file_in and file_out for read and write data 
		File file_in = new File(inpath);
		File file_out = new File(outpath);
		
		try {
			// check the target file is existted or not:
			if (!file_in.exists()) {
				file_in.createNewFile();
			}
			if(!file_out.exists()) {
				file_out.createNewFile();
			}
			
			//read file
			InputStreamReader isr = new InputStreamReader(new FileInputStream(file_in), "utf-8");
			BufferedReader br = new BufferedReader(isr);
			
			// -1 == null
			String temp = null;
			while ((temp = br.readLine()) != null) {
				//split by '-' and space
				for(String sub_temp: temp.split("-| ")) {
					System.out.print(sub_temp + " && ");
				}
				System.out.println();
			}
			
			br.close();
			isr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		try{
//			// read TXT file
//			File file_in = new File(infile);
//			InputStreamReader reader = new InputStreamReader(
//				new FileInputStream(file_in));
//			BufferedReader br = new BufferedReader(reader);
//
//			String line = "";
//			line = br.readLine();
//			
//			// write TXT
//			File file_out = new File(outfile);
//			
//			if(!file_out.exists()) {
//				file_out.createNewFile();
//			}
//			
//			FileWriter fw = new FileWriter(file_out, false);
//			BufferedWriter bw = new BufferedWriter(fw);
//			
//			bw.write(line + "\n");
//			while(line != null){
//				line = br.readLine();
//				bw.write(line + "\n");
//			}
//			bw.close();
//			fw.close();
//			
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
}