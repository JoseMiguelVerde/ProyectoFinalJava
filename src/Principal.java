import Entidades.Empleado;
import Entidades.Gerente;
import Entidades.Percepciones;
import Utilidades.Constantes;
import Utilidades.Constantes.BuscarPor;
import Utilidades.Constantes.Estatus;
import Utilidades.Constantes.Generos;
import Utilidades.Constantes.Puesto;
import Utilidades.Validaciones;
import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.util.Scanner;

import Datos.Archivos;
public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner leer=new Scanner(System.in);
		String opcion, nombreCompletoEmpleado, rfc,codigoPostal, curp, direccion, fechaDeNacimiento, puesto, genero;
		boolean ciclo=false;
		Validaciones validar=new Validaciones();
		Archivos manipulacionArchivos= new Archivos();
		System.out.println(Constantes.BIENVENIDO);
		do {
			System.out.println(Constantes.MENU_INICIAL);
			opcion=leer.nextLine();
			if(validar.validarEntero(opcion)) {
				if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
					switch(Integer.parseInt(opcion))
					{
						case 1:
							do {
							
								System.out.println(Constantes.MENU_EMPLEADOS);
								opcion=leer.nextLine();
								if(validar.validarEntero(opcion)) {
									if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
										switch(Integer.parseInt(opcion))
										{
										case 1:
											do {
												System.out.println(Constantes.NOMBRE_COMPLETO);
												nombreCompletoEmpleado=leer.nextLine();
												if(validar.nombreYDireccion(nombreCompletoEmpleado)) {
													do {
														System.out.println(Constantes.CURP);
														curp=leer.nextLine();
														if(validar.validarCurp(curp)) {
															do {
																System.out.println(Constantes.RFC);
																rfc=leer.nextLine();
																if(validar.validarRfc(rfc)) {
																	do {
																		System.out.println(Constantes.FECHA_DE_NACIMIENTO);
																		fechaDeNacimiento=leer.nextLine();
																		if(validar.fechaDeNacimiento(fechaDeNacimiento)) {
																			do {
																				System.out.println(Constantes.DIRECCION);
																				direccion =leer.nextLine();
																				if(validar.nombreYDireccion(direccion)) {
																					do {
																						System.out.println(Constantes.CODIGO_POSTAL);
																						codigoPostal =leer.nextLine();
																						if(validar.codigoPostal(codigoPostal)) {
																							do {
																								System.out.println(Constantes.PUESTO);
																								puesto =leer.nextLine();
																								if(validar.puestoYGenero(puesto)) {
																									do {
																										System.out.println(Constantes.GENERO);
																										genero =leer.nextLine();
																										if(validar.puestoYGenero(genero)) {
																											if(manipulacion.guardaEmpleado(new Empleado(nombreCompletoEmpleado,(Integer.parseInt(puesto)==1?Puesto.EMPLEADO:Puesto.GERENTE),rfc,  curp,  direccion, (Integer.parseInt(genero)==1?Generos.MASCULINO:Generos.FEMENINO), LocalDate.parse(fechaDeNacimiento, Constantes.FORMATO_FECHA_NACIMIENTO),  Integer.parseInt(codigoPostal))) && manipulacionArchivos.guardaEmpleado(new Empleado(nombreCompletoEmpleado,(Integer.parseInt(puesto)==1?Puesto.EMPLEADO:Puesto.GERENTE),rfc,  curp,  direccion, (Integer.parseInt(genero)==1?Generos.MASCULINO:Generos.FEMENINO), LocalDate.parse(fechaDeNacimiento, Constantes.FORMATO_FECHA_NACIMIENTO),  Integer.parseInt(codigoPostal)))) {
																												System.out.println(Constantes.INSERTADO);	
																												ciclo=false;
																											}else {
																												System.out.println(Constantes.NO_INSERTADO);
																												ciclo=false;
																											}
																										}else {
																											System.out.println(Constantes.OPCION_INVALIDA);
																											ciclo=true;
																										}
																									}while(ciclo);
																								}else {
																									System.out.println(Constantes.OPCION_INVALIDA);
																									ciclo=true;
																								}
																							}while(ciclo);
																						}else {
																							System.out.println(Constantes.CODIGO_POSTAL_EQUIVOCADA);
																							ciclo=true;
																						}
																					}while(ciclo);
																				}else {
																					System.out.println(Constantes.DIRECCION_EQUIVOCADA);
																					ciclo=true;
																				}
																			}while(ciclo);
																		}else {
																			System.out.println(Constantes.FECHA_DE_NACIMIENTO);
																			ciclo=true;
																		}
																	}while(ciclo);
																}else {
																	System.out.println(Constantes.RFC_EQUIVOCADA);
																	ciclo=true;
																}
															}while(ciclo);
														}else {
															System.out.println(Constantes.CURP_EQUIVOCADA);
															ciclo=true;
														}
													}while(ciclo);
												}else {
													System.out.println(Constantes.NOMBRE_EQUIVOCADO);
													ciclo=true;
												}
											}while(ciclo);
											break;
										case 2:
											break;
										case 3:
											break;
										case 4:
											break;
										}
									}else {
										System.out.println(Constantes.OPCION_INVALIDA);
										ciclo=true;
									}
								}else {
									System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
									ciclo=true;
								}
							}while(ciclo);
							break;
						case 2:
							do {
								
								System.out.println(Constantes.MENU_DEDUCCIONES);
								opcion=leer.nextLine();
								if(validar.validarEntero(opcion)) {
									if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
										switch(Integer.parseInt(opcion))
										{
										case 1:
											break;
										case 2:
											break;
										case 3:
											break;
										case 4:
											break;
										}
									}else {
										System.out.println(Constantes.OPCION_INVALIDA);
										ciclo=true;
									}
								}else {
									System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
									ciclo=true;
								}
							}while(ciclo);
							break;
						case 3:
							do {
								
								System.out.println(Constantes.MENU_PERCEPCIONES);
								opcion=leer.nextLine();
								if(validar.validarEntero(opcion)) {
									if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=4) {
										switch(Integer.parseInt(opcion))
										{
										case 1:
											break;
										case 2:
											break;
										case 3:
											break;
										case 4:
											break;
										}
									}else {
										System.out.println(Constantes.OPCION_INVALIDA);
										ciclo=true;
									}
								}else {
									System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
									ciclo=true;
								}
							}while(ciclo);
							break;
						case 4:
							
							break;
									
					}
					System.out.println(Constantes.VOLVER_AL_MENU);
					opcion = leer.nextLine();			
					if (validar.validarEntero(opcion) == true && Integer.parseInt(opcion)== 1) 
					{
						ciclo = true;
					}
					else
					{
						System.out.println(Constantes.DESPEDIDA);
						ciclo = false;
					}
				}else {
					if(Integer.parseInt(opcion)==5) {
						System.out.println(Constantes.DESPEDIDA);
						ciclo=false;
					}else {
						System.out.println(Constantes.OPCION_INVALIDA);
						ciclo=true;
					}
				}
			}else {
				System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
				ciclo=true;
			}
		}while(ciclo);
		leer.close();
		
	}

}
