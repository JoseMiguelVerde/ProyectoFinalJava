import Entidades.Deducciones;
import Entidades.Empleado;
import Entidades.Gerente;
import Entidades.Percepciones;
import Utilidades.Constantes;
import Utilidades.Constantes.BuscarPor;
import Utilidades.Constantes.Deduccion;
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
		String opcion, nombreCompletoEmpleado, rfc,codigoPostal, curp, direccion, fechaDeNacimiento, puesto, genero,idEmpleado, estatus, percepcion, deduccion;
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
												System.out.println(Constantes.ALTA_EMPLEADO);
												System.out.println(Constantes.NOMBRE_COMPLETO);
												nombreCompletoEmpleado=leer.nextLine();
												if(validar.nombre(nombreCompletoEmpleado)) {
													do {
														System.out.println(Constantes.CURP);
														curp=leer.nextLine();
														if(validar.validarCurp(curp)) {
															if(!validar.validaCurpUnico(curp)) {
																do {
																	System.out.println(Constantes.RFC);
																	rfc=leer.nextLine();
																	if(validar.validarRfc(rfc)) {
																		if(!validar.validaRfcUnico(rfc)) {
																			do {
																				System.out.println(Constantes.FECHA_DE_NACIMIENTO);
																				fechaDeNacimiento=leer.nextLine();
																				if(validar.validarFecha(fechaDeNacimiento)) {
																					do {
																						System.out.println(Constantes.DIRECCION);
																						direccion =leer.nextLine();
																						if(validar.direccion(direccion)) {
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
																													if(manipulacionArchivos.guardaEmpleado(new Empleado(nombreCompletoEmpleado,(Integer.parseInt(puesto)==1?Puesto.EMPLEADO:Puesto.GERENTE),rfc,  curp,  direccion, (Integer.parseInt(genero)==1?Generos.MASCULINO:Generos.FEMENINO), LocalDate.parse(fechaDeNacimiento, Constantes.FORMATO_FECHA_NACIMIENTO),  Integer.parseInt(codigoPostal)))) {
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
																					System.out.println(Constantes.FECHA_DE_NACIMIENTO_EQUIVOCADA);
																					ciclo=true;
																				}
																			}while(ciclo);
																		}else {
																			System.out.println(Constantes.RFC_EXISTENTE);
																			ciclo=true;
																		}
																	}else {
																		System.out.println(Constantes.RFC_EQUIVOCADA);
																		ciclo=true;
																	}
																}while(ciclo);
															}else {
																System.out.println(Constantes.CURP_EXISTENTE);
																ciclo=true;
															}
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
											if(validar.contenidoDeArchivoEmpleados()){
												do {
													System.out.println(Constantes.BAJA_EMPLEADO);
													opcion=leer.nextLine();
													if(validar.validarEntero(opcion)) {
														if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=2) {
															switch(Integer.parseInt(opcion))
															{
															case 1:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 8, Estatus.BAJA.getEstatus())) {
																			System.out.println(Constantes.ELIMINADO);
																			ciclo=false;
																		}else {
																			System.out.println(Constantes.NO_ELIMINADO);
																			ciclo=false;
																		}
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																}while(ciclo);
																
																break;
															case 2:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		if(manipulacionArchivos.bajaEmpleadoPorIdFisica(Integer.parseInt(idEmpleado))) {
																			System.out.println(Constantes.ELIMINADO);
																			ciclo=false;
																		}else {
																			System.out.println(Constantes.NO_ELIMINADO);
																			ciclo=false;
																		}
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																}while(ciclo);
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
											}else {
												System.out.println(Constantes.NO_HAY_DATOS);
												ciclo=false;
											}
											break;
										case 3:
											if(validar.contenidoDeArchivoEmpleados()){
												do {
													System.out.println(Constantes.MODIFICAR_EMPLEADO);
													opcion=leer.nextLine();
													if(validar.validarEntero(opcion)) {
														if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=8) {
															switch(Integer.parseInt(opcion))
															{
															case 1:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.NOMBRE_COMPLETO);
																			nombreCompletoEmpleado=leer.nextLine();
																			if(validar.nombre(nombreCompletoEmpleado)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 1, nombreCompletoEmpleado)) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}
																			}else {
																				System.out.println(Constantes.NOMBRE_EQUIVOCADO);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																}while(ciclo);
																break;
															case 2:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.PUESTO);
																			puesto=leer.nextLine();												
																			if(validar.puestoYGenero(puesto)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 2, (Integer.parseInt(puesto)==1?Puesto.EMPLEADO:Puesto.GERENTE).getPuesto())) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}
																				
																				
																			}else {
																				System.out.println(Constantes.OPCION_INVALIDA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																}while(ciclo);	
																break;
															case 3:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.RFC);
																			rfc=leer.nextLine();
																			if(validar.validarRfc(rfc)) {
																				if(!validar.validaRfcUnico(rfc)) {
																					if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 4, rfc)) {
																						System.out.println(Constantes.EDITADO);
																						ciclo=false;
																					}else {
																						System.out.println(Constantes.NO_EDITADO);
																						ciclo=false;
																					}	
																							
																						
																				}else {
																					System.out.println(Constantes.RFC_EXISTENTE);
																					ciclo=true;
																				}
																			}else {
																				System.out.println(Constantes.RFC_EQUIVOCADA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
																
																break;
															case 4:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.CURP);
																			curp=leer.nextLine();
																			if(validar.validarCurp(curp)) {
																				if(!validar.validaCurpUnico(curp)) {
																					if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 5, curp)) {
																						System.out.println(Constantes.EDITADO);
																						ciclo=false;
																					}else {
																						System.out.println(Constantes.NO_EDITADO);
																						ciclo=false;
																					}	
																				}else {
																					System.out.println(Constantes.CURP_EXISTENTE);
																					ciclo=true;
																				}
																			}else {
																				System.out.println(Constantes.CURP_EQUIVOCADA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
																break;
															case 5:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.DIRECCION);
																			direccion=leer.nextLine();
																			if(validar.direccion(direccion)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 6, direccion)) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}	
																					
																				
																			}else {
																				System.out.println(Constantes.DIRECCION_EQUIVOCADA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
																break;
															case 6:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.CODIGO_POSTAL);
																			codigoPostal=leer.nextLine();
																			if(validar.codigoPostal(codigoPostal)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 7, codigoPostal)) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}	
																			}else {
																				System.out.println(Constantes.CODIGO_POSTAL_EQUIVOCADA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
																break;
															case 7:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.GENERO);
																			genero=leer.nextLine();
																			if(validar.puestoYGenero(genero)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 8,  (Integer.parseInt(genero)==1?Generos.MASCULINO:Generos.FEMENINO).getNombreGenero())) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}
																				
																			}else {
																				System.out.println(Constantes.OPCION_INVALIDA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
																break;
															case 8:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		do {
																			System.out.println(Constantes.FECHA_DE_NACIMIENTO);
																			fechaDeNacimiento=leer.nextLine();
																			if(validar.validarFecha(fechaDeNacimiento)) {
																				if(manipulacionArchivos.modificarPorIdEmpleado(Integer.parseInt(idEmpleado), 10, fechaDeNacimiento )) {
																					System.out.println(Constantes.EDITADO);
																					ciclo=false;
																				}else {
																					System.out.println(Constantes.NO_EDITADO);
																					ciclo=false;
																				}
																			}else {
																				System.out.println(Constantes.FECHA_DE_NACIMIENTO_EQUIVOCADA);
																				ciclo=true;
																			}
																		}while(ciclo);
																		
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																	
																}while(ciclo);
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
											}else {
												System.out.println(Constantes.NO_HAY_DATOS);
												ciclo=false;
											}
											
											break;
										case 4:
											if(validar.contenidoDeArchivoEmpleados()){
												do {
													System.out.println(Constantes.CONSULTAR_EMPLEADO);
													opcion=leer.nextLine();
													if(validar.validarEntero(opcion)) {
														if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=6) {
															switch(Integer.parseInt(opcion))
															{
															case 1:
																do {
																	System.out.println(Constantes.DAME_ID_EMPLEADO);
																	idEmpleado=leer.nextLine();
																	if(validar.validarEntero(idEmpleado)) {
																		System.out.println(manipulacionArchivos.mostrar(manipulacionArchivos.buscarEnListaEmpleados(BuscarPor.ID, idEmpleado), 1));
																		ciclo=false;
																	}else {
																		System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
																		ciclo=true;
																	}
																}while(ciclo);
																
																break;
															case 2:
																do {
																	System.out.println(Constantes.NOMBRE_COMPLETO);
																	nombreCompletoEmpleado=leer.nextLine();
																	if(validar.nombre(nombreCompletoEmpleado)) {
																		System.out.println(manipulacionArchivos.mostrar(manipulacionArchivos.buscarEnListaEmpleados(BuscarPor.NOMBRE, nombreCompletoEmpleado), 1));
																		ciclo=false;
																	}else {
																		System.out.println(Constantes.NOMBRE_EQUIVOCADO);
																		ciclo=true;
																	}
																}while(ciclo);
																break;
															case 3:
																do {
																	System.out.println(Constantes.PUESTO);
																	puesto=leer.nextLine();												
																	if(validar.puestoYGenero(puesto)) {
																		System.out.println(manipulacionArchivos.mostrar(manipulacionArchivos.buscarEnListaEmpleados(BuscarPor.PUESTO, (Integer.parseInt(puesto)==1?Puesto.EMPLEADO:Puesto.GERENTE).getPuesto()), 1));
																		ciclo=false;
																	}else {
																		System.out.println(Constantes.OPCION_INVALIDA);
																		ciclo=true;
																	}
																}while(ciclo);
																break;
															case 4:
																do {
																	System.out.println(Constantes.GENERO);
																	genero=leer.nextLine();
																	if(validar.puestoYGenero(genero)) {
																		System.out.println(manipulacionArchivos.mostrar(manipulacionArchivos.buscarEnListaEmpleados(BuscarPor.GENERO, (Integer.parseInt(genero)==1?Generos.MASCULINO:Generos.FEMENINO).getNombreGenero()), 1));
																		ciclo=false;
																	}else {
																		System.out.println(Constantes.OPCION_INVALIDA);
																		ciclo=true;
																	}
																}while(ciclo);
																break;
															case 5:
																do {
																	System.out.println(Constantes.ESTATUS);
																	estatus=leer.nextLine();
																	if(validar.puestoYGenero(estatus)) {
																		System.out.println(manipulacionArchivos.mostrar(manipulacionArchivos.buscarEnListaEmpleados(BuscarPor.ESTATUS, (Integer.parseInt(estatus)==1?Estatus.ACTIVO.getEstatus():Estatus.BAJA.getEstatus())), 1));
																		ciclo=false;
																	}else {
																		System.out.println(Constantes.OPCION_INVALIDA);
																		ciclo=true;
																	}
																}while(ciclo);
																break;
															case 6:
																System.out.println(manipulacionArchivos.mostrarTodosEmpledos());
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
											}else {
												System.out.println(Constantes.NO_HAY_DATOS);
												ciclo=false;
											}
											
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
											if(validar.contenidoDeArchivoEmpleados()){
												do {
													System.out.println(Constantes.AGREGAR_DEDUCCIONES);
													idEmpleado=leer.nextLine();
													if(validar.validarEntero(idEmpleado)) {
														do{
															System.out.println(Constantes.TIPOS_DEDUCCIONES);
															deduccion=leer.nextLine();
															if(validar.deduccionYPercepcionOpcion(deduccion)) {
																if(manipulacionArchivos.agregarDeduccion(new Deducciones(Integer.parseInt(idEmpleado),(Integer.parseInt(deduccion)==1?Deduccion.FORMACION_PROFESIONAL:(Integer.parseInt(deduccion)==2?Deduccion.CONTINGENCIA_COMUN:Deduccion.SEGURO_MEDICO))))) {
																	System.out.println(Constantes.AGREGADO);	
																	ciclo=false;
																}else {
																	System.out.println(Constantes.NO_AGREGADO);
																	ciclo=false;
																}
															}else {
																System.out.println(Constantes.OPCION_INVALIDA);
																ciclo=true;
															}
														}while(ciclo);
														
														

													}else {
														System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
														ciclo=true;
													}
													
												}while(ciclo);
											}else {
												System.out.println(Constantes.NO_HAY_DATOS);
												ciclo=false;
											}
											
											break;
										case 2:
											if(validar.contenidoDeArchivoEmpleados()){
												do {
													System.out.println(Constantes.AGREGAR_DEDUCCIONES);
													opcion=leer.nextLine();
													if(validar.validarEntero(opcion)) {
														if(Integer.parseInt(opcion)>=1 && Integer.parseInt(opcion)<=6) {
															switch(Integer.parseInt(opcion))
															{
															
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
											}else {
												System.out.println(Constantes.NO_HAY_DATOS);
												ciclo=false;
											}
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
							if(validar.contenidoDeArchivoEmpleados()) {
								do {
									System.out.println(Constantes.DAME_ID_EMPLEADO);
									idEmpleado=leer.nextLine();
									if(validar.validarEntero(idEmpleado)) {
										if(manipulacionArchivos.mostrarNominaPorEmpleado(Integer.parseInt(idEmpleado))) {
											manipulacionArchivos.mostrarNominaPorEmpleadoEnConsola(Integer.parseInt(idEmpleado));
											ciclo=false;
										}else {
											System.out.println(Constantes.ERROR_AL_CREAR_NOMINA);
											ciclo=false;
										}
									}else {
										System.out.println(Constantes.INGRESAR_VALOR_NUMERICO);
										ciclo=true;
									}
									
								}while(ciclo);
							}else {
								System.out.println(Constantes.NO_HAY_DATOS);
								ciclo=false;
							}
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
