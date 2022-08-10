import React from "react";
import {ResponsiveGrid, MapTo, withComponentMappingContext} from "@adobe/aem-react-editable-components";

require('./MyGrid.css');

export class MyGrid extends ResponsiveGrid {

    /**
     * The attributes that will be injected in the root element of the container
     *
     * @returns {Object} - the attributes of the container
     */
    get containerProps() {
        let containerProps = super.containerProps;
        containerProps.className = (containerProps.className || '') + ' mygrid-container ' +  this.props.gridClassNames;
        return containerProps;
    }

    render() {
        return (
            <div {...this.containerProps}>
                <div className="mygrid-message">Welcome to my Custom Grid!</div>
                { super.childComponents }
                { super.placeholderComponent }
            </div>
        )
    }

}

MapTo('aemlab-spa/components/custom/mygrid')(withComponentMappingContext(MyGrid));