package com.divesh.serialization;

import java.io.*;
public class Persist{
	// is used to write primitive data types and Java Objects to an
	// OutPutStream. Only thouse objects that supports java.io.serializable
	// interaface can be written to stream.
 public static void main(String args[])throws Exception{
  Student s1 =new Student(211,"ravi");

  FileOutputStream fout=new FileOutputStream("f.txt");
  ObjectOutputStream out=new ObjectOutputStream(fout);

  out.writeObject(s1);
  out.flush();

  System.out.println("success");
 }
}