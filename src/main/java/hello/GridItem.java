package hello;

public class GridItem {
	private Integer ID;
	public String title;
	public String description;
	public String background;
	
	//public GridItem(int id){this.ID=id;}
	/*public GridItem(String title, String description, String background){
		this.title=title;
		this.description=description;
		this.background=background;
	}*/
	public void setID(Integer I){this.ID=I;}
	public Integer getID(){return this.ID;}
}
