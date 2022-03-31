package com.community.aemlab.spa.core.models.impl;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import javax.inject.Inject;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.apache.sling.models.factory.ModelFactory;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;
import com.adobe.cq.export.json.SlingModelFilter;
import com.adobe.cq.wcm.core.components.models.Container;
import com.adobe.cq.wcm.core.components.models.ListItem;
import com.community.aemlab.spa.core.models.CustomGrid;
import com.day.cq.wcm.api.TemplatedResource;
import com.day.cq.wcm.api.components.ComponentManager;
import com.drew.lang.annotations.NotNull;

@Model(adaptables = SlingHttpServletRequest.class, adapters = { CustomGrid.class,
		ComponentExporter.class }, resourceType = CustomGridImpl.RESOURCE_TYPE, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class CustomGridImpl implements CustomGrid, Container {

	static final String RESOURCE_TYPE = "aemlab-spa/components/custom/customgrid";

	@Self
	private SlingHttpServletRequest request;
	
	@Inject @Source("script-bindings")
	Resource resource;

	@ValueMapValue
	private String gridLayout;

	@ValueMapValue
	private String title;

	@ValueMapValue
	private String description;

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getGridLayout() {
		return gridLayout;
	}

	@Override
	public String getExportedType() {
		return CustomGridImpl.RESOURCE_TYPE;
	}
	
	/**
     * The model factory.
     */
    @OSGiService
    protected ModelFactory modelFactory;
    
    /**
     * The sling model factory service.
     */
    @OSGiService
    protected SlingModelFilter slingModelFilter;
	
	/**
     * The list of child items.
     */
    protected List<ListItem> items;

    /**
     * The list of child resources that are components.
     */
    protected List<Resource> childComponents;

    /**
     * The child resources to be exported.
     */
    protected List<Resource> filteredChildComponents;

    /**
     * Map of the child items to be exported wherein the key is the child name, and the value is the child model.
     */
    protected Map<String, ? extends ComponentExporter> itemModels;

    /**
     * The name of the child resources in the order they are to be exported.
     */
    private String[] exportedItemsOrder;


	@NotNull
	@Override
	public Map<String, ? extends ComponentExporter> getExportedItems() {
		 if (itemModels == null) {
	            itemModels = getItemModels(request, ComponentExporter.class);
	        }
	        return itemModels;
	}

	@NotNull
	@Override
	public String[] getExportedItemsOrder() {
		if (exportedItemsOrder == null) {
            Map<String, ? extends ComponentExporter> models = getExportedItems();
            if (!models.isEmpty()) {
                exportedItemsOrder = models.keySet().toArray(ArrayUtils.EMPTY_STRING_ARRAY);
            } else {
                exportedItemsOrder = ArrayUtils.EMPTY_STRING_ARRAY;
            }
        }
        return Arrays.copyOf(exportedItemsOrder, exportedItemsOrder.length);
	}
	
	/**
     * Get the models for the child resources as provided by {@link AbstractContainerImpl#getFilteredChildren()}.
     *
     * @param request The current request.
     * @param modelClass The child model class.
     * @return Map of models wherein the key is the child name, and the value is it's model.
     */
    protected Map<String, ComponentExporter> getItemModels(@NotNull final SlingHttpServletRequest request,
                                                           @NotNull final Class<ComponentExporter> modelClass) {
        Map<String, ComponentExporter> models = new LinkedHashMap<>();
        getFilteredChildren().forEach(child -> {
            ComponentExporter model = modelFactory.getModelFromWrappedRequest(request, child, modelClass);
            if (model != null) {
                models.put(child.getName(), model);
            }
        });
        return models;
    }
    
    /**
     * Return (and cache) the list of children resources that are components, filtered by the Sling Model Filter. This
     * should only be used for JSON export, for other usages refer to {@link AbstractContainerImpl#getChildren}.
     *
     * @return The list of children resources available for JSON export.
     */
    @NotNull
    protected List<Resource> getFilteredChildren() {
        if (filteredChildComponents == null) {
            filteredChildComponents = new LinkedList<>();
            slingModelFilter.filterChildResources(getChildren())
                .forEach(filteredChildComponents::add);
        }
        return filteredChildComponents;
    }
    
    /**
     * Return (and cache) the list of children resources that are components
     *
     * @return List of all children resources that are components.
     */
    @NotNull
    protected List<Resource> getChildren() {
        if (childComponents == null) {
            Resource effectiveResource = this.getEffectiveResource();
            childComponents = Optional.ofNullable(request.getResourceResolver().adaptTo(ComponentManager.class))
                .map(componentManager ->
                    StreamSupport.stream(effectiveResource.getChildren().spliterator(), false)
                        .filter(res -> Objects.nonNull(componentManager.getComponentOfResource(res))))
                .orElseGet(Stream::empty)
                .collect(Collectors.toList());
        }
        return childComponents;
    }
    
    /**
     * Get the effective {@link TemplatedResource} for the current resource.
     *
     * @return The TemplatedResource, or the current resource if it cannot be adapted to a TemplatedResource.
     */
    @NotNull
    protected Resource getEffectiveResource() {
        if (this.resource instanceof TemplatedResource) {
            return this.resource;
        }
        return Optional.ofNullable((Resource)this.resource.adaptTo(TemplatedResource.class))
                .orElse(Optional.ofNullable((Resource)this.request.adaptTo(TemplatedResource.class))
                .orElse(this.resource));
    }

}