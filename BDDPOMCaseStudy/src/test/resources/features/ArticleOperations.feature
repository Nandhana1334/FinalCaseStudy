Feature: Article Operations
 
Scenario: Invalid Login into app
Given User is on login Page
When User enter Invalid Credentials
| mail | pwd |
| nandhana@gmail.com | nandhanana |
Then Should display the invalid login message
| msg |
| Wrong email/password combination |
 
Scenario: Valid Login into app
Given User is on login Page
When User enter Valid Credentials
| mail | pwd |
| nandhana@gmail.com | nandh |
Then Should display the success login message
| profileName |
| Nandhana |
 
 
Scenario: User Create the Article with duplicate Title
Given User is on newArticleCreationPage
When User Create the duplicate article
| title |about|desc|
| Article4 | sample article | sample article |
Then   Should display the duplicate article message

 
Scenario: User Create the new Article
Given User is on newArticleCreationPage
When User create the new Article
| title |about|desc|
| article5 | sample article |sample article|
Then Should display the new Article Title
|article5|
 
Scenario: User update the Article
Given User is on updateArticlePage
| title |
|article5|
When User Update the Article
| title |about|desc|
| article6 | sample article |sample article| 
Then Should display the updated Article Title
| title |
| article6 |
 
 
Scenario: User delete the Article
Given User is on deleteArticlePage
| title |
|article6|
When User delete the Article
Then Should display the article deletion msg
| msg |
| Articles not available. |
 