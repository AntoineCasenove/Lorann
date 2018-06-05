package view;

import controller.IController;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

public class Thread_Monster extends Thread {
	
	IController controller;
	
	private final int loop = 250;
	
	String name;
	
	int x,y;
	
	boolean inLife = true;
	
	public Thread_Monster (String name, IController controller){
		super(name);
		this.name = name;
		this.controller = controller;
	}

	public void run(){
		  
		while (true) {
			
			int random = (int)(Math.random()*8);
			
			if(name == "1"){
				
				if(inLife == true && this.controller.getView().getMonster1().isInLife() == true){
					
					x = this.controller.getView().getMonster1().getX(); 
					y = this.controller.getView().getMonster1().getY();
					
					this.controller.getView().setTabElement('!', x, y);
					this.controller.getView().refreshFrame('!', x, y);
					
					switch(random){
					case 0 :
					case 1 :
					case 2 :
						if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster1().moveUp();
						}
						else if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster1().moveDown();
						}
					break;
					case 3 :
						if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster1().moveDown();
						}
						else if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster1().moveUp();
						}
					break;
					case 4 :
					case 5 :
						if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster1().moveLeft();
						}
					break;
					case 6 :
					case 7 :
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster1().moveRight();
						}
						else if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster1().moveLeft();
						}
					break;
					default: 
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster1().moveRight();
						}
					break;
					}

					x = this.controller.getView().getMonster1().getX(); 
					y = this.controller.getView().getMonster1().getY();
					
					this.controller.getView().refreshFrame('1', x, y);
					
					if(x == this.controller.getView().getLorann().getPosition().x && y == this.controller.getView().getLorann().getPosition().y){
						this.controller.getView().getLorann().setInLife(false);
					}
				}
			}
			
			if(name == "2" || name == "5"){
				
				if(inLife == true && this.controller.getView().getMonster2().isInLife() == true){
					
					x = this.controller.getView().getMonster2().getX(); 
					y = this.controller.getView().getMonster2().getY();
					
					this.controller.getView().setTabElement('!', x, y);
					this.controller.getView().refreshFrame('!', x, y);
					
					switch(random){
					case 0 :
						if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster2().moveUp();
						}
						else if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster2().moveDown();
						}
					break;
					case 1 :
					case 2 :
					case 3 :
					case 4 :
						if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster2().moveDown();
						}
						else if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster2().moveUp();
						}
					break;
					case 5 :
						if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster2().moveLeft();
						}
						else if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster2().moveRight();
						}
					break;
					case 6 :
					case 7 :
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster2().moveRight();
						}
						else if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster2().moveLeft();
						}
					break;
					default: 
					break;
					}
					
					x = this.controller.getView().getMonster2().getX(); 
					y = this.controller.getView().getMonster2().getY();
					
					this.controller.getView().refreshFrame('2', x, y);
					
					if(x == this.controller.getView().getLorann().getPosition().x && y == this.controller.getView().getLorann().getPosition().y){
						this.controller.getView().getLorann().setInLife(false);
					}
				}
			}
			
			if(name == "3"){
				
				if(inLife == true && this.controller.getView().getMonster3().isInLife() == true){
					
					x = this.controller.getView().getMonster3().getX(); 
					y = this.controller.getView().getMonster3().getY();
					
					this.controller.getView().setTabElement('!', x, y);
					this.controller.getView().refreshFrame('!', x, y);
					
					switch(random){
					case 0 :
					case 1 :
					case 2 :
						if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster3().moveUp();
						}
						else if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster3().moveDown();
						}
					break;
					case 3 :
						if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster3().moveDown();
						}
						else if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster3().moveUp();
						}
					break;
					case 4 :
					case 5 :
						if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster3().moveLeft();
						}
					break;
					case 6 :
					case 7 :
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster3().moveRight();
						}
						else if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster3().moveLeft();
						}
					break;
					default: 
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster3().moveRight();
						}
					break;
					}
					
					x = this.controller.getView().getMonster3().getX(); 
					y = this.controller.getView().getMonster3().getY();
					
					this.controller.getView().refreshFrame('3', x, y);
					
					if(x == this.controller.getView().getLorann().getPosition().x && y == this.controller.getView().getLorann().getPosition().y){
						this.controller.getView().getLorann().setInLife(false);
					}
				}
			}
			
			if(name == "4"){
				
				if(inLife == true && this.controller.getView().getMonster4().isInLife() == true){
					
					x = this.controller.getView().getMonster4().getX(); 
					y = this.controller.getView().getMonster4().getY();
					
					this.controller.getView().setTabElement('!', x, y);
					this.controller.getView().refreshFrame('!', x, y);
					
					switch(random){
					case 0 :
					case 1 :
					case 2 :
						if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster4().moveUp();
						}
						else if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster4().moveDown();
						}
					break;
					case 3 :
					case 4 :
						if(this.controller.getView().getTabElement(x, y+1) == '!' || this.controller.getView().getTabElement(x, y+1) == 'L'){
							this.controller.getView().getMonster4().moveDown();
						}
						else if(this.controller.getView().getTabElement(x, y-1) == '!' || this.controller.getView().getTabElement(x, y-1) == 'L'){
							this.controller.getView().getMonster4().moveUp();
						}
					break;
					case 5 :
						if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster4().moveLeft();
						}
					break;
					case 6 :
					case 7 :
						if(this.controller.getView().getTabElement(x+1, y) == '!' || this.controller.getView().getTabElement(x+1, y) == 'L'){
							this.controller.getView().getMonster4().moveRight();
						}
						else if(this.controller.getView().getTabElement(x-1, y) == '!' || this.controller.getView().getTabElement(x-1, y) == 'L'){
							this.controller.getView().getMonster4().moveLeft();
						}
					break;
					default: 
					break;
					}
					
					x = this.controller.getView().getMonster4().getX(); 
					y = this.controller.getView().getMonster4().getY();
					
					this.controller.getView().refreshFrame('4', x, y);
					
					if(x == this.controller.getView().getLorann().getPosition().x && y == this.controller.getView().getLorann().getPosition().y){
						this.controller.getView().getLorann().setInLife(false);
					}
				}
			}
			
			controller.getView().updateF();
			
			 try {
				Thread.sleep(loop);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
  } 
}
