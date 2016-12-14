package pages

import geb.Page

class WikipediaHomePage extends Page {
	
	static url = 'https://www.wikipedia.org/'
	
	static at = { browser.driver.currentUrl == url }

	static content = {
		searchInput { $('#searchInput') }
		searchButton { $('.pure-button') }
	}
}
