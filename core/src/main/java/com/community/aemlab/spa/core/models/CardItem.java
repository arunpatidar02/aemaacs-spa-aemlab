package com.community.aemlab.spa.core.models;

import org.osgi.annotation.versioning.ProviderType;

import com.adobe.cq.export.json.ComponentExporter;


@ProviderType
public interface CardItem extends ComponentExporter {

	public LinkModel getCardItemLink();
	
	public String getCardItemImage();

	public String getCardItemDescription();

	public String getCardItemTitle();
	
	public String getCardItemPretitle();

}