import java.io.*;
import java.util.ArrayList;

class Solution {
    ArrayList<String> array = new ArrayList<String>();
    ArrayList<String> array2 = new ArrayList<String>();
    public void solution() {
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/Resource/test.txt");
            FileReader filereader = new FileReader(file);
            BufferedReader bufreader = new BufferedReader(filereader);
            String line = "";
            while ((line = bufreader.readLine()) != null) {
                array.add(line);
            }
            bufreader.close();
            filereader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

        for(int i = 0; i < array.size(); i++) {
            String a = array.get(i);
            String[] b = a.split("/");
            String[] c = a.split(":");
            String[] d = c[0].split(b[0],2);

            if(d.length > 2) {

            }
            array2.add(b[0] + " " + d[1]);
        }


        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "/Resource/out.txt");
            FileWriter fw = new FileWriter(file);

            int num = 1;
            for(int i = 0; i < array2.size(); i++) {
                if(i < array2.size()-1 && array2.get(i).equals(array2.get(i+1))) {
                    num++;
                } else {
                    fw.write(array2.get(i) + " " + num + "\n");
                    num = 1;
                }
            }

            fw.flush();
            fw.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}

public class test {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution();
    }
}