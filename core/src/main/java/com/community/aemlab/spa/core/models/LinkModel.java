package com.community.aemlab.spa.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class LinkModel {

	@ValueMapValue
	private String linkText;

	@ValueMapValue
	private String linkURL;

	public String getLinkURL() {
		return linkURL;
	}

	public String getLinkText() {
		return linkText;
	}


}