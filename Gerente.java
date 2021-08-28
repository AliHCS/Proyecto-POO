import java.util.Scanner;

public class Gerente extends Empleado //Hacemos que el gerente sea hijo de la clase empleado
{
	private double bono=0.0;
	public Gerente(){
		super(); //Se llama a todos los tributos y metodos del padre
	}
	public void prueba(){
		String pru=""+getSueldo();
		System.out.println(pru);
	}

	//setters and getters
	public void setBono(double bono){
		this.bono=bono;
	}
	public double getBono(){
		return this.bono;
	}
	//fin de setters and getters
}