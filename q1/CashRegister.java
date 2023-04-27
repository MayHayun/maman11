import java.util.ArrayList;

/*a class to represent that cashier - and all its functionality*/
public class CashRegister{
	
	private float totalInRegister; // amount of money in register at the moment
	private float curTotal; // the sum of the current purchase
	private ArrayList<LineInCheck> curPurchase; //current data for current customer*/

	/*constructors*/
	public CashRegister(float total) 
	{
		this.totalInRegister = total;
		this.curTotal =0;
		curPurchase = new ArrayList<LineInCheck>();
	}
	public CashRegister() {
		this(0);
	}

	/*getters*/
	public float getTotal()
	{
		return this.totalInRegister;
	}
	
	public float getCurTotal()
	{
		return this.curTotal;
	}
	/*setters*/
	public void setTotal(float total)
	{
		this.totalInRegister = total;
	}

	/*a method to add another line(items) to the current purchase*/
	public void addToPurchase(Item i, int quantity)
	{
		LineInCheck l = new LineInCheck(i, quantity);
		curPurchase.add(l);
		curTotal += l.getTotal();
	}

	/*a method to get the check for current purchase*/
	public void getCurCheck()
	{
		for (int i = 0; i < curPurchase.size() ; i++)
			System.out.println(curPurchase.get(i).toString());
		System.out.println("total is:\t" + curTotal);
	}

	/*a method to get payment for purchase from costumer*/
	public void getPayed(float payment)
	{
		this.totalInRegister += curTotal;
		float temp = payment - curTotal;
		curTotal = 0;
		curPurchase.clear();
		System.out.println("your change is:" + temp);
	}
}
