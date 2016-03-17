package com.aic.paas.task.util.http;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class HttpPostWithBody extends HttpEntityEnclosingRequestBase {
	  public static final String METHOD_NAME = "POST";
	  public String getMethod() { return METHOD_NAME; }

	  public HttpPostWithBody(final String uri) {
	    super();
	    setURI(URI.create(uri));
	  }
	  public HttpPostWithBody(final URI uri) {
	    super();
	    setURI(uri);
	  }
	  public HttpPostWithBody() { super(); }
}
