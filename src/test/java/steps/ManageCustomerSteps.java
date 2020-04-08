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
		System.out.println("Dado um usuário que se encontra na tela de listagem de cliente");
		DriverFactory.acessURL("https://www.grocerycrud.com/demo/bootstrap_theme");		
		Assert.assertTrue("Usuário não se encontra na tela de listagem de cliente",customerList.isCustomerListingPage());
	}

	@Dado("estando na versao do produto {string}")
	public void verificarVersaoDoProduto(String versao) {
	   System.out.println("E estando na versão do produto "+versao);
	   customerList.selectVersion4();
	}
	
	@Dado("um usuario que se encontra na pagina de criacao de um cliente")
	public void estarNaTelaCriacaoDeCliente() {
	    System.out.println("Dado um usuário que se encontra na página de criação de um cliente");
	    Assert.assertTrue("Usuário não se encontra na página de criação de cliente",customerAdd.isCustomerAdditionPage());
	}

	@Quando("clica no botao Add Customer")
	public void clicarBotaoAdicionarCliente() {
	    System.out.println("Quando clica no botão Add Customer");
	    customerList.clickAddCustomerButton();
	    customerAdd.isCustomerAdditionPage();
	}

	@Quando("preenche o campo Name do formulario com a informacao {string}")
	public void preencherCampoNome (String name) {
	    System.out.println("E preenche o campo Name do formulário com a informação "+name);
	    customerAdd.setName(name);
	}

	@Quando("preenche o campo LastName do formulario com a informacao {string}")
	public void preencherCampoSobrenome(String lastName) {
		System.out.println("E preenche o campo LastName do formulário com a informação "+lastName);
		customerAdd.setLastName(lastName);
	}

	@Quando("preenche o campo ContactFirstName do formulario com a informacao {string}")
	public void preencherCampoNomeDoContato(String contactFirstName) {
		System.out.println("E preenche o campo ContactFirstName do formulário com a informação "+contactFirstName);
		customerAdd.setContactFirstName(contactFirstName);;
	}

	@Quando("preenche o campo Phone do formulario com a informacao {string}")
	public void preencherCampoTelefone(String phone) {
		System.out.println("E preenche o campo Phone do formulário com a informação "+phone);
		customerAdd.setPhone(phone);
	}

	@Quando("preenche o campo AddressLine1 do formulario com a informacao {string}")
	public void preencherCampoEndereco1(String addressLine1) {
		System.out.println("E preenche o campo AddressLine1 do formulário com a informação "+addressLine1);
		customerAdd.setAddressLine1(addressLine1);
	}

	@Quando("preenche o campo AddressLine2 do formulario com a informacao {string}")
	public void preencherCampoEndereco2(String addressLine2) {
		System.out.println("E preenche o campo AddressLine2 do formulário com a informação "+addressLine2);
		customerAdd.setAddressLine2(addressLine2);
	}

	@Quando("preenche o campo City do formulario com a informacao {string}")
	public void preencherCampoCidade(String city) {
		System.out.println("E preenche o campo City do formulário com a informação "+city);
		customerAdd.setCity(city);
	}

	@Quando("preenche o campo State do formulario com a informacao {string}")
	public void preencherCampoEstado(String state) {
		System.out.println("E preenche o campo State do formulário com a informação "+state);
		customerAdd.setState(state);
	}

	@Quando("preenche o campo PostalCode do formulario com a informacao {string}")
	public void preencherCampoCodigoPostal(String postalCode) {
		System.out.println("E preenche o campo PostalCode do formulário com a informação "+postalCode);
		customerAdd.setPostalCode(postalCode);
	}

	@Quando("preenche o campo Country do formulario com a informacao {string}")
	public void preencherCampoPais(String country) {
		System.out.println("E preenche o campo Country do formulário com a informação "+country);
		customerAdd.setCountry(country);
	}

	@Quando("preenche o campo fromEmployeer do formulario com a informacao {string}")
	public void preencherCampoEmpregador(String fromEmployeer) {
		System.out.println("E preenche o campo fromEmployeer do formulário com a informação "+fromEmployeer);
		customerAdd.setFromEmployeer(fromEmployeer);
	}

	@Quando("preenche o campo CreditLimit do formulario com a informacao {string}")
	public void preencherCampoLimiteCredito(String creditLimit) {
		System.out.println("E preenche o campo CreditLimit do formulário com a informação "+creditLimit);
		customerAdd.setCreditLimit(creditLimit);
	}

	@Quando("clica no botao Save")
	public void clicarBotaoSalvar() {
		System.out.println("E clica no botão Save");
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
	    System.out.println("E clica no botão Delete");
	    customerList.clickDeleteButton();
	}

	@Quando("confirma remocao de cliente na popup")
	public void confirmarRemocaoCliente() {
	    System.out.println("E confirma remoção de cliente na popup");
	    customerList.confirmDeletionCustomerPopup();
	}

	@Entao("aparece uma mensagem de dados armazenados com sucesso")
	public void validarMensagemDadosSalvos() {
	    System.out.println("Então aparece uma mensagem de dados armazenados com sucesso");
	    Assert.assertTrue("ASSERT FAILED - Não está aparecendo mensagem de dados armazenados com sucesso", customerAdd.validateMessageCustomerAdded());
	}	

	@Entao("aparece mensagem de confirmacao de remocao")
	public void validarMensagemRemocao() {
	    System.out.println("Então aparece mensagem de confirmação de remoção");
	    Assert.assertTrue("ASSERT FAILED - Não está aparecendo mensagem de confirmação de remoção", customerList.validateMessageCustomerDeleted());
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
