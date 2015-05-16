package wiki;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import fw.DBManager;
import fw.ResultSetBeanMapping;



public class WikiPageDAO {
    
	/**
	 * ResultSet�̈�s��WikiPage�̃C���X�^���X�ɕϊ�����N���X
	 * �����ł������p����Ȃ��̂ŁA
	 * �����N���X�Ƃ��āA���̏ꏊ�ŃC���X�^���X�����܂��B
	 */
    private ResultSetBeanMapping<WikiPage> allMapping = new ResultSetBeanMapping<WikiPage>(){

        public WikiPage createFromResultSet(ResultSet rs) 
        	throws SQLException {
    		
            WikiPage page = new WikiPage();
    		page.setName(rs.getString("name"));
    		page.setContent(rs.getString("content"));
    		page.setUpdateTime(rs.getTimestamp("update_time"));
    		return page;
        }
        
    };
    
    
    /**
     * ���̃N���X�̃C���X�^���X���擾���܂��B
     */
    public static WikiPageDAO getInstance(){
        return new WikiPageDAO();
    }


    /**
     * �S���������s���܂��B
     * �߂�l��WikiPage�I�u�W�F�N�g��List�ł��B
     */
	public List<WikiPage> findAll() throws SQLException {

		String sql = "select * from wiki_page"
		    	+ " order by update_time desc";

		return DBManager.simpleFind(sql, allMapping);
	}
	
	
    /**
     * �w�肵�����t�ɕ�����v���郌�R�[�h���������܂��B
     * �߂�l��WikiPage�I�u�W�F�N�g��List�ł��B
     */
	public List<WikiPage> findByWord(String word) throws SQLException{
		String sql = "select * from wiki_page"
		    + " where content like '%" +word+ "%'";
		
		return DBManager.simpleFind(sql, allMapping);
	}
	
	
    /**
     * �w�肵�����O�Ɉ�v���郌�R�[�h���������܂��B
     */
	public WikiPage findByName(String name) throws SQLException{
		String sql = "select * from wiki_page"
		    + " where name='" +name+ "'";

		
		List<WikiPage> list = DBManager.simpleFind(sql, allMapping);
		if(list.size() == 0){
		    return null;
		}else if(list.size() > 1){
		    throw new IllegalArgumentException("record > 1");
		}
		
		return list.get(0);
	}
	
	
	/**
	 * �w�肵��WikiPage������INSERT�����s���܂��B
	 */
	public void insert(WikiPage page) throws SQLException {
	    String sql = "insert into wiki_page (name, content)" 
	        + " values("
	        	+ "'" + page.getName() + "'"
	        	+ ",'" + page.getContent() + "'"
	        + ")"
	        ;	    
	    DBManager.simpleUpdate(sql);	
	}
	
		
	/**
	 * �w�肵��WikiPage������UPDATE�����s���܂��B
	 */
	public void update(WikiPage page) throws SQLException {
	    String sql = "update wiki_page " 
	        + " set "
	        	+ " content='" + page.getContent() + "'"
	        + " where name='" + page.getName() + "'";
	    DBManager.simpleUpdate(sql);	    
	}
		
	
	/**
	 * �w�肵��WikiPage������DELETE�����s���܂��B
	 */
	public void delete(WikiPage page) throws SQLException {
	    String sql = "delete from wiki_page where name='" 
	        + page.getName() + "'";
	    DBManager.simpleUpdate(sql);
	}
	
	
	//����m�F�p
	public static void main(String[] args) throws Exception{
	    WikiPageDAO dao = new WikiPageDAO();	    
	    List<WikiPage> list = dao.findAll();
	    for(int i=0; i<list.size(); i++){
	        WikiPage page = list.get(i);
	        System.out.println(page);
	    }
	}
}
