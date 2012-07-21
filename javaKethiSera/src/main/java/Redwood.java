package main.java;

public class Redwood extends Tree {
}
class Tree extends Plant {	
}

class Plant
{   public String name;
  public Plant()
  {
	  name = null;
  }
 public Plant(String name) {
	this.name=name;
	}
}