import { MapTo } from '@adobe/aem-react-editable-components';
import React, { Component } from 'react';
import DOMPurify from 'dompurify';
import extractModelId from '../../utils/extract-model-id';

require('./CardItem.css');

/**
 * Default Edit configuration for the Card Item component
 *
 * @type EditConfig
 */
const CardItemEditConfig = {
  emptyLabel: 'Card Item',

  isEmpty: function (props) {
    return !props || !props.cardItemTitle || !props.cardItemDescription || !props.cardItemImage || !props.cardItemPretitle || !props.cardItemLink;
  }
};

/**
 * Card Item React component
 */
class CardItem extends Component {

  get description() {
    return (
      <div
        id={extractModelId(this.props.cqPath)}
        data-rte-editelement
        dangerouslySetInnerHTML={{
          __html: DOMPurify.sanitize(this.props.cardItemDescription)
        }}
      />
    );
  }

  get cta() {
    return this.props.CardItemLink ? <a href={this.props.cardItemLink.linkURL}>{this.props.cardItemLink.linkText}</a> : "";
  }

  render() {
    return (
      <div className="cards-item_container">
        <div className="cards-item_image"><img alt="" src={this.props.cardItemImage} /></div>
        <div className="cards-item_pretitle">{this.props.cardItemPretitle}</div>
        <div className="cards-item_title">{this.props.cardItemTitle}</div>
        <div className="cards-item_description">{this.description}</div>

        <div className="cards-item_cta">{this.cta}</div>
      </div>
    );
  }
}

export default MapTo('aemlab-spa/components/custom/cards/card-item')(
  CardItem,
  CardItemEditConfig
);
