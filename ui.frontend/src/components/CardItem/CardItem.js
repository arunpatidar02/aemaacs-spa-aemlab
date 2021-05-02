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
const TextEditConfig = {
  emptyLabel: 'Card Item',

  isEmpty: function(props) {
    return !props || !props.text || props.text.trim().length < 1;
  }
};

/**
 * Card Item React component
 */
class CardItem extends Component {
  get richTextContent() {
    return (
      <div
        id={extractModelId(this.props.cqPath)}
        data-rte-editelement
        dangerouslySetInnerHTML={{
          __html: DOMPurify.sanitize(this.props.text)
        }}
      />
    );
  }

  get textContent() {
    return <div>{this.props.text}</div>;
  }

  render() {
    return this.props.richText ? this.richTextContent : this.textContent;
  }
}

export default MapTo('aemlab-spa/components/custom/cards/card-item')(
  Text,
  TextEditConfig
);
