package foo;
import java.util.Random;

public class Menjan {
    final static String[] words = new String[]{
            "�V���[��p","�U�N","�͂��߂Ă�","�`���[",
            "�ɓ���","�Ȃ���","����Ȃ�","�O�p","���͂悤",
            "101��ڂ�","�v���|�[�Y","�r������","80�L��",
            "�o����","�s���`�ł�","����","�Ԃ�", 
        };

    public String getSingleWord() {
        int index = new Random().nextInt(words.length);
        return words[index];
    }

	public String getWord(){
		return getSingleWord() + " " + getSingleWord();
	}

}
