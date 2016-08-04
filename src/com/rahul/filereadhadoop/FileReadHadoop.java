package com.rahul.filereadhadoop;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

public class FileReadHadoop {

	public static void main(String[] args) throws IOException {

		Configuration conf = new Configuration();
		FileSystem fs = FileSystem.get(URI.create("hdfs://localhost:54310/user/hadoop/"), conf);
		InputStream is = null;
		
		is = fs.open(new Path("hdfs://localhost:54310/user/hadoop/stream.pl"));
		IOUtils.copyBytes(is, System.out, conf);
		fs.close();
		
		
	}

}
