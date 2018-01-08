package com.example.ahmed.quizapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ahmed on 12/28/2017.
 */

class Quiz extends Activity {
    //QUESTIONS
    String[] questions;

    //Question
    int quesNum=0;
    String questionNumber;

    //ANSWERS for questions
    String[] answers;

    //Users Answer
    int uAnswer;

    //For Checking right answer(For Button Color)
    Boolean check=false;

    //OPTIONS for questions
    String[] Q1options;
    String[] Q2options;
    String[] Q3options;
    String[] Q4options;
    String[] Q5options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //Storing questions(Strings)
        questions = new String[5];
        questions[0]=
                "What is the currency of Nepal?\n";
        questions[1]=
                "Respiration means ?\n";
        questions[2]=
                "Who invented cycle\n";
        questions[3]=
                "Which planet has the longest day\n";
        questions[4]=
                "How many planets are there in the Solar System\n";

        //Answers for questions
        answers = new String[5];
        answers[0]="Rupee";
        answers[1]="the process during which food is oxidized and its chemical energy is transformed into useful form";
        answers[2]="Mc Millan";
        answers[3]="Venus";
        answers[4]="8";

        //Storing options for different Questions
        //Q1 Options
        Q1options = new String[4];
        Q1options[0]="Rupee";
        Q1options[1]="Kina";
        Q1options[2]="Ruble";
        Q1options[3]="Peso";

        //Q2 Options
        Q2options = new String[4];
        Q2options[0]="interconversion of food and energy";
        Q2options[1]="the process during which food is oxidized and its chemical energy is transformed into useful form";
        Q2options[2]="process of converting matter into energy";
        Q2options[3]="process of water purification";

        //Q3 Options
        Q3options = new String[4];
        Q3options[0]="Charles babbage";
        Q3options[1]="Nobel";
        Q3options[2]="Mc Millan";
        Q3options[3]="Gottileb daimler";

        //Q4 Options
        Q4options = new String[4];
        Q4options[0]="Saturn";
        Q4options[1]="Mercury";
        Q4options[2]="Venus";
        Q4options[3]="Mars";

        //Q5 Options
        Q5options = new String[4];
        Q5options[0]="12";
        Q5options[1]="15";
        Q5options[2]="9";
        Q5options[3]="8";


        //Setting First,n Questions Dynamically
        TextView question = (TextView) findViewById (R.id.question_textView);
        question.setText(questions[quesNum]);

        //Updating value of 'quesNum' from 0 to 1
        //quesNum++;
        questionNumber="QUESTION#0"+(quesNum+1);

        //Checking variable quesNum
       // Toast.makeText(Quiz.this,"questNum="+quesNum,Toast.LENGTH_SHORT).show();

        //Setting First,n Question numbers dynamically
        TextView questionHeading = (TextView) findViewById(R.id.question_heading_textView);
        questionHeading.setText(questionNumber);

        //For Buttons
        final Button button1 = (Button) findViewById (R.id.button1);
        final Button button2 = (Button) findViewById (R.id.button2);
        final Button button3 = (Button) findViewById (R.id.button3);
        final Button button4 = (Button) findViewById (R.id.button4);

        //Settings Options for First Question
        //For Button 1
        button1.setText(Q1options[0]);
        //For Button 2
        button2.setText(Q1options[1]);
        //For Button 3
        button3.setText(Q1options[2]);
        //For Button 4
        button4.setText(Q1options[3]);


        //For Button1 Color
        button1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                //Has to set Button background from drawable
                //Buttonclick
                //if a Button is clicked once disable all buttons
                 CheckAnswer(button1);

