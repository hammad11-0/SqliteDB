package haqnawaz.org.sqlitedb20211216;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button buttonAdd, buttonViewAll;
    EditText editName, editAge;
    Switch switchIsActive;
  private RecyclerView r1;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonViewAll = findViewById(R.id.buttonViewAll);
        editName = findViewById(R.id.editTextName);
        editAge = findViewById(R.id.editTextAge);
        switchIsActive = findViewById(R.id.switchStudent);


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            StudentModel studentModel;

            @Override
            public void onClick(View v) {
                try {
                    studentModel = new StudentModel(editName.getText().toString(), Integer.parseInt(editAge.getText().toString()), switchIsActive.isChecked());
                    Toast.makeText(MainActivity.this, studentModel.toString(), Toast.LENGTH_SHORT).show();
                }
                catch (Exception e){
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                 dbHelper.addStudent(studentModel);
            }
        });

        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                List<StudentModel> list = dbHelper.getAllStudents();
                r1=findViewById(R.id.RecyclerView);



                layoutManager = new LinearLayoutManager(MainActivity.this);
                r1.setLayoutManager(layoutManager);
                adapter = new myRVA(list,MainActivity.this) {

                };
                r1.setAdapter(adapter);


            }
        });

    }
}
