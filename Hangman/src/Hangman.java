import javafx.scene.shape.Circle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;


public class Hangman {

    public static void main(String[] args) throws FileNotFoundException {
        JFrame myframe=new JFrame("hangman 2.0");
        myframe.setVisible(true);
        myframe.setSize(400,750);
        JButton submit=new JButton("Submit");
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setLayout(new GridLayout(0,1));
        JTextField myText=new JTextField();
        JLabel man=new JLabel();
        Circle head=new Circle(200,200,40);
        myframe.add(man);
        myframe.add(myText);
        myframe.add(submit);
        submit.setBackground (Color.CYAN);
        while (true) {
            File file = new File("c://movie.txt");
            Scanner in = new Scanner(file);
            ArrayList<String> words = new ArrayList<>();
            while (in.hasNextLine()) {
                words.add(in.nextLine());
            }
            int num = (int) (Math.random() * words.size() + 1);
            in.close();
            String myword = words.get(num);
            int spacecounter = 0;
            ArrayList<String> wordHide = new ArrayList<>();
            for (int i = 0; i < myword.length(); i++) {
                if (myword.charAt(i) != ' ')
                    wordHide.add("_");
                else {
                    spacecounter++;
                    wordHide.add(" ");
                }

            }
            System.out.println("its " + (myword.length() - spacecounter) + " letters(to show the answer Enter <Q>" );
            System.out.println(wordHide);
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a letter");
            int chances = 10;
            boolean flag = false;
            char letter;
            int index;
            while (chances > 0 && wordHide.contains("_")) {
                letter = input.next().charAt(0);
                if(letter=='Q') break;
                index = myword.indexOf(letter);
//                System.out.println(index);
                if (index != -1)
                    wordHide.set(index, String.valueOf(letter));
//                System.out.println(wordHide);
                while (index >= 0) {
                    index = myword.indexOf(letter, index + 1);
                    if (index != -1) {
                        wordHide.set(index, String.valueOf(letter));
                    }
                }
                if (myword.contains(String.valueOf(letter)))
                    System.out.println(wordHide);
                if (!myword.contains(String.valueOf(letter))) {
                    chances--;
                    System.out.println("wrong you have " + chances + " chances");
                    System.out.println(wordHide);
                }
            }
            if (wordHide.contains("_")) {
                System.out.println("you lost the word was " + myword);
            } else {
                System.out.println("yeeeeeeeeeah it was " + myword);
            }
            System.out.println("Do you want to play again? <yes:1 / no:0>");
            if(input.nextInt()==0) break;
        }

    }
}