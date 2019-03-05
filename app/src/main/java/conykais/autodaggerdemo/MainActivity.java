package conykais.autodaggerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import autodagger.AutoInjector;

@AutoInjector(App.class)
public class MainActivity extends AppCompatActivity {

    @Inject
    Person person;
    @Inject
    Test test;
    @Inject
    Mode mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerService.<AppComponent>get(this.getApplicationContext()).inject(this);
//        person = DaggerService.<AppDependencies>get(getApplicationContext()).person();
        TextView textView = findViewById(R.id.tv);
        textView.setText(test.getName());
        Log.d("aa", "onCreate: main " + person);
        Log.d("aa", "onCreate: main " + mode.toString());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, Main2Activity.class));
            }
        });
    }
}
