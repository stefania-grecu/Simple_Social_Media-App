/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TemaTest;


import java.io.*;

public class App {
    
public App() {/* compiled code */
}

    public static void main(java.lang.String[] strings) {
        //-create-user
        if (strings[0].equals("-create-user")) {
            if (strings.length == 1) {
                System.out.println("{'status':'error','message':'Please provide username'}");
            } else if (strings.length == 2) {
                System.out.println("{'status':'error','message':'Please provide password'}");
            } else {
                String[] user = new String[2];
                user = strings[1].split(" ");
                String[] password = new String[2];
                password = strings[2].split(" ");

                if (!strings[1].startsWith("-u")) {
                    System.out.println("{'status':'error','message':'Please provide username'}");
                } else {
                    if (!strings[2].startsWith("-p")) {
                        System.out.println("{'status':'error','message':'Please provide password'}");
                    } else {
                        int k = 0;
                        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] nume = new String[2];
                                nume = line.split(" ");
                                if (nume[0].equals(user[1])) {
                                    k = 1;
                                }
                            }
                            br.close();
                        } catch (IOException e) {
                            k = 0;
                        }
                        if (k == 1) {
                            System.out.println("{'status':'error','message':'User already exists'}");
                        } else {
                            try (FileWriter fw = new FileWriter("user.csv", true);
                                 BufferedWriter bw = new BufferedWriter(fw);
                                 PrintWriter out = new PrintWriter(bw)) {
                                out.println(user[1] + " " + password[1]);
                            } catch (IOException e) {
                                System.out.println(e);
                            }
                            System.out.println("{'status':'ok','message':'User created successfully'}");

                        }
                    }
                }
            }
        }

        //-create-post
        if (strings[0].equals("-create-post")) {
            if (strings.length == 1) {
                System.out.println("{'status':'error','message':'You need to be authenticated'}");
            } else if (strings.length == 2) {
                System.out.println("{'status':'error','message':'You need to be authenticated'}");
            } else {
                if (!strings[1].startsWith("-u") || !strings[2].startsWith("-p")) {
                    System.out.println("{'status':'error','message':'You need to be authenticated'}");
                } else {

                    String[] user = new String[2];
                    user = strings[1].split(" ");
                    String[] password = new String[2];
                    password = strings[2].split(" ");

                    int k = 0;

                    try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            String[] nume = new String[2];
                            nume = line.split(" ");
                            if (!nume[0].equals(user[1]) && !nume[1].equals(password[1])) {
                                k = 1;
                            }
                        }
                    } catch (IOException e) {
                        k = 0;
                    }
                    if (k == 1) {
                        System.out.println("{'status':'error','message':'Login failed'}");
                    } else {
                        if (!strings[3].startsWith("-t")) {
                            System.out.println("{'status':'error','message':'No text provided'}");
                        } else {
                            String[] text = new String[2];
                            text = strings[3].split("'");

                            //System.out.println(text[1]);

                            if (text[1].length() > 300) {
                                System.out.println("{'status':'error','message':'Post text length exceeded'}");
                            } else {
                                System.out.println("{'status':'ok','message':'Post added successfully'}");
                            }
                        }
                    }
                }
            }
        }


        //-cleanup-all
        if (strings[0].equals("-cleanup-all")) {
            File myFile = new File("user.csv");
            myFile.delete();
        }
    }

}