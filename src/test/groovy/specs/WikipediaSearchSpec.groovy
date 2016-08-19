package specs

import pages.WikipediaHomePage
import pages.WikipediaResultsPage
import geb.spock.GebSpec
import spock.lang.Unroll

class WikipediaSearchSpec extends GebSpec {
	
	def "Search by Customer Reference Number"() {
		
		given:'A user navigates to the Search Page'
			to WikipediaHomePage
		
		when:'The user enters a Customer Reference Number'
			searchInput = 'Capgemini'
			searchButton.click()
		
		then:'Only transactions for that customers are returned'
			at WikipediaResultsPage
	}
}
