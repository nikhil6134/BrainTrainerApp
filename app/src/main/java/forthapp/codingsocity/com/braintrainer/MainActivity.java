package forthapp.codingsocity.com.braintrainer;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button startbutton;
    TextView sumtext;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView textView;
    int locationofcorrectanswer;
    int score =0;
    int numberofquestions = 0;
    TextView numberTextview;
    TextView timerTextview;
    Button playagain;
    ConstraintLayout gamelayout;




    ArrayList<Integer> answers =  new ArrayList<Integer>();

  public  void  playagain(View view){

      score = 0;
      numberofquestions = 0;
      timerTextview.setText("30s");
      numberTextview.setText(Integer.toString(score)+ "/" + Integer.toString(numberofquestions));
      newquestions();
      playagain.setVisibility(View.INVISIBLE);
      textView.setText("");
      button0.setEnabled(true);
      button1.setEnabled(true);
      button2.setEnabled(true);
      button3.setEnabled(true);

      new CountDownTimer(30100,1000) {
          @Override
          public void onTick(long l) {

              timerTextview.setText(String.valueOf(l/1000) + "s");
          }

          @Override
          public void onFinish() {
              textView.setText("Done!!");
              playagain.setVisibility(View.VISIBLE);
              MediaPlayer mplayer = MediaPlayer.create(getApplicationContext(),R.raw.airhorn);
              mplayer.start();
              button0.setEnabled(false);
              button1.setEnabled(false);
              button2.setEnabled(false);
              button3.setEnabled(false);



          }
      }.start();



  }



    public void chooseAnswer(View view){


     if (Integer.toString(locationofcorrectanswer).equals(view.getTag().toString()))
     {
         textView.setText("Correct!!");
         score ++;
     }
      else
     {
         textView.setText("Wrong!!");

     }
     numberofquestions ++;

     numberTextview.setText(Integer.toString(score) + "/" + Integer.toString(numberofquestions));

     newquestions();





  }


  public void  newquestions(){


      Random rand = new Random();

      int a = rand.nextInt(21);
      int b = rand.nextInt(21);

      sumtext.setText(Integer.toString(a) + "+" + Integer.toString(b));

      locationofcorrectanswer = rand.nextInt(4);
      answers.clear();


      for (int i=0;i<=4;i++) {

          if (i == locationofcorrectanswer) {
              answers.add(a + b);

          } else {
              int wronganswer = rand.nextInt(41);

              while (wronganswer == a + b) {

                  wronganswer = rand.nextInt(41);
              }

              answers.add(wronganswer);
          }

      }

      button0.setText(Integer.toString(answers.get(0)));
      button1.setText(Integer.toString(answers.get(1)));
      button2.setText(Integer.toString(answers.get(2)));
      button3.setText(Integer.toString(answers.get(3)));




  }

    public void start(View view){

        startbutton.setVisibility(View.INVISIBLE);
        gamelayout.setVisibility(View.VISIBLE);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    startbutton = findViewById(R.id.startbut);
    sumtext = findViewById(R.id.questiontextview);
    button0 = findViewById(R.id.button0);
    button1 = findViewById(R.id.button1);
    button2 = findViewById(R.id.button2);
    button3 = findViewById(R.id.button3);
    textView = findViewById(R.id.textView5);
    numberTextview =  findViewById(R.id.numberstextview);
    timerTextview = findViewById(R.id.timertextview);
    playagain = findViewById(R.id.playagain);
    gamelayout = findViewById(R.id.gamelayout);
    gamelayout.setVisibility(View.INVISIBLE);
    startbutton.setVisibility(View.VISIBLE);

      playagain(textView);

    }




    }

