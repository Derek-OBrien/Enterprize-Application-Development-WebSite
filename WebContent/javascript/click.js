// JavaScript Document

$(function() {
				// Clickable Dropdown
			$('.sponsors > ul').toggleClass('no-js js');
			$('.sponsors .js ul').hide();
			$('.sponsors .js').click(function(e) {
				$('.sponsors .js ul').slideToggle(200);
				$('.clicker').toggleClass('active');
				e.stopPropagation();
			});
			$(document).click(function() {
				if ($('.sponsors.js ul').is(':visible')) {
					$('.sponsors .js ul', this).slideUp();
					$('.clicker').removeClass('active');
				}
			});
		});