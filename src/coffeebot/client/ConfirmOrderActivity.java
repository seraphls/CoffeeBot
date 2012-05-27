package coffeebot.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;

public class ConfirmOrderActivity extends Activity {
	private String order;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.confirm_screen);
	    
	    final Button sendButton = (Button) findViewById(R.id.sendOrderButton);
		final EditText orderText = (EditText) findViewById(R.id.orderPreview);
		orderText.setText("Order");
		sendButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				sendOrder();
			}
		});
	}
    
	public ConfirmOrderActivity(String orderIn) {
		order = orderIn;
	}
	
	public void sendOrder() {
		String subject;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		Date date = new Date();
		subject = "Order: " + User.getUserName() + ": " + dateFormat.format(date);
		Intent intent = new Intent(Intent.ACTION_SENDTO);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_SUBJECT, subject);
		intent.putExtra(Intent.EXTRA_TEXT, order.toString());
		intent.setData(Uri.parse("@string/server_email"));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		
	}
	
	public String toString() {
		return order;
	}
	
}
