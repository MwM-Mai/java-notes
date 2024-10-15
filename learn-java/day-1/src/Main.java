import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws ParseException {
	Date d = new Date(1000L * 60 * 60 * 24 * 365);
	//SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	//System.out.println(d.getTime());
	//System.out.println(sd.format(d));
	//System.out.println(sd.parse("1971-01-01 08:00:00 周五").getTime());

	//Calendar c = Calendar.getInstance();
	//c.setTime(d);
	//System.out.println(c.getTime());
	//c.set(Calendar.YEAR, 2024);
	//System.out.println(c.getTime());

	Set<String> zoneIds = ZoneId.getAvailableZoneIds();
	ZoneId zd = ZoneId.systemDefault();
	Instant now = Instant.now(); // 获取当前世界时间
	Instant instant = Instant.ofEpochMilli(0L); // 获取世界时间 毫秒
	ZonedDateTime zonedDateTime = Instant.now().atZone(zd);// 获取当前时区的时间戳
	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	String format = dateTimeFormatter.format(zonedDateTime);
	TemporalAccessor parse = dateTimeFormatter.parse("2024-04-16 14:40:59");
	LocalDateTime localDateTime = LocalDateTime.of(2024, 1, 1, 1, 1, 1);


	System.out.println(now);
	System.out.println(instant);
	System.out.println(zonedDateTime);
	System.out.println(parse.get(ChronoField.YEAR));
	System.out.println(localDateTime);
	}
  }