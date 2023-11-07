import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import exception.LowbalanceException;
import model.Account;
import service.AccountService;

public class AccountServiceTest {
	Account ac1 = new Account(1,5000);
	Account ac2 = new Account(2,10000);
	Account ac3 = new Account(3,0);
	AccountService as = new AccountService();

	@Test
	@DisplayName("Withdraw")
	public void testWithdrawShouldWithdrawSuccessully() {

		float amount = 1000;
		float expectedBalance = 4000;
		float acctualBalance = 0;
		try {
			acctualBalance = as.withdrawal(ac1, amount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(expectedBalance+" "+acctualBalance);
		assertEquals(expectedBalance, acctualBalance);
	}

	@Test
	public void depositeTest() {

		float amount = 1000;
		float expectedBalance = 11000;
		float acctualBalance = as.deposite(ac2,amount);
//		System.out.println(expectedBalance+" "+acctualBalance);
		assertEquals(expectedBalance, acctualBalance);
	}

	@Test
	public void tranceferFundTest() {
		assertEquals(true,as.transferFund(ac1, ac2, 1000));
	}
	
	@Test
	public void testWithdrawShouldThrowLowbalanceException() {
		assertThrows(LowbalanceException.class, ()->as.withdrawal(ac3, 1000) );
	}

}
