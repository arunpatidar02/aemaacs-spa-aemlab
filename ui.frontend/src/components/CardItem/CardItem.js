import { MapTo } from '@adobe/aem-react-editable-components';
import DOMPurify from 'dompurify';
import React, { Component } from 'react';
import extractModelId from '../../utils/extract-model-id';

require('./CardItem.css');

/**
 * Default Edit configuration for the Card Item component
 *
 * @type EditConfig
 */
const CardItemEditConfig = {
  emptyLabel: 'Card Item',

  isEmpty: function(props) {
    return !props || !props.cardItemTitle;
  }
};

/**
 * Card Item React component
 */
class CardItem extends Component {

  get title() {
    return <div>{this.props.cardItemTitle}</div>;
  }
  get preTitle() {
    return <div>{this.props.cardItemPretitle}</div>;
  }
  get description() {
    return <div>{this.props.cardItemDescription}</div>;
  }

  render() {
    return (
<>
<div>{this.title}</div>
<div>{this.preTitle}</div>
<div>{this.description}</div>
</>
    );
  }
}

export default MapTo('aemlab-spa/components/custom/cards/card-item')(
  CardItem,
  CardItemEditConfig
);
