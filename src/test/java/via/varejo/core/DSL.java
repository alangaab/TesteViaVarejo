package via.varejo.core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DSL {

	public void escrever(By by, String texto) {
		DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}

	public void escrever(String id_campo, String texto) {
		escrever(By.id(id_campo), texto);
	}

	public void clicar(By by, String id_campo) {
		DriverFactory.getDriver().findElement(by).click();
	}

	public void clicar(String id_campo) {
		clicar(By.id(id_campo), id_campo);
	}
	
	public void clicarXpath(By by, String xpath) {
		DriverFactory.getDriver().findElement(by).click();
	}
	public void clicarXpath(String xpath) {
		clicar(By.xpath(xpath), xpath);
	}
	
	public void clicarCssSelector(By by, String cssSelector) {
		DriverFactory.getDriver().findElement(by).click();
	}
	public void clicarCssSelector(String cssSelector) {
		clicar(By.cssSelector(cssSelector), cssSelector);
	}
	
	public void esperaExplicita(String propriedade) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions
				.visibilityOf(DriverFactory.getDriver().findElement(By.className(propriedade))));
	}
	
	public String recuperarPropriedade(String propriedade) {
		String textoValidacao = DriverFactory.getDriver().findElement(By.className(propriedade)).getText();
		return textoValidacao;
	}
	
	public void screenshot() throws IOException {
		File scrFile = ((TakesScreenshot)DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("screenshot.png"));
	}
}