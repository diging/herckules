function d3init(graph) {
	
	if(graph==null){
		alert("no network");
	}
	// Layout size
	var width = 500, height = 500;
	var layout;
	var color = d3.scale.category20();
	// Preparing the force directed graph
	layout = d3.layout.force()
	.charge(-150)
	.linkDistance(100)
	.gravity(.06)
	.size([width, height]);
	layout
	.nodes(graph.nodes)
	.links(graph.links)
	.start();
	

	var vis = d3.select("#chart").append("svg:svg")
	.attr("width", width)
	.attr("height", height)
	.append('svg:g');
	// Zoom in and out
//	.call(d3.behavior.zoom().on("zoom", redraw))


	// Prepare the arrow
	vis.append("defs").selectAll("marker")
	.data(["arrow"])
	.enter()
	.append("marker")
	.attr("id", String)
	.attr("viewBox", "0 -5 10 10")
	.attr("refX", 15)
	.attr("refY", -1.5)
	.attr("markerWidth", 6)
	.attr("markerHeight", 6)
	.attr("orient", "auto")
	.append("path")
	.attr("d", "M0,-5L10,0L0,5");



	// Draw links between the nodes
	var link = vis.selectAll(".link")
	.data(graph.links)
	.enter().append("line")
	.attr("class", "link")
	.style("stroke-width", function(d) { return Math.sqrt(d.value); })
	.attr("marker-end", "url(#arrow)")
	.on("click", function(d){
		//display_annotations_of_edge(d.source,d.target);
		//add_annotationstolink(d);
		//d3.event.preventDefault();
	});

	// Dragging the nodes
	var node_drag = d3.behavior.drag()
	.on("dragstart", dragstart)
	.on("drag", dragmove)
	.on("dragend", dragend);

	// Starts the drag
	// Means starts with force.stop
	function dragstart(d, i) {
		layout.stop(); // stops the force auto positioning before you start dragging
	}

	// Moves the node based on the user interaction
	// and places the node in the selected location
	function dragmove(d, i) {
		d.px += d3.event.dx;
		d.py += d3.event.dy;
		d.x += d3.event.dx;
		d.y += d3.event.dy; 
		tick(); // this is the key to make it work together with updating both px,py,x,y on d !
	}

	// End drag
	function dragend(d, i) {
		d.fixed = true; 

		tick();
		layout.resume();
	}

	// Properties for the nodes
	var gnodes = vis.selectAll('g.gnode')
	.data(graph.nodes)
	.enter();

	var node = gnodes.append('circle')
	.attr("class", "node")
	.attr("r",10) 	
	.style("fill", function(d) { return color(d.group); })
	.call(node_drag)
	.on("mouseover", fade(.1)).on("mouseout", fade(1));;

	node.append("svg:circle")
	.attr("r", 10);


//	Appending labels to the nodes
	var text = gnodes.append("text")
	.call(node_drag)
	.text(function(d) { return d.label; });

//	Appending title to the nodes 
//	Mouse hover on the node shows the name of the node.
	node.append("title")
	.text(function(d) { return d.label; });

//	Properties for the position of the node
	function tick() {
		link.attr("x1", function(d) { return d.source.x; })
		.attr("y1", function(d) { return d.source.y; })
		.attr("x2", function(d) { return d.target.x; })
		.attr("y2", function(d) { return d.target.y; });
//		.attr("cx", function(d) { return d.x = Math.max(6, Math.min(width - 6, d.x)); })
//		.attr("cy", function(d) { return d.y = Math.max(6, Math.min(height - 6, d.y)); });

		node.attr("transform", function(d) { return "translate(" + (d.x) + "," + d.y + ")"; });
		//.attr("cx", function(d) { return d.x = Math.max(6, Math.min(width - 6, d.x)); })
		//.attr("cy", function(d) { return d.y = Math.max(6, Math.min(height - 6, d.y)); });
		text.attr("transform", function(d) { return "translate(" + (d.x) + "," + d.y + ")"; });
//		.attr("cx", function(d) { return d.x = Math.max(6, Math.min(width - 6, d.x)); })
//		.attr("cy", function(d) { return d.y = Math.max(6, Math.min(height - 6, d.y)); });
	};


//	Works on loading the network and placing the nodes randomly for view

	layout.on("tick", tick);

	function neighboring(a, b) {

		//	return linkedByIndex[a.index + "," + b.index];
		return link.some(function(d) {
			return (d.source === a && d.target === b);

		});
	}


	function fade(opacity) {
		return function(d, i) {
			//fade all elements
//			d3.select(d.source).style("opacity", opacity);
//			d3.select(d.target).style("opacity", opacity);
			//fade all elements
			vis.selectAll("line").style("opacity", opacity);

			var associated_links = vis.selectAll("line").filter(function(d) {
				return  d.source.index == i;
				// return d.source.index == i || d.target.index == i;
			}).each(function(d) {
				//unfade links and nodes connected to the current node
				d3.select(this).style("opacity", 1);
				//THE FOLLOWING CAUSES: Uncaught TypeError: Cannot call method 'setProperty' of undefined
				//  d3.select(d.source).style("opacity", 1);
				//  d3.select(d.target).style("opacity", 1);
				node.style("opacity", function(o) {
					d3.select(o.source).style("opacity", 1);
				});
			});

		};

	}

}

