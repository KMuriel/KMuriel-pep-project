package Service;
import DAO.AccountDAO;
import Model.Account;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService()
    {
        accountDAO = new AccountDAO();
    }
    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account addAccount(Account account) {
        if (account.getUsername().length() == 0)
        {
            return null;
        }
        if (account.getPassword().length() < 4)
        {    
            return null;
        }
        /*if (account.getUsername() != null)
        {
            return null;
        }*/
        return accountDAO.createNewAccount(account);
    }
    public Account checkLogin(Account account)
    {
        return accountDAO.loginCheck(account);
    }
}
