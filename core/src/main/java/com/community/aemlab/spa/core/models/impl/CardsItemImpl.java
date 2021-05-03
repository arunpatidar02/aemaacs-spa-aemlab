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
import com.community.aemlab.spa.core.models.CardItem;
import com.community.aemlab.spa.core.models.LinkModel;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { CardItem.class,
		ComponentExporter.class }, resourceType = CardsItemImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CardsItemImpl implements CardItem {

	static final String RESOURCE_TYPE = "aemlab-spa/components/custom/cards/card-item";

	@Self
	private SlingHttpServletRequest request;

	@ChildResource(name = "cta")
	private LinkModel cta;

	@ValueMapValue
	private String pretitle;

	@ValueMapValue
	private String title;

	@ValueMapValue
	private String description;

	@ValueMapValue
	private String fileReference;

	@Override
	public String getCardItemImage() {
		return fileReference;
	}

	@Override
	public LinkModel getCardItemLink() {
		return cta;
	}

	@Override
	public String getCardItemDescription() {
		return description;
	}

	@Override
	public String getCardItemTitle() {
		return title;
	}

	@Override
	public String getCardItemPretitle() {
		return pretitle;
	}

	@Override
	public String getExportedType() {
		return CardsItemImpl.RESOURCE_TYPE;
	}

}