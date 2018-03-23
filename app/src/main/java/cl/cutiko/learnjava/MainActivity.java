package cl.cutiko.learnjava;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import cl.cutiko.javasimulator.ServerConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //For practice create an Article model
                Object article = new Object();
                new ServerConnection().upload("/articles/userId/articleId").upload(article, new ServerConnection.ServerResponse() {
                    @Override
                    public void error(String error) {
                        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void success() {
                        Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
