package pages

import geb.Page

class WikipediaResultsPage extends Page {
	
	static url = 'https://en.wikipedia.org/wiki/'
	
	static at = { browser.driver.currentUrl.contains(url) }

	static content = {
		firstHeading { $('#firstHeading').text() }
		searchInput { $('#searchInput') }
		searchButton { $('#searchButton') }
	}
}
