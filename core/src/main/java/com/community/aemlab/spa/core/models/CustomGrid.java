package com.community.aemlab.spa.core.models;

import org.osgi.annotation.versioning.ConsumerType;

import com.adobe.cq.export.json.ContainerExporter;
import com.adobe.cq.wcm.core.components.models.Component;

@ConsumerType
public interface CustomGrid extends Component, ContainerExporter {

	public String getDescription();

	public String getTitle();
	
	public String getGridLayout();

}