(this["webpackJsonprestaurant-finder-react"]=this["webpackJsonprestaurant-finder-react"]||[]).push([[0],{39:function(t,e,s){},40:function(t,e,s){},49:function(t,e,s){"use strict";s.r(e);var n=s(1),a=s(0),c=s.n(a),i=s(17),r=s.n(i),o=(s(39),s.p,s(40),s(10)),l=s(2),h=s(9),d=(s(41),s(8)),j=s.n(d),u=s(51),b=s(54),O=s(52),g=s(53),p=s(25),x=s(26),f=j.a.icon({iconUrl:p.a,shadowUrl:x.a});j.a.Marker.prototype.options.icon=f;var m=function(t){return Object(n.jsx)("div",{class:"map",children:Object(n.jsxs)(u.a,{center:[t.details.lat,t.details.lng],zoom:17,scrollWheelZoom:!1,style:{height:"100vh"},children:[Object(n.jsx)(b.a,{attribution:'\xa9 <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',url:"https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"}),Object(n.jsx)(O.a,{position:[t.details.lat,t.details.lng],children:Object(n.jsx)(g.a,{children:t.details.name})})]})})},v=s(18),y=s.n(v);function _(t){var e="",s=t.split(""),n=Number(s[0]+s[1]),a=Number(s[2]+s[3]);return n>0&&n<=12?e=""+n:n>12?e=""+(n-12):0==n&&(e="12"),e+=a<10?":0"+a:":"+a,e+=n>=12?" P.M.":" A.M."}var S=function(t){var e=Object(a.useState)([]),s=Object(h.a)(e,2),c=s[0],i=s[1],r=Object(a.useState)(!1),o=Object(h.a)(r,2),l=o[0],d=o[1],j=Object(a.useState)(!1),u=Object(h.a)(j,2),b=u[0],O=u[1],g=Object(a.useState)("Show Images"),p=Object(h.a)(g,2),x=p[0],f=p[1];if(Object(a.useEffect)((function(){fetch("http://localhost:8080/api/v1/getSingleRestaurant?id="+t.match.params.id,{method:"GET",headers:{"Content-Type":"application/json"}}).then((function(t){return t.json()})).then((function(t){i(t),d(!0),document.title=t.name}))}),[]),l){var v=_(c.open_time),S=_(c.close_time);return Object(n.jsxs)("div",{children:[Object(n.jsx)(y.a,{}),Object(n.jsx)("h1",{children:c.name}),Object(n.jsx)("hr",{}),function(t){return c.is_open_now?Object(n.jsx)("div",{class:"is-open",children:Object(n.jsxs)("h3",{children:["Open until ",t]})}):Object(n.jsx)("div",{class:"is-closed",children:Object(n.jsx)("h3",{children:"This restaurant is currently closed"})})}(S),Object(n.jsxs)("h3",{children:["Phone: ",c.phone]}),Object(n.jsx)("h3",{children:c.overall_rating}),Object(n.jsxs)("h3",{children:["Price: ",c.price]}),Object(n.jsxs)("h3",{children:["Location: ",c.location+" "+c.city+","+c.state]}),Object(n.jsxs)("h3",{children:["Hours: ",v," until ",S]}),Object(n.jsx)("button",{class:"button",onClick:function(){b?(O(!1),f("Show Images")):b||(O(!0),f("Hide Images"))},children:x}),function(t){if(b)return Object(n.jsxs)("div",{class:"images-container",children:[Object(n.jsx)("img",{alt:"",src:t[0]}),Object(n.jsx)("img",{alt:"",src:t[1]}),Object(n.jsx)("img",{alt:"",src:t[2]})]})}(c.photos),Object(n.jsx)(m,{details:c})]})}return Object(n.jsxs)("div",{children:[Object(n.jsx)("h1",{children:"Loading Restaurant Information..."}),Object(n.jsx)("div",{class:"loading-icon"})]})},C=s(27),M=s(28),T=s(16),k=s(32),w=s(31),L=function(t){Object(k.a)(s,t);var e=Object(w.a)(s);function s(t){var n;return Object(C.a)(this,s),(n=e.call(this,t)).componentDidMount=n.componentDidMount.bind(Object(T.a)(n)),n.fetchDataFromYelp=n.fetchDataFromYelp.bind(Object(T.a)(n)),n.state={rest_list:[],search_list:[],searchString:"",searchRegex:"[a-zA-Z[ ]*[0-9]*]+",lat:"",lng:"",dataLoaded:!1,currentMealType:""},n}return Object(M.a)(s,[{key:"componentDidMount",value:function(){var t=this.state.lat,e=this.state.lng;navigator.geolocation?(console.log("navigator.geolocation is available"),navigator.geolocation.getCurrentPosition(function(s){console.log("current position acquired"),t!==s.coords.latitude&&e!==s.coords.longitude&&(this.setState({lat:s.coords.latitude}),this.setState({lng:s.coords.longitude}),console.log(s.coords.latitude+" "+s.coords.longitude),this.fetchDataFromYelp())}.bind(this))):alert("Unable to get geolocation!")}},{key:"search",value:function(){this.state.search_list.length>0&&(this.state.search_list=[]);for(var t=0;t<this.state.rest_list.length;t++){var e=this.state.rest_list[t];(e.name.toLowerCase().includes(this.state.searchString.toLowerCase())||e.city.toLowerCase().includes(this.state.searchString.toLowerCase()))&&(this.state.search_list.push(e),console.log(this.state.search_list.length)),this.forceUpdate()}}},{key:"fetchDataFromYelp",value:function(){fetch("http://localhost:8080/api/v1/getRestaurantData?lat= "+this.state.lat+"&lng="+this.state.lng+"&meal_type=lunch",{method:"GET",headers:{"Content-Type":"application/json"}}).then((function(t){return t.json()})).then(function(t){this.setState({rest_list:t}),console.log(this.state.rest_list.businesses),this.setState({dataLoaded:!0}),this.setState({currentMealType:"lunch"})}.bind(this))}},{key:"changeMealType",value:function(t){this.state.search_list.length>0&&this.setState({search_list:[]}),this.setState({dataLoaded:!1}),fetch("http://localhost:8080/api/v1/getRestaurantData?lat= "+this.state.lat+"&lng="+this.state.lng+"&food_type="+t,{method:"GET",headers:{"Content-Type":"application/json"}}).then((function(t){return t.json()})).then(function(e){this.setState({rest_list:e}),this.setState({dataLoaded:!0}),this.setState({currentMealType:t})}.bind(this))}},{key:"render",value:function(){var t=this;return this.state.dataLoaded?Object(n.jsxs)("div",{class:"main",children:[Object(n.jsx)(y.a,{}),Object(n.jsxs)("div",{class:"page-header",children:[Object(n.jsx)("h1",{children:"Restaurant Finder"}),Object(n.jsx)("hr",{}),Object(n.jsx)("button",{class:"button",onClick:function(){t.changeMealType("breakfast")},children:"Breakfast"}),Object(n.jsx)("button",{class:"button",onClick:function(){t.changeMealType("lunch")},children:"Lunch"}),Object(n.jsx)("button",{class:"button",onClick:function(){t.changeMealType("dinner")},children:"Dinner"}),0==t.state.search_list.length?Object(n.jsxs)("h3",{children:["Currently displaying ",t.state.rest_list.length," restaurants that serve ",t.state.currentMealType]}):Object(n.jsxs)("h3",{children:["Currently displaying ",t.state.search_list.length," restaurants that serve ",t.state.currentMealType]}),Object(n.jsx)("input",{class:"search-element",onChange:function(e){return t.setState({searchString:e.target.value})},pattern:this.state.searchRegex,id:"searchInputElement",placeholder:"Search"}),Object(n.jsx)("button",{class:"button",onClick:function(){t.search()},children:"Search"})]}),0==t.state.search_list.length?t.state.rest_list.map((function(t){return Object(n.jsxs)("div",{class:"box",children:[Object(n.jsx)("h3",{children:t.name}),Object(n.jsxs)("h3",{children:[t.address,t.city,",",t.state]}),Object(n.jsxs)("h3",{children:[t.rating," / 5 based on ",t.num_of_reviews," reviews"]}),Object(n.jsx)(o.a,{children:Object(n.jsx)(o.b,{target:"_blank",to:"/details/"+t.id,children:"View More Details"})})]})})):t.state.search_list.map((function(t){return Object(n.jsxs)("div",{class:"box",children:[Object(n.jsx)("h3",{children:t.name}),Object(n.jsxs)("h3",{children:[t.address,t.city,",",t.state]}),Object(n.jsxs)("h3",{children:[t.rating," / 5 based on ",t.num_of_reviews," reviews"]}),Object(n.jsx)(o.a,{children:Object(n.jsx)(o.b,{target:"_blank",to:"/details/"+t.id,children:"View More Details"})})]})}))]}):Object(n.jsxs)("div",{children:[Object(n.jsx)("h1",{children:"Finding Nearby Restaurants..."}),Object(n.jsx)("div",{class:"loading-icon"})]})}}]),s}(c.a.Component),D=function(){return Object(n.jsx)("main",{children:Object(n.jsx)(o.a,{children:Object(n.jsxs)(l.c,{children:[Object(n.jsx)(l.a,{exact:!0,path:"/",component:L}),Object(n.jsx)(l.a,{path:"/details/:id",component:S})]})})})};var F=function(){return Object(n.jsx)("div",{className:"App",children:Object(n.jsx)(o.a,{children:Object(n.jsx)(D,{})})})},R=function(t){t&&t instanceof Function&&s.e(3).then(s.bind(null,55)).then((function(e){var s=e.getCLS,n=e.getFID,a=e.getFCP,c=e.getLCP,i=e.getTTFB;s(t),n(t),a(t),c(t),i(t)}))};r.a.render(Object(n.jsx)(c.a.StrictMode,{children:Object(n.jsx)(F,{})}),document.getElementById("root")),R()}},[[49,1,2]]]);
//# sourceMappingURL=main.73c5b012.chunk.js.map