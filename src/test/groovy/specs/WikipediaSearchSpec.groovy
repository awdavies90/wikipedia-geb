package specs

import pages.WikipediaHomePage
import pages.WikipediaResultsPage
import geb.spock.GebSpec
import spock.lang.Unroll

class WikipediaSearchSpec extends GebSpec {
	
	def "1 - Wikipedia Search"() {
		
		given:'A user navigates to the Wikipedia Search Page'
			to WikipediaHomePage
		
		when:'The user enters some text into the search box and clicks search'
			searchInput = 'Capgemini'
			searchButton.click()
		
		then:'The user is navigated to an information page with a title matching the search text'
			at WikipediaResultsPage
			firstHeading == 'Capgemini'
	}
}
