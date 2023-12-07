README POO

Clasa Utilizator retine informații despre un utilizator, inclusiv numele și parola acestuia, postările făcute, utilizatorii urmăriți, comentariile create și id-urile pentru like-uri. Constructorul primește doar numele de utilizator și parola. Metodele includ funcții de obținere a numelui și parolei, adăugare/ștergere de postări și alte operații similare pentru listele respective.

Clasa Postare conține informații despre o postare, inclusiv id, text, utilizator, comentarii, like-uri și data postării. Constructorul primește textul, id-ul și numele utilizatorului care a creat postarea. Metodele includ obținerea id-ului, adăugare/ștergere de comentarii, adăugare/ștergere de like-uri și obținerea datelor și numărului de like-uri și comentarii.

Clasa Comentariu conține informații despre un comentariu, inclusiv id, text, utilizator, like-uri și data comentariului. Constructorul este similar cu cel al clasei Postare, iar metodele includ obținerea id-ului, datelor, utilizatorului și numărului de like-uri, precum și adăugare/ștergere de like-uri.

Interfața Likeable conține metode pentru adăugarea și ștergerea unui utilizator într-o listă atunci când acesta dă sau șterge un like la o postare sau un comentariu.

Clasa App conține informații despre utilizatori și variabile pentru gestionarea identificatorilor de postări și comentarii. Metoda adaugaUser adaugă un utilizator în lista de utilizatori.

În main, se creează o instanță a clasei App și se rezolvă cerințele:

-dacă nu se primesc parametri la linia de comandă, se intră în testul cu Dummy și se afișează "Hello world!"
-dacă prima valoare din strings este "-cleanup-all", se parcurg utilizatorii, postările și comentariile și se eliberează listele. La final, se șterge și fișierul CSV cu utilizatori.
-dacă prima valoare din strings este "-create-user", se verifică parametrii și se adaugă utilizatorul în funcție de aceștia. Se afișează un mesaj specific pentru fiecare caz.
-pentru celelalte comenzi care necesită autentificare, se afișează un mesaj dacă parametrii nu sunt suficienți pentru autentificare.
-create-post: verificăm existența utilizatorului în fișier și prezența textului în șiruri; dacă lungimea textului este mai mare, afișăm eroare, altfel se creează postarea.
-delete-post-by-id: căutăm utilizatorul în fișier, verificăm primirea unui ID; dacă ID-ul furnizat se găsește în lista unei postări a utilizatorului, postarea este ștearsă și se afișează un mesaj; altfel, primim eroare.
-follow-user-by-username: căutăm utilizatorul în fișier, verificăm primirea unui nume de utilizator; dacă numele există în fișier, îl căutăm în lista de urmăriți și îl adăugăm dacă nu există.
-unfollow-user-by-username: similar cu adăugarea, doar că acum căutăm în lista de urmăriți și ștergem dacă există, afișând un mesaj de succes sau eroare.
-like-post: căutăm utilizatorul în fișier, verificăm primirea unui ID; dacă ID-ul este asociat unei postări create de utilizator sau pentru care acesta a dat deja like, OK primește valoarea 1; în caz contrar, căutăm ID-ul și, dacă găsim, adăugăm like și în lista de like-uri a postării și a utilizatorului.
-unlike-post: similar cu like, doar că acum căutăm în lista de like-uri și ștergem like-ul, afișând un mesaj de succes sau eroare.
-comment-post: similar cu crearea unei postări, primim ID-ul postării și textul comentariului; dacă îndeplinește condițiile, se creează un comentariu, adăugăm ID-ul în lista de comentarii și în lista de comentarii a utilizatorului.
-delete-comment-by-id: similar cu ștergerea unei postări, putem șterge un comentariu doar dacă acesta aparține utilizatorului sau a fost creat de acesta, ștergându-l din ambele liste.
-like-comment: similar cu like la postare, doar că acum căutăm comentariul creat de utilizator sau la care a dat deja like, adăugându-l în liste.
-unlike-comment: dacă sunt îndeplinite condițiile, căutăm utilizatorul autentificat, verificăm dacă are în lista de like-uri ID-ul furnizat; dacă da, căutăm în postările celorlalți utilizatori și ștergem like-ul, afișând un mesaj de succes sau eroare.
-get-followings-posts: dacă sunt îndeplinite condițiile, creăm o listă de postări ale utilizatorilor urmăriți, o ordonăm descrescător după dată și, dacă este cazul, după ID, apoi le afișăm conform cerințelor.
-get-user-posts: similar cu anteriorul, dar adăugăm doar postările utilizatorilor pe care îi urmărim.
-get-post-details: dacă sunt îndeplinite condițiile, căutăm ID-ul furnizat pentru postare, adăugăm comentariile într-o listă și le ordonăm descrescător; apoi le afișăm sau afișăm o eroare.
-get-following: dacă sunt îndeplinite condițiile, parcurs lista de urmăriți și afișăm conform cerințelor.
-get-followers: dacă sunt îndeplinite condițiile, verificăm dacă numele de utilizator furnizat există și afișăm urmăritorii acestuia conform cerințelor.
-get-most-liked-posts: dacă sunt îndeplinite condițiile, adăugăm toate postările într-o listă, le ordonăm descrescător după numărul de like-uri și le afișăm pe primele 5.
-get-most-commented-posts: similar cu anteriorul, dar ordonăm după numărul de comentarii.
-get-most-followed-users: dacă sunt îndeplinite condițiile, creăm o clasă internă Followers pentru a reține utilizatorul și numărul de urmăritori; apoi, sortăm și afișăm primii 5.
-get-most-liked-users: dacă sunt îndeplinite condițiile, creăm o clasă internă Like pentru a reține utilizatorul și numărul de like-uri; sortăm și afișăm primii 5.
