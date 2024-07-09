package com.u063.sqlcommands;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import androidx.transition.ViewGroupOverlayApi14;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.database.Cursor;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
	
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void Run(View w){
		EditText et=findViewById(R.id.name);
		EditText etx=findViewById(R.id.mlCommand);
		SQLiteDatabase db = getBaseContext().openOrCreateDatabase(et.getText().toString()+".db", MODE_PRIVATE, null);
		Toast.makeText(this, "Succeful", Toast.LENGTH_SHORT).show();
		db.execSQL(etx.getText().toString());
	}
	public void getData(View w){
		EditText et=findViewById(R.id.name);
		EditText etx=findViewById(R.id.file);
		
		
		SQLiteDatabase db = getBaseContext().openOrCreateDatabase(et.getText().toString()+".db", MODE_PRIVATE, null);
		Toast.makeText(this, "Succeful", Toast.LENGTH_SHORT).show();
		try {
			List text=Files.readAllLines(Paths.get(etx.getText().toString()));
			
			for (String line : text) {
				//System.out.println(line);
				db.execSQL(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//List text=Files.readAllLines(Paths.get(etx.getText().toString()));
	}
}
