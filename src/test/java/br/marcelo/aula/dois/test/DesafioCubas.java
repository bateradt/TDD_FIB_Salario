package br.marcelo.aula.dois.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DesafioCubas {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\ChromeDriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://192.168.4.103:8080/correntista/novo");
		WebElement campoNome = driver.findElement(By.name("nome"));
		WebElement campoEmail = driver.findElement(By.name("email"));
		WebElement botaoSalvar = driver.findElement(By.id("button1"));
		campoNome.sendKeys("Marcelo Fernando Scarpim");
		campoEmail.sendKeys("marcelofscarpim@gmail.com");
		botaoSalvar.click();
		driver.close();
		
		//driver.getPageSource().contains("meu nome");
	
	}

}
