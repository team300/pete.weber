package guess;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GuessNumber {

    /**
     * ������̐���
     */
    private String numberText;

    /**
     * ���s��
     */
    private int count;

    /**
     * ���͐���
     */
    private String inputText;

    /**
     * ���̓G���[���b�Z�[�W�B
     * ���̓G���[�����邩�̔���ɂ����p
     */
    private String inputErrorMessage;

    /**
     * �q���g�̃q�b�g��
     */
    private int hit;

    /**
     * �q���g�̃G���[��
     */
    private int error;

    
    /**
     * �Z�b�V�����X�R�[�v����A
     * ���̃N���X�̃C���X�^���X���擾���܂��B
     */
    public static GuessNumber getInstanceFromSession(
            HttpServletRequest request) {
        HttpSession session = request.getSession();
        GuessNumber guess = (GuessNumber) session
                .getAttribute("guess");
        if (guess == null) {
            guess = new GuessNumber();
            session.setAttribute("guess", guess);
        }
        return guess;
    }

    
    GuessNumber() {
        reset();
    }

    
    /**
     * ���̃I�u�W�F�N�g�����������܂�
     */
    public void reset() {
        numberText = "";
        for (int i = 0; i < 4; i++) {
            while (true) {
                String oneNumber = createOneNumber();
                if (numberText.indexOf(oneNumber) == -1) {
                    numberText += oneNumber;
                    break;
                }
            }
        }

        count = 0;
        inputErrorMessage = null;
    }


    /**
     * �f�o�b�O�p
     */
    public String toString() {
        return super.toString() 
            + ",number=" + numberText
            + ",input=" + inputText 
            + ",hit=" + hit
            + ",error=" + error;
    }

    
    /**
     * ���̓e�L�X�g���Z�b�g����
     * �e�L�X�g�̃G���[���Ȃ����`�F�b�N����
     */
    public void setInput(String text) {

        inputText = text;

        if (text == null || !text.matches("\\d{4}")) {
            inputErrorMessage = inputText
                    + " ��4���̐����ł͂���܂���";
            return;
        }

        inputErrorMessage = null;
    }
    
    /**
     * ���̓G���[�����邩�H
     */
    public boolean isInputError() {
        return inputErrorMessage != null;
    }
    
    /**
     * �����̔�����s���A�q�b�g�A�G���[�����v�Z����
     */
    public void challenge() {
        count++;

        hit = 0;
        error = 0;

        for (int i = 0; i < inputText.length(); i++) {
            char c = inputText.charAt(i);

            if (numberText.charAt(i) == c) {
                hit++;
            } else if (numberText.indexOf(c) != -1) {

                error++;
            }
        }
    }

    /**
     * ���ׂăq�b�g���H
     */
    public boolean isAllHit() {
        return hit == 4;
    }

    

      
    //�Q�b�^�A���̑��̃��\�b�h�Q
  
    
    public int getCount() {
        return count;
    }

    public String getNumber() {
        return numberText;
    }

    public String getInput() {
        return inputText;
    }
    
    public String getInputErrorMessage() {
        return inputErrorMessage;
    }

    public int getHit() {
        return hit;
    }

    public int getError() {
        return error;
    }

    private String createOneNumber() {
        int n = new Random().nextInt(10);
        return String.valueOf(n);
    }

}
