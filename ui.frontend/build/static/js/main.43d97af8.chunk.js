(this["webpackJsonpaem-spa"]=this["webpackJsonpaem-spa"]||[]).push([[0],{210:function(t,e,n){t.exports=n(474)},471:function(t,e,n){},472:function(t,e,n){},473:function(t,e,n){},474:function(t,e,n){"use strict";n.r(e);n(211),n(388),n(436);var a=n(59),o=n(29),s=n(2),p=n.n(s),r=n(206),c=n(19),i=n(48),m=n(49),u=n(51),b=n(50),l=n(8),O=function(t){Object(u.a)(n,t);var e=Object(b.a)(n);function n(){return Object(i.a)(this,n),e.apply(this,arguments)}return Object(m.a)(n,[{key:"render",value:function(){return p.a.createElement("div",null,this.childComponents,this.childPages)}}]),n}(l.Page),h=Object(l.withModel)(O),y=n(209),j=n(58);n(471);var E,d,g=function(t){Object(u.a)(n,t);var e=Object(b.a)(n);function n(){return Object(i.a)(this,n),e.apply(this,arguments)}return Object(m.a)(n,[{key:"containerProps",get:function(){var t=Object(y.a)(Object(j.a)(n.prototype),"containerProps",this);return t.className=(t.className||"")+" page "+(this.props.cssClassNames||""),t}}]),n}(l.Page),T=(Object(l.MapTo)("aem-spa/components/page")(Object(l.withComponentMappingContext)((E=g,function(t){Object(u.a)(n,t);var e=Object(b.a)(n);function n(){return Object(i.a)(this,n),e.apply(this,arguments)}return Object(m.a)(n,[{key:"render",value:function(){var t=this,e=this.props.cqPath;return e?(d=d||"html",p.a.createElement(c.d,{key:e,exact:!0,path:"(.*)"+e+"(."+d+")?",render:function(e){return p.a.createElement(E,Object.assign({},t.props,e))}})):p.a.createElement(E,this.props)}}]),n}(s.Component)))),n(208)),C=n.n(T);n(472);var M=function(t){Object(u.a)(n,t);var e=Object(b.a)(n);function n(){return Object(i.a)(this,n),e.apply(this,arguments)}return Object(m.a)(n,[{key:"richTextContent",get:function(){return p.a.createElement("div",{id:(t=this.props.cqPath,t&&t.replace(/\/|:/g,"_")),"data-rte-editelement":!0,dangerouslySetInnerHTML:{__html:C.a.sanitize(this.props.text)}});var t}},{key:"textContent",get:function(){return p.a.createElement("div",null,this.props.text)}},{key:"render",value:function(){return this.props.richText?this.richTextContent:this.textContent}}]),n}(s.Component);Object(l.MapTo)("aem-spa/components/text")(M,{emptyLabel:"Text",isEmpty:function(t){return!t||!t.text||t.text.trim().length<1}});Object(l.MapTo)("aem-spa/components/container")(Object(l.withComponentMappingContext)(l.AllowedComponentsContainer),{emptyLabel:"Container",isEmpty:function(t){return!t||!t.cqItemsOrder||0===t.cqItemsOrder.length}});Object(l.MapTo)("aem-spa/components/experiencefragment")(Object(l.withComponentMappingContext)(l.Container),{emptyLabel:"Experience Fragment",isEmpty:function(t){return!t||!t.configured}});var f=n(42),V=n(21);Object(l.MapTo)("aem-spa/components/download")(V.DownloadV1,{isEmpty:V.DownloadV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/list")(V.ListV2,{isEmpty:V.ListV2IsEmptyFn}),Object(l.MapTo)("aem-spa/components/separator")(V.SeparatorV1,{isEmpty:V.SeparatorV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/breadcrumb")(V.BreadCrumbV2,{isEmpty:V.BreadCrumbV2IsEmptyFn}),Object(l.MapTo)("aem-spa/components/button")(V.ButtonV1,{isEmpty:V.ButtonV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/teaser")(V.TeaserV1,{isEmpty:V.TeaserV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/image")(V.ImageV2,{isEmpty:V.ImageV2IsEmptyFn}),Object(l.MapTo)("aem-spa/components/title")(V.TitleV2,{isEmpty:V.TitleV2IsEmptyFn}),Object(l.MapTo)("aem-spa/components/navigation")(V.NavigationV1),Object(l.MapTo)("aem-spa/components/languagenavigation")(V.LanguageNavigationV1),Object(l.MapTo)("aem-spa/components/tabs")(f.TabsV1,{isEmpty:f.TabsV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/accordion")(f.AccordionV1,{isEmpty:f.AccordionV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/carousel")(f.CarouselV1,{isEmpty:f.CarouselV1IsEmptyFn}),Object(l.MapTo)("aem-spa/components/container")(f.ContainerV1,{isEmpty:f.ContainerV1IsEmptyFn});n(473);document.addEventListener("DOMContentLoaded",(function(){a.ModelManager.initialize().then((function(t){var e=Object(o.a)();Object(r.render)(p.a.createElement(c.e,{history:e},p.a.createElement(h,{history:e,cqChildren:t[a.Constants.CHILDREN_PROP],cqItems:t[a.Constants.ITEMS_PROP],cqItemsOrder:t[a.Constants.ITEMS_ORDER_PROP],cqPath:t[a.Constants.PATH_PROP],locationPathname:window.location.pathname})),document.getElementById("spa-root"))}))}))}},[[210,1,2]]]);
//# sourceMappingURL=main.43d97af8.chunk.js.map