import java.io.*;
import java.util.Scanner;

public class Buscar{
	
	public boolean  busqueda(String clave,String nombreA){
		String idConsulta = clave;
		int aux=0;
		boolean temp=false;
    		try
    		{		//Abrimos el archivo para poder usarlo
		
      			BufferedReader br = new BufferedReader(
        			new InputStreamReader(
          			new FileInputStream(nombreA)
        			));
      			String linea = "";
      			while( (linea = br.readLine()) != null ) //Verificamos que no este vacio
      			{
        			if( linea.contains( idConsulta ) )
        			{
          				System.out.println( linea );
					aux=1;
        			}
      			}
			if(aux!=0){ //Vemos si el dato se econtro
				System.out.println("El empleado fue encontrado");
				temp=true;
				aux=0;
			}else{
				System.out.println("El empleado NO fue encontrado");
				temp=false;
				aux=0;
			}
			aux=0;
      			br.close();		//Cerramos el archivo 
			return temp;		//Retornamos que encontro el metodo
    		}
    		catch( IOException exc )
    		{
      			System.out.println("IOException generada");
      			exc.printStackTrace();
    		}
		return temp;
	}
	public void busqueda(){ //Leemos lo que el usuario desea hacer
		String clave="";
		String nomA="";
		Scanner c = new Scanner(System.in);
		System.out.println("¿Desea buscar gerente(1) o empleado(2)?");
		String op=""+c.next();
		switch(op){ //Usamos el switch para entrar a lo que se realizara
			case"1":{ //Si es un gerente se realiza lo siguiente para la busqueda
				nomA="gerentes.txt";	//Pasamos el nombre del archivo
				System.out.println("\tEscribe el nuemro de cuenta: ");
				clave=""+c.next();
				if(clave.length()==9){ 	//Verificamos que la clave tenga lo que necesitamos 
					busqueda(clave,nomA);
				}else{
					System.out.println("El numero de cuetna debe tener 9 digitos");
				}
				break;
			}case "2":{ //Si es un empleado se realiza lo siguiente para la busqueda
				nomA="empleados.txt"; 	//Pasamos el nombre del archivo
				System.out.println("\tEscribe el nuemro de cuenta: ");
				clave=""+c.next();
				if(clave.length()==9){ //Verificamos que la clave tenga lo que necesitamos
					busqueda(clave,nomA);
				}else{
					System.out.println("El numero de cuetna debe tener 9 digitos");
				}
				break;
			}default:{
				System.out.println("opcion invalida");
				break;
			}
		}
	}
}