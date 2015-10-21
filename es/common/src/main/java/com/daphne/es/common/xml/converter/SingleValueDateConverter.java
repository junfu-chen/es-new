package com.daphne.es.common.xml.converter;

import java.text.ParseException;
import java.util.Date;



import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
public class SingleValueDateConverter implements Converter {
	
	public static String pattern="yyyy-MM-dd HH:mm:ss";
	
    public void marshal(Object source, HierarchicalStreamWriter writer,
            MarshallingContext context) {
    	Date date = (Date) source;
        writer.setValue(DateFormatUtils.format(date, pattern));
    }
    
    public Object unmarshal(HierarchicalStreamReader reader,
            UnmarshallingContext context) {
    	Date date = null;
		try {
			date = DateUtils.parseDate(reader.getValue(), pattern);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return date;
    }

    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }
}