import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.lang.IllegalStateException;

public class Sistema
{
    public static void main(String[]args)
    {	
		Insertar insertar = new Insertar(); //Se crea una referencia a tipo de objeto necesitado
		Buscar buscar = new Buscar();       //Se crea una referencia a tipo de objeto necesitado
		Eliminar eliminar = new Eliminar(); //Se crea una referencia a tipo de objeto necesitado
		String cla="";
		Scanner opcion = new Scanner(System.in); //Se crea una referencia a tipo de objeto necesitado
		Scanner entrada; //Se lee la opcion con un Scanner 
		
		do{   //Usamos un do while para iterar el menú que se propuso para relizar el proyecto
			try{    //Se utilizo el try - catch para poder prevenir error al momento de ingresar la opcion
				menu(); cla=opcion.next();
			}catch(Exception ex){
				System.out.println("error");
			}
			switch(cla){ // aqui se compara el valor que el usuario escojio y se procede a entrar y realizar lo que se necesita
				case "1" :{
					System.out.println("Elegiste: 1.-INSERTAR\n");
					insertar.agregarRegistro(); //Se llama a la clase y a su metodo respectivamente
					break;
				}
				case "2": {
					System.out.println("Elegiste: 2.-CONSULATAR\n");
					buscar.busqueda(); //Se llama a la clase y a su metodo respectivamente
					break;
				}
				case "3": {
					System.out.println("Elegiste: 3.-MODIFICAR");
					eliminar.elimi(1); //Se llama a la clase y a un metodo en este caso es el modificar un elemento
					break;
				}
				case "4":{
					System.out.println("Elegiste: 4.-ELIMINAR");
					eliminar.elimi(0); //Se llama a la clase y a un metodo en este caso es eliminar un elemento
					break;
				}
				case "5":{ //Se sale del menu
					cla="5";
					break;
				}
				default : { //Si la opcion que inserto el usuario no es ninguna de las anteriores entra a este caso
					break;
				}
			}
		}while(cla!="5");
		
	}
	 //Se muestra todas las opciones que tiene nuestro menu 
	public static void menu(){
		System.out.println("************Bienvenido**********\n");		
		System.out.println("1.-INSERTAR");
		System.out.println("2.-CONSULATAR");
		System.out.println("3.-MODIFICAR");
		System.out.println("4.-ELIMINAR");
		System.out.println("5.-Salir\n");
		System.out.print("\tIngresa una opcion:");
	}
	

}