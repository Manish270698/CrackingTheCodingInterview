package Arrays_and_Strings;

//Assumption: String has enough space at end
public class URLify {
    public static void main(String[] args) {
        String s = "My name is Manish        ";

        char[] arr = s.toCharArray();
        arr = replace(arr, s.trim().length());
        System.out.println(arr);

    }

    public static char[] replace(char[] c, int trueLength) {
        int spaces = 0;
        int index = 0;
        int i = 0;

        for (i = 0; i < trueLength; i++)
            if (c[i] == ' ')
                spaces++;

        index = trueLength + spaces * 2;

        // for cases when no space is present
        if (trueLength < c.length)
            c[trueLength] = '\0';

        for (i = trueLength - 1; i >= 0; i--) {
            if (c[i] == ' ') {
                c[index - 1] = '0';
                c[index - 2] = '2';
                c[index - 3] = '%';
                index = index - 3;
            } else {
                c[index - 1] = c[i];
                index--;
            }
        }
        return c;
    }
}
