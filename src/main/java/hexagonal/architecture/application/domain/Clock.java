package hexagonal.architecture.application.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 
 * @author cisse
 *
 */
public class Clock {
	/*
	 * This function return a string who represent the Sysdate formated dd/MM/yyyy
	 */
	public String dateAsString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return simpleDateFormat.format(new Date());
	}
}
