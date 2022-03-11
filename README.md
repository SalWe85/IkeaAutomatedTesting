# IkeaAutomatedTesting
 Selenium automated testing on ikea.rs site
 <br>------------------------------------------<br>
 <br>
v.0.5 : Added log4j.<br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Implemented log4j logging utility. All print() methods replaced with log.info / log.error.<br>
<br>
v0.4.1 : Changes to ProductSearchTest and many locators<br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Code inside ProductSearchTest moved to SearchResultsPage and converted to two new methods. <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Many element names changed on web site, had to update correct paths in many Page classes. <br>
<br>
v0.4 : Home page 'dot' button test<br>
      &nbsp;&nbsp;&nbsp;**Test 6 (HomePageDotTest):** <br>
      &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Scrolling down to 'dot' element on home page, hovering over it for 2 sec and clicking on it. Verifying that correct product was opened.<br>
<br>
v0.3 : Select most expensive product Test and add it to shopping cart test.<br>
      &nbsp;&nbsp;&nbsp;**Test 5 (ShoppingCartTest):** <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Chaining previous tests to find random most expensive product. Than adding it to shopping cart, navigating to shopping cart, <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;checking if url is correct and checking if product is added to shopping cart. <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- IMPORTANT: If product is not in stock, test will continue by searching for another product.<br>
<br>
      &nbsp;&nbsp;&nbsp;**Test 4 (ProductSortingTest):** <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Search for random product, sort results by price (high to low), click on most expensive one and open it. <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Added method that checks if sorting is successfull by comparing first product price to second one. <br>
<br>
v0.2 : Search product test added.<br>
      &nbsp;&nbsp;&nbsp;**Test 3 (ProductSearchTest):** <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- New method in Base Page created. It will create list of product names, than input random product name in search field and navigate to search result page. <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- New SearchResultTest created. It will collect searched products in a list, and check if first found product is same as searched keyword.<br>
<br>
v0.1 : First commit.<br>
      &nbsp;&nbsp;&nbsp;**Test 2 (LoginTest):**<br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Try to log in with random generated invalid credentials.<br>
      &nbsp;&nbsp;&nbsp;**Test 1 (LoginTest):**<br>
             &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Log in with valid credentials.<br>
 ------------------------------------------<br>
 TO DO:<br>
 At least 4 more tests.<br>
