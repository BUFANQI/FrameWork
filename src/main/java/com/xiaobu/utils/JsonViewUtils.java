package com.xiaobu.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;

public class JsonViewUtils {
	/**
	 * Instantiates a new json view utils.
	 */
	private JsonViewUtils() {
	}

	/**
	 * Render.
	 *
	 * @param model the model
	 * @param response the response
	 */
	public static void render(final Object model, final HttpServletResponse response) {
		try {
			final MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
			jsonConverter.setPrettyPrint(true);
			final MediaType jsonMimeType = MediaType.APPLICATION_JSON;
			jsonConverter.write(model, jsonMimeType, new ServletServerHttpResponse(response));
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Render.
	 *
	 * @param response the response
	 */
	public static void render(final HttpServletResponse response) {
		try {
			final Map<String, Object> map = new HashMap<String, Object>();
			response.setStatus(HttpServletResponse.SC_OK);
			render(map, response);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Render exception.
	 *
	 * @param ex the ex
	 * @param response the response
	 */
	public static void renderException(final Exception ex, final HttpServletResponse response) {
		final Map<String, String> map = new HashMap<String, String>();
		map.put("error", ex.getMessage());
		map.put("stacktrace", Arrays.deepToString(ex.getStackTrace()));
		renderException(map, response);
	}

	/**
	 * Render exception.
	 *
	 * @param model the model
	 * @param response the response
	 */
	private static void renderException(final Map model, final HttpServletResponse response) {
		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		model.put("status", HttpServletResponse.SC_BAD_REQUEST);
		render(model, response);
	}
	
	
	 public static void toJSONResponse(String jsonString, HttpServletResponse response) {
		if (response == null) {
			return;
		}
		response.setContentType("application/jsonrequest");
		response.setCharacterEncoding("UTF-8");
		PrintWriter pw = null;
		try {
			pw = response.getWriter();
			pw.write(jsonString);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			if (pw != null) {
				pw.flush();
				pw.close();
			}
		}
	}
}
