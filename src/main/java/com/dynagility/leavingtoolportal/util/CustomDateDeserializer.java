package com.dynagility.leavingtoolportal.util;

import java.io.IOException;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dynagility.leavingtoolportal.exceptions.InternalErrorException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class CustomDateDeserializer extends StdDeserializer<Date> {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    public static final String DATE_PATTERN = "dd-MM-yyyy"; 
    public CustomDateDeserializer() {
        this(null);
    }
 
    public CustomDateDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        
        try
        {
            String dateString = p.getText();
            return DateTimeUtil.toUtilDateUTC(dateString, DATE_PATTERN);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new InternalErrorException(e.getMessage());
        }
        
    }

}
