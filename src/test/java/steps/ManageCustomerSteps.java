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
	public void estarNaTelaDeListagemDeCliente() {
		System.out.println("Dado um usu�rio que se encontra na tela de listagem de cliente");
		DriverFactory.acessURL("https://www.grocerycrud.com/demo/bootstrap_theme");		
		Assert.assertTrue("Usu�rio n�o se encontra na tela de listagem de cliente",customerList.isCustomerListingPage());
	}

	@Dado("estando na versao do produto {string}")
	public void verificarVersaoDoProduto(String versao) {
	   System.out.println("E estando na vers�o do produto "+versao);
	   customerList.selectVersion4();
	}
	
	@Dado("um usuario que se encontra na pagina de criacao de um cliente")
	public void estarNaTelaCriacaoDeCliente() {
	    System.out.println("Dado um usu�rio que se encontra na p�gina de cria��o de um cliente");
	    Assert.assertTrue("Usu�rio n�o se encontra na p�gina de cria��o de cliente",customerAdd.isCustomerAdditionPage());
	}

	@Quando("clica no botao Add Customer")
	public void clicarBotaoAdicionarCliente() {
	    System.out.println("Quando clica no bot�o Add Customer");
	    customerList.clickAddCustomerButton();
	    customerAdd.isCustomerAdditionPage();
	}

	@Quando("preenche o campo Name do formulario com a informacao {string}")
	public void preencherCampoNome (String name) {
	    System.out.println("E preenche o campo Name do formul�rio com a informa��o "+name);
	    customerAdd.setName(name);
	}

	@Quando("preenche o campo LastName do formulario com a informacao {string}")
	public void preencherCampoSobrenome(String lastName) {
		System.out.println("E preenche o campo LastName do formul�rio com a informa��o "+lastName);
		customerAdd.setLastName(lastName);
	}

	@Quando("preenche o campo ContactFirstName do formulario com a informacao {string}")
	public void preencherCampoNomeDoContato(String contactFirstName) {
		System.out.println("E preenche o campo ContactFirstName do formul�rio com a informa��o "+contactFirstName);
		customerAdd.setContactFirstName(contactFirstName);;
	}

	@Quando("preenche o campo Phone do formulario com a informacao {string}")
	public void preencherCampoTelefone(String phone) {
		System.out.println("E preenche o campo Phone do formul�rio com a informa��o "+phone);
		customerAdd.setPhone(phone);
	}

	@Quando("preenche o campo AddressLine1 do formulario com a informacao {string}")
	public void preencherCampoEndereco1(String addressLine1) {
		System.out.println("E preenche o campo AddressLine1 do formul�rio com a informa��o "+addressLine1);
		customerAdd.setAddressLine1(addressLine1);
	}

	@Quando("preenche o campo AddressLine2 do formulario com a informacao {string}")
	public void preencherCampoEndereco2(String addressLine2) {
		System.out.println("E preenche o campo AddressLine2 do formul�rio com a informa��o "+addressLine2);
		customerAdd.setAddressLine2(addressLine2);
	}

	@Quando("preenche o campo City do formulario com a informacao {string}")
	public void preencherCampoCidade(String city) {
		System.out.println("E preenche o campo City do formul�rio com a informa��o "+city);
		customerAdd.setCity(city);
	}

	@Quando("preenche o campo State do formulario com a informacao {string}")
	public void preencherCampoEstado(String state) {
		System.out.println("E preenche o campo State do formul�rio com a informa��o "+state);
		customerAdd.setState(state);
	}

	@Quando("preenche o campo PostalCode do formulario com a informacao {string}")
	public void preencherCampoCodigoPostal(String postalCode) {
		System.out.println("E preenche o campo PostalCode do formul�rio com a informa��o "+postalCode);
		customerAdd.setPostalCode(postalCode);
	}

	@Quando("preenche o campo Country do formulario com a informacao {string}")
	public void preencherCampoPais(String country) {
		System.out.println("E preenche o campo Country do formul�rio com a informa��o "+country);
		customerAdd.setCountry(country);
	}

	@Quando("preenche o campo fromEmployeer do formulario com a informacao {string}")
	public void preencherCampoEmpregador(String fromEmployeer) {
		System.out.println("E preenche o campo fromEmployeer do formul�rio com a informa��o "+fromEmployeer);
		customerAdd.setFromEmployeer(fromEmployeer);
	}

	@Quando("preenche o campo CreditLimit do formulario com a informacao {string}")
	public void preencherCampoLimiteCredito(String creditLimit) {
		System.out.println("E preenche o campo CreditLimit do formul�rio com a informa��o "+creditLimit);
		customerAdd.setCreditLimit(creditLimit);
	}

	@Quando("clica no botao Save")
	public void clicarBotaoSalvar() {
		System.out.println("E clica no bot�o Save");
		customerAdd.clickSaveButton();
	}
	
	@Quando("clica no link de voltar para a lista")
	public void voltarParaTelaDeListagem() {
	    System.out.println("Quando clica no link de voltar para a lista");
	    customerAdd.goBackToList();
	}

	@Quando("pesquisa pelo campo Name o valor {string}")
	public void pesquisarNome(String name) {
	    System.out.println("E pesquisa pelo campo Name o valor "+name);
	    customerList.searchForName(name);
	}

	@Quando("seleciona o checkbox")
	public void selecionarCliente() {
	    System.out.println("E seleciona o checkbox");
	    customerList.selectCustomer();
	}

	@Quando("clica no botao Delete")
	public void clicarBotaoRemover() {
	    System.out.println("E clica no bot�o Delete");
	    customerList.clickDeleteButton();
	}

	@Quando("confirma remocao de cliente na popup")
	public void confirmarRemocaoCliente() {
	    System.out.println("E confirma remo��o de cliente na popup");
	    customerList.confirmDeletionCustomerPopup();
	}

	@Entao("aparece uma mensagem de dados armazenados com sucesso")
	public void validarMensagemDadosSalvos() {
	    System.out.println("Ent�o aparece uma mensagem de dados armazenados com sucesso");
	    Assert.assertTrue("ASSERT FAILED - N�o est� aparecendo mensagem de dados armazenados com sucesso", customerAdd.validateMessageCustomerAdded());
	}	

	@Entao("aparece mensagem de confirmacao de remocao")
	public void validarMensagemRemocao() {
	    System.out.println("Ent�o aparece mensagem de confirma��o de remo��o");
	    Assert.assertTrue("ASSERT FAILED - N�o est� aparecendo mensagem de confirma��o de remo��o", customerList.validateMessageCustomerDeleted());
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
