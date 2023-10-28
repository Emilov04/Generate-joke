package DadJokesPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    TextArea text;
    Button button;


    public MyFrame(){
        setTitle("Jokes");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        button = new Button("Generate joke");
        button.setBackground(Color.BLUE);
        button.setBounds(20,70, 100,40);
        button.addActionListener(this);

        add(button);

        text = new TextArea();
        String a = DadJokes.main();
        text.append(a);
        text.setEditable(false);
        text.setForeground(Color.black);
        text.setBounds(0, 0, 500,50);
        add(text);

        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

         StringBuilder a = new StringBuilder(DadJokes.main());

         if(a.length() > 70){
             int curr = 70;

             while(a.charAt(curr) != ' '){
                 --curr;
             }
             a.insert(curr, "\n");
         }

         text.setText(String.valueOf(a));
    }
}
