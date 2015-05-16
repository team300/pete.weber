package guess;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GuessNumberCUI {

    public static void main(String[] args) throws Exception {

        GuessNumber guess = new GuessNumber();
 
        BufferedReader in = new BufferedReader(
                new InputStreamReader(System.in));

        System.out.println("4���̐�������͂��Ă�������");
       
        String line;
        while ((line = in.readLine()) != null) {

            guess.setInput(line);//���͐������Z�b�g
            
            if (guess.isInputError()) {//���̓G���[�H
                System.out.println(guess
                        .getInputErrorMessage());
                continue;
            } 
      
            guess.challenge();//�����蔻����s
                
            if(guess.isAllHit()){//������H
                System.out.println("������I");
                break;
                
            }else{//�͂���
                String hint 
                	= guess.getCount() + "���"
                    + "hit=" + guess.getHit()
                    + ",error=" + guess.getError();
                System.out.println(hint);
            }
        }
    }

}
