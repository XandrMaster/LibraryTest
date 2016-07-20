package test.example.xandr.com.deploylibstest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import test.example.xandr.com.librarytest.LibsClass;

public class MainActivity extends AppCompatActivity {

	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				LibsClass libsClass = new LibsClass();
				Log.d("TAG", libsClass.publicFunc("My name"));
			}
		});
	}
}
