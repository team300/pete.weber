package wiki;

import java.sql.Timestamp;


public class WikiPage {

	/** �y�[�W�̖��O */
    private String name;
    
    /** �y�[�W�̓��e */
    private String content;
    
    /** �X�V���� */
    private Timestamp updateTime;
   
    
    /** 
     * �f�o�b�O�p�̕������� 
     */
    public String toString(){
        return super.toString()
        	+ ",name=" + name
        	+ ",content=" + content
        	+ ",updateTime=" + updateTime
        	;
    }
    

    /**
     * ���`���s�������e��Ԃ�
     */
    public String getFormatedContent(){
    	WikiFormater formater = new WikiFormater();
    	return formater.formatText(content);
    }
    

    //�ȉ��̓Q�b�^�A�Z�b�^
    public String getContent() {
        return content;
    }

    public void setContent(String contents) {
        this.content = contents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
