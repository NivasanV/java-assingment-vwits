package service;
import exception.LowbalanceException;
import model.Account;

public class AccountService {
	
	public float withdrawal(Account ac, float amount) throws Exception{
		if(ac.getBalance() > 0) {
			ac.setBalance(ac.getBalance() - amount);
			return ac.getBalance();
		}
		throw new LowbalanceException();
	}
	
	public float deposite(Account ac, float amount) {
		ac.setBalance(ac.getBalance() + amount);
		return ac.getBalance();
	}
	
	public boolean transferFund(Account sender, Account reciver, float amount) {
		if(sender.getBalance() > amount) {
			sender.setBalance(sender.getBalance()-amount);
			reciver.setBalance(reciver.getBalance() + amount);
			return true;
		}
		return false;
	}
}
