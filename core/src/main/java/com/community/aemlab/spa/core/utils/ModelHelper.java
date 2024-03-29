package com.community.aemlab.spa.core.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModelHelper.class);

	/**
	 * @param resource
	 * @param modelClass class of the model
	 * @param <T>        type of class of the model
	 * @return List of models retrieved from the children of the input resource
	 */
	public static <T> List<T> getChildrenModels(final Resource resource, Class<T> modelClass) {
		List<T> items = null;
		if (resource != null) {
			items = new ArrayList<T>();

			final Iterator<Resource> childrenIterator = resource.listChildren();
			while (childrenIterator.hasNext()) {
				final Resource next = childrenIterator.next();
				final T item = next.adaptTo(modelClass);
				items.add(item);
			}
		}
		return items;
	}

	/**
	 * @param <T>
	 * @param strings array object
	 * @return List of object values
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> covertArrayToList(Object[] prop) {
		List<T> list = new ArrayList<T>();
		if (prop != null)
			list = (List<T>) Arrays.asList(prop);
		return list;
	}

	/**
	 * @param string url
	 * @return string Formatted url
	 */
	public static String getLink(String url) {
		String link = url;
		if (url != null) {
			final String regex = "(http:\\/\\/|https:\\/\\/(www)?)([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?";
			final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
			final Matcher matcher = pattern.matcher(url);
			if (!(matcher.find() || url.startsWith("#") || url.equals("/") || url.contains("?")
					|| url.toLowerCase().matches(
							".*\\.(doc|docx|htm|html|odt|pdf|xls|xlsx|ods|ppt|pptx|txt|png|jpeg|jpg|xls|xlsx|svg|zip|shtml|json|log)$")
					|| url.toLowerCase().startsWith("tel:") || url.toLowerCase().startsWith("mailto:"))) {
				link = link + ".html";
			}
		}
		return link;
	}

}