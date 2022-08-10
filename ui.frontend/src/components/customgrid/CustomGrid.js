import React from "react";
import {ResponsiveGrid, MapTo, withComponentMappingContext} from "@adobe/aem-react-editable-components";
import DOMPurify from 'dompurify';
import extractModelId from '../../utils/extract-model-id';

require('./CustomGrid.css');

/**
 * Default Edit configuration for the Cards component
 *
 * @type EditConfig
 */
 const CustomGridEditConfig = {
    emptyLabel: 'Custom Grid',

    isEmpty: function (props) {
        return !props || !props.title || !props.description || !props.cqItemsOrder || props.cqItemsOrder.length === 0;
    }
};

export class CustomGrid extends ResponsiveGrid {

    /**
     * The attributes that will be injected in the root element of the container
     *
     * @returns {Object} - the attributes of the container
     */
    get containerProps() {
        let containerProps = super.containerProps;
        containerProps.className = (containerProps.className || '') + ' customgrid-container customgrid-container-' +  this.props.gridLayout;
        return containerProps;
    }

    get description() {
        return (
            <div
                id={extractModelId(this.props.cqPath)}
                data-rte-editelement
                dangerouslySetInnerHTML={{
                    __html: DOMPurify.sanitize(this.props.description)
                }}
            />
        );
    }

    render() {
     /*   var list = [];
        let layoutCount = this.props.gridLayout ? this.props.gridLayout : 1;
        for (var i=1; i<=layoutCount; i++) {
            let className='customgrid_child-container-'+layoutCount+'-'+i;
            list.push(<div className={ className }>{ super.childComponents }{ super.placeholderComponent }</div>);
        } */
       let layoutCount = this.props.gridLayout ? this.props.gridLayout : 1;
       let className = "customgrid_child-container custom-col-layout-"+layoutCount;

        return (
            <div {...this.containerProps}>
                <h3 className="custom-component-message">Custom Grid!</h3>
                <p className="customgrid_title">{this.props.title}</p>
                <div className="customgrid_description">{this.description}</div>
                <div className={className}>
                    { super.childComponents }
                    { super.placeholderComponent }
                </div>
            </div>
        )
    }

}

MapTo('aemlab-spa/components/custom/customgrid')(withComponentMappingContext(CustomGrid),CustomGridEditConfig);