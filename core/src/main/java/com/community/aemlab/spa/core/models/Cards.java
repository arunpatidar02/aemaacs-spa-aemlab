package com.community.aemlab.spa.core.models;

import org.osgi.annotation.versioning.ProviderType;

import com.adobe.cq.export.json.ComponentExporter;

@ProviderType
public interface Cards extends ComponentExporter {

	public LinkModel getCardLink();

	public String getCardDescription();

	public String getCardTitle();
	
	public String getCardLayout();

}