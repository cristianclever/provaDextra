package br.com.fservice.http.filter;

//com.vulcabras.web.filter.NoCacheFilter
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebFilter("/faces/*")
public class NoCacheFilter implements Filter {



	/*
	 * Atributos
	 */

	private static int cacheTimeoutInMinutes = 60 * 10;

	private static Pattern patternNoCache = Pattern.compile(".*/.xhtm.*");

	private static Pattern patternCache = Pattern.compile(".*/.js.*|.*/.css.*|.*/.jpg.*");

	private static DateFormat httpDateFormat;

	public int getCacheTimeoutInMinutes() {
		return cacheTimeoutInMinutes;
	}

	public void setCacheTimeoutInMinutes(int cacheTimeoutInMinutes) {
		this.cacheTimeoutInMinutes = cacheTimeoutInMinutes * 60;
	}

	public Pattern getPatternNoCache() {
		return patternNoCache;
	}

	public void setPatternNoCache(Pattern patternNoCache) {
		this.patternNoCache = patternNoCache;
	}

	public void destroy() {
	}

	/**
	 * Define a política para o cacheamento utilizando headers
	 * 
	 * @param uri
	 *            a uri que esta sendo requisitada
	 * @param request
	 * @param response
	 * @return true, caso a uri tenha recebido o Header que permite Cache.
	 * @auhtor Cristian Clever
	 * @since 16/07/2010
	 */
	private void processarCache(final String uri, ServletRequest req, ServletResponse resp) {

		final HttpServletRequest request = (HttpServletRequest) req;
		final HttpServletResponse response = (HttpServletResponse) resp;

		if(uri!=null){
			
			
			setNOCacheHeaders(request, response);
			/*
			if(uri.contains(".xhtml")){
				setNOCacheHeaders(request, response);
			}
			else{
				setCacheHeaders( response,cacheTimeoutInMinutes);
			}
			*/
			
		}
		
		
	}

	/**
	 * 
	 * @param response
	 * @param seconds
	 *            quantidade de segundos para que o cache seja expirado
	 * @auhtor Cristian Clever
	 * @since 19/07/2010
	 */
	public static void setNOCacheHeaders(final HttpServletRequest request, final HttpServletResponse response) {
		if (response != null) {

			response.setHeader("Pragma", "public");
			response.setDateHeader("Expires", 0);
			final String userAgent = request.getHeader("User-Agent");

			if (userAgent.toUpperCase().contains("MSIE")) {
				response.setHeader("Cache-Control", "max-age=0;public;must-revalidate, post-check=0, pre-check=0;");
			} else {
				response.setHeader("Cache-Control", "no-cache, no-store");
			}

		}
	}

	/**
	 * 
	 * @param response
	 * @param seconds
	 *            quantidade de segundos para que o cache seja expirado
	 * @auhtor Cristian Clever
	 * @since 19/07/2010
	 */
	public static void setCacheHeaders(HttpServletResponse response, int seconds) {
		if (response != null) {
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.SECOND, seconds);

			StringBuffer buffMaxAge = new StringBuffer();
			buffMaxAge.append("PUBLIC, max-age=").append(seconds).append(", must-revalidate");
			response.setHeader("Cache-Control", buffMaxAge.toString());
			buffMaxAge = null;
			response.setHeader("Expires", getHtmlExpiresDateFormat().format(cal.getTime()));
		}
	}

	private static DateFormat getHtmlExpiresDateFormat() {

		if (httpDateFormat == null) {
			httpDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
			httpDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
		}
		return httpDateFormat;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		processarCache(((HttpServletRequest) request).getRequestURI(), request, response);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
	}

	public Pattern getPatternCache() {
		return patternCache;
	}

	public void setPatternCache(Pattern patternCache) {
		this.patternCache = patternCache;
	}
}
