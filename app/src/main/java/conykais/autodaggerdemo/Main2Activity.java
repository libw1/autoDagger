package conykais.autodaggerdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import javax.inject.Inject;

import autodagger.AutoInjector;

@AutoInjector(App.class)
public class Main2Activity extends AppCompatActivity {

    @Inject
    Person person;
    @Inject
    Test test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        DaggerService.<AppComponent>get(getApplicationContext()).inject(this);
        TextView textView = findViewById(R.id.text);
        textView.setText(person.getName());
        Log.d("aa", "onCreate: 2main " + person);
    }
}
