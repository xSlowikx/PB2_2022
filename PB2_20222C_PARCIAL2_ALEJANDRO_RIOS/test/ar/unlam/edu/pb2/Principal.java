package ar.unlam.edu.pb2;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**System.out.println("Ingrese un caracter: ");
		Scanner ingresoTeclado = new Scanner(System.in);
		char caracterIngresado = (char) ingresoTeclado.next().charAt(0);
		ingresoTeclado.close();

		caracterIngresado = Character.toLowerCase(caracterIngresado);
		if (caracterIngresado == 'a' || caracterIngresado == 'e' || caracterIngresado == 'i' || caracterIngresado == 'o'
				|| caracterIngresado == 'u') {

			System.out.println("VOCAL");
			System.out.println("El caracter es:\t" + (int) caracterIngresado);
		} else {
			System.out.println("Lo ingresado no es una vocal");
		}
		 */
		
		//--------------------------------------------------------------------------------------------------------//
		
		/*System.out.println("1 PARA GRADOS\n 2 PARA RADIANES");
		System.out.println("Ingrese un codigo: ");
		Scanner ingresoTeclado = new Scanner(System.in);
		int codigoSeleccionado = ingresoTeclado.nextInt();
		if(codigoSeleccionado == 1) {
			System.out.println("Ingrese grados");
			double gradosObtenidos = ingresoTeclado.nextDouble();
			System.out.println("Sus grados expresados en radianes es: " + (Math.PI/180) * gradosObtenidos);
		} else if (codigoSeleccionado == 2) {
			System.out.println("Ingrese radianes");
			double radianesObtenidos = ingresoTeclado.nextDouble();
			System.out.println("Sus radianes expresados en grados es: " + (180/Math.PI) * radianesObtenidos);
		}*/
		
		// ---------------------------------------------------------------------------------------------------------------------------------------------------------------//		
		
		System.out.println("Ingrese horas trabajadas: ");
		Scanner ingresoTeclado = new Scanner(System.in);
		int horasTrabajadas = ingresoTeclado.nextInt();
		System.out.println("Ingrese valor hora: ");
		Scanner ingresoTeclado2 = new Scanner(System.in);
		double valorHora = ingresoTeclado.nextDouble();
		
		if (horasTrabajadas > 150) {
			int adicional = 1500;
			System.out.println("La remuneracion es:\t" + (double) (horasTrabajadas * valorHora + adicional));
		} else if (horasTrabajadas > 50) {
			int adicional = 500;
			System.out.println("La remuneracion es:\t" + (double) (horasTrabajadas * valorHora + adicional));
		}
		
	}
}
