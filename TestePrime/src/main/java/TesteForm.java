import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class TesteForm {

private WebDriver driver;
	
	@Before
	public void Inicializa() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.automationtesting.in/Register.html");
	}
	
	@After
	public void Finaliza() {
		driver.quit();
	}
	
	@Test
	public void verificaPaginaRegistro() {
		Assert.assertEquals("Register", driver.findElement(By.xpath("//h2")).getText());
	}
	
	@Test
	public void clicaBtSubmitCampoFirstNameVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).getAttribute("validationMessage");
		Assert.assertEquals("Preencha este campo.", msg);
	}
	
	@Test
	public void clicaBtSubmitCampoLastNameVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).getAttribute("validationMessage");
		Assert.assertEquals("Preencha este campo.", msg);
	}
	
	@Test
	public void textArea() {
		driver.findElement(By.xpath("//div[@class=\"col-md-8 col-xs-8 col-sm-8\"]//textarea")).sendKeys("Rua Jorge Couceiro da Costa Eiras");
	}
	
	@Test
	public void campoEmailAdressVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("validationMessage");
		Assert.assertEquals("Preencha este campo.", msg);
		
	}
	
	@Test
	public void campoEmailAdressInvalido() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sdsd");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("validationMessage");
		char v = '"';
		String email = driver.findElement(By.xpath("//input[@type='email']")).getAttribute("value");
		Assert.assertEquals("Inclua um "+v+"@"+v+" no endereço de e-mail. "+v+email+v+" está com um "+v+"@"+v+" faltando.", msg);
		
	}
	
	@Test
	public void campoPhoneVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//input[@type='tel']")).getAttribute("validationMessage");
		Assert.assertEquals("Preencha este campo.", msg);
	}
	
	@Test
	public void campoPhoneInvalido() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//input[@type='tel']")).getAttribute("validationMessage");
		//System.out.println(msg);
		Assert.assertEquals("É preciso que o formato corresponda ao exigido.", msg);
	}
	
	@Test
	public void campoGenderVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//input[@value='Male']")).getAttribute("validationMessage");
		Assert.assertEquals("Selecione uma das opções.", msg);
	}
	
	@Test
	public void campoGenderMarcado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Male']")).isSelected());

	}
	
	@Test
	public void campoHobbiesMarcado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.id("checkbox2")).click();
		Assert.assertTrue(driver.findElement(By.id("checkbox2")).isSelected());

	}
	
	@Test
	public void campoLanguagesClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.id("msdd")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Portuguese']")).click();
		
		Assert.assertEquals("Portuguese", driver.findElement(By.xpath("//div[@class='ui-autocomplete-multiselect-item']")).getText());

	}
	
	@Test
	public void campoSkillsClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		WebElement element = driver.findElement(By.id("Skills"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Java");
		Assert.assertEquals("Java", combo.getFirstSelectedOption().getText());

	}
	
	@Test
	public void campoCountyNaoSelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("countries")).getAttribute("validationMessage");
		Assert.assertEquals("Selecione um item da lista.", msg);
	}
	
	@Test
	public void campoCountryClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		Assert.assertEquals("Select Country", combo.getFirstSelectedOption().getText());
		driver.findElement(By.id("submitbtn")).click();
		
		//Este campo está com problemas e não é possivel selecionar
		//algum item para finalizar o cadastro. Caso adicione outro
		//option, é possível continuar o cadastro.

	}
	
	@Test
	public void campoSelectCountryClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		WebElement element = driver.findElement(By.id("country"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Australia");
		Assert.assertEquals("Australia", combo.getFirstSelectedOption().getText());

	}
	
	@Test
	public void campoYearNaoSelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("yearbox")).getAttribute("validationMessage");
		Assert.assertEquals("Selecione um item da lista.", msg);
	}
	
	@Test
	public void campoYearClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		WebElement element = driver.findElement(By.id("yearbox"));
		Select combo = new Select(element);
		combo.selectByVisibleText("1992");
		Assert.assertEquals("1992", combo.getFirstSelectedOption().getText());

	}
	
	@Test
	public void campoMounthNaoSelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.xpath("//select[@placeholder='Month']")).getAttribute("validationMessage");
		Assert.assertEquals("Selecione um item da lista.", msg);
	}
	
	@Test
	public void campoMounthClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		WebElement element = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combo = new Select(element);
		combo.selectByVisibleText("May");
		Assert.assertEquals("May", combo.getFirstSelectedOption().getText());

	}
	
	@Test
	public void campoDayNaoSelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("daybox")).getAttribute("validationMessage");
		Assert.assertEquals("Selecione um item da lista.", msg);
	}
	
	@Test
	public void campoDayClicadoESelecionado() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		WebElement element = driver.findElement(By.id("daybox"));
		Select combo = new Select(element);
		combo.selectByVisibleText("16");
		Assert.assertEquals("16", combo.getFirstSelectedOption().getText());
		
	}
	
	@Test
	public void campoPasswordVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		
		WebElement elementd = driver.findElement(By.id("daybox"));
		Select combod = new Select(elementd);
		combod.selectByVisibleText("16");
		
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("firstpassword")).getAttribute("validationMessage");
		Assert.assertEquals("Please Enter an UpperCase,LowserCase Alphabet and a Number", msg);
	}
	
	@Test
	public void campoPasswordInvalido() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		
		WebElement elementd = driver.findElement(By.id("daybox"));
		Select combod = new Select(elementd);
		combod.selectByVisibleText("16");
		
		driver.findElement(By.id("firstpassword")).sendKeys("werewer");
		
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("firstpassword")).getAttribute("validationMessage");
		Assert.assertEquals("Please Enter an UpperCase,LowerCase Alphabet and a Number", msg);
	}
	
	@Test
	public void campoConfirmPasswordVazio() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		
		WebElement elementd = driver.findElement(By.id("daybox"));
		Select combod = new Select(elementd);
		combod.selectByVisibleText("16");
		
		driver.findElement(By.id("firstpassword")).sendKeys("Qwerty1");
		
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("secondpassword")).getAttribute("validationMessage");
		Assert.assertEquals("Preencha este campo.", msg);
	}
	
	@Test
	public void campoConfirmPasswordInvalido() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		
		WebElement elementd = driver.findElement(By.id("daybox"));
		Select combod = new Select(elementd);
		combod.selectByVisibleText("16");
		
		driver.findElement(By.id("firstpassword")).sendKeys("Qwerty1");
		driver.findElement(By.id("secondpassword")).sendKeys("wefwef");
		
		driver.findElement(By.id("submitbtn")).click();
		//Pega o tooltip
		String msg = driver.findElement(By.id("secondpassword")).getAttribute("validationMessage");
		Assert.assertEquals("Passwords dont match", msg);
	}
	
	@Test
	public void cadastroForm() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).sendKeys("Thales");
		driver.findElement(By.xpath("//*[@placeholder=\"Last Name\"]")).sendKeys("Medeiros");
		driver.findElement(By.xpath("//div[@class=\"col-md-8 col-xs-8 col-sm-8\"]//textarea")).sendKeys("Rua Jorge Couceiro da Costa Eiras");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("thalesmed@gmail.com");
		driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("0000000000");
		driver.findElement(By.xpath("//input[@value='Male']")).click();
		driver.findElement(By.id("checkbox2")).click();
		driver.findElement(By.id("msdd")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Portuguese']")).click();
		
		WebElement elements = driver.findElement(By.id("Skills"));
		Select combos = new Select(elements);
		combos.selectByVisibleText("Java");
		
		WebElement element = driver.findElement(By.id("countries"));
		Select combo = new Select(element);
		combo.selectByVisibleText("Select Country");
		
		WebElement elementsc = driver.findElement(By.id("country"));
		Select combosc = new Select(elementsc);
		combosc.selectByVisibleText("Australia");
		
		WebElement elementy = driver.findElement(By.id("yearbox"));
		Select comboy = new Select(elementy);
		comboy.selectByVisibleText("1992");
		
		WebElement elementm = driver.findElement(By.xpath("//select[@placeholder='Month']"));
		Select combom = new Select(elementm);
		combom.selectByVisibleText("May");
		
		WebElement elementd = driver.findElement(By.id("daybox"));
		Select combod = new Select(elementd);
		combod.selectByVisibleText("16");
		
		driver.findElement(By.id("firstpassword")).sendKeys("Qwerty1");
		driver.findElement(By.id("secondpassword")).sendKeys("Qwerty1");
		
		driver.findElement(By.id("submitbtn")).click();
		Assert.assertEquals("Register", driver.findElement(By.xpath("//h2")).getText());
	}
	
	@Test
	public void clicaBotaoRefresh() {
		
		//Clica no Iframe e deixa a pagina de formulario como default
		driver.findElement(By.xpath("//div[@class='grippy-host']")).click();
		driver.findElement(By.id("Button1")).click();
		Assert.assertEquals("", driver.findElement(By.xpath("//*[@placeholder=\"First Name\"]")).getAttribute("value"));
	}

}
