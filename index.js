/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

var myChart;
var myChartAcc;
 
var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
		$("*[data-action=close-menu]").click(app.hideMenu);
		$("*[data-action=show-menu]").click(app.showMenu);
		$("*[data-action=toggle-menu]").click(app.toggleMenu);
		$("#content").width( $( window ).width() );
		$("#header").width( $( window ).width() );
		$("*[data-role=page]").first().show();
		hash = location.hash.substr(1).split('&');
		if(document.getElementById(hash[0])){
			app.showPage(hash[0]);
		}
		$("#chat_controls>button").click(app.chatSend);
		$("#images>button").click(app.takePhoto);
		app.drawChartAcc();
		// document.getElementById("requests").onclick = getPictures() 
    },

    // Bind Event Listeners
    //
    // Bind any events that are required on startup. Common events are:
    // 'load', 'deviceready', 'offline', and 'online'.


    bindEvents: function() {
    	$("#money").click(app.getFaxes);
    	// app.updateNews();
        document.addEventListener('deviceready', this.onDeviceReady, false);
		window.addEventListener('hashchange', this.hashChange, false);
    },

    getFaxes: function() {

    	$("#getstarted").append("ceva");
    	// document.getElementById("requests").onclick = function() }

    },

	updateArray: function() {
		var aux = Math.floor(Math.random() * 90)  + 1;
		myChart.data.datasets[0].data.push(aux);
		var nr=myChart.data.labels.length;
		nr++;
		myChart.data.labels.push(nr);
		myChart.data.datasets[0].data.splice(0,1);
		myChart.data.labels.splice(0,1);
		myChart.update();
	},

    // deviceready Event Handler
    //
    // The scope of 'this' is the event. In order to call the 'receivedEvent'
    // function, we must explicitly call 'app.receivedEvent(...);'
    onDeviceReady: function() {

        app.receivedEvent('deviceready');

        function onSuccess(acceleration) {
    			myChartAcc.data.datasets[0].data.push(acceleration.y);
				var nrAcc=myChart.data.labels.length;
				nrAcc++;
				myChartAcc.data.labels.push(nrAcc);
				myChartAcc.update();
		};

		function onError() {
    		alert('onError!');
		};

		var options = { frequency: 1000 }; 

		var watchID = navigator.accelerometer.watchAcceleration(onSuccess, onError, options);
    },
	//events on hash/location change
	hashChange: function(){
		var hash = location.hash.substr(1);
		var values = {};
		hash = hash.split('&');
		hash.forEach(function(el,index){
			if(el.indexOf("=")>=0){
				el = {name:el.split("=")[0] , value:el.split("=")[1]};
				values[el.name] = el.value;
				hash[index]=el;
			}
		});
		if(document.getElementById(hash[0])){
			app.showPage(hash[0]);
		}
	},
    // Update DOM on a Received Event
    receivedEvent: function(id) {
        /*var parentElement = document.getElementById(id);
        var listeningElement = parentElement.querySelector('.listening');
        var receivedElement = parentElement.querySelector('.received');

        listeningElement.setAttribute('style', 'display:none;');
        receivedElement.setAttribute('style', 'display:block;');

        console.log('Received Event: ' + id);*/
    },
	showPage: function(id){
		if( document.getElementById(id).getAttribute("data-role") == "page"){
			$("*[data-role=page]").hide();
			$("#"+id).show();
			app.hideMenu();
		}
	},
	showMenu: function(){
		document.getElementById("app").classList.add("show");
	},
	
	hideMenu: function(){
		document.getElementById("app").classList.remove("show");
	},
	
	toggleMenu: function(){
		if(document.getElementById("app").classList.contains("show")){
			app.hideMenu();
		}else{
			app.showMenu();
		}
	}

};
