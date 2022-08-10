package com.community.aemlab.spa.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.community.aemlab.spa.core.utils.ModelHelper;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

	@ValueMapValue
	private String linkText;

	@ValueMapValue
	private String linkURL;

	@PostConstruct
	protected void init() {
		if (linkURL != null) {
			linkURL = ModelHelper.getLink(linkURL);
		}
	}

	public String getLinkURL() {
		return linkURL;
	}

	public String getLinkText() {
		return linkText;
	}

}