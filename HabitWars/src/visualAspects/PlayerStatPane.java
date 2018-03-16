package visualAspects;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.TextAlignment;

public class PlayerStatPane extends Pane{
	//this page needs to have 3 status bars and any time i change any of the values 
	//the perspective bars get changed as well when those values get changed.
	private String name ="";
	private int hpint=50;
	private fullstatPane hpbar=new fullstatPane(Color.RED,50,50,"HP");
	private fullstatPane xpbar=new fullstatPane(Color.YELLOW,100,22,"XP");
	private fullstatPane manaBar=new fullstatPane(Color.BLUE,100,60,"MANA");
	private int mana=0;
	private int exp=0;
	private Label goldLbl=new Label();
	private Label levelLbl=new Label("level 1");
	private int goldAmnt=1000;
	private Label playername=new Label();
	public PlayerStatPane(){
		levelLbl.setLayoutY(1);
		levelLbl.setLayoutX(70);
		playername.setLayoutY(1);
		playername.setLayoutX(10);
		hpbar.setLayoutY(20);
		hpbar.setLayoutX(20);
		
		xpbar.setLayoutY(41);
		xpbar.setLayoutX(20);
		
		manaBar.setLayoutY(61);
		manaBar.setLayoutX(20);
		
		Circle coincirc=new Circle();
		coincirc.setFill(Color.GOLD);
		coincirc.setRadius(10);
		coincirc.setCenterX(280);
		coincirc.setCenterY(50);
		goldLbl.setText(goldAmnt+"");
		goldLbl.setLayoutY(40);
		goldLbl.setLayoutX(295);
		this.getChildren().addAll(playername,manaBar,hpbar,xpbar,coincirc,goldLbl,levelLbl);
		
	}
	public int getHpint() {
		return hpint;
	}
	public void setHpint(int hpint) {
		
		this.hpint = hpint;
		hpbar.setValue(hpint);
		hpbar.toFront();
	}
	public void setlevel(int lvl) {
		levelLbl.setText("level "+lvl);
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMana() {
		return mana;
	}
	public void setMana(int mana) {
		this.mana = mana;
		manaBar.setValue(mana);
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
		xpbar.setValue(exp);
	}
	public void setMaxExp(int mxExp) {
		
		xpbar.setmaxValue(mxExp);
	}
	public void setMaxMana(int mxMana) {
		
		manaBar.setmaxValue(mxMana);
	}
	public void setGold(int gold){
		goldLbl.setText(gold+"");
	}
	public void setPName(String name2){
		playername.setText(name2);
	}
	public void setmaxEXP(int mExp) {
		xpbar.setmaxValue(mExp);
	}
	public void setAll(int health, int level, double gold, double exp, double mana2, String name2) {
		hpbar.setValue(health);
		setlevel((int)level);
		this.setGold((int)gold);
		setExp((int)exp);
		setMana((int)mana2);
		setPName(name2);
	}
}
 class blackrect extends Rectangle{
	public blackrect(){
		this.setFill(Color.BLACK);
		this.setWidth(150);
		this.setHeight(10);
	}
}
 class statBox extends Rectangle{
	private int maxPnt;
	private int value;
	public statBox(){
		
	}
	public statBox(Color bc,int maxPnt,int curintval){
		this.setFill(bc);
		this.maxPnt=maxPnt;
		this.value=curintval;
		this.setWidth((value/(double)this.maxPnt)*146);
		this.setHeight(8);
		
	}
	public void setValue(int value){
		this.value=value;
		this.setWidth((value/(double)maxPnt)*146);
	}
	public void setmaxpnt(int maxPnt){
		this.maxPnt=maxPnt;
		this.setWidth((this.value/(double)maxPnt)*146);
	}
}
 class fullstatPane extends Pane{
		private int maxPnt;
		private int value;
		private statBox colordBar=new statBox();
		private Label stat=new Label();
		public fullstatPane(Color bc,int maxPnt,int curintval,String name){
			blackrect black=new blackrect();
			black.setY(10);
			black.setX(40);
			this.maxPnt=maxPnt;
			value=curintval;
			colordBar=new statBox(bc,maxPnt,curintval);
			colordBar.setY(11);
			colordBar.setX(42);
			Label nameLbl=new Label();
			nameLbl.setText(name);
			nameLbl.setTextAlignment(TextAlignment.RIGHT);
			nameLbl.setLayoutX(5);
			nameLbl.setLayoutY(6);
			nameLbl.setMinWidth(35);
			stat.setText(curintval+"/"+maxPnt);
			stat.setLayoutX(200);
			stat.setLayoutY(6);
			this.getChildren().addAll(nameLbl,black,colordBar,stat);
			
		}
		public void setValue(int value){
			this.value=value;
			stat.setText(value+"/"+maxPnt);
			colordBar.setValue(value);
		}
		public void setmaxValue(int maxVal){
			this.maxPnt=maxVal;
			stat.setText(value+"/"+maxVal);
			colordBar.setmaxpnt(maxVal);
		}
	}