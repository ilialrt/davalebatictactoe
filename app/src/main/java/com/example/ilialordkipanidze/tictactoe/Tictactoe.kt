package com.example.ilialordkipanidze.tictactoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Tictactoe : AppCompatActivity implements View.OnClickListener() {


    private Button[][] buttons= new Button[3][3];

    private boolean player1Turn = true;

    private int roundCount;

    private int player1points;
    private int player2points;

    private TextView textViewPlayer1;
    private  TextView textViewPlayer2;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)



        textViewPlayer1= findViewById(R.id.text_view_p1);
        textViewPlayer2=findViewById(R.id.text_view_p2);

        for (int i = 0;i < 3;i++){
             for (int j = 0;j<3;j++){
                  String buttonID = "button_"+ i + j;
                   int resID=getResources().getIdentifier(buttonID, defType:"id", getPackageName());
                    buttons[i][j] = findViewById(resID);
                     buttons[i][j].setOnClickListener(this);

        }

        }
Button buttonReset = findViewById(R.id.button_reset);
 buttonReset.setOnClickListener(new View.OnClickListener(){
         @Override
         public void onClick(View v){
resetGame();
 }
    });
    }
    @Override
    public void onClick(View v){
         if (!(( Button) v).getText().toString().eqauls("")) {
             return;
         }

        if (player1Turn){
            ((Button) v).setText("X");
        }else {
            ((Button) v).setText("O");
        }

        roundCount++;


        if(checkForWin()){
            if(player1Turn) {
                player1Wins();
            } else{
                player2Wins();
            }
        } else if (roundCount== 9){
            draw();
        } else {
            player1Turn = !player1Turn;
        }

    }


    private boolean CheckForWin(){
        String[][] field = new String[3][3];

        for (int i = 0;i < 3;i++){
        for (int j = 0;j < 3;j++){
             field[i][j] = buttons[i][j].getText().toString();
    }
    }
    }
    for (int i=0;i < 3;i++){
        if (field[i][0].equals(field[i][1])
        && field[i][0].equals(field[i][2])
        && !field[i][0].equals(""))  {
            return true;
        }
    }

}
for (int i=0;i < 3;i++){
    if (field[0][i].equals(field[1][i])
            && field[0][i].equals(field[2][i])
            && !field[0][i].equals(""))  {
        return true;
    }

    if (field[0][0].equals(field[1][1])
            && field[0][0].equals(field[2][2])
            && !field[0][0].equals(""))  {
        return true;
    }

    if (field[0][2].equals(field[1][1])
            && field[0][2].equals(field[2][0)
            && !field[0][2].equals(""))  {
        return true;
    }

    return false;
}
private void player1Wins(){
    player1Points++;
    Toast.makeText(context:this,"Player 1 Wins!",Toast.LENGTH_SHORT).show();
    updatePointsText();
    resetBoard();
}

private void player2Wins(){
    player2Points++;
    Toast.makeText(context:this,"Player 2 Wins!",Toast.LENGTH_SHORT).show();
    updatePointsText();
    resetBoard();
}
}

private void draw() {
    Toast.maketext(context:this,"Draw!",Toast.LENGTH_SHORT).show();
    resetBoard();
}

private void updatePointsText(){
    textViewPlayer1.setText("Player 1: " + player1Points)
    textViewPlayer2.setText("Player 2:" + player2Points)
}

private void resetBoard(){
    for (int i = 0;i < 3;i++){
        for(int j = 0;j < 3;j++){
        buttons[i][j].setText("");
    }


        roundCount = 0;
        player1Turn = true;
    }

    private void resetGame(){
        Player1Points = 0;
        Player2Points = 0;
        updatePointsText();
        resetBoard();
    }
}
@Override
 protected void onSaveInstance(Bundle outState){
    super.onSaveInstanceState(outState);

    outState.putInt("roundCount",roundCount);
    outStateputInt("player1Points",player1Points);
    outStateputInt("player2Points",player2Points);
    outState.putBoolean("player1Turn",player1Turn);
}

@Overide
protected void onRestoreInstanceState(Bundle savedInstnceState){
    super.onRestoreInstanceState(savedInstanceState);

    roundCount = savedInstanceState.getInt(key:"roundCount");
    player1Points = savedInstanceState.getInt(key:"player1Points");
    player2Points = savedInstanceState.getInt(key:"player2Points");
    player1Turn = savedInstanceState.getBoolean(key:"player1Turn");git remote
}
}
}
