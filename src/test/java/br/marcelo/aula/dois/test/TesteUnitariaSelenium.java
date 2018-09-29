package br.marcelo.aula.dois.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteUnitariaSelenium {
	
	@Test
	public void DeveValidarSeGravouMeuCadastro() {
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.4.103:8080/correntista/novo");
		WebElement campoNome = driver.findElement(By.name("nome"));
		WebElement campoEmail = driver.findElement(By.name("email"));
		WebElement botaoSalvar = driver.findElement(By.id("button1"));
		campoNome.sendKeys("Marcelo3");
		campoEmail.sendKeys("marcelotestem@gmail.com");
		botaoSalvar.click();
		//driver.close();

		assertTrue("Conteudo encontrado", driver.getPageSource().contains("Marcelo3"));
	}

}
