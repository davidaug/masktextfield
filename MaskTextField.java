import java.util.ArrayList;
import javafx.scene.control.TextField;

/**
 *
 * @author David Augusto
 * @version 1.0
 * 
 * Email: davidaug23.7@gmail.com
 * Site: www.david.blog.br
 * 
 * Please read the readme in 
 * 
 * 
 * 
 */
public class MaskTextField extends TextField {

    private String mask;
    private ArrayList<String> patterns;

    public MaskTextField() {
        super();
        patterns = new ArrayList<String>();
    }

    public MaskTextField(String text) {
        super(text);
        patterns = new ArrayList<String>();
    }

    @Override
    public void replaceText(int start, int end, String text) {

       
        String tempText = this.getText() + text;

        if(mask == null || mask.length() == 0){
            super.replaceText(start, end, text);
        }else if (tempText.matches(this.mask) || tempText.length() == 0) {        //text.length == 0 representa o delete ou backspace

            super.replaceText(start, end, text);

        } else {

            String tempP = "^";

            for (String patt : this.patterns) {

                tempP += patt;

                if (tempText.matches(tempP)) {

                    super.replaceText(start, end, text);
                    break;

                }

            }

        }

    }

    /**
     * @return the Regex Mask
     */
    public String getMask() {
        return mask;
    }

    /**
     * @param mask the mask to set
     */
    public void setMask(String mask) {

        String tempMask = "^";

        for (int i = 0; i < mask.length(); ++i) {

            char temp = mask.charAt(i);
            String regex;
            int counter = 1;
            int step = 0;

            if (i < mask.length() - 1) {
                for (int j = i + 1; j < mask.length(); ++j) {
                    if (temp == mask.charAt(j)) {
                        ++counter;
                        step = j;
                    } else if (mask.charAt(j) == '!') {
                        counter = -1;
                        step = j;
                    } else {
                        break;
                    }
                }
            }
            switch (temp) {

                case '*':
                    regex = ".";
                    break;
                case 'S':
                    regex = "[^\\s]";
                    break;
                case 'P':
                    regex = "[A-z.]";
                    break;
                case 'M':
                    regex = "[0-z.]";
                    break;
                case 'A':
                    regex = "[0-z]";
                    break;
                case 'N':
                    regex = "[0-9]";
                    break;
                case 'L':
                    regex = "[A-z]";
                    break;
                case 'U':
                    regex = "[A-Z]";
                    break;
                case 'l':
                    regex = "[a-z]";
                    break;
                case '.':
                    regex = "\\.";
                    break;
                default:
                    regex = Character.toString(temp);
                    break;

            }

            if (counter != 1) {

                this.patterns.add(regex);

                if (counter == -1) {
                    regex += "+";
                    this.patterns.add(regex);
                } else {
                    String tempRegex = regex;
                    for (int k = 1; k < counter; ++k) {
                        regex += tempRegex;
                        this.patterns.add(tempRegex);
                    }
                }

                i = step;

            } else {
                this.patterns.add(regex);
            }

            tempMask += regex;

        }

        this.mask = tempMask + "$";

    }

}
