package coffeebot.client;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.net.Uri;
import android.text.format.DateFormat;
import android.app.Activity;

public class Order extends Activity {
	private static final String SERVER_EMAIL = "mailto:seraph.lesabre@live.com";
	private String order;
	
	public Order(String orderIn) {
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
		intent.setData(Uri.parse(SERVER_EMAIL));
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(intent);
		
	}
	
	public String toString() {
		return order;
	}
	
}
