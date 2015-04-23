package com.cloudesire.fed4fire.bonfire.compute.client.impl;

import com.cloudesire.tisana4j.ExceptionTranslator;
import com.cloudesire.tisana4j.exceptions.RestException;
import org.apache.http.Header;

public class BonfireExceptionTranslator implements ExceptionTranslator
{

	public static class BonfireException extends RestException
	{

		public BonfireException ( Integer responseCode, String msgError )
		{
			super(responseCode, msgError);
		}

		@Override public String toString ()
		{
			return "BonfireException{} " + super.toString();
		}
	}

	@Override public  RestException  translateException ( int responseCode, String responseMessage,
			String bodyMessage, ResponseMessage returnMessageRef, Header[] headers )
	{
		Integer rcode = null;
		for (Header h : headers)
		{
			if(h.getName().equals("Content-Type") && h.getValue().contains("application/vnd.bonfire+xml"))
					return  new RestException( responseCode, "" + responseMessage + ": " + bodyMessage );

			if(h.getName().equals("Content-Length"))
			try
			{
				rcode = Integer.parseInt(h.getValue());
			}catch (NumberFormatException e)
			{
				rcode = null;
			}
		}

		return  new BonfireException( rcode, "" + responseMessage + " - " + bodyMessage );
	}
}
