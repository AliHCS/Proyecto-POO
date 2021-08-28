
public class Empleado {

	private String nombre;
	private String departamento;
	private int numeroDeCuenta;
	private double sueldo;
	
	//constructor sin valores que llama a otro constructor con valores predeterminados
	public Empleado(){
		this(0,"","",0.0);
	}
	//inicializa un registro
	public Empleado(int numC, String nom, String dep, double suel){
		setNombre(nom);
		setDepartamento(dep);
		setNumeroDeCuenta(numC);
		setSueldo(suel);
	}
	
	//setters and getters
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	public void setDepartamento(String departamento){
		this.departamento=departamento;
	}
	public void setNumeroDeCuenta(int numeroDeCuenta){
		this.numeroDeCuenta=numeroDeCuenta;
	}
	public void setSueldo(double sueldo){
		this.sueldo=sueldo;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getDepartamento(){	
		return this.departamento;
	}
	public int getNumeroDeCuenta(){
		return this.numeroDeCuenta;
	}
	public double getSueldo(){
		return this.sueldo;
	}
	//fin de setters and getters

	public String concatenacion(){ //Mostamos todos los valores que se metieron
		String cs=getNumeroDeCuenta()+","+getNombre()+","+
			getDepartamento()+","+getSueldo();
		return cs;
	}

}//fin de la clase 
