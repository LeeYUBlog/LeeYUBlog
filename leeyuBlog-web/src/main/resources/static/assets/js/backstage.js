var utils = (function () {
	'use strict';
	
	/**
	 * Returns the offset of an element relative to the document, or at least that's what I think it does 
	 */ 
	function offset(element) {
		var rect = element.getBoundingClientRect();
		var docElem = document.documentElement;

		return {
			top: rect.top + 
						window.pageYOffset - docElem.clientTop,
			left: rect.left + 
						window.pageXOffset - docElem.clientLeft
		};
	};

	/**
	 * Show an element using the display style
	 */
	function show(target) {
		target.style.display = '';
	}
	
	/**
	 * Hide an element using the display style
	 */
	function hide(target) {
		target.style.display = 'none';
	}

	return {
		dom: {
			offset,
			show,
			hide
		}
	};
}());



(function () {
	'use strict';
	
	/**
	 * Handles the category and tags options lists
	 */
	
	var classes = {
		component: '.js-OptionsList',
		state: {
			selected: 'is-selected'
		}
	};

	$$(classes.component)._.events({
		'click': function onOptionListClick({ target }) {
			var isChecked = 
				! target.classList
					.contains(classes.state.selected)
			
			setChecked({
				target, 
				checked: isChecked
			});
		}
	});

	function setChecked({ target, checked }) {
		var isChecked = !!checked;
		target.setAttribute('aria-checked', !! isChecked);

		if (isChecked) {
			target.classList.add(classes.state.selected);
		} else {
			target.classList.remove(classes.state.selected);
		}
	}
}());



(function () {
	'use strict';

	/**
	 * Sets the text body for the post editor 
	 */

	var classes = {
		component: '.js-PostEditor',
		textarea: '.js-PostEditor__textarea',
		editOptions: '.js-postEditOptions',
	};
	
	/**
	 * The user's mouse position when starting the text selection
	 * @type {Object}
	 */
	var startMousePosition;	

	/**
	 * The user's current mouse position
	 * @type {Object}
	 */
	var currentMousePosition = {};
	
	var $editor = $(classes.textarea);
	var $postEditOptions = $(classes.editOptions);

	$editor._.events({
		'select': function onEditorTextSelect(e) {
			var editorOffset = utils.dom.offset($editor);
			var editorRight = editorOffset.left + $editor.getBoundingClientRect().width;
			
			// Gotta show the element before we can get its width
			utils.dom.show($postEditOptions);
			
			var optionsWidth = $postEditOptions.offsetWidth;
			var top  = currentMousePosition.y - editorOffset.top;
			// Not sure why subtracting the padding on the container makes it center (which is the 30 * 2), but okay
			var left = Math.min(
					currentMousePosition.x - editorOffset.left - Math.abs((currentMousePosition.x - startMousePosition.x)  / 2) - (30 * 2),
					editorRight
			);

			$postEditOptions.style.top  = `${top}px`;
			$postEditOptions.style.left = `${left}px`;
		}
	})
	
	window.addEventListener('mousedown', onMouseDown);
	window.addEventListener('mousemove', onMouseMove);
	
	function onMouseDown(e) {
		utils.dom.hide($postEditOptions);
		startMousePosition = {
			x: e.pageX,
			y: e.pageY
		};
	}
	
	function onMouseMove(e) {
		currentMousePosition.x = e.pageX;
		currentMousePosition.y = e.pageY;
	}
	
	// The text is set here so as to not pollute the Jade file 
	var body = `I don't know if you knew this, but flexbox is awesome. If you're not using, what are you doing with your life? Lorem ipsum dolor sit amet, consectetur adipisicing elit. Expedita non modi temporibus voluptates culpa deserunt, repellat, assumenda est quia vero atque adipisci laborum sequi qui pariatur earum aspernatur eius. Ut officiis culpa enim perspiciatis dicta tenetur, repellat nobis fuga, aliquam libero non voluptatem sint ab nostrum dolorem quidem. Animi, quaerat.

Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum inventore sunt minima nam accusantium mollitia voluptate veniam eius ea dolorum. Repudiandae quibusdam voluptas assumenda velit odit rem consequatur tempora repellendus natus temporibus, quis necessitatibus blanditiis quam molestiae harum quo vero porro cupiditate unde numquam perspiciatis nemo! Voluptatem recusandae blanditiis flex is awesome, perferendis maxime fugit, neque, harum cumque asperiores ut impedit odit! Quasi fuga eius sed eos distinctio ipsam, quisquam explicabo magni sequi incidunt reprehenderit neque commodi tempore, deserunt atque veritatis dolore earum, modi iure ducimus odit maxime eligendi harum tenetur ad? Expedita at, nesciunt neque reiciendis dolor deleniti maxime.

Lorem ipsum dolor sit amet, consectetur adipisicing elit. Placeat dolores cupiditate laboriosam id consequuntur atque delectus et temporibus ea dolor dicta odit accusantium quas laborum numquam, aliquam vero, iusto quaerat explicabo eum. Ipsum ad nulla, dolorem, ullam velit minus aliquam inventore aut reiciendis perspiciatis officiis laudantium expedita ab eos molestiae quibusdam nostrum eligendi laborum repellat, enim hic iste nemo temporibus! Rerum error modi sapiente, distinctio molestias aperiam obcaecati voluptas animi.

Lorem ipsum dolor sit amet, consectetur adipisicing elit. Accusantium voluptate commodi aspernatur quis eveniet veritatis deserunt rem, odio, quod explicabo, necessitatibus illum vitae iste et nostrum nulla. Nulla blanditiis delectus fugiat voluptate illo facilis non iusto maiores, repudiandae vel illum suscipit quidem vero modi eos, mollitia dolorem molestiae molestias voluptatem ea ullam esse? Accusantium, dolorum, perferendis. Voluptate nam similique repellat sit ducimus quaerat tempora nesciunt nemo numquam quia asperiores iste unde quod iusto, reiciendis explicabo aperiam, voluptates quidem possimus voluptas animi dolorem facere? Nam fuga veniam, nesciunt, quos voluptate adipisci.`;
	
	$editor.textContent = body;
}());

