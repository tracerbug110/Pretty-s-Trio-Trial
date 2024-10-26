import java.util.ArrayList;
import java.util.Random;

public class Utilities 
{
	public String getDieImage(int dieValue)
	{
		return "Dice/Dice_" + dieValue + ".png";
	}
	
	public ArrayList<Integer> rollDice(ArrayList<Integer> dice)
	{
		Random rng = new Random(System.currentTimeMillis());
		
		for(int i = 0; i < dice.size(); i++)
		{
			dice.set(i, rng.nextInt(1, 7));
		}
		return dice;
	}
	
	// Why is it always 3?
	public boolean isAllThrees(ArrayList<Integer> dice)
	{
		for(int i = 0; i < dice.size() - 1; i++)
		{
			if(dice.get(i) != 3)
				return false;
		}
		return true;
	}
}
