package main.java;

public class Redwood extends Tree {
}
class Tree extends Plant {	
	public Tree()
	{
		super(null);
	}
}

class Plant
{   public String name;
  private Plant()
  {
	  name = null;
  }
 public Plant(String name) {
	this.name=name;
	}
}