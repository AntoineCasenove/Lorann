package view;

import controller.IController;

/**
* @author Antoine CASENOVE antoine.casenove@viacesi.fr
*/

public class Thread_Lorann extends Thread {
	
	IController controller;
	
	private final int loop = 100;
	
	public Thread_Lorann (String name, IController controller){
		super(name);
		this.controller = controller;
	}

	public void run(){
		  
		while (true) {
			
		 controller.getView().getLorann().afk();
		 controller.getView().updateF();
		 controller.gameOver();
			 
		 try {
			Thread.sleep(loop);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
  } 
	
}