                 button1.setEnabled(false);
                 button2.setEnabled(false);
                 button3.setEnabled(false);
                 button4.setEnabled(false);
                }
        });


        //For Button2 Color
        button2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //Has to set Button background from drawable
                //Buttonclick
                CheckAnswer(button2);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

            }
        });


        //For Button3 color
        button3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                CheckAnswer(button3);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);

            }
        });


        //For Button4 color
        button4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                CheckAnswer(button4);

                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
            }
        });


        //For Next Button
        Button button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            //Has to Reset the state of UI & Change the set up
            public void onClick(View view) {
                //Checking the state of App
                //Checking Question number

                //If quesNum = 5 display result
                if((quesNum)==5){
                     //Display Result Using a Alert Dialog Box

                     // Create an alert dialog box
                    AlertDialog.Builder builder = new AlertDialog.Builder(
                            Quiz.this);

                    // Set alert title
                    builder.setTitle("Result");

                    // Set the value for the positive reaction from the user
                    // You can also set a listener to call when it is pressed
                    builder.setPositiveButton("OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // Perform some operation
                                    System.exit(0);
                                }
                            });

                    // The message
                    builder.setMessage("You have Scored : "+(uAnswer*10) + " Points");

                    // Create the alert dialog and display it
                    AlertDialog theAlertDialog = builder.create();
                    theAlertDialog.show();
                    //  Toast.makeText(Quiz.this,"You have Scored : "+(uAnswer*10) + " Points",Toast.LENGTH_LONG).show();
                }

                //Else Perform action
                else{
                   //Changing Buttons Color to default
                    button1.setBackground(getResources().getDrawable(R.drawable.button));
                    button2.setBackground(getResources().getDrawable(R.drawable.button));
                    button3.setBackground(getResources().getDrawable(R.drawable.button));
                    button4.setBackground(getResources().getDrawable(R.drawable.button));

                    //Activating Buttons
                    button1.setEnabled(true);
                    button2.setEnabled(true);
                    button3.setEnabled(true);
                    button4.setEnabled(true);

                    //Changing Question Heading Number
                    questionNumber="QUESTION#0"+(quesNum+1);
                    //Setting First,n Question numbers dynamically
                    TextView questionHeading = (TextView) findViewById(R.id.question_heading_textView);
                    questionHeading.setText(questionNumber);

                    //Changing Question
                    //Setting First,n Questions Dynamically
                    TextView question = (TextView) findViewById (R.id.question_textView);
                    question.setText(questions[quesNum]);

                    //Changing Button text with (Options)
                    //Settings Options for n Questions
                    //Updating Options According to questions
                    switch (quesNum){
                        case 1:
                            updateOptions(Q2options);
                            break;
                        case 2:
                            updateOptions(Q3options);
                            break;
                        case 3:
                            updateOptions(Q4options);
                            break;
                        case 4:
                            updateOptions(Q5options);
                            break;

                        default:
                            //do nothing
                    }

                }

            }
        });

    }

        public void updateOptions(String[] q1options) {
            //Settings Options for First,n Questions
            //For Buttons
            final Button button1 = (Button) findViewById (R.id.button1);
            final Button button2 = (Button) findViewById (R.id.button2);
            final Button button3 = (Button) findViewById (R.id.button3);
            final Button button4 = (Button) findViewById (R.id.button4);

            //For Button 1
            button1.setText(q1options[0]);
            //For Button 2
            button2.setText(q1options[1]);
            //For Button 3
            button3.setText(q1options[2]);
            //For Button 4
            button4.setText(q1options[3]);
     }


    //Checks Answer and Changes button color according to answer
    public void CheckAnswer(Button button1){

        String chk = button1.getText().toString();
        //Ternery operator to trigger Boolean variable check
        check = (chk == answers[quesNum]) ? true : false;

        //Receiving Unknown Buttons as parameter(button1)
        Button button = button1;

        //quesNum from value (1 to 2)
         quesNum++;

        //Checking variable quesNum
      //  Toast.makeText(Quiz.this,"questNum="+quesNum,Toast.LENGTH_LONG).show();

        //Has to record the correct answer
        if(check!=true){
            //Wrong Answer
            //button click == red color button(Drawable)
            button.setBackground(getResources().getDrawable(R.drawable.buttonclick));

        }else{
             //Right Answer
            uAnswer=uAnswer+1;
            //button right == green color button(Drawable)
            button.setBackground(getResources().getDrawable(R.drawable.buttonright));
        }


    }

    //Try to update UI with threads
    /*
    public void updateUI(){
        //Setting First,n Questions Dynamically
        TextView question = (TextView) findViewById (R.id.question_textView);
        question.setText(questions[quesNum]);

        //Updating value of 'quesNum' from 0 to 1
        quesNum++;
        questionNumber="QUESTION#0"+quesNum;

        //Setting First,n Question numbers dynamically
        TextView questionHeading = (TextView) findViewById(R.id.question_heading_textView);
        questionHeading.setText(questionNumber);


        //Updating Options According to questions
        switch (quesNum){
            case 1:
                updateOptions(Q1options);
                break;
            case 2:
                updateOptions(Q2options);
                break;
            case 3:
                updateOptions(Q3options);
                break;
            case 4:
                updateOptions(Q4options);
                break;
            case 5:
                updateOptions(Q5options);
                break;
        }

    }


    public void updateOptions(String[] options){
        //Settings Options for First,n Questions
        //For Button 1
        button1.setText(options[0]);
        //For Button 2
        button2.setText(options[1]);
        //For Button 3
        button3.setText(options[2]);
        //For Button 4
        button4.setText(options[3]);
    }
    */


}