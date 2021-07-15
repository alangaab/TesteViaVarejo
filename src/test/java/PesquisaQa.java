import static org.junit.Assert.assertEquals;

import java.io.IOException;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import via.varejo.core.DSL;
import via.varejo.core.DriverFactory;

public class PesquisaQa {

	String url;
	private DSL dsl;

	@Before
	public void iniciar() {
		url = "https://bit.ly/3jOMrR9";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\alan_\\eclipse-workspace\\PesquisaComQA\\drivers\\Chrome\\chromedriver.exe");
		DriverFactory.getDriver();
		dsl = new DSL();
		
	}

	@After
	public void finalizar() throws IOException {
		dsl.screenshot();
		DriverFactory.FinishDriver();
	}

	@Dado("^que eu acesse a pagina da VV Test$")
	public void que_eu_acesso_a_pagina_da_VV_Test() throws Throwable {
		DriverFactory.getDriver().get(url);

	}

	@E("^acesse o menu Pesquisa QA$")
	public void acesse_o_menu_Pesquisa_QA() throws Throwable {
		Thread.sleep(2000);
		dsl.clicarXpath("//a[@href='http://www.lourencodemonaco.com.br/vvtest/pesquisa/']");

	}

	@Quando("^eu preencher todos os campos obrigatorios$")
	public void eu_preencher_todos_os_campos_obrigatorios() throws Throwable {
		dsl.escrever("nf-field-5", "Alan");
		Thread.sleep(500);
		dsl.escrever("nf-field-6", "Gabriel");
		Thread.sleep(500);
		dsl.escrever("nf-field-7", "alangaab1@gmail.com");
		Thread.sleep(500);
		dsl.escrever("nf-field-8", "alangaab1@gmail.com");
		Thread.sleep(500);
		dsl.escrever("nf-field-17", "(11) 99671-1949");
		Thread.sleep(500);
		dsl.clicar("nf-label-class-field-10-1");
		Thread.sleep(500);
		dsl.clicarCssSelector("option[value='mais-de-5-anos']");
		Thread.sleep(500);
		dsl.clicarCssSelector("option[value='desafio']");
		Thread.sleep(500);
		dsl.clicar("nf-label-class-field-13-1");
		Thread.sleep(500);
		dsl.escrever("nf-field-14", "java");
		Thread.sleep(500);
		dsl.escrever("nf-field-15", "Entrar na empresa VIA VAREJO e auxiliar na Transformação Digital, "
						+ "promovendo Qualidade, processos Automatizados, Esteira Contínua, Shift Left, capacitando o time através de treinamentos, "
						+ "compartilhando informações, transformando o conhecimento tácito em explícito e Liderando com Excelência.");
		Thread.sleep(500);
		dsl.clicar("nf-field-16");
		dsl.esperaExplicita("nf-response-msg");
	}

	@Entao("^deve ser direcionado para uma pagina de sucesso$")
	public void deve_ser_direcionado_para_uma_pagina_de_sucesso() throws Throwable {
		String validacao = dsl.recuperarPropriedade("nf-response-msg");
		assertEquals("Your form has been successfully submitted.", validacao);
		Thread.sleep(1000);
	}
}
