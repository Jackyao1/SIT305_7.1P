package com.example.Jack7_1P;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Jack7_1P.database.Database;
import com.example.Jack7_1P.model.Items;

public class CreateAdvert extends AppCompatActivity {

    TextView textboxName, textboxPhone, textboxDescription, textboxDate, textboxLocation;
    RadioButton RDBLost, RDBFound;
    Button btnSaveAdvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_advert);

        Database db = new Database(this);

        textboxName = findViewById(R.id.editTextName);
        textboxPhone = findViewById(R.id.editTextPhone);
        textboxDescription = findViewById(R.id.editTextDes);
        textboxDate = findViewById(R.id.editTextDate);
        textboxLocation = findViewById(R.id.editTextLocation);
        RDBLost = findViewById(R.id.lostButton);
        RDBFound = findViewById(R.id.foundButton);
        btnSaveAdvert = findViewById(R.id.BtnSaveAdvert);

        Intent ReturnMain = new Intent(this, MainActivity.class);

        btnSaveAdvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Type = "";
                String Name = textboxName.getText().toString();
                int Phone = 0;
                String Description = textboxDescription.getText().toString();
                String Date = textboxDate.getText().toString();
                String Location = textboxLocation.getText().toString();
                boolean input = true;
                if (RDBLost.isChecked() == true){
                    Type = "Lost";
                }else if (RDBFound.isChecked() == true){
                    Type = "Found";
                }else{
                    input = false;
                }
                if (!textboxPhone.getText().toString().equals("")){
                    Phone = Integer.parseInt(textboxPhone.getText().toString());
                }else{
                    input = false;
                }
                if (textboxName.getText().toString().equals("")||textboxDescription.getText().toString().equals("")
                        ||textboxDate.getText().toString().equals("")||textboxLocation.getText().toString().equals("")){
                    input = false;
                }
                Items tempItems;
                if (input == true){
                    tempItems = new Items(Type,Name,Phone,Description,Date,Location);
                    db.InsertAdvert(tempItems);
                    startActivity(ReturnMain);
                }else{
                    Toast.makeText(getApplicationContext(), "Please filled in every boxes and button!.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}