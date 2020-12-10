package com.roulette.application.util;

/**
 * This class is for application constants 
 * @author Nicolas Palacios Rios
 * @version 1.0
 *
 */
public class RouletteConstants {

	
	public static final String LINK_CREATE_ROULETTE = "/create_roulette";
	public static final String LINK_OPEN_ROULETTE = "/open_roulette/{idRoulette}";
	public static final String LINK_CREATE_BET = "/cretae-bet";
	public static final String LINK_CLOSE_ROULETTE = "/close-roulette/{idRoulette}";
	public static final String LINK_ROULETTE_LIST_WITH_STATUS = "/roulette-list-with-status";
	
	public static final String MESSAGE_VALIDATE_NUMBER_AND_COLOR_CONTROLLER = "Debe de ingresar un numero o un color, no un número y un color";
	public static final String MESSAGE_VALIDATE_OPEN_ROULETTE_CORRECT = "La ruleta se abrió correctamente";
	public static final String MESSAGE_VALIDATE_OPEN_ROULETTE_INCORRECT = "La apertura de la ruleta fue denegada";
	public static final String MESSAGE_CLOSE_ROULETTE_CORRECT = "La ruleta se cerro correctamente";
	public static final String MESSAGE_ROULETTE_NOT_FOUNT = "No se ha encontrado la ruleta seleccionada";
	public static final String MESSAGE_VALIDATE_NUMBER_AND_COLOR_SERVICE = "La apuesta no tiene los criterios requeridos, ingrese un numero del 0 al 36, o el color negro o rojo";
	public static final String MESSAGE_CLOSE_BET = "La ruleta está cerrada o la cantidad de dinero no está entre 0 y 10000";
	public static final String MESSAGE_CREATE_BET_CORRECT = "Se ha creado la apuesta correctamente";

	public static final String CONSTANT_OPEN = "open";
	public static final String CONSTANT_CLOSE = "close";
	public static final String CONSTANT_BLACK = "negro";
	public static final String CONSTANT_RED = "rojo";	

}
