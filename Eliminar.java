import java.io.*;
import java.util.*;
import java.lang.SecurityException;

public class Eliminar
{
  public void borrar(String id, String nombreA,String nombreB)
  {
    ArrayList<String> contenido = new ArrayList<String>(0); //Creamos la referencia tipo ArrayList
    String idElimina = id;

    try //Definimos la parte de lectura del archivo y lo pasammos al array list
    {
      BufferedReader br = new BufferedReader(
        new InputStreamReader(
          new FileInputStream(nombreA)
        )
      );
      String linea = "";
      while( (linea = br.readLine()) != null )
      {
        if( !linea.contains( idElimina ) )
        {
          contenido.add( linea );
        }
      }
      br.close();
      PrintWriter pw = new PrintWriter(
        new OutputStreamWriter(
          new FileOutputStream(nombreB)
        )
      );
      for(int i=0; i<contenido.size();i++)
      {
        pw.println( contenido.get(i) );
      }
      pw.close();
    }
    catch( IOException exc )
    {
      System.out.println("IOException generada");
      exc.printStackTrace();
    }
  }

	public void elimi(int op1){
		 //Aqui vamos a procer a eliminar o modificar un archivo
		Scanner op=new Scanner(System.in);
		String clave="";
		String opcion="";
		Buscar b=new Buscar(); //Creamos una referecia para buscar el dato
		if(op1==0){
			System.out.println("Desea eliminar gerente(1) o empleado(2)?");
		}else{
			System.out.println("Desea modificar gerente(1) o empleado(2)?");
		}
		//Usamos el switch para entrar a lo que el usuario desea realizar
		opcion=""+op.next();
		switch(opcion){
			case "1":{
				System.out.println("Introduce la cave del empleado:");
				clave=""+op.next();	//Pedimos la clave y la guardamos en una variable
				if(clave.length()==9){		//Verificamos que la longitud de la calve sea del tamaño que necesitamos
					if(b.busqueda(clave,"gerentes.txt")){		//En caso de que sea procedemos a buscar en el archivo la clave 
						if(op1==0){
							borrar(clave,"gerentes.txt","gerentes.txt");	//Llama al metodo Borrar y borra el elemento 
							System.out.println("Elemento eliminado");
						}else{
							modificar(clave,"gerentes.txt",1);   //Llama al metodo modificar y modifica el elemento
							System.out.println("Elemento modificado correctamente");
						}
					}
				}else{
					System.out.println("El numero de cuenta debe ser de 9 digitos");
				}
				break;
			}case "2":{ //Pedimos la clave y la guardamos en una variable
				System.out.println("Introduce la cave del empleado:");
				clave=""+op.next();
				if(clave.length()==9){ //Verificamos que la longitud de la calve sea del tamaño que necesitamos
					if(b.busqueda(clave,"empleados.txt")){
						if(op1==0){ //En caso de que sea procedemos a buscar en el archivo la clave
							borrar(clave,"empleados.txt","empleados.txt");
							System.out.println("Elemento eliminado");
						}else{
							modificar(clave,"empleados.txt",0);
						}
					}
				}else{
					System.out.println("El numero de cuenta debe ser de 9 digitos");
				}
				break;
			}default :{
				System.out.println("¡¡¡Opcion invalida!!!");
				break;
			}
		}
	}
		//Metodo modificar
	public void modificar(String id,String nombreA,int aux){
		ArrayList<String> contenido = new ArrayList<String>(0);
    		String idElimina = id;
		String bandera="";
		Gerente gerente = new Gerente();
		Empleado empleado = new Empleado();
		Scanner entrada = new Scanner(System.in);
    		try{	//Entra al archivo 
      			BufferedReader br = new BufferedReader(
        		new InputStreamReader(
          			new FileInputStream(nombreA)));
      			String linea = "";
      			while( (linea = br.readLine()) != null ) //Verifica que el archivo no este vacio
     			{
        			if( !linea.contains( idElimina ) )
        			{
          				contenido.add( linea );
        			}else{
					if(aux==1){
						try{ //Para un gerente 
							System.out.println("Ingresa el nuevo nuemero de cuetna:");
							int numC=entrada.nextInt();
							gerente.setNumeroDeCuenta(numC);//lee el numero de cuenta
							bandera=""+gerente.getNumeroDeCuenta();
							System.out.println("Ingresa el nuevo nombre:");
							String nom=entrada.next();
							gerente.setNombre(nom);//lee el nombre
							System.out.println("Ingresa el nuevo departamento:");
							String dep=entrada.next();
							gerente.setDepartamento(dep);//lee el departamento
							System.out.println("Ingresa el nuevo sueldo:");
							double sal=entrada.nextDouble();
							gerente.setSueldo(sal);//lee el sueldo-->bono = saldo*.20 + saldo;
							gerente.setBono((gerente.getSueldo()*0.20));
							gerente.setSueldo(gerente.getSueldo()+gerente.getBono());//lee el sueldo-->bono = saldo*.20 + saldo;
							if(gerente.getNumeroDeCuenta()>0 && bandera.length()==9){
								contenido.add(gerente.concatenacion());
								System.out.println("Elemento modificado correctamente");
							}else{
									System.out.println("El numero de ceutna debe ser mayor que cero");
									System.out.println("Y de nueve digitos");
									contenido.add( linea );
							}
						}catch(NoSuchElementException elementException){
							System.err.println("Entrada invalida intente de nuevo");
							contenido.add( linea );
							//entrada.nextLine();//descarta la entrada para que el usuario intente de nuevo
						}//fin de catch
					}else{
						try{ //Para un empleado
							System.out.println("Ingresa el nuevo nuemero de cuetna:");
							int numC=entrada.nextInt();
							empleado.setNumeroDeCuenta(numC);//lee el numero de cuenta
							bandera=""+empleado.getNumeroDeCuenta();
							System.out.println("Ingresa el nuevo nombre:");
							String nom=entrada.next();
							empleado.setNombre(nom);//lee el nombre
							System.out.println("Ingresa el nuevo departamento:");
							String dep=entrada.next();
							empleado.setDepartamento(dep);//lee el departamento
							System.out.println("Ingresa el nuevo sueldo:");
							double sal=entrada.nextDouble();
							empleado.setSueldo(sal);//lee el sueldo
							if(empleado.getNumeroDeCuenta()>0 && bandera.length()==9){
								contenido.add(empleado.concatenacion());
								System.out.println("Elemento modificado correctamente");
							}else{
								System.out.println("El numero de ceutna debe ser mayor que cero");
								System.out.println("Y de nueve digitos");
								contenido.add( linea );
							}
						}catch(NoSuchElementException elementException){
							System.err.println("Entrada invalida intente de nuevo");
							contenido.add( linea );
							//entrada.nextLine();//descarta la entrada para que el usiario intente de nuevo
						}//fin de catch
					}
				}
      			} //Cierra el archivo 
      			br.close();
      			PrintWriter pw = new PrintWriter(
        		new OutputStreamWriter(
          			new FileOutputStream(nombreA)));
      			for(int i=0; i<contenido.size();i++)
      			{
        			pw.println( contenido.get(i) );
      			}
      			pw.close();
    		}catch( IOException exc ){
      			System.out.println("IOException generada");
      			exc.printStackTrace();
    		}
	}
}