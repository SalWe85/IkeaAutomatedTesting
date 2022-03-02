# IkeaAutomatedTesting
 Selenium automated testing on ikea.rs site
 <br>------------------------------------------<br>
 <br>
v0.3 : Select most expensive product Test and add it to shopping cart test.<br>
      &nbsp;&nbsp;&nbsp;**Test 5 (ShoppingCartTest):** <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;- Chaining previous tests to find random most expensive product. Than adding it to shopping cart, navigating to shopping cart, <br>
              &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;checking if url is correct and checking if product is added to shopping cart. <br>
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
 At least 5 more tests.<br>
