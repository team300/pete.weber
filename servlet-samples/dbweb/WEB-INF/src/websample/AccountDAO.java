package websample;

import java.sql.SQLException;
import java.util.List;


public class AccountDAO {

	/**
	 * �S���������s���B
	 * �߂�l��Account�I�u�W�F�N�g��List
	 */
    public List<Account> findAll() {
    	String sql = "SELECT * FROM ACCOUNT";
        try {
            return DBManager3.simpleFind(sql, 
            		new AccountMapping() );
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        } 
    }
        

    /**
     * ������Account�I�u�W�F�N�g������INSERT�������s��
     */
    public int insert(Account account){
    	String sql = "INSERT INTO ACCOUNT(ID, NAME, MONEY)" 
    		+ " VALUES(" 
			+ account.getId()
			+ ",'" +account.getName()
			+ "'," +account.getMoney()
			+ ")"
			;
        try {
            return DBManager3.simpleUpdate(sql);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
    

    //�K�v�ɉ����ă��\�b�h��ǉ����Ă���
}
