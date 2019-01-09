package com.example.lenovo.game2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ImageView imvAnimal;
    private RadioGroup radAnswer;
    private String strAnswer;
    private MyAlertDialog objMyAlert;
    private Question objQuestion;
    private MyAlertDialog objMyAlertDialog;
    private int intTime = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialwidget();



        objQuestion = new Question();
        objQuestion.setOnQuestionChangeListener(new Question.OnQuestionChangeListener() {
            @Override
            public void onQuestionChangeListener(Question question) {
               switch (question.getIntQuestion()){
                   case 1 :
                       imvAnimal.setImageResource(R.drawable.cow1);
                       break;
                   case 2 :
                       imvAnimal.setImageResource(R.drawable.horse);
                       break;
                   case 3 :
                       imvAnimal.setImageResource(R.drawable.pig);
                       break;
                   case 4 :
                       imvAnimal.setImageResource(R.drawable.sheep);
                       break;
                   default:
                       break;
               }
            }
        });



        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.radCow:
                        strAnswer = "COW";
                        break;
                    case R.id.radHorse:
                        strAnswer = "HORSE";
                        break;
                    case R.id.radPig:
                        strAnswer = "PIG";
                        break;
                    case R.id.radSheep:
                        strAnswer = "SHEEP";
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
            }
        });
    }
    private void initialwidget(){
        imvAnimal = (ImageView) findViewById(R.id.imvAnimal);
        radAnswer = (RadioGroup) findViewById(R.id.radAnswer);

    }

    public void ClickAnswer(View view){
        checkChooseAnswer();
    }
    private void checkChooseAnswer(){
        if (strAnswer != null){
            Log.d("masterUNG", "strAnswer = " + strAnswer);

            sentValueToQuestion();
        }else {
            Log.d("masterUNG","Please Choose Something");

            objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.NoChooseEveryThing(MainActivity.this);
        }
    }
    private void sentValueToQuestion(){

        if(intTime == 4){
            intTime = 0;
        }
        intTime++;

        objQuestion.setIntQuestion(intTime);
    }
}
