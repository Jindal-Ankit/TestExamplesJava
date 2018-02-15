import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class SimpleDateFormat {

	public static void main(String[] args) throws ParseException {

		
		//String input = "Mon Jun 18 00:00:00 IST 2012";
	/*	String input = "Mon Feb 03 2014 00:00:00 GMT+0000";
		DateTimeFormatter f = DateTimeFormatter.ofPattern( "E MMM dd HH:mm:ss z uuuu" )
		                                       .withLocale( Locale.US );
		ZonedDateTime zdt = ZonedDateTime.parse( input , f );
		
		LocalDate ld = zdt.toLocalDate();
		DateTimeFormatter fLocalDate = DateTimeFormatter.ofPattern( "dd/MM/uuuu" );
		String output = ld.format( fLocalDate) ;

		System.out.println(output);
*/		
		
		String dateFormat = "EEE MMM dd yyyy HH:mm:ss X";
		String inputDate = "Mon Feb 03 2014 00:00:00 GMT+0000";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(dateFormat);
		Date date = sdf.parse(inputDate);		
		java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("dd-mm-yyyy");
		String formattedDate = df.format(date);
		System.out.println(date + " After Formatting " + formattedDate);
/*		String origDate = "Mon Feb 03 2014 00:00:00 GMT+0000";
		String str = "08-FEB-2014";
		
		String expected = "dd-MMM-yyyy";
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(expected);
		
		try {
			sdf.parse(origDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}*/
	}

}
