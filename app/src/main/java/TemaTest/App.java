/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package TemaTest;

import java.io.*;
import java.util.ArrayList;

public class App {
    static ArrayList<Utilizator> userName;
    //int idOld = 0;
    static int k, ok;
    static String[] user = new String[2];
    static String[] password = new String[2];
    static String[] nume = new String[2];

    public App() {/* compiled code */
        if (userName == null)
            userName = new ArrayList<>();
    }

    public void adaugaUser(Utilizator user) {
        userName.add(user);
    }

//    public void adaugaPostare(Utilizator user, String text) {
//        for (Utilizator i : userName) {
//            String nume = i.getNume();
//            String password = i.getPassword();
//            if (nume.equals(user.getNume()) && password.equals(user.getPassword())) {
//                Postare post = new Postare(text);
//                i.adaugaPostare(post);
//                return;
//            }
//        }
//    }


    public static void main(String[] strings) {
        App app = new App();

        //-cleanup-all
        if (strings[0].equals("-cleanup-all")) {
            for (Utilizator i : userName) {
                for (Postare j : i.postare)
                    if(j.comentariu != null)
                        j.comentariu.clear();
                if (i.postare != null)
                    i.postare.clear();
                if (i.urmareste != null)
                    i.urmareste.clear();
                if (i.like != null)
                    i.like.clear();
                if (i.comentariu != null)
                    i.comentariu.clear();
            }
            if (userName != null)
                userName.clear();

            File myFile = new File("user.csv");
            if (myFile.delete())
                System.out.println("{ 'status' : 'ok', 'message' : 'Cleanup finished successfully'}");
        }

        //-create-user
        if (strings[0].equals("-create-user")) {
            if (strings.length == 1) {
                System.out.println("{'status':'error','message':'Please provide username'}");
            } else if (strings.length == 2) {
                System.out.println("{'status':'error','message':'Please provide password'}");
            } else {
                user = strings[1].split(" ");
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
                                nume = line.split(" ");
                                if (nume[0].equals(user[1])) {
                                    k = 1;
                                }
                            }
                        } catch (IOException e) {
                            k = 0;
                        }
                        if (k == 1) {
                            System.out.println("{'status':'error','message':'User already exists'}");
                        } else {
                            Utilizator utilizator = new Utilizator(user[1], password[1]);
                            app.adaugaUser(utilizator);

                            try (FileWriter fw = new FileWriter("user.csv", true);
                                 BufferedWriter bw = new BufferedWriter(fw);
                                 PrintWriter out = new PrintWriter(bw)) {
                                out.println(user[1] + " " + password[1]);
                            } catch (IOException ignored) {
                            }
                            System.out.println("{'status':'ok','message':'User created successfully'}");
                        }
                    }
                }
            }
        } else if (strings.length <= 2 || !strings[1].startsWith("-u") || !strings[2].startsWith("-p"))
            System.out.println("{ 'status' : 'error', 'message' : 'You need to be authenticated'}");
        else {

            //-create-post
            if (strings[0].equals("-create-post")) {
                user = strings[1].split(" ");
                password = strings[2].split(" ");

                k = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        nume = new String[2];
                        nume = line.split(" ");
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-text")) {
                        System.out.println("{'status':'error','message':'No text provided'}");
                    } else {
                        String[] text = new String[2];
                        text = strings[3].split("'");

                        if (text[1].length() > 300) {
                            System.out.println("{'status':'error','message':'Post text length exceeded'}");
                        } else {
                            for (Utilizator i : userName)
                                if (i.getNume().equals(user[1])){
                                    Postare post = new Postare(text[1]);
                                    i.adaugaPostare(post);
                                }
                            System.out.println("{'status':'ok','message':'Post added successfully'}");
                        }
                    }
                }
            }

            //delete-post-by-id
            if (strings[0].equals("-delete-post-by-id")) {
                String[] user = strings[1].split(" ");
                String[] password = strings[2].split(" ");

                k = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] nume = new String[2];
                        nume = line.split(" ");
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-id")) {
                        System.out.println("{'status':'error','message':'No identifier was provided'}");
                    } else {
                        String[] id = new String[2];
                        id = strings[3].split("'");

                        ok = 0;

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (Postare j : i.postare) {
                                    int index = Integer.parseInt(id[1]);

                                    if (j.getId() == index) {
                                        i.stergerePostare(j);
                                        System.out.println("{'status':'ok','message':'Post deleted successfully'}");
                                        ok = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (ok == 0)
                            System.out.println("{'status':'error','message':'The identifier was not valid'}");
                    }
                }
            }

            //-follow-user-by-username
            if (strings[0].equals("-follow-user-by-username")) {
                String[] user = strings[1].split(" ");
                String[] password = strings[2].split(" ");

                k = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] nume = new String[2];
                        nume = line.split(" ");
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-username")) {
                        System.out.println("{'status':'error','message':'No username to follow was provided'}");
                    } else {
                        String[] userFollow = strings[3].split(" ");
                        ok = 0;

                        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] nume = new String[2];
                                nume = line.split(" ");
                                if (nume[0].equals(userFollow[1])) {
                                    ok = 1;
                                }
                            }
                        } catch (IOException ignored) {
                        }

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (String j : i.urmareste) {
                                    if (j.equals(userFollow[1])) {
                                        ok = 0;
                                        break;
                                    }
                                }
                            }
                        }
                        if (ok == 0)
                            System.out.println("{ 'status' : 'error', 'message' : 'The username to follow was not valid'}");
                        else {
                            for (Utilizator i : userName) {
                                if (i.getNume().equals(user[1])) {
                                    i.adaugaUrmareste(userFollow[1]);
                                }
                            }
                            System.out.println("{ 'status' : 'ok', 'message' : 'Operation executed successfully'}");
                        }
                    }
                }
            }

            //-unfollow-user-by-username
            if (strings[0].equals("-unfollow-user-by-username")) {
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
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-username")) {
                        System.out.println("{'status':'error','message':'No username to unfollow was provided'}");
                    } else {
                        String[] userUnfollow = new String[2];
                        userUnfollow = strings[3].split(" ");

                        int ok = 0;
                        boolean contor = false;

                        try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                String[] nume = new String[2];
                                nume = line.split(" ");
                                if (nume[0].equals(userUnfollow[1])) {
                                    ok = 1;
                                }
                            }
                        } catch (IOException ignored) {
                        }

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (String j : i.urmareste) {
                                    if (j.equals(userUnfollow[1])) {
                                        i.stergereUrmareste(userUnfollow[1]);
                                        System.out.println("{ 'status' : 'ok', 'message' : 'Operation executed successfully'}");
                                        contor = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (!contor)
                            System.out.println("{ 'status' : 'error', 'message' : 'The username to unfollow was not valid'}");
                    }
                }
            }

            //-like-post
            if (strings[0].equals("-like-post")) {
                user = strings[1].split(" ");
                password = strings[2].split(" ");

                k = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] nume = new String[2];
                        nume = line.split(" ");
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-post-id")) {
                        System.out.println("{'status':'error','message':'No post identifier to like was provided'}");
                    } else {
                        String[] id = strings[3].split(" ");
                        ok = 0;
                        String[] idInt = id[1].split("'");
                        int index = Integer.parseInt(idInt[1]);
                        boolean conter = false;

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (Postare j : i.postare) {
                                    if (j.getId() == index) {
                                        ok = 1;
                                        break;
                                    }
                                }
                                for (String j : i.like) {
                                    if (j.equals(id[1])) {
                                        ok = 1;
                                        break;
                                    }
                                }
                            }
                        }
                        if (ok == 0) {
                            for (Utilizator i : userName) {
                                if (!i.getNume().equals(user[1])) {
                                    for (Postare j : i.postare) {
                                        if (j.getId() == index) {
                                            conter = true;
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if (conter) {
                            for (Utilizator i : userName) {
                                if (i.getNume().equals(user[1])) {
                                    i.adaugaLike(id[1]);
                                }
                            }
                            System.out.println("{ 'status' : 'ok', 'message' : 'Operation executed successfully'}");
                        } else {
                            System.out.println("{ 'status' : 'error', 'message' : 'The post identifier to like was not valid'}");
                        }
                    }
                }
            }

            //-unlike-post
            if (strings[0].equals("-unlike-post")) {
                user = strings[1].split(" ");
                password = strings[2].split(" ");

                k = 0;

                try (BufferedReader br = new BufferedReader(new FileReader("user.csv"))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] nume = new String[2];
                        nume = line.split(" ");
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-post-id")) {
                        System.out.println("{'status':'error','message':'No post identifier to unlike was provided'}");
                    } else {
                        String[] id = strings[3].split(" ");
                        ok = 0;

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (String j : i.like) {
                                    if (j.equals(id[1])) {
                                        i.stergereLike(id[1]);
                                        ok = 1;
                                        System.out.println("{ 'status' : 'ok', 'message' : 'Operation executed successfully'}");
                                        break;
                                    }
                                }
                            }
                        }

                        if (ok == 0)
                            System.out.println("{ 'status' : 'error', 'message' : 'The post identifier to unlike was not valid'}");
                    }
                }
            }

            //-comment-post
            if (strings[0].equals("-comment-post")) {
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
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length <= 4 || !strings[3].startsWith("-post-id") || !strings[4].startsWith("-text")) {
                        System.out.println("{'status':'error','message':'No text provided'}");
                    } else {
                        String[] id = strings[3].split(" ");
                        String[] text = strings[4].split("'");

                        if (text[1].length() >= 300) {
                            System.out.println("{ 'status' : 'error', 'message' : 'Comment text length exceeded'}");
                        } else {
                            String[] idInt = id[1].split("'");
                            int index = Integer.parseInt(idInt[1]);

                            for (Utilizator i : userName)
                                for (Postare j : i.postare)
                                    if (j.getId() == index) {
                                        Comentariu com = new Comentariu(text[1]);
                                        j.adaugaComentariu(com);
                                        for (Utilizator l : userName)
                                            if (l.getNume().equals(user[1]))
                                                l.adaugaComentariu(com);
                                        System.out.println("{ 'status' : 'ok', 'message' : 'Comment added successfully'}");
                                        break;
                                    }
                        }


                    }
                }
            }

            //-delete-comment-by-id
            if (strings[0].equals("-delete-comment-by-id")) {
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
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length <= 3 || !strings[3].startsWith("-id")) {
                        System.out.println("{'status':'error','message':'No identifier was provided'}");
                    } else {
                        String[] id = strings[3].split(" ");
                        ok = 0;
                        String[] idInt = id[1].split("'");
                        int index = Integer.parseInt(idInt[1]);

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (Postare j : i.postare) {
                                    for (Comentariu l : j.comentariu) {
                                        if (l.getId() == index) {
                                            j.stergereComentariu(l);
                                            System.out.println("{ 'status' : 'ok', 'message' : 'Post deleted successfully'}");
                                            ok = 1;
                                            break;
                                        }
                                    }
                                }
                                for (Comentariu j : i.comentariu) {
                                    if (j.getId() == index) {
                                        i.stergereComentariu(j);
                                        System.out.println("{ 'status' : 'ok', 'message' : 'Post deleted successfully'}");
                                        ok = 1;
                                        break;
                                    }
                                }
                            }
                        }

                        if(ok == 0)
                            System.out.println("{'status':'error','message':'The identifier was not valid'}");
                    }
                }
            }

            //-like-comment
            if (strings[0].equals("-like-comment")) {
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
                        if (nume[0].equals(user[1]) && nume[1].equals(password[1])) {
                            k = 1;
                        }
                    }
                } catch (IOException ignored) {
                }
                if (k == 0) {
                    System.out.println("{'status':'error','message':'Login failed'}");
                } else {
                    if (strings.length == 3 || !strings[3].startsWith("-post-id")) {
                        System.out.println("{'status':'error','message':'No comment identifier to like was provided'}");
                    } else {
                        String[] id = strings[3].split(" ");
                        int ok = 0;

                        for (Utilizator i : userName) {
                            if (i.getNume().equals(user[1])) {
                                for (String j : i.like) {
                                    if (j.equals(id[1])) {
                                        i.stergereLike(id[1]);
                                        ok = 1;
                                        System.out.println("{ 'status' : 'ok', 'message' : 'Operation executed successfully'}");
                                        break;
                                    }
                                }
                            }
                        }

                        if (ok == 0)
                            System.out.println("{ 'status' : 'error', 'message' : 'The post identifier to unlike was not valid'}");
                    }
                }
            }
        }
    }
}