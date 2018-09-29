package br.marcelo.aula.dois.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteAutomatizado {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tdp.com.br");
		WebElement campoDeTexto = driver.findElement(By.name("pesquisar"));
		campoDeTexto.sendKeys("Setup");
		campoDeTexto.submit();
	}

}
