package com.community.aemlab.spa.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.community.aemlab.spa.core.models.Cards;
import com.community.aemlab.spa.core.models.LinkModel;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { Cards.class,
		ComponentExporter.class }, resourceType = CardsImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CardsImpl implements Cards {

	static final String RESOURCE_TYPE = "aemlab-spa/components/custom/cards";

	@Self
	private SlingHttpServletRequest request;

	@ChildResource(name = "cta")
	private LinkModel cta;

	@ValueMapValue
	private String cardLayout;

	@ValueMapValue
	private String title;

	@ValueMapValue
	private String description;

	@Override
	public LinkModel getCardLink() {
		return cta;
	}

	@Override
	public String getCardDescription() {
		return description;
	}

	@Override
	public String getCardTitle() {
		return title;
	}

	@Override
	public String getCardLayout() {
		return cardLayout;
	}

	@Override
	public String getExportedType() {
		return CardsImpl.RESOURCE_TYPE;
	}

}