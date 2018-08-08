package sg.edu.rp.c346.dynamicspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1, spn2;
    Button btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        //to update entries of the spinner(same as ListView)
        final ArrayList<String>alNumbers;
        final ArrayAdapter<String>aaNumbers;

        //initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);

        //Bind the ArrayAdapter to the spinner
        spn2.setAdapter(aaNumbers);



        //This is appoach 1 to add the numbers to arraylist
//        alNumbers.add("2");
//        alNumbers.add("4");
//        alNumbers.add("6");

        //This is approach 2 to add the numbers to arraylist
          //Get the string-array and store as an Array
//        String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
          //Convert Array to List and add to the ArrayList
//        alNumbers.addAll(Arrays.asList(strNumbers));

          //Set the spinner by clicking the button
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                int pos = spn1.getSelectedItemPosition();
                    //need to clear the list first because everytime press the button, it will just add on so must clear
//                alNumbers.clear();
//
//                if(pos == 0){
//                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                else{
//                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//              aaNumbers.notifyDataSetChanged();
//            }
//        });

        //Set the spinner automatically
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                alNumbers.clear();

//              Approach 1
                switch (i){
                    case 0:
                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    //2 is the position of the numbers that i want it to show which is 6
                    spn2.setSelection(2);
                    break;
                    case 1:
                    String[] strNumbers1 = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers1));
                    //1 is the position of the numbers that i want it to show which is 3
                    spn2.setSelection(1);
                    break;
                }

//                Approach 2
//                if(pos == 0){
//                    String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }
//                else{
//                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
//                    alNumbers.addAll(Arrays.asList(strNumbers));
//                }

              aaNumbers.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}
