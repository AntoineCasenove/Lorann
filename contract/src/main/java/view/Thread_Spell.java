package view;

import controller.IController;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr, Antonin PRETET antonin.pretet@viacesi.fr
*/

public class Thread_Spell extends Thread {
	
	IController controller;
	
	boolean spellOnMap = true;
	
	char direction;
	
	private final int loop = 60;
	
	public Thread_Spell (IController controller, char direction){
		this.controller = controller;
		this.direction = direction;
	}

	public void run(){
		  
		while (this.controller.isSpellOnMap() == true) {
		
		this.controller.getView().setTabElement('!', this.controller.getView().getSpell().getPosition().x, this.controller.getView().getSpell().getPosition().y);
		this.controller.getView().refreshFrame('!', this.controller.getView().getSpell().getPosition().x, this.controller.getView().getSpell().getPosition().y);
		
		int x = this.controller.getView().getSpell().getPosition().x;
		int y = this.controller.getView().getSpell().getPosition().y;
		
		//this.controller.getView().getSpell().moveSpell(this.controller.getDirection());
		
		if(direction == 'U'){
			if(this.controller.getView().getTabElement(x, y-1) == '!')
				this.controller.getView().getSpell().moveUp();
			else if(this.controller.getView().getTabElement(x, y-1) == 'L'){
				this.controller.getView().refreshFrame('!', x, y);
				this.controller.getView().setTabElement('!', x, y);
				this.controller.getView().updateF();
				this.controller.setSpellOnMap(false);
			}
			else if(this.controller.getView().getTabElement(x, y-1) == '1')
			{
				this.controller.getView().getMonster1().setInLife(false);
				this.controller.getView().setTabElement('!', x, y-1);
			}
			else if(this.controller.getView().getTabElement(x, y-1) == '2')
			{
				this.controller.getView().getMonster2().setInLife(false);
				this.controller.getView().setTabElement('!', x, y-1);
			}
			else if(this.controller.getView().getTabElement(x, y-1) == '3')
			{
				this.controller.getView().getMonster3().setInLife(false);
				this.controller.getView().setTabElement('!', x, y-1);
			}
			else if(this.controller.getView().getTabElement(x, y-1) == '4')
			{
				this.controller.getView().getMonster4().setInLife(false);
				this.controller.getView().setTabElement('!', x, y-1);
			}
			else{
				this.controller.getView().getSpell().moveDown();
				direction = 'D';
			}
		}
		
		if(direction == 'D'){
			if(this.controller.getView().getTabElement(x, y+1) == '!')
				this.controller.getView().getSpell().moveDown();
			else if(this.controller.getView().getTabElement(x, y+1) == 'L'){
				this.controller.getView().refreshFrame('!', x, y);
				this.controller.getView().setTabElement('!', x, y);
				this.controller.getView().updateF();
				this.controller.setSpellOnMap(false);
			}
			else if(this.controller.getView().getTabElement(x, y+1) == '1')
			{
				this.controller.getView().getMonster1().setInLife(false);
				this.controller.getView().setTabElement('!', x, y+1);
			}
			else if(this.controller.getView().getTabElement(x, y+1) == '2')
			{
				this.controller.getView().getMonster2().setInLife(false);
				this.controller.getView().setTabElement('!', x, y+1);
			}
			else if(this.controller.getView().getTabElement(x, y+1) == '3')
			{
				this.controller.getView().getMonster3().setInLife(false);
				this.controller.getView().setTabElement('!', x, y+1);
			}
			else if(this.controller.getView().getTabElement(x, y+1) == '4')
			{
				this.controller.getView().getMonster4().setInLife(false);
				this.controller.getView().setTabElement('!', x, y+1);
			}
			else{
				this.controller.getView().getSpell().moveUp();
				direction = 'U';
			}
		}
		
		if(direction == 'L'){
			if(this.controller.getView().getTabElement(x-1, y) == '!')
				this.controller.getView().getSpell().moveLeft();
			else if(this.controller.getView().getTabElement(x-1, y) == 'L'){
				this.controller.getView().refreshFrame('!', x, y);
				this.controller.getView().setTabElement('!', x, y);
				this.controller.getView().updateF();
				this.controller.setSpellOnMap(false);
			}
			else if(this.controller.getView().getTabElement(x-1, y) == '1')
			{
				this.controller.getView().getMonster1().setInLife(false);
				this.controller.getView().setTabElement('!', x-1, y);
			}
			else if(this.controller.getView().getTabElement(x-1, y) == '2')
			{
				this.controller.getView().getMonster2().setInLife(false);
				this.controller.getView().setTabElement('!', x-1, y);
			}
			else if(this.controller.getView().getTabElement(x-1, y) == '3')
			{
				this.controller.getView().getMonster3().setInLife(false);
				this.controller.getView().setTabElement('!', x-1, y);
			}
			else if(this.controller.getView().getTabElement(x-1, y) == '4')
			{
				this.controller.getView().getMonster4().setInLife(false);
				this.controller.getView().setTabElement('!', x-1, y);
			}
			else{
				this.controller.getView().getSpell().moveRight();
				direction = 'R';
			}
		}
		
		if(direction == 'R'){
			if(this.controller.getView().getTabElement(x+1, y) == '!')
				this.controller.getView().getSpell().moveRight();
			else if(this.controller.getView().getTabElement(x+1, y) == 'L'){
				this.controller.getView().refreshFrame('!', x, y);
				this.controller.getView().setTabElement('!', x, y);
				this.controller.getView().updateF();
				this.controller.setSpellOnMap(false);
			}
			else if(this.controller.getView().getTabElement(x+1, y) == '1')
			{
				this.controller.getView().getMonster1().setInLife(false);
				this.controller.getView().setTabElement('!', x+1, y);
			}
			else if(this.controller.getView().getTabElement(x+1, y) == '2')
			{
				this.controller.getView().getMonster2().setInLife(false);
				this.controller.getView().setTabElement('!', x+1, y);
			}
			else if(this.controller.getView().getTabElement(x+1, y) == '3')
			{
				this.controller.getView().getMonster3().setInLife(false);
				this.controller.getView().setTabElement('!', x+1, y);
			}
			else if(this.controller.getView().getTabElement(x+1, y) == '4')
			{
				this.controller.getView().getMonster4().setInLife(false);
				this.controller.getView().setTabElement('!', x+1, y);
			}
			else{
				this.controller.getView().getSpell().moveLeft();
				direction = 'L';
			}
		}
		
		if(this.controller.isSpellOnMap() == true){
			this.controller.getView().setTabElement('S', this.controller.getView().getSpell().getPosition().x, this.controller.getView().getSpell().getPosition().y);
			this.controller.getView().refreshFrame('S', this.controller.getView().getSpell().getPosition().x, this.controller.getView().getSpell().getPosition().y);
		}
		
		//System.out.println(this.controller.getView().getSpell().getPosition().x + " " + this.controller.getView().getSpell().getPosition().y);

		controller.getView().updateF();

		try {
			Thread.sleep(loop);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
	}
  } 
	
}