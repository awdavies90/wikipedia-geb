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
			searchInput = input
			searchButton.click()
		
		then:'The user is navigated to an information page with a title matching the search text'
			at WikipediaResultsPage
			firstHeading == input
		
		where:'The following search inputs are used'
			input << ['Capgemini', 'IBM', 'Accenture']
	}
	
	def "2 - Wikipedia Search With Dynamic Where Block"() {
		
		given:'A user navigates to the Wikipedia Search Page'
			to WikipediaHomePage
		
		when:'The user enters some text into the search box and clicks search'
			searchInput = input
			searchButton.click()
		
		then:'The user is navigated to an information page with a title matching the search text'
			at WikipediaResultsPage
			firstHeading == input
		
		where:'The following search inputs are used'
			input << ['Capgemini', 'IBM', 'Accenture']
	}
	
	def "3 - Wikipedia Search from Results Page"() {
		
		given:'A user navigates to the Wikipedia Search Page, performs a search and is at the Wikipedia Results Page'
			to WikipediaHomePage
			searchInput = 'Capgemini'
			searchButton.click()
			at WikipediaResultsPage
		
		when:'The user performs another search with different text at the Results page'
			searchInput = 'IBM'
			searchButton.click()
		
		then:'The user is navigated to an information page with a title matching the second search text'
			at WikipediaResultsPage
			firstHeading == 'IBM'
	}
}
