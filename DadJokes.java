package DadJokesPackage;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.Scanner;

public class DadJokes {

    public static String  main(){ // if method is not static, you will need to instantiate class on every button click

        String link = "https://icanhazdadjoke.com/";
        URL url;
        String joke = "";
        try {

            url = new URL(link);
            HttpsURLConnection con =  (HttpsURLConnection) url.openConnection();

            con.setRequestMethod("GET");

            StringBuilder response = new StringBuilder();
            Scanner scanner = new Scanner(con.getInputStream());


            while(scanner.hasNext()){
                response.append(scanner.nextLine());
            }
            System.out.println(response);

            String content = "<meta property=\"og:description\" content=\""; // to find  joke in html format.

            int x = response.indexOf(content) + content.length();
            int x1 = x;

            while(!joke.contains("/><meta")){

                System.out.println(x);
                joke += String.valueOf(response.charAt(x));
                x++;
            }
            return joke.substring(0, x - x1 - 9);// - 9 (subtract "/><meta") data is received in html format.



        } catch (Exception e) {
            e.printStackTrace();
        }
            return joke;
    }
}
