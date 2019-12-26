package exception;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class formatErrorLog extends Formatter {

	@Override
	public String format(LogRecord record) {
		DateFormat simple = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
		Date date = new Date(record.getMillis());
		return record.getMessage()+" "+simple.format(date)+"\n"; 
	}

}
