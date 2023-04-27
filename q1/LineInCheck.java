
/*a class that represents line in a bill*/

public class LineInCheck{
	private Item i; // item for line in check
	private int quantity;
	private float total; // total sum for quantity of item i

	/*a constructor that gets a product and quantity and init all attributes*/
	public LineInCheck(Item i, int quantity)
	{
		this.i = i;
		this.quantity = quantity;
		total = i.getPrice() * quantity;
	}

	/*getters*/
	public Item getItem() 
	{
		return this.i;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public float getTotal()
	{
		return total;
	}
	/*setters*/
	public void setQuantity(int quantity)
	{
		if(quantity >0)
		{
			this.quantity = quantity;
			this.total = i.getPrice() * quantity;
		}
	}
	
	public void setItem(Item i)
	{
		this.i = i;
		this.total = i.getPrice() * this.quantity;
	}

	/*to string for line in check - prints the items name - quantity for consumer - total amount of money*/
	public String toString() 
	{
		String res = "";
		res = res.concat(i.getName());
		res = res.concat("\t");
		res = res.concat(String.valueOf(quantity));
		res = res.concat("\t");
		res = res.concat(String.valueOf(total));
		return res;
	}
}
