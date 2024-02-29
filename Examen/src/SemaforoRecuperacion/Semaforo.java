package SemaforoRecuperacion;

public class Semaforo extends Thread { 

private String color; 

private int tiempo; 

 
	public Semaforo(String color, int tiempo) { 
	
		this.color = color; 
		
		

		this.tiempo = tiempo; 	 

} 
public void run() { 
		
		System.out.println("El semaforo de color " + color + " dura " + tiempo/1000 + " segundos"); 
		
		try { 
		
			Thread.sleep(tiempo); 
		
		} catch (InterruptedException e) { 
		
			e.printStackTrace(); 
	} 
} 

	public static void main (String [] args) throws InterruptedException { 
		
		Semaforo rojo = new Semaforo("rojo", 5000); 	
		Semaforo amarillo = new Semaforo ("amarillo", 2000); 
		Semaforo verde = new Semaforo ("verde", 3000); 
		
		rojo.start(); 
		rojo.join(); 
		amarillo.start(); 
		amarillo.join(); 
		verde.start(); 
		verde.join(); 

} 

} 
