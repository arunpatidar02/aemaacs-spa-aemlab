import { MapTo } from '@adobe/aem-react-editable-components';
import React, { Component } from 'react';
import DOMPurify from 'dompurify';
import extractModelId from '../../utils/extract-model-id';

require('./Cards.css');

/**
 * Default Edit configuration for the Cards component
 *
 * @type EditConfig
 */
const CardsEditConfig = {
    emptyLabel: 'Cards',

    isEmpty: function (props) {
        return !props || !props.cardTitle || !props.cardDescription || !props.cardLink;
    }
};

/**
 * Cards React component
 */

class Cards extends Component {
    get description() {
        return (
            <div
                id={extractModelId(this.props.cqPath)}
                data-rte-editelement
                dangerouslySetInnerHTML={{
                    __html: DOMPurify.sanitize(this.props.cardDescription)
                }}
            />
        );
    }

    get cta() {
        return this.props.cardLink ? <a href={this.props.cardLink.linkURL}>{this.props.cardLink.linkText}</a> : "";
    }

    render() {
        return (
            <div className="cards_container">
                <div className="cards_title">{this.props.cardTitle}</div>
                <div className="cards_description">{this.description}</div>

                <div className="cards_cta">{this.cta}</div>
            </div>
        );
    }
}

export default MapTo('aemlab-spa/components/custom/cards')(
    Cards,
    CardsEditConfig
);
