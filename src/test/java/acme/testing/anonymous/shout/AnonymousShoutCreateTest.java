package acme.testing.anonymous.shout;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.AcmeEndeavoursTest;

public class AnonymousShoutCreateTest extends AcmeEndeavoursTest{

	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createPositive(final int recordIndex, final String author, final String text, final String info) {
		
		// Accedemos al formulario
		super.clickOnMenu("Anonymous", "Create a shout");
		
		// Introducimos los datos
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		
		// Le damos al boton
		super.clickOnSubmitButton("Shout!");
		
		
	    super.clickOnMenu("Anonymous", "List recent shouts");
		
		// Comprobamos cada columna
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, text);
		super.checkColumnHasValue(recordIndex, 3, info);
		
		
	}
	
	/*
	 * En este test se va comprobar si cualquier anónimo no puede crear un shout
	 * se imponen las siguientes restricciones:
	 * 	-El campo autor debe contener entre 5 y 25 palabras
	 * 	-El campo autor no puede contener palabras spam
	 * 	-El campo autor no puede estar vacío
	 * 	-El campo texto no puede contener palabras spam
	 * 	-El campo texto no puede estar vacío
	 * 	-El campo texto puede contener como máximo 100 caracteres
	 */
	
	@ParameterizedTest
	@CsvFileSource(resources = "/anonymous/shout/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void createNegative(final int recodIndex, final String author, final String text, final String info) {
		
		super.clickOnMenu("Anonymous", "Create a shout");
		super.fillInputBoxIn("author", author);
		super.fillInputBoxIn("text", text);
		super.fillInputBoxIn("info", info);
		super.clickOnSubmitButton("Shout!");
		super.checkErrorsExist();
		
	
			
		}
	
}
