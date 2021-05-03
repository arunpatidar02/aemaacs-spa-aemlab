 import { MapTo } from '@adobe/aem-react-editable-components';
 import DOMPurify from 'dompurify';
 import React, { Component } from 'react';
 import extractModelId from '../../utils/extract-model-id';
 
 require('./Cards.css');
 
 /**
  * Default Edit configuration for the Cards component
  *
  * @type EditConfig
  */
 const CardsEditConfig = {
   emptyLabel: 'Cards',
 
   isEmpty: function(props) {
    return !props || !props.cardTitle;
   }
 };
 
 /**
  * Cards React component
  */

 class Cards extends Component {
    get title() {
        return <div>{this.props.cardTitle}</div>;
      }
      get description() {
        return <div>{this.props.cardDescription}</div>;
      }
    
      render() {
        return (
    <>
    <div>{this.title}</div>
    <div>{this.description}</div>
    </>
        );
      }
 }
 
 export default MapTo('aemlab-spa/components/custom/cards')(
    Cards,
    CardsEditConfig
 );
 