package coffeebot.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CoffeeBotActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    
	    //final String SERVER_EMAIL = "mailto:seraph.lesabre@live.com";
		//String order;
		
		final Button sendButton = (Button) findViewById(R.id.sendOrderButton);
		final EditText orderText = (EditText) findViewById(R.id.orderEntry);
		sendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sendOrder(orderText.getText().toString());
			}
		});
    }
    
    public void sendOrder(String order) {
    	final String SERVER_EMAIL = "mailto:seraph.lesabre@live.com";
    	final String USERNAME = "Prototype";
    	
		String subject = "Sample Order";
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		subject = "Order: " + USERNAME + ": " + dateFormat.format(date);
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, order.toString());
		intent.setData(Uri.parse(SERVER_EMAIL));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		
	}
    
}