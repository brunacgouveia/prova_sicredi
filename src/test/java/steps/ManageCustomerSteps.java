package steps;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.tools.ant.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import driver.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

import pages.CustomerAddPage;
import pages.CustomerListPage;


public class ManageCustomerSteps {
	
	private CustomerListPage customerList = new CustomerListPage();
	private CustomerAddPage customerAdd = new CustomerAddPage();
	
	@Dado("um usuario que se encontra na tela de listagem de cliente")
	public void um_usuario_que_se_encontra_na_tela_de_listagem_de_cliente() {
		System.out.println("Dado um usuário que se encontra na tela de listagem de cliente");
		DriverFactory.acessarURL("https://www.grocerycrud.com/demo/bootstrap_theme");		
		Assert.assertTrue("Usuário não se encontra na tela de listagem de cliente",customerList.isPaginaDeListagem());
	}

	@Dado("estando na versao do produto {string}")
	public void estando_na_versao_do_produto(String versao) {
	   System.out.println("E estando na versão do produto "+versao);
	   customerList.selecionarVersao4();
	}
	
	@Dado("um usuario que se encontra na pagina de criacao de um cliente")
	public void um_usuario_que_se_encontra_na_pagina_de_criacao_de_um_cliente() {
	    System.out.println("Dado um usuário que se encontra na página de criação de um cliente");
	    Assert.assertTrue("Usuário não se encontra na página de criação de cliente",customerAdd.isPaginaDeCriacao());
	}

	@Quando("clica no botao Add Customer")
	public void clica_no_botao_Add_Customer() {
	    System.out.println("Quando clica no botão Add Customer");
	    customerList.clicarBotaoAddCustomer();
	    customerAdd.isPaginaDeCriacao();
	}

	@Quando("preenche o campo Name do formulario com a informacao {string}")
	public void preenche_o_campo_Name_do_formulario_com_a_informacao(String name) {
	    System.out.println("E preenche o campo Name do formulário com a informação "+name);
	    customerAdd.preencherCampoName(name);
	}

	@Quando("preenche o campo LastName do formulario com a informacao {string}")
	public void preenche_o_campo_LastName_do_formulario_com_a_informacao(String lastName) {
		System.out.println("E preenche o campo LastName do formulário com a informação "+lastName);
		customerAdd.preencherCampoLastName(lastName);
	}

	@Quando("preenche o campo ContactFirstName do formulario com a informacao {string}")
	public void preenche_o_campo_ContactFirstName_do_formulario_com_a_informacao(String contactFirstName) {
		System.out.println("E preenche o campo ContactFirstName do formulário com a informação "+contactFirstName);
		customerAdd.preencherCampoContactFirstName(contactFirstName);;
	}

	@Quando("preenche o campo Phone do formulario com a informacao {string}")
	public void preenche_o_campo_Phone_do_formulario_com_a_informacao(String phone) {
		System.out.println("E preenche o campo Phone do formulário com a informação "+phone);
		customerAdd.preencherCampoPhone(phone);
	}

	@Quando("preenche o campo AddressLine1 do formulario com a informacao {string}")
	public void preenche_o_campo_AddressLine1_do_formulario_com_a_informacao(String addressLine1) {
		System.out.println("E preenche o campo AddressLine1 do formulário com a informação "+addressLine1);
		customerAdd.preencherCampoAddressLine1(addressLine1);
	}

	@Quando("preenche o campo AddressLine2 do formulario com a informacao {string}")
	public void preenche_o_campo_AddressLine2_do_formulario_com_a_informacao(String addressLine2) {
		System.out.println("E preenche o campo AddressLine2 do formulário com a informação "+addressLine2);
		customerAdd.preencherCampoAddressLine2(addressLine2);
	}

	@Quando("preenche o campo City do formulario com a informacao {string}")
	public void preenche_o_campo_City_do_formulario_com_a_informacao(String city) {
		System.out.println("E preenche o campo City do formulário com a informação "+city);
		customerAdd.preencherCampoCity(city);
	}

	@Quando("preenche o campo State do formulario com a informacao {string}")
	public void preenche_o_campo_State_do_formulario_com_a_informacao(String state) {
		System.out.println("E preenche o campo State do formulário com a informação "+state);
		customerAdd.preencherCampoState(state);
	}

