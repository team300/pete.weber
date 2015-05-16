package validate;

public class Eto {

    final static String[] etoArray = new String[]{
            "�q(��)",
            "�N(����)",
            "��(�Ƃ�)",
            "�K(��)",
            "�C(����)",
            "��(��)",
            "��(����)",
            "��(�Ђ�)",
            "�\(����)",
            "��(�Ƃ�)",
            "��(����)",
            "��(��)",
    };
    
    /**
     * �G���[���b�Z�[�W
     */
    private String error;

    /**
     * ����(���͕�����)
     */
    private String yearStr;

    /**
     * ���x
     */
    private String etoText;
        

    public void setYearStr(String yearStr){       
        this.yearStr = yearStr;
    }
    
    public void validate(){
        if(yearStr == null || yearStr.length() == 0){
            error = "��������Ă�";
            return;
        }
        
        try{
            //���l�`�F�b�N�����l�ɕϊ�
            int year = Integer.parseInt(yearStr);
            //�Ó����`�F�b�N
            if(year < 0){
                error = "�I���O�̐l�̓T�|�[�g�O�ł�";
            }else{
            	int index = (year + 8) % 12;   
            	etoText = etoArray[index];
            }
        }catch(NumberFormatException e){
            error = "�N�����Ă�������";
        }
    }
    
    /**
     * �G���[��������擾����B
     * �G���[���Ȃ��ꍇ��null
     */
    public String getError(){
        return error;
    }
    
    /**
     * ���x�̕�������擾����
     */
    public String getEtoText(){        
        return etoText;
    }
}
