package menue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UserInfo {
	private int health=0;
	private double exp=0;
	private double mana=0;
	private int maxmana=0;
	private int level=1;
	private double gold=0;
	private int expTillNext=0;
	private String name="";
	private LocalDate compDate=LocalDate.now();

	//this inicialises the user stats
	public UserInfo(int health,double exp,double mana,double gold,int level){
		this.setHealth(health);
		this.setExp(exp);
		this.setMana(mana);
		this.setGold(gold);
		this.setLevel(level);
		expTillNext=level*100;
	}

	
	public String toString(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String svstr="HP ,("+ health+")LVL ,("+level+")GOLD ,("+gold+")EXP ,("+exp+")MANA ,("+mana+")NAME ,("+name+")"+"signin ,("+compDate.format(formatter).toString()+")";
		return svstr;
		
	}
	public void readUserString(String infoString){
		//this reads the user info from a string
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String[] arr = infoString.split("[\\(\\)]");
		health = Integer.parseInt(arr[1]);
		level = Integer.parseInt(arr[3]);
		gold = Double.parseDouble(arr[5]);
		exp = Double.parseDouble(arr[7]);
		mana = Double.parseDouble(arr[9]);
		name =(arr[11]);
		compDate =LocalDate.parse(arr[13], formatter) ;
	}
	
	//builds the getters and setters
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health>50)
			health=50;
		if(health<0)
			health=0;
		this.health = health;
	}

	public double getExp() {
		return exp;
	}

	public void setExp(double exp) {
		if(exp>expTillNext){
			exp=exp-expTillNext;
			level++;
			expTillNext=level*100;
		}
		this.exp = exp;
	}
	public double getExpTillNext() {
		expTillNext=level*100;
		return expTillNext;
	}
	public double getMana() {
		return mana;
	}

	public void setMana(double mana) {
		this.mana = mana;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public double getper() {
		// TODO Auto-generated method stub
		return 1;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxmana() {
		return maxmana;
	}

	public void setMaxmana(int maxmana) {
		this.maxmana = maxmana;
	}

	public LocalDate getCompDate() {
		return compDate;
	}

	public void setCompDate(LocalDate compDate) {
		this.compDate = compDate;
	}


	public void reset() {
		health=50;
		 exp=0;
		mana=0;
		maxmana=0;
		level=1;
		gold=0;
		expTillNext=1;
		name="";
		
	}
}
