package jp.iface.common;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;


public class CommonUtil {

	public boolean isEmpty(String str) {

		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}

	public String zeroToBlank(int num) {

		if (num == 0) {
			return "";
		} else {
			return new Integer(num).toString();
		}
	}

	public String toStringDate(Date date) {

		if(date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		return df.format(date);
	}

	public String toStringDateTime(Date date) {

		if(date == null) {
			return "";
		}
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		return df.format(date);
	}
	public static String toString(double value) {

		return String.format("%f", value);
	}

	public Date convertDate(String date, String pattern) {

		if (date != null && !date.equals("")) {

			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				return format.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}
	public Date convertDate(String date, String pattern, Locale locale) {

		if (date != null && !date.equals("")) {

			SimpleDateFormat format = new SimpleDateFormat(pattern, locale);
			try {
				return format.parse(date);
			} catch (ParseException e) {
				return null;
			}
		}
		return null;
	}

	public Integer convertInt(String num) {

		if (num != null && num.equals("")) {

			try {
				return Integer.parseInt(num);
			}catch (Exception e) {
				return null;
			}
		}
		return null;
	}

	public String getImageBase64(String _url) {

		URLConnection conn = null;
		InputStream in = null;
		String responseData = "";
		try {

			URL url = new URL(_url); // ダウンロードする URL
			conn = url.openConnection();
			InputStream inputStream = conn.getInputStream();

            ByteArrayOutputStream bout = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            while(true) {
                int len = inputStream.read(buffer);
                if(len < 0) {
                    break;
                }
                bout.write(buffer, 0, len);
            }
            responseData = Base64.getEncoder().encodeToString(bout.toByteArray());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (in != null) {
					in.close();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseData;
	}
}
