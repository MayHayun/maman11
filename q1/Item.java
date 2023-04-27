
/*a class that represents items that can be purchased*/

public class Item 
{
	
	private String name;// name of product
	private float price; // price of product

	/*constructor to init new item that can be bought*/
	public Item(String name, float price) 
	{
		this.name = name;
		this.price = price;
	}


	/*getters*/
	public float getPrice()
	{
		return this.price;
	}
	
	public String getName()
	{
		return this.name;
	}
	/*setters*/
	public void setPrice(float price)
	{
		if(price >= 0)
			this.price = price;
	}
	
	public void setName(String name)
	{
		if(!name.equals(""))
			this.name = name;
	}

	public String toString()
	{
		String res = "";
		res = res.concat(this.name);
		res = res.concat(" ");
		res = res.concat(String.valueOf(price));
		return res;
	}
}
