import java.io.*;
import java.util.*;
import java.lang.SecurityException;

public class Insertar
{
  	public static void insertaDato(String s,String nomA){
    		ArrayList<String> cs = new ArrayList<String>(0); //Utilizamos un ArrayList para poder manejar los nombres en el archivo
    		try{
      
      			File f = new File(nomA);  //Verificamos si no hay un archivo ya existen y si no lo hay lo creamos
      			if( !f.exists() ){
        			f.createNewFile();
      			}

 			BufferedReader br = new BufferedReader(
        		new InputStreamReader(
          			new FileInputStream(nomA)));      //Creamos las referiancias del tipo de clase que vamos utilizar para escribir en el archivo
      			String linea = "";
      			while( (linea = br.readLine()) != null )
      			{
        			cs.add( linea );           //Verificamos cuanto se leera 
      			}
      			br.close();

      			PrintWriter pw = new PrintWriter(
        			new OutputStreamWriter(
          				new FileOutputStream(nomA)));  
      			for(int i=0; i<cs.size();i++)
      			{
        			pw.println( cs.get(i) );         //Ingresamos el texto escrito en el archivo del tamaño del ArrayList
      			}
     			pw.println( s );
      			pw.close(); 				//Cerramos el archivo 
    		}catch( IOException exc ){
      			exc.printStackTrace();
    		}
	}

	public void agregarRegistro(){  //Procedemos con el metodo de agregar un registro
		String nombreArchivo="";
		int aux=0,bandera=0;
		Scanner opcion=new Scanner(System.in);  //leemos la opcion que se preguntara
		System.out.println("¿Desea insertar empleado(1) o gerente(2)?"); //Preguntamos que tipo de trabajador se desea agregar
		String op=opcion.next();
		switch(op){  //Usamos un switch para poder entrar a la opcion seleccionada
			case "1":{
				nombreArchivo="empleados.txt"; //Si es un tipo empleado lo guardaremos en un archivo llamado empleados
				break;
			}
			case "2":{
				nombreArchivo="gerentes.txt";  //Si es un gerente lo guardaremos en un archivo llamado gerentes
				aux=1;
				break;
			}default:{       //En caso de que sea una opcion diferente entra en el default
				System.out.println("Opcion invalida");     
				bandera=1;
				break;
			}
		}
		if(bandera==0){
			//objeto que se va a escribir en el archivo
			Empleado empleado = new Empleado();
			Gerente gerente = new Gerente();
			Scanner entrada = new Scanner(System.in);
			String bandera2="";
			System.out.printf("%s\n","Para terminar la incersion presione <ctrl> z y oprima Intro");   //Espesificamos el como se debe realizar la insercion del tipo de empleado
			System.out.printf("%s\n","Escriba numero de cuenta(>0),Nombre,Departamento,Sueldo");

			while(entrada.hasNext()){//itera hasta encontrar el indicador de fin de etrada
				try{
				//obtiene los datos que se van a almacenar
				
					if(aux==1){
						gerente.setNumeroDeCuenta(entrada.nextInt());//lee el numero de cuenta
						bandera2=""+gerente.getNumeroDeCuenta();
						System.out.println(""+bandera2.length());
						gerente.setNombre(entrada.next());//lee el nombre
						gerente.setDepartamento(entrada.next());//lee el departamento
						gerente.setSueldo(entrada.nextDouble());//lee el sueldo-->bono = saldo*.20 + saldo;
						gerente.setBono((gerente.getSueldo()*0.20));
						gerente.setSueldo(gerente.getSueldo()+gerente.getBono());//lee el sueldo-->bono = saldo*.20 + saldo;
					}else{
						empleado.setNumeroDeCuenta(entrada.nextInt());//lee el numero de cuenta
						bandera2=""+empleado.getNumeroDeCuenta();
						empleado.setNombre(entrada.next());//lee el nombre
						empleado.setDepartamento(entrada.next());//lee el departamento
						empleado.setSueldo(entrada.nextDouble());//lee el sueldo
					}
					 //se verifica que el empleado y el gerente tengan un numero de cuenta mayor a 0 y de 9 digitos
					if((empleado.getNumeroDeCuenta()>0||gerente.getNumeroDeCuenta()>0)&& bandera2.length()==9){
						if(aux==1){
							insertaDato(gerente.concatenacion(),nombreArchivo);
						}else{
							insertaDato(empleado.concatenacion(),nombreArchivo);
						}
					}else{
						System.out.println("El numero de cuenta debe ser mayor que cero");
						System.out.println("Y debe tener 9 digitos");
					}
				}catch(NoSuchElementException elementException){
					System.err.println("Entrada invalida intente de nuevo");
					entrada.nextLine();//descarta la entrada para que el usiario intente de nuevo
				}//fin de catch
		
				System.out.printf("%s\n","Escriba numero de cuenta(>0),Nombre,Departamento,Sueldo");
			}//fin de while()
		}
	}//fin de agregar registro
}