	@Quando("preenche o campo PostalCode do formulario com a informacao {string}")
	public void preenche_o_campo_PostalCode_do_formulario_com_a_informacao(String postalCode) {
		System.out.println("E preenche o campo PostalCode do formulário com a informação "+postalCode);
		customerAdd.preencherCampoPostalCode(postalCode);
	}

	@Quando("preenche o campo Country do formulario com a informacao {string}")
	public void preenche_o_campo_Country_do_formulario_com_a_informacao(String country) {
		System.out.println("E preenche o campo Country do formulário com a informação "+country);
		customerAdd.preencherCampoCountry(country);
	}

	@Quando("preenche o campo fromEmployeer do formulario com a informacao {string}")
	public void preenche_o_campo_fromEmployeer_do_formulario_com_a_informacao(String fromEmployeer) {
		System.out.println("E preenche o campo fromEmployeer do formulário com a informação "+fromEmployeer);
		customerAdd.preencherCampoFromEmployeer(fromEmployeer);
	}

	@Quando("preenche o campo CreditLimit do formulario com a informacao {string}")
	public void preenche_o_campo_CreditLimit_do_formulario_com_a_informacao(String creditLimit) {
		System.out.println("E preenche o campo CreditLimit do formulário com a informação "+creditLimit);
		customerAdd.preencherCampoCreditLimit(creditLimit);
	}

	@Quando("clica no botao Save")
	public void clica_no_botao_Save() {
		System.out.println("E clica no botão Save");
		customerAdd.clicarBotaoSave();
	}
	
	@Quando("clica no link de voltar para a lista")
	public void clica_no_link_de_voltar_para_a_lista() {
	    System.out.println("Quando clica no link de voltar para a lista");
	    customerAdd.goBackToList();
	}

	@Quando("pesquisa pelo campo Name o valor {string}")
	public void pesquisa_pelo_campo_Name_o_valor(String name) {
	    System.out.println("E pesquisa pelo campo Name o valor "+name);
	    customerList.preencherCampoPesquisaName(name);
	}

	@Quando("seleciona o checkbox")
	public void seleciona_o_checkbox() {
	    System.out.println("E seleciona o checkbox");
	    customerList.selecionarCustomer();
	}

	@Quando("clica no botao Delete")
	public void clica_no_botao_Delete() {
	    System.out.println("E clica no botão Delete");
	    customerList.clicarBotaoDelete();
	}

	@Quando("confirma remocao de cliente na popup")
	public void confirma_remocao_de_cliente_na_popup() {
	    System.out.println("E confirma remoção de cliente na popup");
	    customerList.confirmarRemocaoClientePopup();
	}

	@Entao("aparece uma mensagem de dados armazenados com sucesso")
	public void aparece_uma_mensagem_de_dados_armazenados_com_sucesso() {
	    System.out.println("Então aparece uma mensagem de dados armazenados com sucesso");
	    Assert.assertTrue("ASSERT FAILED - Não está aparecendo mensagem de dados armazenados com sucesso", customerAdd.validarMensagemCustomerAdicionado());
	}	

	@Entao("aparece mensagem de confirmacao de remocao")
	public void aparece_mensagem_de_confirmacao_de_remocao() {
	    System.out.println("Então aparece mensagem de confirmação de remoção");
	    Assert.assertTrue("ASSERT FAILED - Não está aparecendo mensagem de confirmação de remoção", customerList.validarMensagemRemocaoCliente());
	}
	
	
	@After
	public void saveScreenshot(){	    
		System.out.println("Salvando screenshot...");	
		
		String date = new SimpleDateFormat("yy-MM-dd_HH-mm-ss").format(new Date());		
		try { 
			TakesScreenshot screenshot = (TakesScreenshot)DriverFactory.getDriver();
			File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
			File tgtFile = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\images\\customer_screenshot_" + date + ".png");

			FileUtils.getFileUtils().copyFile(srcFile, tgtFile); 
		} catch(Exception e) { 
			System.out.println(e);
		}		 				
	}

}
